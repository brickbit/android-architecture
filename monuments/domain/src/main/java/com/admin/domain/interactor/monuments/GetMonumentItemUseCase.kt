package com.admin.domain.interactor.monuments
/*
import com.admin.domain.executor.Executor
import com.admin.domain.model.MonumentItemDto
import com.admin.domain.repository.MonumentRepository
import com.admin.domain.repository.RefreshStrategy
import io.reactivex.Observable

class GetMonumentItemUseCase(private val repository: MonumentRepository,
                             executor: Executor)
    : ObservableInteractor<MonumentItemDto>(executor = executor){

    companion object {
        private const val ID = 1
        private const val DEFAULT_ID = 1
    }

    private var def_id: Long = DEFAULT_ID.toLong()

    private var refreshStrategy = RefreshStrategy.NETWORK


    fun execute(id: Long = ID.toLong(), refreshStrategy: RefreshStrategy, onNext: (MonumentItemDto) -> Unit, onComplete: () -> Unit, onError: (Throwable) -> Unit) {
        this.refreshStrategy = refreshStrategy
        this.def_id=id
        super.execute(onNext, onComplete, onError)
    }

    override fun buildObservable(): Observable<MonumentItemDto> =
            repository.getMonumentItem(id = def_id,refreshStrategy = refreshStrategy)
}*/