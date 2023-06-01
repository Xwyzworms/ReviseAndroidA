/*
#       Written by : Rose (Pratama Azmi A)
#       Date : Unknown 
#       Text editor : AndroidStudio + VIM
*/
package com.example.revisitingandroid.main.contents.compose.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.revisitingandroid.R
import com.example.revisitingandroid.main.contents.compose.model.DamnCategory
import com.example.revisitingandroid.main.contents.compose.ui.theme.RevisitingAndroidTheme
import java.util.Locale.Category

@Composable
fun CategoryItem(
    category : DamnCategory,
    modifier : Modifier = Modifier
)
{
    Column(
        modifier = modifier,
        horizontalAlignment =  Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(category.imageCategory),
            contentDescription = null,
            modifier = Modifier
                .size(60.dp)
                .clip(CircleShape)
        )

        Text(text = stringResource(category.textCategory),
            fontSize = 10.sp,
            modifier = Modifier.paddingFromBaseline(top = 16.dp, bottom=8.dp)
            )
    }
}


@Composable
@Preview(showBackground=true)
fun CategoryItemPreview()
{
    RevisitingAndroidTheme() {
        CategoryItem(category = DamnCategory(
            R.drawable.icon_category_cappuccino,
            R.string.category_cappuccino
        ),
            modifier = Modifier.padding(8.dp)
        )
    }
}