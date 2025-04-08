package com.dimas.graphqlapp.domain

class GetCountriesUseCase(
    private val countryClient: CountryClient
) {
    suspend fun invoke(): List<SimpleCountry> {
        return countryClient
            .getCountries()
            .sortedBy { it.name }
    }
}