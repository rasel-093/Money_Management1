package com.example.money_management1.screens

import android.content.Intent
import androidx.activity.ComponentActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.money_management1.MainActivity
import com.example.money_management1.R
import com.example.money_management1.SignUpActivity
import com.example.money_management1.ui.theme.primaryColor
import com.example.money_management1.ui.theme.whiteBackground


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(context: ComponentActivity){
    //val context  = LocalContext.current
    val image =   painterResource(id = R.drawable.money_bag)
    val email = rememberSaveable {
        mutableStateOf("")
    }
    val password = rememberSaveable {
        mutableStateOf("")
    }
    val passwordVisibility = rememberSaveable{
        mutableStateOf(false)
    }
//    val focusRequester: FocusRequester = rememberSaveable {
//        FocusRequester()
//    }
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Box(
            modifier = Modifier
                //.fillMaxWidth()
                //.fillMaxHeight(0.4f)
                .fillMaxSize()
                .background(whiteBackground),
            contentAlignment = Alignment.TopCenter
        ) {
            Image(
                painter = image,
                contentDescription = null,
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .background(whiteBackground)
                    .padding(top = 40.dp)
            )
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
           // verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                //.fillMaxHeight()
                .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
                .background(whiteBackground)
                .padding(5.dp)
        ) {
            Text(
                text = "Sign in",
                style = TextStyle(fontWeight = FontWeight.Bold, letterSpacing = 2.sp),
                fontSize = 26.sp
            )
            //Spacer(modifier = Modifier.padding(20.dp))
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                OutlinedTextField(
                    value = email.value,
                    onValueChange = {email.value = it},
                    label = { Text(text = "Email Address" ) },
                    placeholder = { Text(text = "Email Address" ) },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth(0.8f)
                )
                OutlinedTextField(
                    value = password.value,
                    onValueChange = {password.value = it},
                    trailingIcon = {
                        IconButton(onClick = { passwordVisibility.value = !passwordVisibility.value }) {
                            Icon(
                                painter = painterResource(id = R.drawable.password_eye),
                                contentDescription = null,
                                tint = if(passwordVisibility.value) primaryColor else Color.Gray
                            )
                        }
                    },
                    label = { Text(text = "Password") },
                    placeholder = { Text(text = "Password") },
                    singleLine = true,
                    visualTransformation = if(passwordVisibility.value) VisualTransformation.None
                    else PasswordVisualTransformation(),
                    modifier = Modifier.fillMaxWidth(0.8f)
                )
                Spacer(modifier = Modifier.padding(10.dp))
                Button(
                    onClick = {
                        val intent = Intent(context,MainActivity::class.java)
                        context.startActivity(intent)
                        context.finish()
                    },
                    modifier = Modifier
                        .fillMaxWidth(0.8f)
                        .height(50.dp)
                )
                {
                    Text(
                        text = "Sign in",
                        fontSize = 20.sp
                    )
                }
                Spacer(modifier = Modifier.padding(10.dp))
                Text(
                    text = "Create An Account",
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp,
                    color = Color(0xFF485CCA),
                    modifier = Modifier.clickable(
                        onClick = {
                            val intent = Intent(context, SignUpActivity::class.java)
                            context.startActivity(intent)
                        }
                    )
                )
                Spacer(modifier = Modifier.padding(20.dp))
            }
        }
    }
}