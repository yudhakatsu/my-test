package com.amanda.jetheroes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.amanda.jetheroes.model.HeroesData
import com.amanda.jetheroes.ui.theme.JetHeroesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetHeroesTheme{
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    JetHeroesApp()
                }
            }
        }
    }

    @Composable
    fun JetHeroesApp(
        modifier: Modifier = Modifier,
    ) {
        Box(modifier = modifier) {
            LazyColumn {
                items(HeroesData.heroes, key = { it.id }) { hero ->
                    HeroListItem(
                        name = hero.name,
                        photoUrl = hero.photoUrl,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
        }
    }
}