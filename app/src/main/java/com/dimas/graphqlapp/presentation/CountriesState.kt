package com.dimas.graphqlapp.presentation

import com.dimas.graphqlapp.domain.DetailedCountry
import com.dimas.graphqlapp.domain.SimpleCountry

data class CountriesState(
    val countries: List<SimpleCountry> = emptyList(),
    val isLoading: Boolean = false,
    val selectedCountry: DetailedCountry? = null
)
