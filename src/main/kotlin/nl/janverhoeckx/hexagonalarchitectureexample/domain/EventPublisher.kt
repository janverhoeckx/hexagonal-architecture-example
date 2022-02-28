package nl.janverhoeckx.hexagonalarchitectureexample.domain

interface EventPublisher {
    fun publishEvent(eventData: Any)
}