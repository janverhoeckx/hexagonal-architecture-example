package nl.janverhoeckx.hexagonalarchitectureexample.infrastructure.repository

import nl.janverhoeckx.hexagonalarchitectureexample.domain.medication.PractitionerRepository
import nl.janverhoeckx.hexagonalarchitectureexample.domain.practitioner.Practitioner
import org.springframework.stereotype.Component
import java.util.*

@Component
class PractitionerRepositorySpringDataJdbcAdapter: PractitionerRepository {
    override fun findById(id: UUID): Practitioner {
        TODO("Not yet implemented")
    }
}