package com.dimas.graphqlapp.di

import com.dimas.graphqlapp.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, ViewModelModule::class])
interface AppComponent {
    fun inject(activity: MainActivity)
}