package com.dimas.graphqlapp.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dimas.graphqlapp.di.utils.ViewModelKey
import com.dimas.graphqlapp.presentation.CountriesViewModel
import com.dimas.graphqlapp.presentation.DaggerViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(CountriesViewModel::class)
    abstract fun bindViewModel(viewModel: CountriesViewModel): ViewModel

    @Binds
    abstract fun bindFactory(factory: DaggerViewModelFactory): ViewModelProvider.Factory
}

