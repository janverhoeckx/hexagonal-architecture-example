package nl.janverhoeckx.hexagonalarchitectureexample.domain.medication

import java.util.*

class MedicationDispenser(
    private val patientRepository: PatientRepository,
    private val medicationRegistry: MedicationRegistry,
    private val practitionerRepository: PractitionerRepository
) {
    fun dispenseMedication(
        medicationId: UUID,
        quantity: Quantity,
        patientId: UUID,
        practitionerId: UUID
    ) {
        val patient = patientRepository.findById(patientId)
        val medication = medicationRegistry.findById(medicationId)
        val practitioner = practitionerRepository.findById(practitionerId)
        patient.dispenseMedication(medication, practitioner, quantity)
        patientRepository.save(patient)
    }
}