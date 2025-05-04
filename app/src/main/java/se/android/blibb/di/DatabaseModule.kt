package se.android.blibb.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import se.android.blibb.data.local.ProductDatabase
import se.android.blibb.data.local.dao.ProductDao
import se.android.blibb.data.repository.LocalDataSourceImpl
import se.android.blibb.data.repository.OnBoardingOperationImpl
import se.android.blibb.data.repository.Repository
import se.android.blibb.domain.repository.LocalDataSource
import se.android.blibb.domain.repository.OnBoardingOperations
import se.android.blibb.utils.Constants.PRODUCT_DATABASE
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    ): ProductDatabase {
        return Room.databaseBuilder(
            context,
            ProductDatabase::class.java,
            PRODUCT_DATABASE
        ).build()
    }

    @Provides
    @Singleton
    fun provideProductDao(database: ProductDatabase): ProductDao {
        return database.productDao()
    }

    @Provides
    @Singleton
    fun provideLocalDataSource(
        database: ProductDatabase
    ): LocalDataSource {
        return LocalDataSourceImpl(database)
    }

    @Provides
    @Singleton
    fun provideOnBoardingOperations(@ApplicationContext context: Context): OnBoardingOperations {
        return OnBoardingOperationImpl(context)
    }

    @Provides
    @Singleton
    fun provideRepository(
        dataStore: OnBoardingOperations,
        localDataSource: LocalDataSource
    ): Repository {
        return Repository(dataStore, localDataSource)
    }
}


/*@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    ): ProductDatabase {
        return Room.databaseBuilder(
            context,
            ProductDatabase::class.java,
            PRODUCT_DATABASE
        ).build()
    }

    @Provides
    @Singleton
    fun provideLocalDataSource(
        database: ProductDatabase
    ): LocalDataSource {
        return LocalDataSourceImpl(database)
    }

}*/