package com.norm.myimagecarouselcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.content.MediaType.Companion.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.carousel.HorizontalUncontainedCarousel
import androidx.compose.material3.carousel.rememberCarouselState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import com.norm.myimagecarouselcompose.ui.theme.MyImageCarouselComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyCarousel()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyCarousel() {
    val carouselState = rememberCarouselState {
        4
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        HorizontalUncontainedCarousel(
            state = carouselState,
            itemWidth = 300.dp,
            itemSpacing = 16.dp,
        ) { page ->
            Box(
                modifier = Modifier
                    .size(256.dp),
            ) {
                Image(
                    painter = painterResource(
                        id = when (page) {
                            0 -> R.drawable.img1
                            1 -> R.drawable.img2
                            3 -> R.drawable.img3
                            4 -> R.drawable.img4
                            else -> R.drawable.ic_launcher_background
                        },
                    ),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxSize()
//                        .clip(RoundedCornerShape(16.dp)),
                )
            }
        }
    }
}