package test.app

import grails.gorm.transactions.Transactional

@Transactional
class TestService {

    def serviceMethod() {
        println "test"
    }
}
