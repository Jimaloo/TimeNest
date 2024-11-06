package com.jimjuma.timenest.screens.home

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.jimjuma.timenest.data.MuseumObject
import com.jimjuma.timenest.screens.EmptyScreenContent
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun HomeScreen(
    navigateToDetails: (objectId: Int) -> Unit
) {
    val viewModel = koinViewModel<ListViewModel>()
    val timeZones = listOf(
        TimeZoneInfo("Aerith", "Berlin", "4:58 PM", "☀️", Color(0xFF4A90E2)),
        TimeZoneInfo("Vincent", "Transylvania", "5:58 PM", "🌤", Color(0xFFFFCC00)),
        TimeZoneInfo("Cloud", "Kyoto", "11:58 PM", "🌙", Color(0xFFB1B1B1))
    )
    Scaffold(
        topBar = {
            Spacer(modifier = Modifier.height(50.dp))
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navigateToDetails(1)
                },
                backgroundColor = Color(0xFFFFCC00)
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Add")
            }
        },
        backgroundColor = Color.Black
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            MainClock(
                "9:58 AM",
                "Good Night",
                "Nairobi"
            )

            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(timeZones) { timeZone ->
                    TimeZoneCard(timeZone)
                }
            }
        }
    }
}

@Composable
fun MainClock(currentTime: String, greeting: String, location: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp)
    ) {
        Text(
            text = currentTime,
            style = MaterialTheme.typography.h3,
            color = Color.White
        )
        Text(
            text = greeting,
            style = MaterialTheme.typography.h6,
            color = Color.White
        )
        Box(
            modifier = Modifier
                .padding(top = 4.dp)
                .background(Color.DarkGray, shape = RoundedCornerShape(12.dp))
                .padding(horizontal = 12.dp, vertical = 4.dp)
        ) {
            Text(
                text = location.uppercase(),
                style = MaterialTheme.typography.caption,
                color = Color.White
            )
        }
    }
}

@Composable
fun TimeZoneCard(timeZoneInfo: TimeZoneInfo) {
    Card(
        shape = RoundedCornerShape(12.dp),
        backgroundColor = Color(0xFF1C1C1E),
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = timeZoneInfo.name,
                        style = MaterialTheme.typography.h6,
                        color = Color.White
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = timeZoneInfo.icon, fontSize = 20.sp)
                }
                Spacer(modifier = Modifier.height(4.dp))
                Box(
                    modifier = Modifier
                        .background(timeZoneInfo.locationColor, shape = RoundedCornerShape(8.dp))
                        .padding(horizontal = 8.dp, vertical = 4.dp)
                ) {
                    Text(
                        text = timeZoneInfo.location.uppercase(),
                        style = MaterialTheme.typography.caption,
                        color = Color.White
                    )
                }
            }

            Text(
                text = timeZoneInfo.time,
                style = MaterialTheme.typography.h6,
                color = Color.White
            )
        }
    }
}

data class TimeZoneInfo(
    val name: String,
    val location: String,
    val time: String,
    val icon: String,
    val locationColor: Color
)
