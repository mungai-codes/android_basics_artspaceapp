package com.mungaicodes.artspaceapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mungaicodes.artspaceapp.ui.theme.ArtSpaceAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ArtSpaceApp()
                }
            }
        }
    }
}

@Composable
fun ArtSpaceApp() {

    var artwork by remember {
        mutableStateOf(1)
    }

    val image = when(artwork) {

        1 -> R.drawable.one
        2 -> R.drawable.two
        3 -> R.drawable.three
        4 -> R.drawable.four
        5 -> R.drawable.five
        6 -> R.drawable.six
        7 -> R.drawable.seven
        8 -> R.drawable.eight
        9 -> R.drawable.nine
        10 -> R.drawable.ten
        11 -> R.drawable.eleven
        else -> R.drawable.one
    }

    val header = when(artwork) {

        1 -> R.string.heading_1
        2 -> R.string.heading_2
        3 -> R.string.heading_3
        4 -> R.string.heading_4
        5 -> R.string.heading_5
        6 -> R.string.heading_6
        7 -> R.string.heading_7
        8 -> R.string.heading_8
        9 -> R.string.heading_9
        10 -> R.string.heading_10
        11 -> R.string.heading_11
        else -> R.string.heading_12
    }

    val description = when(artwork) {

        1 -> R.string.desc_1
        2 -> R.string.desc_2
        3 -> R.string.desc_3
        4 -> R.string.desc_4
        5 -> R.string.desc_5
        6 -> R.string.desc_6
        7 -> R.string.desc_7
        8 -> R.string.desc_8
        9 -> R.string.desc_9
        10 -> R.string.desc_10
        11 -> R.string.desc_11
        else -> R.string.desc_12
    }


    ArtSpaceAppImageAndContentDescription(
        image = painterResource(image),
        contentDescription = artwork.toString(),
        heading = header,
        description = description
    )

    DisplayControls(
        onPrevious = {
            artwork--
            if (artwork < 1) {
                artwork++
            }
        },
        onNextClick = {
            artwork++
            if (artwork > 12) {
                artwork--
            }
        },
    )
}

@Composable
fun DisplayControls(
    modifier: Modifier = Modifier,
    onPrevious: () -> Unit,
    onNextClick: () -> Unit

) {
    Row(
        modifier = modifier
            .fillMaxSize()
            .padding(bottom = 15.dp),
        verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.Center
    ) {
        Button(
            onClick = onPrevious
        ) {
            Text(text = "PREVIOUS")
        }
        Spacer(modifier = Modifier.width(55.dp))
        Button(
            onClick = onNextClick,
            modifier = Modifier
                .width(108.dp)
        ) {
            Text(text = "Next")
        }
    }
}

@Composable
fun ArtSpaceAppImageAndContentDescription(
    modifier: Modifier = Modifier,
    image: Painter,
    contentDescription: String,
    @StringRes heading: Int,
    @StringRes description: Int,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
            .fillMaxSize()
            .padding(top = 160.dp)
    ) {
        Surface(
            elevation = 10.dp,
            shape = RoundedCornerShape(10.dp),
            border = BorderStroke(3.dp, Color.DarkGray),
            color = Color.White
        ) {
            Image(
                painter = image,
                contentDescription = contentDescription,
                modifier = Modifier
                    .wrapContentSize(Alignment.Center)
                    .padding(10.dp)
            )
        }
        Spacer(modifier = Modifier.height(60.dp))
        Surface(
            elevation = 10.dp,
            shape = RoundedCornerShape(10.dp),
            border = BorderStroke(3.dp, Color.DarkGray),
            color = Color.White,
        ) {
            Column(
                modifier = Modifier
                    .padding(10.dp)

            ) {
                Text(
                    text = stringResource(heading),
                    fontSize = 22.sp,
                    fontWeight = FontWeight.SemiBold,
                    textAlign = TextAlign.Justify
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = stringResource(description),
                    fontSize = 20.sp,
                    fontFamily = FontFamily.Cursive,
                    textAlign = TextAlign.Justify
                )
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun ArtSpaceAppPreview() {
    ArtSpaceAppTheme {
        ArtSpaceApp()
    }
}