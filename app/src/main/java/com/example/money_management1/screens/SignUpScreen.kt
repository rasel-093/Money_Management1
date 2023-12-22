package com.example.money_management1.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.money_management1.R
import com.example.money_management1.ui.theme.primaryColor
import com.example.money_management1.ui.theme.whiteBackground

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpScreen(navHostController: NavHostController){
//    val context = LocalContext.current
    val image = painterResource(id = R.drawable.money_bag)
    val name = rememberSaveable {
        mutableStateOf("")
    }
    val phone = rememberSaveable{
        mutableStateOf("")
    }
    val email = rememberSaveable{
        mutableStateOf("")
    }
    val password = rememberSaveable{
        mutableStateOf("")
    }
    val confirmPassword = rememberSaveable{
        mutableStateOf("")
    }
    val passwordVisibility = rememberSaveable{ mutableStateOf(false)}
    val confirmPasswordVisibility = rememberSaveable{ mutableStateOf(false) }
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.BottomCenter
    ){
        Box(
            modifier = Modifier
                .fillMaxSize()
//                .fillMaxWidth()
//                .fillMaxHeight(0.3f)
                    ,
            contentAlignment = Alignment.TopCenter
        ){
            Image(
                painter = image,
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .background(whiteBackground)
                    .padding(top = 30.dp)
            )
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.70f)
                .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
                .background(whiteBackground),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Spacer(modifier = Modifier.padding(top = 5.dp, start = 20.dp, end = 20.dp, bottom = 20.dp))
            Text(
                text = "Sign Up",
                fontSize = 26.sp,
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 2.sp
                )
            )
//            Spacer(modifier = Modifier.padding(top = 5.dp, start = 20.dp, end = 20.dp, bottom = 20.dp))
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                OutlinedTextField(
                    value = name.value,
                    onValueChange = {name.value = it},
                    label = { Text(text = "Name")},
                    placeholder = { Text(text = "Name")},
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth(0.8f)
                )
                OutlinedTextField(
                    value = phone.value,
                    onValueChange = {phone.value = it},
                    label = { Text(text = "Phone")},
                    placeholder = { Text(text = "Phone")},
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Phone
                    ),
                    modifier = Modifier.fillMaxWidth(0.8f)
                )
                OutlinedTextField(
                    value = email.value,
                    onValueChange = {email.value = it},
                    label = { Text(text = "Email")},
                    placeholder = { Text(text = "Email")},
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Email
                    ),
                    modifier = Modifier.fillMaxWidth(0.8f)
                )
                OutlinedTextField(
                    value = password.value,
                    onValueChange = {password.value = it},
                    label = { Text(text = "Password")},
                    placeholder = { Text(text = "Password")},
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Password
                    ),
                    trailingIcon =  {
                        IconButton(
                            onClick = {passwordVisibility.value = !passwordVisibility.value} ,
                        ){
                            Icon(
                                painter = painterResource(id = R.drawable.password_eye),
                                contentDescription = null,
                                tint = if(passwordVisibility.value) primaryColor else Color.Gray
                            )
                        }
                    },
                    visualTransformation = if(passwordVisibility.value) VisualTransformation.None
                                            else PasswordVisualTransformation(),
                    modifier = Modifier.fillMaxWidth(0.8f)
                )
                OutlinedTextField(
                    value = confirmPassword.value,
                    onValueChange = {confirmPassword.value = it},
                    label = { Text(text = "Confirm Password")},
                    placeholder = { Text(text = "Confirm Password")},
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Password
                    ),
                    trailingIcon =  {
                        IconButton(
                            onClick = {confirmPasswordVisibility.value = !confirmPasswordVisibility.value} ,
                        ){
                            Icon(
                                painter = painterResource(id = R.drawable.password_eye),
                                contentDescription = null,
                                tint = if(confirmPasswordVisibility.value) primaryColor else Color.Gray
                            )
                        }
                    },
                    visualTransformation = if(confirmPasswordVisibility.value) VisualTransformation.None
                    else PasswordVisualTransformation(),
                    modifier = Modifier.fillMaxWidth(0.8f)
                )
                Spacer(modifier = Modifier.padding(10.dp))
                Button(
                    onClick = {
                    },
                    modifier = Modifier
                        .fillMaxWidth(0.8f)
                        .height(50.dp)
                ) {
                    Text(
                        text = "Sign Up",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
                Spacer(modifier = Modifier.padding(5.dp))
//                Text(
//                    text = "Login Instead",
//                    fontWeight = FontWeight.Bold,
//                    fontSize = 14.sp,
//                    color = Color(0xFF485CCA),
//                    modifier= Modifier.clickable(
//                        onClick = {
//                            val intent = Intent(context,LoginActivity::class.java)
//                            context.startActivity(intent)
//                            context.finish()
//                        }
//                    )
//                )
//                Spacer(modifier = Modifier.padding(20.dp))
            }
        }
    }
}