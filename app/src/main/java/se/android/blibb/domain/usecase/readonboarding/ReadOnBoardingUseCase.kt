package se.android.blibb.domain.usecase.readonboarding

import se.android.blibb.data.repository.Repository
import kotlinx.coroutines.flow.Flow

class ReadOnBoardingUseCase(private val repository: Repository) {

    operator fun invoke(): Flow<Boolean> = repository.readOnBoardingState()

}