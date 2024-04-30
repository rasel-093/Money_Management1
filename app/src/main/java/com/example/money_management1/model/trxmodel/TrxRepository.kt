package com.example.money_management1.model.trxmodel

import androidx.lifecycle.LiveData

class TrxRepository(
    private val trxDao: TrxDao
) {
    //For transaction item
    val allTrx: LiveData<List<TrxItem>> = trxDao.getAll()
    suspend fun insertTrx(trxItem: TrxItem) {
        trxDao.insert(trxItem)
    }

    suspend fun deleteTrx(trxItem: TrxItem) {
        trxDao.delete(trxItem)
    }

    suspend fun updateTrx(trxItem: TrxItem) {
        trxDao.update(trxItem)
    }

    suspend fun deleteAllTrx() {
        trxDao.deleteAll()
    }
    suspend fun getEachExpenseAmount(trxType: String): Int?{
        return trxDao.getEachExpenseAmount(trxType)
    }
    suspend fun getEachIncomeAmount(trxType: String): Int?{
        return trxDao.getEachIncomeAmount(trxType)
    }
}

