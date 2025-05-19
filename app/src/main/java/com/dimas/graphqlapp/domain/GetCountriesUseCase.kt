package com.dimas.graphqlapp.domain

import javax.inject.Inject

class GetCountriesUseCase @Inject constructor(
    private val countryClient: CountryClient
) {
    suspend fun invoke(): List<SimpleCountry> {
        return countryClient
            .getCountries()
            .sortedBy { it.name }
    }
}