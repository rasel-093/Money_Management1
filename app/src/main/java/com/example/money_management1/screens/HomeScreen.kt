package com.example.money_management1.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.money_management1.components.cards.MonthlyHistoryCard
import com.example.money_management1.components.cards.MonthlyIncomeExpenseCard
import com.example.money_management1.model.items

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(innerPadding: PaddingValues) {
    Scaffold(
    ) {padding2 ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding((innerPadding))
                .padding(padding2)
                .padding(10.dp)
        ) {
            MonthlyIncomeExpenseCard()
            Spacer(modifier = Modifier.height(20.dp))
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState(), true)
            ) {
                items.forEach{item->
                    MonthlyHistoryCard(item)
                }
            }
        }
    }
}
//MonthlyHistoryCard()
//MonthlyHistoryCard()
//MonthlyHistoryCard()
//MonthlyHistoryCard()
//MonthlyHistoryCard()
//MonthlyHistoryCard()
//MonthlyHistoryCard()
//MonthlyHistoryCard()
//MonthlyHistoryCard()
//MonthlyHistoryCard()