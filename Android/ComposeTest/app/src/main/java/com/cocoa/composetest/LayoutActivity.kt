package com.cocoa.composetest

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.*
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.awaitFirstDown
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyVerticalGrid
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
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cocoa.composetest.ui.theme.ComposeTestTheme
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class LayoutActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTestTheme {
                Surface(color = MaterialTheme.colors.background) {
                    LayoutActivityDefaultPreview()
                }
            }
        }
    }
}


@Preview(showSystemUi = true)
@Composable
fun LayoutActivityDefaultPreview() {
    val painter = painterResource(id = R.mipmap.logo)
    var message by remember { mutableStateOf("Hello") }
    var enabled by remember { mutableStateOf(true) }
    val alpha: Float by animateFloatAsState(if (enabled) 1f else 0.1f)

    val color by animateColorAsState(
        if (enabled) Color.Blue else Color.Red,
//        animationSpec = spring(Spring.StiffnessMedium)
    )


    val offset = remember { Animatable(Offset(0f, 0f), Offset.VectorConverter) }
    

    Column(
        modifier = Modifier.padding(15.dp)
    ) {

        Box(
            modifier = Modifier
                .fillMaxSize()
                .pointerInput(Unit) {
                    coroutineScope {
                        while (true) {
                            // Detect a tap event and obtain its position.
                            val position = awaitPointerEventScope {
                                awaitFirstDown().position
                            }
                            launch {
                                // Animate to the tap position.
                                offset.animateTo(position)
                            }
                        }
                    }
                }
        ) {
//            Box(modifier = Modifier.offset(offset= offset))
            Text("${offset.value.x}")
        }
        
        Box(
            Modifier
                .height(50.dp)
                .width(50.dp)
//                .graphicsLayer(alpha = alpha)
                .background(color)
        )
        Box(
            modifier = Modifier
//                .background(Color.Blue)
                .animateContentSize()
        ) {
            Button(onClick = {
                if(message.equals("Hello")){
                    message = "123123123123123123"
                    enabled = false
                }else{
                    enabled = true
                    message = "Hello"
                }
            }) {
                Text(text = message)
            }
        }


        Text("* 使用 Modifier.weight")
        Row(modifier = Modifier.padding(10.dp)) {
            Box(
                modifier = Modifier
                    .weight(2F)
                    .height(30.dp)
                    .background(Color.Blue)
            )
            Box(
                modifier = Modifier
                    .weight(1F)
                    .height(30.dp)
                    .background(Color.Red)
            )
        }
        Text("* 使用 BoxWithConstraints 获取父控件的参数")
        BoxWithConstraints() {
            var width = maxWidth / 3;
            Text(
                "My minHeight is $minHeight while my maxWidth is $maxWidth 把当前的text 设置为屏幕的三分之一",
                modifier = Modifier
                    .width(width = width)
                    .background(Color.Gray)
            )
        }
        Text("* 使用 BoxWithConstraints 获取父控件的参数")

//        LazyVerticalGrid(
//            cells = GridCells.Adaptive(minSize = 128.dp)
//        ) {
//            items(3) { photo ->
//                Image(painter = painter, contentDescription = "")
//            }
//        }

        LazyColumn (
            contentPadding = PaddingValues(10.dp),
            verticalArrangement = Arrangement.spacedBy(14.dp),
        ){


            // Add a single item
            item {
                Text(text = "First item")
            }

            // Add 5 items
            items(35) { index ->
                Text(text = "Item: $index")
            }

            // Add another single item
            item {
                Text(text = "Last item")
            }
        }

    }
}

















