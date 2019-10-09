package test.app

import java.time.LocalDateTime

class Org {
    String name
    String num
    Date testDate
    LocalDateTime testDateTwo
    boolean isActive = true
    BigDecimal revenue = 0
    BigDecimal credit
    Long refId = 0L
    String event

    static constraints = {
        name blank: false
        num nullable: true
        testDate nullable: true
        testDateTwo nullable: true
        credit nullable: true
        event nullable: true
    }
}
