package nl.janverhoeckx.hexagonalarchitectureexample.domain.medication

import java.util.*

data class Medication(
    val id: UUID = UUID.randomUUID(),
    val name: String,
    val code: String,
    val minimalIntervalBetweenConsumptionInHours: Long
)