package nl.janverhoeckx.hexagonalarchitectureexample.domain.patient

import nl.janverhoeckx.hexagonalarchitectureexample.domain.medication.Medication
import nl.janverhoeckx.hexagonalarchitectureexample.domain.medication.Quantity
import nl.janverhoeckx.hexagonalarchitectureexample.domain.practitioner.Practitioner
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class PatientTest{

    @Test
    fun `dispenseMedication with no previous dispensed medication`() {
        val medication =
            Medication(name = "Paracetamol", code = "N02BE01", minimalIntervalBetweenConsumptionInHours = 3)
        val patient = Patient(name = Name("John", "Doe"), dispensedMedication = mutableListOf())
        val practitioner = Practitioner()
        val quantity = Quantity(30, "mg")

        patient.dispenseMedication(medication, practitioner, quantity)

        assertEquals(1, patient.dispensedMedication.size)
        val dispensedMedication = patient.dispensedMedication.first()
        assertEquals(quantity, dispensedMedication.quantity)
        assertEquals(medication.id, dispensedMedication.medicationId)
        assertEquals(practitioner.id, dispensedMedication.practitionerId)
    }

}