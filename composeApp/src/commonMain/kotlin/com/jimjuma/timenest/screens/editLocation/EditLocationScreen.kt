package com.jimjuma.timenest.screens.editLocation

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
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.painterResource

@Composable
fun EditLocationScreen(
    navigateToEditScreen: (objectId: Int) -> Unit
) {
    Scaffold(
        topBar = {

            TopAppBar(
                title = { Text("Edit Location", color = Color.White) },
                backgroundColor = Color(0xFF1C1C1E),
                navigationIcon = {
                    IconButton(onClick = { /* Handle back navigation */ }) {
                        Icon(
                            Icons.Default.ArrowBack,
                            contentDescription = "Back",
                            tint = Color.White
                        )
                    }
                },
                actions = {
                    Text(
                        text = "SAVE",
                        color = Color(0xFFFFC107),
                        style = MaterialTheme.typography.button,
                        modifier = Modifier
                            .padding(end = 16.dp)
                            .clickable { /* Handle save action */ }
                    )
                }
            )

        },
        backgroundColor = Color(0xFF1C1C1E)
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            SectionTitle(title = "Pick a time zone", subtitle = "Life begins here.")
            EditableField(icon = Icons.Default.Search, placeholder = "Europe/Berlin")

            SectionTitle(
                title = "Add a place",
                subtitle = "Didn't get the name of the place right? Just change it here."
            )
            EditableField(placeholder = "Berlin")

            SectionTitle(
                title = "Who Lives Here",
                subtitle = "It can be a person’s name, your remote team office in a different time zone or anything at all."
            )
            EditableField(placeholder = "Aerith")

            Spacer(modifier = Modifier.weight(1f))

            Button(
                onClick = { /* Handle delete action */ },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFE3045A)),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                shape = RoundedCornerShape(28.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Delete, // Use appropriate icon resource
                    contentDescription = "Delete",
                    tint = Color.White
                )
            }
        }
    }
}

@Composable
fun SectionTitle(title: String, subtitle: String) {
    Column {
        Text(
            text = title,
            style = MaterialTheme.typography.h6.copy(fontWeight = FontWeight.Bold),
            color = Color.White
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = subtitle,
            style = MaterialTheme.typography.body2,
            color = Color.Gray
        )
    }
}

@Composable
fun EditableField(icon: ImageVector? = null, placeholder: String) {
    OutlinedTextField(
        value = "",
        onValueChange = { /* Handle text input */ },
        placeholder = { Text(text = placeholder, color = Color.White) },
        leadingIcon = {
            icon?.let {
                Icon(imageVector = it, contentDescription = null, tint = Color.White)
            }
        },
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF3A3A3C), shape = RoundedCornerShape(8.dp)),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.Transparent,
            unfocusedBorderColor = Color.Transparent,
            backgroundColor = Color(0xFF3A3A3C),
            textColor = Color.White
        )
    )
}