package nl.janverhoeckx.hexagonalarchitectureexample.domain.medication

import nl.janverhoeckx.hexagonalarchitectureexample.domain.practitioner.Practitioner
import java.time.Instant
import java.time.Instant.now
import java.util.*

class MedicationDispense(
    val id: UUID? = UUID.randomUUID(),
    val medicationId: UUID,
    val quantity: Quantity,
    val practitionerId: UUID,
    val dispensedAt: Instant
) {
    constructor(medication: Medication, practitioner: Practitioner, quantity: Quantity) : this(
        medicationId = medication.id,
        practitionerId = practitioner.id,
        quantity = quantity,
        dispensedAt = now()
    )
}