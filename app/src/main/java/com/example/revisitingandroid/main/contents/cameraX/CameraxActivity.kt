package com.example.revisitingandroid.main.contents.cameraX

import android.Manifest
import android.content.ContentValues
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.provider.MediaStore.Audio.Media
import android.util.Log
import android.widget.Toast
import androidx.camera.core.*
import androidx.camera.core.ImageCapture.OnImageSavedCallback
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.video.Recorder
import androidx.camera.video.VideoCapture
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.revisitingandroid.databinding.ActivityCameraxBinding
import java.text.SimpleDateFormat
import java.util.Locale
import java.util.concurrent.ExecutorService

typealias LumaListener = (luma : Double) -> Unit

class CameraxActivity : AppCompatActivity() {
    private lateinit var binding : ActivityCameraxBinding


    private var imageCapture : ImageCapture? = null
    private var videoCapture : VideoCapture<Recorder>? = null // Recorder itu implement video output, so ya karena dia turunan video output , maka aman aman aja

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
            val cameraSelector: CameraSelector = CameraSelector.DEFAULT_BACK_CAMERA

            // Bind usecases to camera
            try {
                // Unbind use cases before rebinding
                cameraProvider.unbindAll()

                cameraProvider.bindToLifecycle(this, cameraSelector, preview, imageCapture)
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
        // bangke belum terlalu paham kalau ini
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

    }

    private class LuminosityAnalyzer(private val listener : LumaListener) : ImageAnalysis.Analyzer
    {
        override fun analyze(image: ImageProxy) {

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