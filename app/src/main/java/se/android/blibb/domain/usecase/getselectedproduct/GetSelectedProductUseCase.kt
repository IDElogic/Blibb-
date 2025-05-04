package se.android.blibb.domain.usecase.getselectedproduct

import se.android.blibb.data.repository.Repository
import se.android.blibb.domain.model.ProductItem

class GetSelectedProductUseCase(
    private val repository: Repository
) {

    suspend operator fun invoke(productId: Int): ProductItem {
        return repository.getSelectedProduct(productId = productId)
    }

}