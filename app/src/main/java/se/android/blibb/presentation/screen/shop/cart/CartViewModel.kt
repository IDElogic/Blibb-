package se.android.blibb.presentation.screen.shop.cart

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import se.android.blibb.domain.model.ProductItem
import se.android.blibb.domain.usecase.UseCases
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import se.android.blibb.data.local.dao.ProductDao
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import javax.inject.Inject


@HiltViewModel
class CartViewModel @Inject constructor(
    private val useCases: UseCases,
    private val productDao: ProductDao,
) : ViewModel() {

    val productCartList = productDao.getAllProductCart(true).stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(5000),
        emptyList()
    )

    private val _totalPrice = MutableStateFlow(0.0)
    private val _discountedPrice = MutableStateFlow(0.0)
    val totalPrice: StateFlow<Double> = _totalPrice
    val discountedPrice: StateFlow<Double> = _discountedPrice

    private val _checkoutState = MutableStateFlow<CheckoutState>(CheckoutState.Idle)
    val checkoutState = _checkoutState.asStateFlow()

    private val _orderNumber = MutableStateFlow(0)
    val orderNumber: StateFlow<Int> = _orderNumber

    private val _orderDate = MutableStateFlow("")
    val orderDate: StateFlow<String> = _orderDate

    init {
        calculateTotalPrice()
    }

    private fun calculateTotalPrice() {
        viewModelScope.launch {
            productCartList.collect { cartItems ->
                val total = cartItems.sumOf { it.price }
                _totalPrice.value = total
                _discountedPrice.value = total * 0.625
            }
        }
    }

    fun addToCart(productItem: ProductItem) {
        viewModelScope.launch {
            productDao.addCart(productItem.copy(isCart = true))
        }
    }

    fun removeFromCart(productItem: ProductItem) {
        viewModelScope.launch {
            productDao.deleteCart(productItem.copy(isCart = false))
        }
    }

    fun clearCart() {
        viewModelScope.launch {
            productCartList.value.forEach { product ->
                removeFromCart(product)
            }
        }
    }

    fun createOrder() {
        val nextOrderNumber = _orderNumber.value + 1
        _orderNumber.value = nextOrderNumber
        _orderDate.value = SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault()).format(Date())

        Log.d("CartViewModel", "Új rendelés létrehozva: sorszám = $nextOrderNumber, dátum = ${_orderDate.value}")
    }
}

sealed class CheckoutState {
    object Idle : CheckoutState()
    object Processing : CheckoutState()
    object Success : CheckoutState()
    data class Error(val message: String) : CheckoutState()
}

enum class PaymentMethod {
    CreditCard, PayPal, Swish
}
