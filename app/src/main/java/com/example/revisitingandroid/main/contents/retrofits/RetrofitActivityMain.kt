package com.example.revisitingandroid.main.contents.retrofits

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.lifecycle.LiveDataScope
import androidx.lifecycle.Observer
import androidx.lifecycle.liveData
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.revisitingandroid.R
import com.example.revisitingandroid.databinding.ActivityRetrofitMainBinding
import com.example.revisitingandroid.databinding.RvActivityRetrofitMainContentBinding
import com.example.revisitingandroid.main.contents.retrofits.data.Album
import com.example.revisitingandroid.main.contents.retrofits.data.Albums
import com.example.revisitingandroid.main.contents.retrofits.retrofitComponents.AlbumService
import com.example.revisitingandroid.main.contents.retrofits.retrofitComponents.RetrofitInstance
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.DisposableHandle
import kotlinx.coroutines.launch
import retrofit2.Response

class RetrofitActivityMain : AppCompatActivity() {

    private val binding: ActivityRetrofitMainBinding get() = _binding!!
    private var _binding: ActivityRetrofitMainBinding? = null

    private lateinit var retrofitService: AlbumService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityRetrofitMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupRetrofitService()
        setupRecyclerview()
        setupButtons()
    }

    private fun setupRetrofitService() {
        retrofitService = RetrofitInstance.getRetrofitInstance().create(AlbumService::class.java)
    }

    private fun setupRecyclerview() {

        binding.rvRetrofitMain.layoutManager = LinearLayoutManager(this)
    }

    private fun setupButtons() {
        fun getRequestSortedAlbums() {
            val listOfUselessStuff: MutableList<Album> = mutableListOf()
            val responseLiveData: LiveData<Response<Albums>> = liveData {
                val response: Response<Albums> = retrofitService.getSortedAlbums(3)
                // Set the livedataValue to response
                emit(response) // LiveData<Response<Albums>>
            }

            responseLiveData.observe(this, Observer {
                // Since Response Object has the body method, and we know albums is just a list of albums stuff
                val albumList = it.body()?.iterator()
                if (albumList != null) {
                    while (albumList.hasNext()) {
                        val album = albumList.next()
                        listOfUselessStuff.add(album)
                    }
                }
                binding.rvRetrofitMain.adapter = RetrofitMainAdapter(listOfUselessStuff)
            })

        }

        fun getRequestAlbums() {
            val listOfUselessStuff: MutableList<Album> = mutableListOf()
            val responseLiveData: LiveData<Response<Albums>> = liveData(
                context = Dispatchers.IO,
                block = {
                    val response: Response<Albums> = retrofitService.getAlbums()
                    emit(response)

                }
            )

            val observer: Observer<Response<Albums>> = object : Observer<Response<Albums>> {
                override fun onChanged(it: Response<Albums>) {
                    val albumList: MutableIterator<Album>? = it.body()?.iterator()
                    if (albumList != null) {
                        while (albumList.hasNext()) {
                            listOfUselessStuff.add(albumList.next())
                        }
                    }
                    binding.rvRetrofitMain.adapter = RetrofitMainAdapter(listOfUselessStuff)
                }

            }
            responseLiveData.observe(this, observer)
        }

        fun getRequestWithPathParams() {
            val pathResponse: LiveData<Response<Album>> = liveData(
                context = Dispatchers.IO,
                block = {
                    val response : Response<Album> = retrofitService.getAlbum(2)
                    emit(response)
                }
            )

            val observer : Observer<Response<Album>> = object : Observer<Response<Album>>
            {
                override fun onChanged(t: Response<Album>?) {
                    val responseContent = t?.body()
                    if(responseContent != null)
                    {
                        binding.rvRetrofitMain.adapter = RetrofitMainAdapter(arrayListOf(responseContent))
                    }
                }
            }
            pathResponse.observe(this, observer)

        }

        binding.btnRetrofitPath.setOnClickListener {
            getRequestWithPathParams()
        }

        binding.btnRetrofitQuery1.setOnClickListener( object : View.OnClickListener {
            override fun onClick(it: View?) {
                getRequestAlbums()
            }

        })

        binding.btnRetrofitQuery2.setOnClickListener {
            getRequestSortedAlbums();
        }

    }
}