package com.example.money_management1.model.trxmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.money_management1.model.TrxDB
import kotlinx.coroutines.launch

class TrxViewModel(application: Application): AndroidViewModel(application) {
    val allTrx: LiveData<List<TrxItem>>
    private val repository: TrxRepository
    init {
        val trxDao = TrxDB.getInstance(application).trxDao()
        repository = TrxRepository(trxDao)
        allTrx = repository.allTrx
    }

    fun inserTrx(trxItem: TrxItem){
        viewModelScope.launch { repository.insertTrx(trxItem) }
    }
    fun deleteTrx(trxItem: TrxItem){
        viewModelScope.launch { repository.deleteTrx(trxItem) }
    }
    fun updateTrx(trxItem: TrxItem){
        viewModelScope.launch { repository.updateTrx(trxItem) }
    }
    fun deleteAllTrx(){
        viewModelScope.launch { repository.deleteAllTrx() }
    }
}

