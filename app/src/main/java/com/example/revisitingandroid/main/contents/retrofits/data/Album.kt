/*
#       Written by : Rose (Pratama Azmi A)
#       Date : Unknown 
#       Text editor : AndroidStudio + VIM
*/
package com.example.revisitingandroid.main.contents.retrofits.data

import com.google.gson.annotations.SerializedName

//SerializedName --> nama key pada .json yang hendak di parse ( convert ) ke data class
data class Album (
        @SerializedName("id")
        val id : Int,

        @SerializedName("title")
        val title : String,

        @SerializedName("userId")
        val userId : Int


        )