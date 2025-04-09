package com.dimas.graphqlapp.data

import com.apollographql.apollo.ApolloClient
import com.dimas.CountriesQuery
import com.dimas.CountryQuery
import com.dimas.graphqlapp.domain.CountryClient
import com.dimas.graphqlapp.domain.DetailedCountry
import com.dimas.graphqlapp.domain.SimpleCountry
import javax.inject.Inject

class ApolloCountryClient @Inject constructor(
    private val apolloClient: ApolloClient
) : CountryClient {
    override suspend fun getCountries(): List<SimpleCountry> {
        return apolloClient
            .query(CountriesQuery())
            .execute()
            .data
            ?.countries
            ?.map { it.toSimpleCountry() }
            ?: emptyList()
    }

    override suspend fun getCountry(code: String): DetailedCountry? {
        return apolloClient
            .query(CountryQuery(code))
            .execute()
            .data
            ?.country
            ?.toDetailedCountry()
    }

}