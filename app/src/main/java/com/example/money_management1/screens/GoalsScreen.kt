package com.example.money_management1.screens

import android.net.Uri
import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.money_management1.R
import com.example.money_management1.components.ImageSelector
import com.example.money_management1.components.TopBar
import com.example.money_management1.components.UriToBitmap
import com.example.money_management1.components.UriToImage
import com.example.money_management1.model.savingmodel.SavingItem
import com.example.money_management1.model.savingmodel.SavingItemViewModel
import com.example.money_management1.ui.theme.Purple80
import com.example.money_management1.ui.theme.blackFont
import com.example.money_management1.ui.theme.defaultColor
import com.example.money_management1.ui.theme.whiteBackground
import com.example.money_management1.ui.theme.whiteFont
import java.net.URISyntaxException

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun GoalsScreen(paddingValues: PaddingValues, savingItemViewModel: SavingItemViewModel) {
    Scaffold(
        topBar = { TopBar(title = "Saving Goals")},
        modifier = Modifier.padding(paddingValues)
    ) {innerPadding ->
        val savingItems = savingItemViewModel.allSavingItems.observeAsState(listOf()).value
        var isDialogOpen by rememberSaveable {
            mutableStateOf(false)
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(10.dp)
        ) {
            //Heading Card
            ElevatedCard (
                colors = CardDefaults.cardColors(
                    containerColor = defaultColor
                ),
                modifier= Modifier.fillMaxWidth()
            ){
                Column(
                     horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(5.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        GoalCardText(text = "Goals")
                        GoalCardText(text = savingItems.size.toString())
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(5.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        GoalCardText(text = "In Progress")
                        GoalCardText(text = savingItems.filter { !it.isCompleted }.size.toString())
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(5.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        GoalCardText(text = "Completed")
                        GoalCardText(text = savingItems.filter { it.isCompleted }.size.toString())
                    }
                }
            }
            Spacer(modifier = Modifier.height(30.dp))
            //Add Saving Goals
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(
                    text = "Saving Goals" ,
                    style = TextStyle(
                        fontSize = 36.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = blackFont
                    )
                )
                IconButton(onClick = { isDialogOpen = true}) {
                    Icon(
                        painter = painterResource(id = R.drawable.plus),
                        contentDescription = null,
                        tint = Purple80,
                        modifier = Modifier
                            .height(50.dp)
                            .width(50.dp)
                    )
                }
            }
            if(isDialogOpen){
                AddGoalDialog(
                    savingItemViewModel = savingItemViewModel,
                    onValueChange = {isDialogOpen = false}
                )
            }
            Spacer(modifier = Modifier.height(40.dp))
            //Horizontal pager for goal item
            GoalsPager(savingItemViewModel)
        }
    }
}

@Composable
fun GoalCardText(text: String) {
    Text(
        text = text,
        style = TextStyle(
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = whiteFont
        )
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun GoalsPager(savingItemViewModel: SavingItemViewModel) {
    val savingItems = savingItemViewModel.allSavingItems.observeAsState(listOf()).value
    val pagerState = rememberPagerState(pageCount = {
        savingItems.size
    })

    Box(modifier = Modifier
        .fillMaxWidth()
        .padding(10.dp)){
        HorizontalPager(
            state = pagerState,
            pageSpacing = 10.dp,
            pageSize = PageSize.Fixed(300.dp)
        ) { page ->
            ElevatedCard(
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 10.dp , end = 10.dp , top = 20.dp , bottom = 20.dp)
                ) {
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier.fillMaxWidth()
                    ) {
//                        Icon(
//                            painter = painterResource(id = R.drawable.plus),
//                            contentDescription = null
//                        )
                            UriToImage(imageUri = stringToUri(savingItems[page].imageUri))
                        Log.d("Uri-From Db", savingItems[page].imageUri )
                        Column {
                            Text(
                                text = savingItems[page].title ,
                                style = TextStyle(
                                    fontSize = 30.sp,
                                    fontWeight = FontWeight.ExtraBold,
                                    color = blackFont
                                )
                            )
                            Text(
                                text = savingItems[page].req_amount.toString() ,
                                style = TextStyle(
                                    fontSize = 30.sp,
                                    fontWeight = FontWeight.ExtraBold,
                                    color = blackFont
                                )
                            )
                        }
                    }
                    val progress = (savingItems[page].current_amount.toFloat()/savingItems[page].req_amount).toFloat()
                    Log.d("Progress", progress.toString())
                    Log.d("Cureent am", savingItems[page].current_amount.toString())
                    Log.d("req am", savingItems[page].req_amount.toString())
                    Spacer(modifier = Modifier.height(10.dp))
                   // val currentProgress by remember { mutableFloatStateOf(progress.toFloat()) }
                    LinearDeterminantProgressIndicator(progress)
                }
            }
        }
    }
}

@Composable
fun LinearDeterminantProgressIndicator(currentProgress: Float) {
    Log.d("Progress", currentProgress.toString())
    LinearProgressIndicator(
        progress = currentProgress,
        modifier = Modifier
            .height(20.dp)
            .fillMaxWidth(),
        color = defaultColor,
        trackColor = Color.Gray,
        strokeCap = StrokeCap.Round
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddGoalDialog(savingItemViewModel: SavingItemViewModel, onValueChange: (Boolean) -> Unit) {
    var title by rememberSaveable {
        mutableStateOf("")
    }
    var  details by rememberSaveable {
        mutableStateOf("")
    }
    var requiredAmount by rememberSaveable {
        mutableStateOf("")
    }
    var imageUriString by rememberSaveable {
        mutableStateOf("")
    }
//Add saving goal dialog
    AlertDialog(
        onDismissRequest = { /*TODO*/ },
        modifier = Modifier
            .padding(10.dp)
            .background(whiteBackground)
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(10.dp)
                .background(whiteBackground)
        ) {
            Text(text = "Add Saving Goal")
            SavingTextField(onValueChange = {title = it}, label = "Title")
            SavingTextField(onValueChange = {details = it}, label = "Details")
            AmountTextField(onValueChange = {requiredAmount = it}, label = "Amount")
           // SavingTextField(onValueChange = {imagePath = it}, label = "Image Path")
            ImageSelector { imageUriString = it }

            Row(
                horizontalArrangement = Arrangement.End,
                modifier = Modifier.fillMaxWidth()
            ) {
                TextButton(onClick = { onValueChange(false) }) {
                    Text(text = "Cancel")
                }
                TextButton(onClick = {
                    if(title.isNotEmpty() && requiredAmount.isNotEmpty() && imageUriString.isNotEmpty()){
                        Log.d("Uri- Direct", imageUriString )
                        val savingItem = SavingItem(
                            title = title,
                            details = details,
                            req_amount = requiredAmount.toInt(),
                            imageUri = imageUriString
                        )
                        savingItemViewModel.insertSavingItem(savingItem)
                        onValueChange(false)
                    }
                }) {
                    Text(text = "Save")
                }
            }
        }
    }
}
@Composable
fun SavingTextField(onValueChange: (String) -> Unit, label: String){
    var text by rememberSaveable {
        mutableStateOf("")
    }
    OutlinedTextField(
        value = text,
        label = { Text(text = label)},
        onValueChange = {
            text = it
            onValueChange(text)
                        },
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Next
        ),
        modifier = Modifier.padding(5.dp)
    )
}

@Composable
fun AmountTextField(onValueChange: (String) -> Unit, label: String) {
    var amount by rememberSaveable {
        mutableStateOf("")
    }
    OutlinedTextField(
        value = amount,
        label = { Text(text = label)},
        onValueChange = {
            amount = it
            onValueChange(amount)
                        } ,
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Next,
            keyboardType = KeyboardType.Number
        )
    )
}



fun stringToUri(uriString: String): Uri {
    return try {
        Uri.parse(uriString)
    } catch (e: URISyntaxException) {
        throw IllegalArgumentException("Invalid URI string: $uriString")
    }
}
