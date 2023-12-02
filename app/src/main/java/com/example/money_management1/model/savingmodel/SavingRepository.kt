package com.example.money_management1.model.savingmodel

import androidx.lifecycle.LiveData

class SavingRepository(private val savingItemDao: SavingItemDao){

    //For Saving item
    val allSavingItem: LiveData<List<SavingItem>> = savingItemDao.getAllSavings()
    suspend fun insertSavingItem(savingItem: SavingItem){savingItemDao.insertSaving(savingItem)}
    suspend fun updateSavingItem(savingItem: SavingItem){savingItemDao.updateSaving(savingItem)}
    suspend fun deleteSavingItem(savingItem: SavingItem){savingItemDao.deleteSaving(savingItem)}
}