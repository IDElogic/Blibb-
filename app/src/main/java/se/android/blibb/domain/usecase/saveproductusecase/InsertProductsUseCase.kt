package se.android.blibb.domain.usecase.saveproductusecase

import se.android.blibb.data.repository.Repository
import se.android.blibb.domain.model.ProductItem

class InsertProductsUseCase(
    private val repository: Repository
) {

    suspend operator fun invoke(products: List<ProductItem>) = repository.insertProducts(products)

}