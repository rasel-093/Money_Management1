package com.example.money_management1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.money_management1.components.cards.CardText
import com.example.money_management1.model.TrxItem
import com.example.money_management1.model.trxItems
import com.example.money_management1.ui.theme.Money_Management1Theme
import com.example.money_management1.ui.theme.blackFont

class TrxDetailsActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Money_Management1Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Scaffold(
                        topBar = {
                            TopAppBar(
                                navigationIcon = { IconButton(onClick = { /*TODO*/ }) {
                                    Icon(
                                        painter = painterResource(id = R.drawable.backarrow_icon) ,
                                        contentDescription = null ,
                                        tint = Color(0xFF008FFF)
                                    )
                                }},
                                title = { Text(
                                    text = "Transaction Details",
                                    color = Color(0xFF008FFF)
                                )
                                        },
                                actions = { IconButton(onClick = { /*TODO*/ }) {
                                    Icon(
                                        painter = painterResource(id = R.drawable.delete_icon) ,
                                        contentDescription = null ,
                                        tint = Color(0xFF008FFF)
                                    )
                                }},
                                colors = TopAppBarDefaults.smallTopAppBarColors(
                                        containerColor = Color(0xFF50E3C2)
                                    )
                                )
                        }
                    ) {padding->
                        Column(
                            modifier = Modifier.padding(padding)
                        ) {
                            val id = intent.getIntExtra("id", 0)
                            TransactionDetails(trxItems[id])
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun TransactionDetails(trxItem: TrxItem) {
    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp,
            pressedElevation = 6.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            CardText(text = trxItem.amount, fontSize = 26, color = blackFont )
            CardText(text = trxItem.title, fontSize = 26 , color = blackFont)
            CardText(text = trxItem.details, fontSize = 26 , color = blackFont)
            CardText(text = trxItem.date, fontSize = 26 , color = blackFont)
        }
    }
}