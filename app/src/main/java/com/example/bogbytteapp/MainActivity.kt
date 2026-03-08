package com.example.bogbytteapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bogbytteapp.ui.theme.BogbytteAPPTheme
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.lazy.grid.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.unit.*
import androidx.compose.ui.res.painterResource
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.Icons


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            page1()
        }
    }
}

@Composable
fun page1() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        // Search bar
        TextField(
            value = "",
            onValueChange = {},
            placeholder = { Text("Search Books") },
            leadingIcon = {
                Icon(Icons.Default.Search, contentDescription = "Search")
            },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Explore books title
        Text(
            text = "Explore books",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )

        Divider()

        // Book grid
        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            modifier = Modifier.height(300.dp)
        ) {

            items(6) {
                Image(
                    painter = painterResource(id = R.drawable.book),
                    contentDescription = "Book",
                    modifier = Modifier
                        .padding(4.dp)
                        .height(120.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Recently added
        Text(
            text = "Recently added",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )

        Divider()

        LazyRow {

            items(6) {
                Image(
                    painter = painterResource(id = R.drawable.book),
                    contentDescription = "Book",
                    modifier = Modifier
                        .padding(4.dp)
                        .height(120.dp)
                )
            }

        }

        Spacer(modifier = Modifier.weight(1f))

        // Bottom navigation
        NavigationBar {

            NavigationBarItem(
                icon = { Icon(Icons.Default.Home, contentDescription = "Home") },
                label = { Text("Home") },
                selected = true,
                onClick = {}
            )

            NavigationBarItem(
                icon = { Icon(Icons.Default.List, contentDescription = "Trade Books") },
                label = { Text("Trade") },
                selected = false,
                onClick = {}
            )

            NavigationBarItem(
                icon = { Icon(Icons.Default.List, contentDescription = "My Books") },
                label = { Text("My Books") },
                selected = false,
                onClick = {}
            )
        }
    }
}