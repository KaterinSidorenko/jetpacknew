package com.example.jetpackapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults.cardElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackapp.ui.theme.JetpackAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("People!", "How are you?")


                }
            }
        }
    }
}


@Composable
fun Greeting(name: String, greetingWord: String = "Hello") {


    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            "List items", fontSize = 16.sp,
            modifier = Modifier
                .padding(8.dp)
        )

        LazyColumn {

            items(20) { index ->
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                        .background(Color.Blue)

                ) {

                    Card(
                        border = BorderStroke(
                            2.dp,
                            Color.Yellow
                        ),
                        elevation = cardElevation(
                            defaultElevation = 6.dp
                        ), modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                    ) {

                        Image(
                            painter = painterResource(id = R.drawable.ic_android),
                            contentDescription = null,
                            modifier = Modifier
                                .padding(8.dp)
                                .width(24.dp)
                                .height(24.dp)
                        )

                        Text(
                            text = "Hello $name!, $greetingWord",
                            modifier = Modifier
                                .padding(8.dp)
                        )


                    }

                }

            }

        }

    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetpackAppTheme {
        Greeting("wolf")
    }
}