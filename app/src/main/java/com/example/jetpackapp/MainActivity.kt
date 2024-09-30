package com.example.jetpackapp

import android.os.Bundle
import android.widget.EditText
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackapp.ui.theme.JetpackAppTheme
import com.example.jetpackapp.ui.theme.Light_Blue

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
                    PinCodeScreen()
                }
            }
        }
    }
}


@Composable
fun PinCodeScreen() {
    var inputText by remember { mutableStateOf("") }
    var pinCode by remember { mutableStateOf("527131") }
    var errorPin by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        TextBlock(inputText, errorPin)

        PinCodeBlock({ buttonValue ->
            inputText += buttonValue // Обновляем inputText
        },
            onOkClick = {
                errorPin = inputText != pinCode
            })
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextBlock(inputText: String, errorPin: Boolean) {
    Column(
        modifier = Modifier
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Text(
            textAlign = TextAlign.Center,
            text = inputText,
            color = if (errorPin) Color.Red else Color.Black,
            modifier = Modifier.fillMaxWidth(),

            )
    }
}


@Composable
fun PinCodeBlock(
    onButtonClick: (String) -> Unit,
    onOkClick: () -> Unit
) {

    Row(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly // Используйте SpaceEvenly для равномерного расстояния или просто SpaceBetween для уменьшения пустого пространства
    ) {
        CalculatorButton(onClick = { onButtonClick("1") }, text = "1")
        CalculatorButton(onClick = { onButtonClick("2") }, text = "2")
        CalculatorButton(onClick = { onButtonClick("3") }, text = "3")
    }
    Row(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),

        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        CalculatorButton(onClick = { onButtonClick("4") }, text = "4")
        CalculatorButton(onClick = { onButtonClick("5") }, text = "5")
        CalculatorButton(onClick = { onButtonClick("6") }, text = "6")
    }
    Row(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        CalculatorButton(onClick = { onButtonClick("7") }, text = "7")
        CalculatorButton(onClick = { onButtonClick("8") }, text = "8")
        CalculatorButton(onClick = { onButtonClick("9") }, text = "9")
    }
    Row(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        CalculatorButton(onClick = { onButtonClick("") }, text = "<-")
        CalculatorButton(onClick = { onButtonClick("0") }, text = "0")
        CalculatorButton(onClick = { onOkClick() }, text = "OK")


    }
}


@Composable
fun CalculatorButton(
    onClick: () -> Unit,
    text: String,
    modifier: Modifier = Modifier,
    enabled: Boolean = true
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        shape = RoundedCornerShape(5.dp),
        border = BorderStroke(1.dp, Color.White),
        colors = ButtonDefaults.buttonColors(
            containerColor = Light_Blue,
            contentColor = Color.White
        ),
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = 8.dp,
            pressedElevation = 12.dp,
            disabledElevation = 0.dp
        )
    ) {
        Text(text)
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetpackAppTheme {
        PinCodeScreen()
    }
}