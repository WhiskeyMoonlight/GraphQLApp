package com.dimas.graphqlapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider
import com.dimas.graphqlapp.presentation.CountriesScreen
import com.dimas.graphqlapp.presentation.CountriesViewModel
import com.dimas.graphqlapp.ui.theme.GraphQLAppTheme
import org.orbitmvi.orbit.compose.collectAsState
import javax.inject.Inject


class MainActivity : ComponentActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        (application as CountriesApplication).appComponent.inject(this)
        setContent {
            GraphQLAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val viewModel by viewModels<CountriesViewModel> { viewModelFactory }
                    val state = viewModel.collectAsState().value
                    CountriesScreen(
                        state = state,
                        onAction = viewModel::onAction,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}