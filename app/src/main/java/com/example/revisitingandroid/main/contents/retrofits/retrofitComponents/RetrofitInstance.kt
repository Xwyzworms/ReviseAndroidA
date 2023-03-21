/*
##################################################
#       Written by : Rose (Pratama Azmi A)
#       Date : Unknown
#       Text editor : AndroidStudio + VIM
##################################################
*/
package com.example.revisitingandroid.main.contents.retrofits.retrofitComponents

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

// SingleTonClass using Billplugh, because Synchronized SUCKS
class RetrofitInstance private constructor() {

    // Di kotlin nested class udah otomatis Static class yak
    // Static class --> GAperlu buat objek

    private class SingletonHelper
    {
        companion object{

            @JvmStatic
            val BASE_URL : String = "https://jsonplaceholder.typicode.com/" // Best practice put it inside .gradleBuilder

            @JvmStatic // Interceptor ? basically for LOG Body of the request
            //  which logs HTTP request and response data
            val interceptor : HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
                this.level = HttpLoggingInterceptor.Level.BODY
            }
            @JvmStatic // Using Builder Design pattern , basically client ini buat extend fungsionalitas retrofit
            val client = OkHttpClient.Builder().apply {
                this.addInterceptor(interceptor)
                this.connectTimeout(30, TimeUnit.SECONDS)
                this.readTimeout(20, TimeUnit.SECONDS)
                this.writeTimeout(25, TimeUnit.SECONDS)
            }.build() //

            // Here's the step
            // We create the base Class for retrofit
            // It needs URL where to go
            // [optionally] you can enhance the capability by using the OKHttpBuilder
            // ConverterFactory,  membuat data yang diambil oleh retrofit menjadi sebuah class yang dituju ( Deserialized )
            // HttpRequest -> some class
            @JvmStatic
            public val retrofitInstance : Retrofit =
                    Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
                    .build()
        }

    }

    companion object {
        fun getRetrofitInstance() : Retrofit
        {
            return SingletonHelper.retrofitInstance
        }
    }

}