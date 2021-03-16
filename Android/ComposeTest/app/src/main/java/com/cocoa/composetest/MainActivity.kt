package com.cocoa.composetest

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cocoa.composetest.ui.theme.ComposeTestTheme

//https://developer.android.com/codelabs/jetpack-compose-layouts?continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fcompose%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fjetpack-compose-layouts#2
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTestTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    DefaultPreview1()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

fun test() {
//    Toast.makeText(this@,R.string.app_name,Toast.LENGTH_LONG).show()

}

@Preview(showSystemUi = true)
@Composable
fun DefaultPreview1() {
    Column (modifier = Modifier.width(400.dp)
        ){
        SelectionContainer {
            Text(text = "12311231231123123112312311231231123123112312311231231123" ,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1
            )
        }
        Text(
            stringResource(id = R.string.app_name),
            color = Color.Blue,
            fontSize = 13.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.width(300.dp),
            textAlign = TextAlign.Right
        )
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
//    ComposeTestTheme {
//        Greeting("Android")
//    }
    val painter = painterResource(id = R.mipmap.logo)

    Row(
        modifier = Modifier.padding(5.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Button(onClick = {
            Log.d("123", "--123--")
        }) {
            Image(
                painter = painter,
                contentDescription = "Profile pic",
                modifier = Modifier.size(20.dp)
            )
        }
        Column(modifier = Modifier.padding(start = 5.dp)) {
            Text(text = "阿国", fontSize = 10.sp)
            Text(text = "hahah is zhengenguo", fontSize = 8.sp)
        }

    }
}