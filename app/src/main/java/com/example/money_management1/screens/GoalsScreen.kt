package com.example.money_management1.screens

import android.graphics.Paint.Style
import android.graphics.drawable.GradientDrawable
import android.widget.ProgressBar
import androidx.compose.foundation.ExperimentalFoundationApi
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
import androidx.compose.foundation.pager.PagerDefaults
import androidx.compose.foundation.pager.PagerScope
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.money_management1.R
import com.example.money_management1.components.TopBar
import com.example.money_management1.ui.theme.Purple80
import com.example.money_management1.ui.theme.blackFont
import com.example.money_management1.ui.theme.defaultColor
import com.example.money_management1.ui.theme.whiteBackground
import com.example.money_management1.ui.theme.whiteFont
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun GoalsScreen(paddingValues: PaddingValues) {
    Scaffold(
        topBar = { TopBar(title = "Goals")},
        modifier = Modifier.padding(paddingValues)
    ) {innerPadding ->
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
                        GoalCardText(text = "2")
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(5.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        GoalCardText(text = "In Progress")
                        GoalCardText(text = "2")
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(5.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        GoalCardText(text = "Completed")
                        GoalCardText(text = "0")
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
                IconButton(onClick = { /*TODO*/ }) {
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
            Spacer(modifier = Modifier.height(40.dp))
            //Horizontal pager for goal item
            GoalsPager()
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
fun GoalsPager() {
    val pagerState = rememberPagerState(pageCount = {
        10
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
                        .padding(start = 10.dp, end = 10.dp, top = 20.dp, bottom = 20.dp)
                ) {
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.plus),
                            contentDescription = null
                        )
                        Column {
                            Text(
                                text = "New Laptop" ,
                                style = TextStyle(
                                    fontSize = 30.sp,
                                    fontWeight = FontWeight.ExtraBold,
                                    color = blackFont
                                )
                            )
                            Text(
                                text = "2000" ,
                                style = TextStyle(
                                    fontSize = 30.sp,
                                    fontWeight = FontWeight.ExtraBold,
                                    color = blackFont
                                )
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    var currentProgress by remember { mutableStateOf(0.7f) }
                    LinearDeterminantProgressIndicator(currentProgress)
                }
            }
        }
    }
}

@Composable
fun LinearDeterminantProgressIndicator(currentProgress: Float) {
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