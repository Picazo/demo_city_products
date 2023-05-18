package com.juliopicazo.domain

import javax.inject.Inject

interface GetProductUseCase{
    suspend operator fun invoke(): CoroutineResult<List<Product>>
}

class GetProductUseCaseImpl @Inject constructor(
    private val productRepository : ProductRepository
): GetProductUseCase{
    override suspend fun invoke(): CoroutineResult<List<Product>> {
        return when (val serviceResult = productRepository.getProducts()){
            is CoroutineResult.Success ->{
                serviceResult
            }
            is CoroutineResult.Failed ->{
                serviceResult
            }
        }
    }

}