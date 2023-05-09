/*
#       Written by : Rose (Pratama Azmi A)
#       Date : Unknown 
#       Text editor : AndroidStudio + VIM
*/
package com.example.revisitingandroid

import android.content.Context
import com.example.revisitingandroid.main.contents.tdd.SearchTDDHelper
import org.junit.Before
import org.junit.Test
import java.lang.AssertionError

class SearchTest {


    @Test
    fun getSearch_return_Null_if_query_isNull()
    {
        val nullResult = SearchTDDHelper.getSearchUrl(null)
        if(nullResult == null)
        {
            print("Success\n")
        }
        else
        {
            throw AssertionError("Result was not Null")
        }
    }

    @Test
    fun getSearch_return_Null_if_query_isEmpty()
    {
        val result = SearchTDDHelper.getSearchUrl("")
        if(result == null)
        {
            print("Success\n")
        }
        else
        {
            throw AssertionError("Result was not null Bruh")
        }
    }

    @Test
    fun getSearch_return_isNotNull_if_query_isNotEmpty()
    {
        val result = SearchTDDHelper.getSearchUrl("Hello World")
        if(result != null )
        {
            print("Success\n")
        }
        else
        {
            throw AssertionError("Result was null bruh")
        }
    }

    @Test
    fun getSearch_checkQuery_return_true_if_it_contain_query()
    {
        val result = SearchTDDHelper.getSearchUrl("bro")
        if(result?.contains("bro") == true)
        {
            print("Success\n")
        }
        else
        {
            throw AssertionError("Result did not contain Query")
        }
    }

    @Test
    fun getSearch_checkQuery_return_not_null_if_contain_SHIT()
    {
        val result = SearchTDDHelper.getSearchUrl("Bro")
        if(result != null)
        {
            print("Success\n")
        }
        else
        {
            throw  AssertionError("Result was null")
        }
    }
}