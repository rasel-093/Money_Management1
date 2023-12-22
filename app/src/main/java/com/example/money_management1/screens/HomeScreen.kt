package com.example.money_management1.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.money_management1.components.FloatingActionBtn
import com.example.money_management1.components.TopBar
import com.example.money_management1.components.TrxItemDetails
import com.example.money_management1.components.cards.TrxHistoryHeadingCard
import com.example.money_management1.components.cards.TrxHistoryItemCard
import com.example.money_management1.model.savingmodel.SavingItemViewModel
import com.example.money_management1.model.trxmodel.TrxViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    innerPadding: PaddingValues,
    navController: NavHostController,
    trxViewModel: TrxViewModel,
    savingItemViewModel: SavingItemViewModel
) {
    var isOpen by rememberSaveable{
        mutableStateOf(false)
    }
    var isDetailsDialogOpen by rememberSaveable {
        mutableStateOf(false)
    }
    var clickedIndex by rememberSaveable {
        mutableStateOf(0)
    }
    val trxItems = trxViewModel.allTrx.observeAsState(listOf()).value

    Scaffold(
        topBar = { TopBar("Transaction History")},
      // bottomBar = { BottomNavigationBar(navController = navController) },
        floatingActionButton = { FloatingActionBtn({isOpen = it})},
        floatingActionButtonPosition = FabPosition.End
    ) {padding2 ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding((innerPadding))
                .padding(padding2)
                .padding(10.dp)
        ) {
            TrxHistoryHeadingCard(trxItems)
            Spacer(modifier = Modifier.height(20.dp))
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState(), true)
            ) {
                trxItems.forEachIndexed{ index,item->
                    TrxHistoryItemCard(item ,index,{bool,int-> isDetailsDialogOpen = bool
                        clickedIndex = int })
                }
            }
            if(isDetailsDialogOpen){
                TrxItemDetails(
                    trxItem = trxItems[clickedIndex],
                    onDelete = {
                        trxViewModel.deleteTrx(trxItems[clickedIndex])
                        isDetailsDialogOpen = false
                    },
                    onClose = {isDetailsDialogOpen = false}
                )
            }
            if(isOpen){
                AddTrxDialogScreen(
                    onConfirm = {isOpen = false},
                    onCancel = {isOpen = false},
                    trxViewModel = trxViewModel,
                    savingItemViewModel = savingItemViewModel
                )
            }
        }
    }
}