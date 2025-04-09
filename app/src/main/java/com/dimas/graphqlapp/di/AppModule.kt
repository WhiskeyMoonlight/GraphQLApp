package com.dimas.graphqlapp.di

import com.apollographql.apollo.ApolloClient
import com.dimas.graphqlapp.data.ApolloCountryClient
import com.dimas.graphqlapp.domain.CountryClient
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object AppModule {

    @Provides
    @Singleton
    fun provideCountryClient(apolloClient: ApolloClient): CountryClient {
        return ApolloCountryClient(apolloClient)
    }

    @Provides
    @Singleton
    fun provideApolloClient(): ApolloClient {
        return ApolloClient.Builder()
            .serverUrl("https://countries.trevorblades.com/graphql")
            .build()
    }
}