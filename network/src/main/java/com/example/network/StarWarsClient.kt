package com.example.network

import com.apollographql.apollo.ApolloClient
import javax.inject.Inject

class StarWarsClient @Inject constructor(){

    fun buildApolloClient() = ApolloClient.Builder()
        .serverUrl("https://swapi-graphql.netlify.app/.netlify/functions/index")
        .build()
}