package com.example.composegeo

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.composegeo.ui.theme.ComposegeoTheme

class MainActivity : ComponentActivity() {
    private val movieViewModel by viewModels<MovieViewModel>()

    @OptIn(ExperimentalMaterialApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposegeoTheme {
               Surface (
                   color = MaterialTheme.colors.background) {
                       MovieList(movieList = movieViewModel.movieListResponse)
                   movieViewModel.getMovieList()
                   }
            }
        }
    }
}

@Composable
fun MovieList(movieList:List<Movie>) {
    LazyColumn{
        itemsIndexed(items=movieList){ _, item ->
            MovieItem(movie = item)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposegeoTheme {
        val movie = Movie(
            "Coco",
            "https://howtodoandroid.com/images/coco.jpg",
            "Coco is a 2017 american 3d computer",
            "Latest"
        )
        MovieItem(movie = movie)
    }
}