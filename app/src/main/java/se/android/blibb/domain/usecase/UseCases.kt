package se.android.blibb.domain.usecase

import se.android.blibb.domain.usecase.addcartusecase.AddCartUseCase
import se.android.blibb.domain.usecase.deletecartusecase.DeleteCartUseCase
import se.android.blibb.domain.usecase.getallcartusecase.GetAllCartUseCase
import se.android.blibb.domain.usecase.getallproduct.GetAllProductUseCase
import se.android.blibb.domain.usecase.getselectedproduct.GetSelectedProductUseCase
import se.android.blibb.domain.usecase.readonboarding.ReadOnBoardingUseCase
import se.android.blibb.domain.usecase.saveproductusecase.InsertProductsUseCase
import se.android.blibb.domain.usecase.searchproductusecase.SearchProductUseCase
import se.android.blibb.usecase.saveonboarding.SaveOnBoardingUseCase

data class UseCases(
    val saveOnBoardingUseCase: SaveOnBoardingUseCase,
    val insertProductsUseCase: InsertProductsUseCase,
    val readOnBoardingUseCase: ReadOnBoardingUseCase,
    val getSelectedProductUseCase: GetSelectedProductUseCase,
    val getAllProductUseCase: GetAllProductUseCase,
    val getAllCartUseCase: GetAllCartUseCase,
    val addCartUseCase: AddCartUseCase,
    val deleteCart: DeleteCartUseCase,
    val searchProductUseCase: SearchProductUseCase
)