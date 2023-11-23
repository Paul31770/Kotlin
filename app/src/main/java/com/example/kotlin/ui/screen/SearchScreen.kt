package com.example.kotlin.ui.screen

import android.provider.Settings.Global.getString
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.ui.graphics.Color
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.bumptech.glide.integration.compose.placeholder
import com.example.kotlin.R
import com.example.kotlin.exo.PictureData
import com.example.kotlin.exo.pictureList
import com.example.kotlin.ui.theme.KotlinTheme
import com.google.mlkit.vision.text.Text

@Composable
fun searchScreen( modifier: Modifier = Modifier){
    Column(modifier) {
        SearchBar()
        Spacer(Modifier.size(5.dp))
        PictureRowItemPreview(pictureList[0])


    }
    button()
}


@Composable
fun PictureRowItemPreview(data: PictureData) {
    //nom visible dans MainActivity en dessous de setContent{
    KotlinTheme {

        var myList = pictureList
        LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            items(myList.size) {
                PictureRowItem(myList[it])
            }
        }


    }
}



@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun PictureRowItem(data: PictureData, modifier: Modifier = Modifier) {
    var expanded by remember { mutableStateOf(false) }

    Row(modifier = Modifier.padding(horizontal = 5.dp)) {

        GlideImage(
            model = data.url,
            contentDescription = data.text,

            failure = placeholder(R.mipmap.ic_launcher),

            modifier = modifier
                .heightIn(100.dp)
                .widthIn(100.dp)

        )
        Column(
            modifier = Modifier
                .defaultMinSize(minHeight = 100.dp)
                .background(Color.White)
                .fillMaxWidth()
                .padding(horizontal = 5.dp)
                /*.heightIn(min = if (expanded) 950.dp else 100.dp)*/
                .clickable { expanded = !expanded },


        ) {
            Text(
                text = data.text,
                fontSize = 20.sp,
            )
            Text(
                text = if (expanded) data.longText else data.longText.take(20) + " ...",
                maxLines = Int.MAX_VALUE,
                fontSize = 14.sp,
                color = Color.Blue,
                textAlign = TextAlign.Start,
                modifier = Modifier
                    .animateContentSize()
                    .fillMaxWidth()
                    .padding(8.dp),

            )

        }
    }
}














