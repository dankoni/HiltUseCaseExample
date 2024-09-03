package com.example.data.model

data class PlanetDataForList(
    val id: String,
    val name: String,
    val orbitalPeriod: Int)

data class PlanetDataForInfo(
    val id: String,
    val name: String,
    val orbitalPeriod: Int,
    val population: String
)