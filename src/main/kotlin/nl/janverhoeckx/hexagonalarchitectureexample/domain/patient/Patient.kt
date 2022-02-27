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
    fun dispenseMedication(medication: Medication, practitioner: Practitioner, quantity: Quantity) {
        if (!canReceiveMedication(medication)) {
            throw MedicationDispensedToSoonException()
        }
        dispensedMedication += MedicationDispense(medication, practitioner, quantity)
    }

    private fun canReceiveMedication(medication: Medication) =
        dispensedMedication.none { medicationDispense ->
            medicationDispense.medicationId == medication.id &&
                    now().isAfter(
                        medicationDispense.dispensedAt.plus(medication.minimalIntervalBetweenConsumptionInHours, HOURS)
                    )
        }
}