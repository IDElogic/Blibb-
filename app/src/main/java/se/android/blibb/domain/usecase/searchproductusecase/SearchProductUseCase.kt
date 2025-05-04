package se.android.blibb.domain.usecase.searchproductusecase

import se.android.blibb.data.repository.Repository

class SearchProductUseCase(
    private val repository: Repository
) {

    operator fun invoke(query: String) = repository.searchProduct(query)

}