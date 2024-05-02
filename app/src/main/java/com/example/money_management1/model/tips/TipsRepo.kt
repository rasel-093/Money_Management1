package com.example.money_management1.model.tips

import androidx.lifecycle.LiveData

class TipsRepo(
   private val tipsDao: TipsDao
) {
    val allTips: LiveData<List<TipsItem>> = tipsDao.getAll()
    suspend fun insertTips(tipsItem: TipsItem){
        tipsDao.insertTips(tipsItem)
    }
}