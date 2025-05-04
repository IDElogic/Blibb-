package se.android.blibb.domain.usecase.addcartusecase

import se.android.blibb.data.repository.Repository
import se.android.blibb.domain.model.ProductItem

class AddCartUseCase(
    private val repository: Repository
) {

    suspend operator fun invoke(productItem: ProductItem) = repository.addCart(productItem)

}