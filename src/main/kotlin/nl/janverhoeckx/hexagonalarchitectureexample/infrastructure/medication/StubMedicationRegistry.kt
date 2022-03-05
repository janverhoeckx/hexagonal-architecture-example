package nl.janverhoeckx.hexagonalarchitectureexample.infrastructure.medication

import nl.janverhoeckx.hexagonalarchitectureexample.domain.medication.Medication
import nl.janverhoeckx.hexagonalarchitectureexample.domain.medication.MedicationRegistry
import org.springframework.stereotype.Component
import java.util.*

@Component
class StubMedicationRegistry : MedicationRegistry {
    override fun findById(id: UUID): Medication {
        return Medication(id, "Paracetamol", "N02BE01", 3)
    }
}