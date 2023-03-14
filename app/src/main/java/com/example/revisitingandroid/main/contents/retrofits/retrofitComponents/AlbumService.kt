/*
#       Written by : Rose (Pratama Azmi A)
#       Date : Unknown 
#       Text editor : AndroidStudio + VIM
*/
package com.example.revisitingandroid.main.contents.retrofits.retrofitComponents

import com.example.revisitingandroid.main.contents.retrofits.data.Album
import com.example.revisitingandroid.main.contents.retrofits.data.Albums
import retrofit2.Response
import retrofit2.http.*

interface AlbumService {
    // Basically return response object ( Response object basically cuman kelas yang handle komunikasi )

    // SESUAIKAN SAMA API YANG DIPAKE
    @GET("/albums")
    suspend fun getAlbums() : Response<Albums>

    @GET("/albums")
    suspend fun getSortedAlbums(@Query("userId") userId:Int) : Response<Albums>

    @GET("/albums/{id}")
    suspend fun getAlbum(@Path(value="id") albumid : Int) : Response<Album>

    @POST("/albums")
    suspend fun updateAlbum(@Body album : Album) : Response<Album>

}