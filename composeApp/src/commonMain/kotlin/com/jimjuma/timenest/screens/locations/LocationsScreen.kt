package com.jimjuma.timenest.screens.locations

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun LocationsScreen(
    navigateToEditScreen: (objectId: Int) -> Unit

) {

    val timeZones = listOf(
        TimeZoneInfo("Auckland", "Pacific", "2:58 AM", Color.Gray),
        TimeZoneInfo("Azores", "Atlantic", "2:58 PM", Color.Blue),
        TimeZoneInfo("Baghdad", "Asia", "5:58 PM", Color(0xFFFFCC00)),
        TimeZoneInfo("Bahia", "America", "11:58 AM", Color.Blue),
        TimeZoneInfo("Bahia Banderas", "America", "9:58 AM", Color.Blue),
        TimeZoneInfo("Bahrain", "Asia", "5:58 PM", Color(0xFFFFCC00))
    )

    Scaffold(
        topBar = {

                TopAppBar(
                    backgroundColor = Color(0xFF1C1C1E),
                    title = {
                        TextField(
                            value = "",
                            onValueChange = {},
                            placeholder = { Text("Search", color = Color.Gray) },
                            leadingIcon = {
                                Icon(
                                    Icons.Default.Search,
                                    contentDescription = "Search"
                                )
                            },
                            colors = TextFieldDefaults.textFieldColors(
                                backgroundColor = Color(0xFF3A3A3C),
                                textColor = Color.White,
                                cursorColor = Color.White,
                                focusedIndicatorColor = Color.Transparent,
                                unfocusedIndicatorColor = Color.Transparent
                            ),
                            modifier = Modifier.fillMaxWidth()
                        )
                    },
                    navigationIcon = {
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(
                                Icons.Default.ArrowBack,
                                contentDescription = "Back",
                                tint = Color.White
                            )
                        }
                    }
                )

        },
        backgroundColor = Color(0xFF1C1C1E)
    ) { paddingValues ->
        LazyColumn(
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            items(timeZones) { timeZone ->
                TimeZoneItem(timeZone) {
                    navigateToEditScreen(1)
                }
            }
        }
    }
}

@Composable
fun TimeZoneItem(timeZoneInfo: TimeZoneInfo, itemClicked: (id: Int) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth().clickable{
                itemClicked(1)
            }
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            Text(
                text = timeZoneInfo.name,
                style = MaterialTheme.typography.body1,
                color = Color.White
            )
            Spacer(modifier = Modifier.height(4.dp))
            Box(
                modifier = Modifier
                    .background(timeZoneInfo.regionColor, shape = RoundedCornerShape(8.dp))
                    .padding(horizontal = 8.dp, vertical = 4.dp)
            ) {
                Text(
                    text = timeZoneInfo.region.uppercase(),
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

data class TimeZoneInfo(
    val name: String,
    val region: String,
    val time: String,
    val regionColor: Color
)