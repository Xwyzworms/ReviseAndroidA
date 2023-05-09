/*
#       Written by : Rose (Pratama Azmi A)
#       Date : Unknown 
#       Text editor : AndroidStudio + VIM
*/
package com.example.revisitingandroid.main.contents.tdd

object SearchTDDHelper {

    fun getSearchUrl(query : String?) : String?
    {
        if(!query.isNullOrEmpty())
        {
           return "https:///www.google.com/search?q$query"
        }
        return null
    }
}