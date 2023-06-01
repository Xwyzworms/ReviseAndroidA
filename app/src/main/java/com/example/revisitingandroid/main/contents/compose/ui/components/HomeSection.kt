/*
#       Written by : Rose (Pratama Azmi A)
#       Date : Unknown 
#       Text editor : AndroidStudio + VIM
*/
package com.example.revisitingandroid.main.contents.compose.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun HomeSection(
    title : String,
    modifier : Modifier = Modifier,
    content : @Composable () -> Unit
)
{
    Column(modifier)
    {
        SectionText(title = title, modifier)
        content()
    }
}