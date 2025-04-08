package com.dimas.graphqlapp.presentation

sealed interface CountriesAction {
    data class OnSelectedCountry(val code: String) : CountriesAction
    data object OnDismissCountryDialog : CountriesAction
}