package com.example.moodtracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.moodtracker.ui.theme.MoodTrackerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MoodTrackerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MainApp()
                }
            }
        }
    }
}

@Composable
fun MainApp() {
    var tab by remember { mutableStateOf(1) }

    Column(
        modifier = Modifier
            .fillMaxSize()
    ){

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = { tab = 1 }
            ) {
                Text(
                    text = "Calender Tab",
                    fontSize = 13.sp
                )
            }
            Button(
                onClick = { tab = 2 }
            ) {
                Text(
                    text = "Analysis Tab",
                    fontSize = 13.sp
                )
            }
            Button(
                onClick = { tab = 3 }
            ) {
                Text(
                    text = "Profile Tab",
                    fontSize = 13.sp
                )
            }
        }

        when (tab) {
            1 -> { CalenderTab() }
            2 -> { AnalysisTab() }
            else -> { ProfileTab() }
        }
    }
}

@Composable
fun CalenderTab(){
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Image(
            painter = painterResource(id = R.drawable.calender),
            contentDescription = "Calender"
        )

        Spacer (modifier = Modifier.height(24.dp))

        Text(
            text = "How was your day!",
            fontSize = 24.sp
        )

        Spacer(modifier = Modifier.height(24.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ){
            Button(
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
                border = BorderStroke(2.dp, Color.Blue),
                onClick = {}
            ){
                Image(
                    painter = painterResource(id = R.drawable.happy_face),
                    contentDescription = "Happy Face"
                )
            }

            Spacer(modifier = Modifier.width(36.dp))

            Button(
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
                border = BorderStroke(2.dp, Color.Blue),
                onClick = {}
            ){
                Image(
                    painter = painterResource(id = R.drawable.meh_face),
                    contentDescription = "Meh Face"
                )
            }

            Spacer(modifier = Modifier.width(36.dp))

            Button(
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
                border = BorderStroke(2.dp, Color.Blue),
                onClick = {}
            ){
                Image(
                    painter = painterResource(id = R.drawable.sad_face),
                    contentDescription = "Sad Face"
                )
            }
        }
    }
}

@Composable
fun ProfileTab(){
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Image(
            painter = painterResource(id = R.drawable.profile),
            contentDescription = "Profile Image",
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = "Name: Samuel Jackson",
            fontSize = 24.sp
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = "Age: 73",
            fontSize = 24.sp
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = "Hobbies: Cricket, drawing, Swimming",
            fontSize = 24.sp
        )
    }
}

@Composable
fun AnalysisTab(){
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Image(
            painter = painterResource(id = R.drawable.mood_graph),
            contentDescription = "Mood Graph",
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Happiness Percentage for last Month = 88%"
        )
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MoodTrackerTheme {
        MainApp()
    }
}