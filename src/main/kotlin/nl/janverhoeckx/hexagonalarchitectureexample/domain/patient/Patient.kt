package nl.janverhoeckx.hexagonalarchitectureexample.domain.patient

import nl.janverhoeckx.hexagonalarchitectureexample.domain.medication.Medication
import nl.janverhoeckx.hexagonalarchitectureexample.domain.medication.MedicationDispense
import nl.janverhoeckx.hexagonalarchitectureexample.domain.medication.MedicationDispensedToSoonException
import nl.janverhoeckx.hexagonalarchitectureexample.domain.medication.Quantity
import nl.janverhoeckx.hexagonalarchitectureexample.domain.practitioner.Practitioner
import java.time.Instant.now
import java.time.temporal.ChronoUnit.HOURS

import java.util.*

class Patient(
    val id: UUID = UUID.randomUUID(),
    val name: Name,
    val dispensedMedication: MutableList<MedicationDispense>
) {
    fun dispenseMedication(
        medication: Medication,
        practitioner: Practitioner,
        quantity: Quantity
    ): MedicationDispense {
        if (!canReceiveMedication(medication)) {
            throw MedicationDispensedToSoonException()
        }
        val medicationDispense = MedicationDispense(medication, practitioner, quantity)
        dispensedMedication += medicationDispense
        return medicationDispense
    }

    private fun canReceiveMedication(medication: Medication) =
        dispensedMedication
            .filter { medicationDispense -> medicationDispense.medicationId == medication.id }
            .none { medicationDispense ->
                now().isAfter(
                    medicationDispense.dispensedAt.plus(
                        medication.minimalIntervalBetweenConsumptionInHours,
                        HOURS
                    )
                )
            }
}