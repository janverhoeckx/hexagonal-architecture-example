package nl.janverhoeckx.hexagonalarchitectureexample.infrastructure.beans

import nl.janverhoeckx.hexagonalarchitectureexample.domain.medication.MedicationDispenser
import nl.janverhoeckx.hexagonalarchitectureexample.domain.medication.PatientRepository
import nl.janverhoeckx.hexagonalarchitectureexample.domain.medication.PractitionerRepository
import nl.janverhoeckx.hexagonalarchitectureexample.infrastructure.event.StubEventPublisher
import nl.janverhoeckx.hexagonalarchitectureexample.infrastructure.medication.StubMedicationRegistry
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class BeanConfiguration {
    @Bean
    fun getMedicationDispenser(
        patientRepository: PatientRepository,
        practitionerRepository: PractitionerRepository,
        stubMedicationRegistry: StubMedicationRegistry,
        stubEventPublisher: StubEventPublisher
    ): MedicationDispenser =
        MedicationDispenser(
            patientRepository,
            practitionerRepository,
            stubMedicationRegistry,
            stubEventPublisher
        )
}


