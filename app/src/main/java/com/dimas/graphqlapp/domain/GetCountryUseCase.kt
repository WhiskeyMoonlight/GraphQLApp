package com.dimas.graphqlapp.domain

import javax.inject.Inject

class GetCountryUseCase @Inject constructor(
    private val countryClient: CountryClient
) {
    suspend fun invoke(code: String): DetailedCountry? {
        return countryClient.getCountry(code)
    }
}