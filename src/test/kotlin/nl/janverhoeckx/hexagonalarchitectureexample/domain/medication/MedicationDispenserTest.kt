package nl.janverhoeckx.hexagonalarchitectureexample.domain.medication

import nl.janverhoeckx.hexagonalarchitectureexample.domain.EventPublisher
import nl.janverhoeckx.hexagonalarchitectureexample.domain.patient.Name
import nl.janverhoeckx.hexagonalarchitectureexample.domain.patient.Patient
import nl.janverhoeckx.hexagonalarchitectureexample.domain.practitioner.Practitioner
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.jupiter.MockitoExtension
import org.mockito.kotlin.argumentCaptor
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

@ExtendWith(MockitoExtension::class)
internal class MedicationDispenserTest {

    @InjectMocks
    private lateinit var medicationDispenser: MedicationDispenser

    @Mock
    private lateinit var medicationRegistry: MedicationRegistry

    @Mock
    private lateinit var patientRepository: PatientRepository

    @Mock
    private lateinit var practitionerRepository: PractitionerRepository

    @Mock
    private lateinit var eventPublisher: EventPublisher

    @Test
    fun `dispenseMedication with no previous dispensed medication`() {
        val medication =
            Medication(name = "Paracetamol", code = "N02BE01", minimalIntervalBetweenConsumptionInHours = 3)
        val patient = Patient(name = Name("John", "Doe"), dispensedMedication = mutableListOf())
        val practitioner = Practitioner()

        whenever(patientRepository.findById(patient.id)).thenReturn(patient)
        whenever(medicationRegistry.findById(medication.id)).thenReturn(medication)
        whenever(practitionerRepository.findById(practitioner.id)).thenReturn(practitioner)

        medicationDispenser.dispenseMedication(medication.id, Quantity(30, "mg"), patient.id, practitioner.id)

        val argumentCaptor = argumentCaptor<Patient>()
        verify(patientRepository).save(argumentCaptor.capture())

        val savedPatient = argumentCaptor.firstValue
        assertEquals(patient.id, savedPatient.id)
        assertEquals(1, savedPatient.dispensedMedication.size)
        val dispensedMedication = savedPatient.dispensedMedication.first()

        verify(eventPublisher).publishEvent(dispensedMedication)
    }
}