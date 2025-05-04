package se.android.blibb.domain.usecase.getallproduct

import se.android.blibb.data.repository.Repository
import se.android.blibb.domain.model.ProductItem
import kotlinx.coroutines.flow.Flow

class GetAllProductUseCase(
    private val repository: Repository
) {

    operator fun invoke(): Flow<List<ProductItem>> = repository.getAllProduct()

}