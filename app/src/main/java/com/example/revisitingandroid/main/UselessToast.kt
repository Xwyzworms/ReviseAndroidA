/*
#       Written by : Rose (Pratama Azmi A)
#       Date : Unknown 
#       Text editor : AndroidStudio + VIM
*/
package com.example.revisitingandroid.main

import android.content.Context
import android.widget.Toast


fun doToast(context : Context, string: String)
{
    Toast.makeText(context, string, Toast.LENGTH_SHORT).show()
}
