package com.example.money_management1.model.savingmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.money_management1.model.TrxDB
import kotlinx.coroutines.launch

class SavingItemViewModel(application: Application): AndroidViewModel(application) {
    val allSavingItems: LiveData<List<SavingItem>>
    private val savingRepository: SavingRepository
    init {
        val savingItemDao = TrxDB.getInstance(application).savingItemDao()
        savingRepository = SavingRepository(savingItemDao)
        allSavingItems = savingRepository.allSavingItem
    }

    fun insertSavingItem(savingItem: SavingItem){
        viewModelScope.launch { savingRepository.insertSavingItem(savingItem) }
    }
    fun updateSavingItem(savingItem: SavingItem){
        viewModelScope.launch { savingRepository.updateSavingItem(savingItem) }
    }
    fun deleteSavingItem(savingItem: SavingItem){
        viewModelScope.launch { savingRepository.deleteSavingItem(savingItem) }
    }
}