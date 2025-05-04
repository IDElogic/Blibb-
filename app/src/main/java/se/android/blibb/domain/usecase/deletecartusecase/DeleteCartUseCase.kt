package se.android.blibb.domain.usecase.deletecartusecase

import se.android.blibb.data.repository.Repository
import se.android.blibb.domain.model.ProductItem

class DeleteCartUseCase(
    private val repository: Repository
) {

    suspend operator fun invoke(productItem: ProductItem) = repository.deleteCart(productItem)

}