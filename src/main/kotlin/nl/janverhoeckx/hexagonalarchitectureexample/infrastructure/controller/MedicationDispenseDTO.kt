package nl.janverhoeckx.hexagonalarchitectureexample.infrastructure.controller

import nl.janverhoeckx.hexagonalarchitectureexample.domain.medication.Quantity
import java.time.Instant
import java.time.Instant.now
import java.util.*

data class MedicationDispenseDTO(
    val medicationId: UUID,
    val quantity: Quantity,
    val practitionerId: UUID,
    val dispensedAt: Instant = now()
)