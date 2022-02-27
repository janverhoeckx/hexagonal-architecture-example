package nl.janverhoeckx.hexagonalarchitectureexample.domain.medication

import java.util.*

interface MedicationRegistry {
    fun findById(id: UUID): Medication
}