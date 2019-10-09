/*
* Copyright 2019 Yak.Works - Licensed under the Apache License, Version 2.0 (the "License")
* You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0
*/
package grails.event.log

import org.springframework.beans.factory.annotation.Autowired

trait EventLoggerTrait {

    @Autowired
    transient EventLogger eventLogger
}
