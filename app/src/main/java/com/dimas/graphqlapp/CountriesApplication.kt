package com.dimas.graphqlapp

import android.app.Application
import com.dimas.graphqlapp.di.DaggerAppComponent

class CountriesApplication : Application() {
    val appComponent = DaggerAppComponent.create()
}