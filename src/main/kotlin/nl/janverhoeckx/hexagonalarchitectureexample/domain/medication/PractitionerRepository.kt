package nl.janverhoeckx.hexagonalarchitectureexample.domain.medication

import nl.janverhoeckx.hexagonalarchitectureexample.domain.practitioner.Practitioner
import java.util.*

interface PractitionerRepository {
    fun findById(id: UUID): Practitioner
}