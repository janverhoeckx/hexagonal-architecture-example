package nl.janverhoeckx.hexagonalarchitectureexample.infrastructure.repository

import nl.janverhoeckx.hexagonalarchitectureexample.domain.medication.MedicationDispense
import nl.janverhoeckx.hexagonalarchitectureexample.domain.patient.Name
import nl.janverhoeckx.hexagonalarchitectureexample.domain.patient.Patient
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.util.*

@Table("patient")
data class PatientEntity(
    @Id
    val id: UUID,
    val name: Name,
    val dispensedMedication: List<MedicationDispense>
) {
    constructor(patient: Patient) : this(
        patient.id,
        patient.name,
        patient.dispensedMedication
    )

    fun toPatient() = Patient(id, name, dispensedMedication.toMutableList())
}