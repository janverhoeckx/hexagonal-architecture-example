package nl.janverhoeckx.hexagonalarchitectureexample.domain.medication

class MedicationDispensedToSoonException :
    RuntimeException("Minimal waiting time for this medication has not yet passed")