package com.example.freegamelistapp.presentation.free_games_list.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.freegamelistapp.domain.model.FreeGames

@Composable
fun FreeGamesList(
    freeGames: FreeGames,
) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(5.dp)) {
        Card(modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .height(120.dp), backgroundColor = Color(0xFF0A1A3A),
            shape = RoundedCornerShape(15.dp), elevation = 15.dp) {
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically) {
                Card(shape = RoundedCornerShape(15.dp)) {
                    Image(painter = rememberImagePainter(data = freeGames.thumbnail),
                        contentDescription = "games thumbnail")
                }
                Column(modifier = Modifier
                    .fillMaxWidth()
                    .padding(15.dp)) {
                    Text(text = freeGames.title,
                        fontStyle = FontStyle.Italic,
                        textAlign = TextAlign.Center,
                        color = Color.White,
                        style = MaterialTheme.typography.body1)
                    Spacer(modifier = Modifier.height(20.dp))

                    Button(onClick = { /*TODO*/ },
                        shape = RoundedCornerShape(20.dp),
                        modifier = Modifier.size(height = 35.dp,
                            width = 85.dp)) {
                        Text(text = "Details")
                    }

                }

            }

        }
    }

}