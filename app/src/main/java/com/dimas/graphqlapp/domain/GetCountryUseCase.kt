package com.dimas.graphqlapp.domain

class GetCountryUseCase(
    private val countryClient: CountryClient
) {
    suspend fun invoke(code: String): DetailedCountry? {
        return countryClient.getCountry(code)
    }
}