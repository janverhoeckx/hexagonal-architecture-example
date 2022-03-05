package nl.janverhoeckx.hexagonalarchitectureexample.infrastructure.event

import nl.janverhoeckx.hexagonalarchitectureexample.domain.EventPublisher
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

private val LOGGER: Logger = LoggerFactory.getLogger(StubEventPublisher::class.java)

@Component
class StubEventPublisher : EventPublisher {
    override fun publishEvent(eventData: Any) {
        LOGGER.info("Event published: $eventData")
    }
}