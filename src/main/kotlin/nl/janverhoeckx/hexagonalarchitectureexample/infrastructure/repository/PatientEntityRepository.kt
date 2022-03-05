package nl.janverhoeckx.hexagonalarchitectureexample.infrastructure.repository

import org.springframework.data.repository.CrudRepository
import java.util.*

interface PatientEntityRepository : CrudRepository<PatientEntity, UUID>