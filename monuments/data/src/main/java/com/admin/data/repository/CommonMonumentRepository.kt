package com.admin.data.repository

import android.util.Log
import com.admin.data.datasource.database.DatabaseDataSource
import com.admin.data.datasource.network.NetworkDataSource
import com.admin.domain.model.MonumentItemDto
import com.admin.domain.model.MonumentListDto
import com.admin.domain.repository.MonumentRepository
import com.admin.domain.repository.RefreshStrategy
import io.reactivex.Observable

class CommonMonumentRepository(/*private val database: DatabaseDataSource,*/
                               private val network: NetworkDataSource): MonumentRepository {

    override fun getMonumentItem(id:Long, refreshStrategy: RefreshStrategy): Observable<MonumentItemDto> {
        /*val networkAndSave = network.getNews(languageString(persistence.getLanguage()), itemsPerPage, itemsToSkip)
                .flatMap { database.saveNews(it) }
*/
       // val local:Observable<MonumentItemDto> = database.getMonumentItem()
        val network:Observable<MonumentItemDto> = network.getMonumentItem(id)
        return when (refreshStrategy) {
          /*  RefreshStrategy.NETWORK_AND_SAVE_LOCAL -> local//networkAndSave
            RefreshStrategy.LOCAL -> local*/
            RefreshStrategy.NETWORK -> network
        }
    }

    override fun getMonumentList(refreshStrategy: RefreshStrategy): Observable<MonumentListDto> {
        /*val networkAndSave = network.getNews(languageString(persistence.getLanguage()), itemsPerPage, itemsToSkip)
                .flatMap { database.saveNews(it) }
*/
       // val local:Observable<MonumentListDto> = database.getMonumentList()
        val network:Observable<MonumentListDto> = network.getMonumentList()

        return when (refreshStrategy) {
           /* RefreshStrategy.NETWORK_AND_SAVE_LOCAL -> local//networkAndSave
            RefreshStrategy.LOCAL -> local */
            RefreshStrategy.NETWORK -> network
        }
    }
}