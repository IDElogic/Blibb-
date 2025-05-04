package se.android.blibb.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import se.android.blibb.data.repository.Repository
import se.android.blibb.domain.usecase.UseCases
import se.android.blibb.domain.usecase.addcartusecase.AddCartUseCase
import se.android.blibb.domain.usecase.deletecartusecase.DeleteCartUseCase
import se.android.blibb.domain.usecase.getallcartusecase.GetAllCartUseCase
import se.android.blibb.domain.usecase.getallproduct.GetAllProductUseCase
import se.android.blibb.domain.usecase.getselectedproduct.GetSelectedProductUseCase
import se.android.blibb.domain.usecase.readonboarding.ReadOnBoardingUseCase
import se.android.blibb.domain.usecase.saveproductusecase.InsertProductsUseCase
import se.android.blibb.domain.usecase.searchproductusecase.SearchProductUseCase
import se.android.blibb.usecase.saveonboarding.SaveOnBoardingUseCase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    fun provideSaveOnBoardingUseCase(repository: Repository): SaveOnBoardingUseCase {
        return SaveOnBoardingUseCase(repository)
    }

    @Provides
    fun provideInsertProductsUseCase(repository: Repository): InsertProductsUseCase {
        return InsertProductsUseCase(repository)
    }

    @Provides
    fun provideReadOnBoardingUseCase(repository: Repository): ReadOnBoardingUseCase {
        return ReadOnBoardingUseCase(repository)
    }

    @Provides
    fun provideGetSelectedProductUseCase(repository: Repository): GetSelectedProductUseCase {
        return GetSelectedProductUseCase(repository)
    }

    @Provides
    fun provideGetAllProductUseCase(repository: Repository): GetAllProductUseCase {
        return GetAllProductUseCase(repository)
    }

    @Provides
    fun provideGetAllCartUseCase(repository: Repository): GetAllCartUseCase {
        return GetAllCartUseCase(repository)
    }

    @Provides
    fun provideAddCartUseCase(repository: Repository): AddCartUseCase {
        return AddCartUseCase(repository)
    }

    @Provides
    fun provideDeleteCartUseCase(repository: Repository): DeleteCartUseCase {
        return DeleteCartUseCase(repository)
    }

    @Provides
    fun provideSearchProductUseCase(repository: Repository): SearchProductUseCase {
        return SearchProductUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideUseCases(
        saveOnBoardingUseCase: SaveOnBoardingUseCase,
        insertProductsUseCase: InsertProductsUseCase,
        readOnBoardingUseCase: ReadOnBoardingUseCase,
        getSelectedProductUseCase: GetSelectedProductUseCase,
        getAllProductUseCase: GetAllProductUseCase,
        getAllCartUseCase: GetAllCartUseCase,
        addCartUseCase: AddCartUseCase,
        deleteCartUseCase: DeleteCartUseCase,
        searchProductUseCase: SearchProductUseCase
    ): UseCases {
        return UseCases(
            saveOnBoardingUseCase,
            insertProductsUseCase,
            readOnBoardingUseCase,
            getSelectedProductUseCase,
            getAllProductUseCase,
            getAllCartUseCase,
            addCartUseCase,
            deleteCartUseCase,
            searchProductUseCase
        )
    }
}