package com.example.evenoroddnumber

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Home()

        }
    }
}

@Composable
fun Home(){

    var number by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("") }

    fun verifyNumber(){
        val value = number.toIntOrNull()
        result = when{
            value == null ->" Please enter a valid number!"
            value % 2 == 0 ->"$ Even value"
            else -> "$ Odd number"

        }
    }

    Column(
        modifier = Modifier.fillMaxSize().background(color = Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        OutlinedTextField(
            value = number,
            onValueChange = {
                number = it
            },
            label = {
                Text(text = "Enter a Number")
            },
            
            modifier = Modifier.fillMaxWidth(0.5f),
            maxLines = 1,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        Button(
            onClick = {
                verifyNumber()

            },
            modifier = Modifier.padding(vertical = 20.dp)

        ) {


            Text(
                text = "Verify",
                fontSize = 18.sp
            )

        }
        Text(
            text ="Result",
            fontSize = 25.sp
        )
    }

}



@Preview
@Composable
private fun HomePreview(){
    Home()

}
