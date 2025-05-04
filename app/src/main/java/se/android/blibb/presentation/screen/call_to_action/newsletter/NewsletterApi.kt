package se.android.blibb.presentation.screen.call_to_action.newsletter

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface NewsletterApi {
    @POST("subscribe")
    suspend fun subscribe(@Body request: SubscriptionRequest): Response<Void>
}


data class SubscriptionRequest(val email: String)
