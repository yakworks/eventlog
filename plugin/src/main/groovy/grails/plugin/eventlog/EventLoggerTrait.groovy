/*
* Copyright 2019 Yak.Works - Licensed under the Apache License, Version 2.0 (the "License")
* You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0
*/
package grails.plugin.eventlog

import gorm.tools.beans.AppCtx

trait EventLoggerTrait {
    private static EventLogger cachedEventLogger
    static transient EventLogger getEventLogger(){
        if (!cachedEventLogger) cachedEventLogger = AppCtx.get('eventLogger', EventLogger)
        cachedEventLogger
    }
}
