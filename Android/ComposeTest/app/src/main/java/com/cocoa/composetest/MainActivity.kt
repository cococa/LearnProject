package com.cocoa.composetest

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cocoa.composetest.ui.theme.ComposeTestTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val defaultPreview2ViewModel by viewModels<DefaultPreview2ViewModel>()
        setContent {
            ComposeTestTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    ExpandingCard("this is title","状态应该由可组合项中的事件来修改。如果您在运行可组合项时而不是在事件中修改状态，就会产生可组合项的附带效应，应予以避免。如需详细了解 Jetpack Compose 中的附带效应，请参阅 Compose 编程思想。\n" +
                            "为了完成 ExpandingCard 可组合项，我们来显示 body 以及收起按钮（当 expanded 为 true 时）和展开按钮（当 expanded 为 false 时）。")
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
                modifier = Modifier
                    .size(40.dp)
                    .clip(shape = RoundedCornerShape(14.dp))
            )
        }
        Column(modifier = Modifier.padding(start = 5.dp)) {
            Text(text = "123222123", fontSize = 10.sp)
            Text(
                text = "hahah is 12311231231123123112312311231231123123112312311231231123",
                fontSize = 18.sp
            )
            Text(text = "123", maxLines = 2, overflow = TextOverflow.Clip)
        }

    }
}


@Preview(showSystemUi = true)
@Composable
fun DefaultPreview1() {
    Column(
//        modifier = Modifier.width(40.dp)
    ) {
        var name by rememberSaveable { mutableStateOf("") }
        Text("hello${name}")
        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Name") }
        )
    }
}

class DefaultPreview2ViewModel : ViewModel(){
     var name = MutableLiveData<String>("")

    fun changeValue(newValue :String){
        name.value = newValue
    }
}

@Composable
fun DefaultPreview2(defaultPreview2ViewModel : DefaultPreview2ViewModel) {

    val observeName by defaultPreview2ViewModel.name.observeAsState()
    observeName?.let {
        getComponent(it){
            defaultPreview2ViewModel.changeValue(it)
        }
    }


}

@Composable
fun getComponent(name: String, onValueChange: (String) -> Unit) {
    Column(
        modifier = Modifier.padding(10.dp)
    ) {
        Text("hello${name} from method getComponent() ")
        OutlinedTextField(
            value = name,
            onValueChange = onValueChange,
            label = { Text("Name") }
        )
    }
}

@Composable
fun ExpandingCard(title: String, body: String) {
    var expanded by remember { mutableStateOf(false) }

    // describe the card for the current state of expanded
    Card {
        Column(
            Modifier
                .width(280.dp)
                .animateContentSize() // automatically animate size when it changes
                .padding(top = 16.dp, start = 16.dp, end = 16.dp)
        ) {
            Text(text = title)

            // content of the card depends on the current value of expanded
            if (expanded) {
                Text(text = body, Modifier.padding(top = 8.dp))
                // change expanded in response to click events
                IconButton(onClick = { expanded = false }, modifier = Modifier.fillMaxWidth()) {
                    Text("open")
                }
            } else {
                // change expanded in response to click events
                IconButton(onClick = { expanded = true }, modifier = Modifier.fillMaxWidth()) {
                    Text("close")
                }
            }
        }
    }
}


















