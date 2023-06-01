/*
#       Written by : Rose (Pratama Azmi A)
#       Date : Unknown 
#       Text editor : AndroidStudio + VIM
*/
package com.example.revisitingandroid.main.contents.compose.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.revisitingandroid.R
import com.example.revisitingandroid.main.contents.compose.model.Menu
import com.example.revisitingandroid.main.contents.compose.ui.theme.RevisitingAndroidTheme

@Composable
fun MenuItem(
    menu : Menu,
    modifier : Modifier = Modifier
)
{
    Card(modifier = modifier.width(140.dp),
        shape = RoundedCornerShape(8.dp))
    {
        Column() {
            Image(
                painter = painterResource(menu.image),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp)
                    .clip(RoundedCornerShape(8.dp))
            )

            Column(modifier = Modifier.padding(8.dp))
            {

                Text(
                    text = menu.title,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.subtitle1.copy(
                        fontWeight = FontWeight.ExtraBold
                    )
                )

                Text(text = menu.price,
                    maxLines = 1,
                    style = MaterialTheme.typography.subtitle2
                )
            }
        }

    }
}

@Composable
@Preview(showBackground= true)
fun MenuItemPreview()
{
    RevisitingAndroidTheme() {
        MenuItem(
            menu = Menu(R.drawable.menu2, "Hot Pumpkin Latter Spice premium", "Rp.18.000"),
            modifier = Modifier.padding(8.dp)
        )
    }
}