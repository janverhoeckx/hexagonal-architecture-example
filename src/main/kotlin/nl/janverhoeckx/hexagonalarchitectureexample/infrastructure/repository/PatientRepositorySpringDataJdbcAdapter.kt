package nl.janverhoeckx.hexagonalarchitectureexample.infrastructure.repository

import nl.janverhoeckx.hexagonalarchitectureexample.domain.medication.PatientRepository
import nl.janverhoeckx.hexagonalarchitectureexample.domain.patient.Patient
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component
import java.util.*

@Component
class PatientRepositorySpringDataJdbcAdapter(
    private val patientEntityRepository: PatientEntityRepository
) : PatientRepository {

    override fun save(patient: Patient): Patient =
        patientEntityRepository.save(PatientEntity(patient)).toPatient()

    override fun findById(id: UUID): Patient =
        patientEntityRepository.findByIdOrNull(id)?.toPatient()
            ?: throw IllegalStateException("Patient with id $id not found")

    override fun findAll(): Collection<Patient> =
        patientEntityRepository.findAll().toPatients()

    fun Iterable<PatientEntity>.toPatients() = this.map { it.toPatient() }
}

