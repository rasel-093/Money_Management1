package com.example.money_management1.model.tips


import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.money_management1.model.AppDB
import kotlinx.coroutines.launch

class TipsViewModel(application: Application): AndroidViewModel(application) {
    val allTips: LiveData<List<TipsItem>>
    private val repository: TipsRepo
    init {
        val tipsDao = AppDB.getInstance(application).tipsDao()
        repository = TipsRepo(tipsDao)
        allTips = repository.allTips
    }
    fun insertTips(tipsItem: TipsItem){
        viewModelScope.launch {
            repository.insertTips(tipsItem)
        }
    }
}