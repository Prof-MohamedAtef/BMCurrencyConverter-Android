package mo.ed.bankmisr.interactor

import mo.ed.bankmisr.repositories.FromToRepository
import mo.ed.bankmisr.utils.Result
import javax.inject.Inject

class FromToInteractor @Inject constructor(
    private val fromToRepository: FromToRepository
) {

    suspend fun getCurrencies(): Result<*> {
        return fromToRepository.getCurrencies()
    }

}