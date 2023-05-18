package com.juliopicazo.democity.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.juliopicazo.domain.CoroutineResult
import com.juliopicazo.domain.GetProductUseCase
import com.juliopicazo.domain.Product
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(
    private val getProductsUseCase : GetProductUseCase
): BaseViewModel() {

    private var _state = MutableLiveData<ProductData>()
    var state :  LiveData<ProductData> = _state

    fun getProducts() = viewModelScope.launch {
        withContext(Dispatchers.IO) { getProductsUseCase() }.let { result ->
            when (result) {
                is CoroutineResult.Success -> {
                    if (result.data.isNotEmpty()) {
                        _state.value = ProductData(products = result.data)
                    }
                }
                is CoroutineResult.Failed -> {}
                }
            }
        }


    data class ProductData(
        val products : List<Product> = emptyList(),
        val category : List<Product> = emptyList()
    )
}