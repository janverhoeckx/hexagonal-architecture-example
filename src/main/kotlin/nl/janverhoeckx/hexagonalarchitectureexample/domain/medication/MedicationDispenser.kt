package nl.janverhoeckx.hexagonalarchitectureexample.domain.medication

import nl.janverhoeckx.hexagonalarchitectureexample.domain.EventPublisher
import java.util.*

class MedicationDispenser(
    private val patientRepository: PatientRepository,
    private val practitionerRepository: PractitionerRepository,
    private val medicationRegistry: MedicationRegistry,
    private val eventPublisher: EventPublisher
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

        val dispensedMedication =
            patient.dispenseMedication(medication, practitioner, quantity)

        patientRepository.save(patient)
        eventPublisher.publishEvent(dispensedMedication)
    }
}

