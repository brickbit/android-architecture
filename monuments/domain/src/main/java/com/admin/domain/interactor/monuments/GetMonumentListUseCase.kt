package com.admin.domain.interactor.monuments
/*
import com.admin.domain.executor.Executor
import com.admin.domain.model.MonumentListDto
import com.admin.domain.repository.MonumentRepository
import com.admin.domain.repository.RefreshStrategy
import io.reactivex.Observable

class GetMonumentListUseCase(private val repository: MonumentRepository, executor: Executor) : ObservableInteractor<MonumentListDto>(executor = executor){

    private  var refreshStrategy = RefreshStrategy.NETWORK

    override fun buildObservable(): MonumentListDto =
            repository.getMonumentList(refreshStrategy = refreshStrategy)
}*/