package nl.janverhoeckx.hexagonalarchitectureexample.infrastructure.controller

import nl.janverhoeckx.hexagonalarchitectureexample.domain.medication.MedicationDispenser
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/api/patient")
@Transactional
class MedicationController(
    private val medicationDispenser: MedicationDispenser
) {

    @PostMapping("/{patientId}/medication")
    fun patchMedication(
        @RequestBody medicationDTO: MedicationDispenseDTO,
        @PathVariable("patientId") patientId: UUID
    ) {
        medicationDispenser.dispenseMedication(
            medicationDTO.medicationId,
            medicationDTO.quantity,
            patientId,
            medicationDTO.practitionerId
        )
    }
}


