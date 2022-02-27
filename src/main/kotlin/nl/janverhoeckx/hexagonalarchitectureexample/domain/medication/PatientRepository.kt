package nl.janverhoeckx.hexagonalarchitectureexample.domain.medication

import nl.janverhoeckx.hexagonalarchitectureexample.domain.patient.Patient
import java.util.*

interface PatientRepository {
    fun save(patient: Patient): Patient
    fun findById(id: UUID): Patient
}