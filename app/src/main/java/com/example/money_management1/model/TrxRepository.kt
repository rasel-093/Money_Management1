package com.example.money_management1.model

import androidx.lifecycle.LiveData

class TrxRepository(
    private val trxDao: TrxDao
) {
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
}