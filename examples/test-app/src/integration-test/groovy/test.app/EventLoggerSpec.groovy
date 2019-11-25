package test.app

import grails.event.log.EventLogger
import grails.gorm.transactions.Rollback
import grails.testing.mixin.integration.Integration
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.config.AutowireCapableBeanFactory
import org.springframework.web.context.WebApplicationContext
import spock.lang.Specification

@Integration
@Rollback
class EventLoggerSpec extends Specification {
    TestService testService
    TestController controller

    @Autowired
    WebApplicationContext ctx

    void setup() {
        controller = new TestController()
        ctx.autowireCapableBeanFactory.autowireBeanProperties(controller, AutowireCapableBeanFactory.AUTOWIRE_BY_NAME, false)
    }

    void "Check if eventLogger is attached in service"() {

        expect:
        testService.eventLogger instanceof EventLogger

    }

    void "Check if eventLogger is attached in controller"() {

        expect:
        controller.eventLogger instanceof EventLogger

    }

    void "Check if eventLogger is attached in domain"() {

        expect:
        (new Org()).eventLogger instanceof EventLogger
    }
}
