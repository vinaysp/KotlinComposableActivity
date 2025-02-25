package com.example.composearticlekotlin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composearticlekotlin.ui.theme.ComposeArticleKotlinTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeArticleKotlinTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    ArticleBanner()
                    ArticleStructure(
                        title = stringResource(R.string.article_title),
                        firstParagraph = stringResource(R.string.article_first_paragraph),
                        secondParagraph = stringResource(R.string.article_second_paragraph),
                        articleBannerImage = painterResource(R.drawable.bg_compose_background),
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun ArticleStructure(title: String,
                firstParagraph: String,
                secondParagraph: String,
                articleBannerImage: Painter,
                modifier: Modifier = Modifier
) {
    Column(modifier) {
        Image(painter = articleBannerImage, contentDescription = null)
        Text(
            text = title,
            fontSize = 24.sp,
            modifier = Modifier
                .padding(start = 16.dp,
                    end = 16.dp,
                    bottom = 16.dp,
                    top = 16.dp)
        )
        Text(
            text = firstParagraph,
            textAlign = TextAlign.Justify,
            modifier = Modifier
                .padding(start = 16.dp,
                    end = 16.dp)

        )
        Text(
            text = secondParagraph,
            textAlign = TextAlign.Justify,
            modifier = Modifier
                .padding(start = 16.dp,
                    end = 16.dp,
                    bottom = 16.dp,
                    top = 16.dp)

        )
    }
}


//@Composable
//fun ArticleBanner(modifier: Modifier = Modifier){
//    val banner = painterResource(R.drawable.bg_compose_background)
//    Box(modifier.fillMaxSize()) {
//        Image(
//            painter = banner,
//            contentDescription = null
//        )
//    }
//}

@Preview(showBackground = true)
@Composable
fun ArticlePreview() {
    ComposeArticleKotlinTheme {
        ArticleBanner()
        ArticleText(
            stringResource(R.string.article_title),
            stringResource(R.string.article_first_paragraph),
            stringResource(R.string.article_second_paragraph)
        )
    }

}