package se.android.blibb.domain.usecase.getallcartusecase

import se.android.blibb.data.repository.Repository
import se.android.blibb.domain.model.ProductItem
import kotlinx.coroutines.flow.Flow

class GetAllCartUseCase(
    private val repository: Repository
) {

    operator fun invoke(isCart: Boolean): Flow<List<ProductItem>> =
        repository.getAllProductCart(isCart)

}