package ifi.minapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.platform.SoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ifi.minapp.ui.theme.MyApplicationTheme

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun Outlay(){
    var correct = "";
    var text by remember {
        mutableStateOf("")
    }
    var ans = "";
    val keyboardController = LocalSoftwareKeyboardController.current

    Column (
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Center,
    modifier = Modifier
        .padding(16.dp)){
        ShowImage()
        if (keyboardController != null) {
            text = textBox(keyboardController)
            ans = checkAnswere(ans = text, correct = correct).toString()
            OutlinedTextField(value = ans, onValueChange = {ans = it}, readOnly = true, enabled = false)
        }
    }
}

@Composable
fun ShowImage(){
    Image(
        painter = painterResource(id = R.drawable.countryclues_logos_transparent),
        contentDescription = "A call icon for calling"
    )
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun textBox(keyboardController: SoftwareKeyboardController): String{

    var text by remember {
        mutableStateOf("")
    }
    OutlinedTextField(value = text, onValueChange = {text = it},
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
        keyboardActions = KeyboardActions(
            onDone = {
                keyboardController.hide() }))
    return text
}

@Composable
fun checkAnswere(ans: String, correct: String): Boolean{
    return ans == correct
}

/*@Composable
fun ShowText(ans: String){
    var ans by remember {
        mutableStateOf("")
    }
    OutlinedTextField(value = ans, onValueChange = {ans = it}, readOnly = true, enabled = false)
    // Må kanskje returne ans
}*/

@Preview
@Composable
fun OutlayPreview(){
    MyApplicationTheme{
        Outlay()
    }
}