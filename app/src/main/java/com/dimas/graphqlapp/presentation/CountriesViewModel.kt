package com.dimas.graphqlapp.presentation

import androidx.lifecycle.ViewModel
import com.dimas.graphqlapp.domain.GetCountriesUseCase
import com.dimas.graphqlapp.domain.GetCountryUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.withContext
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

class CountriesViewModel @Inject constructor(
    private val getCountriesUseCase: GetCountriesUseCase,
    private val getCountryUseCase: GetCountryUseCase,
) : ViewModel(), ContainerHost<CountriesState, CountriesSideEffect> {

    override val container = container<CountriesState, CountriesSideEffect>(CountriesState()) {
        getCountries()
    }

    fun onAction(action: CountriesAction) {
        when (action) {
            CountriesAction.OnDismissCountryDialog -> handleOnDismissCountryDialog()
            is CountriesAction.OnSelectedCountry -> handleOnSelectedCountry(action.code)
        }
    }

    private fun getCountries(): Job = intent {
        reduce { state.copy(isLoading = true) }


        val countries = withContext(Dispatchers.IO) {
            getCountriesUseCase.invoke()
        }

        reduce {
            state.copy(
                countries = countries,
                isLoading = false,
            )
        }
    }

    private fun handleOnDismissCountryDialog(): Job = intent {
        reduce { state.copy(selectedCountry = null) }
    }

    private fun handleOnSelectedCountry(code: String): Job = intent {
        val country = withContext(Dispatchers.IO) {
            getCountryUseCase.invoke(code)
        }

        reduce {
            state.copy(selectedCountry = country)
        }
    }
}