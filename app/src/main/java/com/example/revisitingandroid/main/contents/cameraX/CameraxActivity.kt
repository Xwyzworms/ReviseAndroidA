package com.example.revisitingandroid.main.contents.cameraX

import android.Manifest
import android.content.ContentValues
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.widget.Toast
import androidx.camera.core.*
import androidx.camera.core.ImageCapture.OnImageSavedCallback
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.video.*
import androidx.camera.video.VideoCapture
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.content.PermissionChecker
import com.example.revisitingandroid.databinding.ActivityCameraxBinding
import java.nio.ByteBuffer
import java.text.SimpleDateFormat
import java.util.Locale

typealias LumaListener = (luma : Double) -> Unit

class CameraxActivity : AppCompatActivity() {
    private lateinit var binding : ActivityCameraxBinding
    private var imageCapture : ImageCapture? = null
    private var videoCapture : VideoCapture<Recorder>? = null // Recorder itu implement video output, so ya karena dia turunan video output , maka aman aman aja

    private var recording : Recording? = null
    //private lateinit var cameraExecutor : ExecutorService

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityCameraxBinding.inflate(layoutInflater)
        setContentView(binding.root)

        checkPermission()
    }

    private fun checkPermission ()
    {
        if(allPermissionGranted())
        {
            startCamera()
        }
        else
        {
            ActivityCompat.requestPermissions(this, REQUIRED_PERMISSIONS, REQUEST_CODE_PERMISSIONS)
        }

        binding.imageCaptureButton.setOnClickListener{ takePhoto() }
        binding.videoCaptureButton.setOnClickListener { captureVideo() }
    }
    private fun allPermissionGranted() : Boolean
    {
        return REQUIRED_PERMISSIONS.all {
            ActivityCompat.checkSelfPermission(this, it) == PackageManager.PERMISSION_GRANTED
        }
    }

    private fun startCamera()
    {

        // You need to configure the camera first
        // TODO
        // CameraX Important shit

        val cameraProviderFuture = ProcessCameraProvider.getInstance(this) // Create or get CameraX Instance
        cameraProviderFuture.addListener({
            val cameraProvider = cameraProviderFuture.get()

            //Preview
            val preview: Preview = Preview.Builder()
                .build()
                .also {
                    it.setSurfaceProvider (
                        binding.viewfinder.surfaceProvider
                    )
                }

            imageCapture = ImageCapture.Builder().build()
            val recorder = Recorder.Builder()
                .setQualitySelector(QualitySelector.from(Quality.HIGHEST))
                .build()
            videoCapture = VideoCapture.withOutput(recorder)

            val imageAnalyzer : ImageAnalysis =  ImageAnalysis.Builder().build().also {
                it.setAnalyzer(ContextCompat.getMainExecutor(this), LuminosityAnalyzer( listener = { luma ->
                    Log.d(TAG, "AverageLuminosity ${luma}")
                }))
            }
            val cameraSelector: CameraSelector = CameraSelector.DEFAULT_BACK_CAMERA


            // Bind usecases to camera
            try {
                // Unbind use cases before rebinding
                cameraProvider.unbindAll()

                cameraProvider.bindToLifecycle(this, cameraSelector, preview)
            } catch (e : Exception) {
                Log.e(TAG, "Use case binding failed",e)
            }
        }, ContextCompat.getMainExecutor(this))
        // Try to bind it into the lifecyclec

    }

    private fun takePhoto()
    {
        // ANother use case
        val imageCapture = imageCapture ?: return // just Check whether the imageCapture val is Null or not

        // Create time stamped name and mediaStore Entry
        val name = SimpleDateFormat(FILENAME_FORMAT, Locale.US)
            .format(System.currentTimeMillis())

        // Define Informasi terkait konten yang hendak di sve
        // Keknya metadata dah ini
        val contentValues : ContentValues = ContentValues().apply {
            put(MediaStore.MediaColumns.DISPLAY_NAME, name)
            put(MediaStore.MediaColumns.MIME_TYPE, "image/jpeg")
            if(Build.VERSION.SDK_INT > Build.VERSION_CODES.P)
            {
                put(MediaStore.Images.Media.RELATIVE_PATH, "Pictures/CameraX-image")
            }
        }

        // OutputOptions using the MediaStore
        val outputOptions = ImageCapture.OutputFileOptions.Builder(contentResolver,
        MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues).build()

        imageCapture.takePicture(
            outputOptions,
            ContextCompat.getMainExecutor(this),
            object : OnImageSavedCallback {
                override fun onImageSaved(outputFileResults: ImageCapture.OutputFileResults) {
                    val msg : String = "Yooo Picture sudah ke save yak"
                    Toast.makeText(baseContext, msg, Toast.LENGTH_SHORT).show()
                }

                override fun onError(exception: ImageCaptureException) {
                    Log.e(TAG, "MABOK")
                }

            }
        )


    }


    private fun captureVideo()
    {
        val videoCapture = this.videoCapture ?: return

        binding.videoCaptureButton.isEnabled = false

        val curRecording = recording
        if(curRecording != null)
        {
            curRecording.stop()
            recording = null
            return
        }

        // Create a new session, define the metadata
        val name = SimpleDateFormat(FILENAME_FORMAT, Locale.US)
            .format(System.currentTimeMillis())
        val contentValues : ContentValues = ContentValues().apply {
            put(MediaStore.MediaColumns.DISPLAY_NAME, name)
            put(MediaStore.MediaColumns.MIME_TYPE, "video/mp4")
            if(Build.VERSION.SDK_INT > Build.VERSION_CODES.P)
            {
                put(MediaStore.Video.Media.RELATIVE_PATH, "Movies/CameraPrim")
            }
        }

        val mediaStoreOutputOptions = MediaStoreOutputOptions.Builder(contentResolver,
            MediaStore.Video.Media.EXTERNAL_CONTENT_URI )
            .setContentValues(contentValues)
            .build()

        recording = videoCapture.output.prepareRecording(this, mediaStoreOutputOptions)
            .apply {
                if(PermissionChecker.checkSelfPermission(this@CameraxActivity, Manifest.permission.RECORD_AUDIO) == PermissionChecker.PERMISSION_GRANTED)
                {
                    withAudioEnabled()
                }
            }
            .start(ContextCompat.getMainExecutor(this)) { recordEvent ->
                when (recordEvent) {
                    is VideoRecordEvent.Start ->
                    {
                        binding.videoCaptureButton.apply {

                            text = "Stop Capturing"
                            isEnabled =true
                        }

                    }
                    is VideoRecordEvent.Finalize ->
                    {
                        if(!recordEvent.hasError())
                        {
                            val message : String ="Video Captured Successfully ${recordEvent.outputResults.outputUri}"
                            Toast.makeText(baseContext, message, Toast.LENGTH_SHORT).show()
                        }
                        else
                        {
                            recording?.close()
                            recording = null
                        }

                        binding.videoCaptureButton.apply {
                            text = "Start Capturing"
                            isEnabled = true
                        }
                    }
                }
            }
    }

    private class LuminosityAnalyzer(private val listener : (luma : Double) -> Unit) : ImageAnalysis.Analyzer
    {

        private fun ByteBuffer.toByteArray() : ByteArray
        {
            Log.d(TAG, "Before ${remaining()}")
            rewind() // A temporary buffer to get small amount of previously recorded data
            val data = ByteArray(remaining()) // ByteArray to create , Remaining --> get the number of elements remaining pada buffer ini
            Log.d(TAG, "After ${remaining()}")
            get(data) // Get the buffer bytes into given destination ( data )
            return  data
        }

        override fun analyze(image: ImageProxy)
        {
            val buffer : ByteBuffer = image.planes[0].buffer // Get the R components
            val data : ByteArray = buffer.toByteArray()
            val convertedPixels :List<Int> = data.map{ it.toInt() and 0xFF }// Get the R pixel components
            Log.d(TAG, "ConvertedPixels ${convertedPixels.toString()}")
            val luma = convertedPixels.average()

            listener(luma)

            image.close()
        }

    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(requestCode == REQUEST_CODE_PERMISSIONS)
        {
            if(allPermissionGranted())
            {
                startCamera()
            }
            else
            {
                Toast.makeText(this, "Permission not Granted by the user",Toast.LENGTH_SHORT).show()
                finish()
            }
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        //cameraExecutor.shutdown()
    }

    companion object  {
        private const val TAG : String = "CameraX"
        private const val FILENAME_FORMAT : String = "yyyy-MM-dd-HH-mm-ss-SSS"
        private val REQUIRED_PERMISSIONS : Array<String> = mutableListOf(
            Manifest.permission.CAMERA,
            Manifest.permission.RECORD_AUDIO
        ).toTypedArray()
        private val REQUEST_CODE_PERMISSIONS : Int = 10
    }
}