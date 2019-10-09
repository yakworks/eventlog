/*
* Copyright 2019 Yak.Works - Licensed under the Apache License, Version 2.0 (the "License")
* You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0
*/
package grails.event.log

import groovy.transform.CompileStatic

import org.grails.core.artefact.ControllerArtefactHandler
import org.grails.core.artefact.DomainClassArtefactHandler
import org.grails.core.artefact.ServiceArtefactHandler

import gorm.tools.repository.GormRepoEntity
import grails.compiler.traits.TraitInjector

/**
 * @author Alexey Zvegintcev
 */
@CompileStatic
class EventLoggerTraitInjector implements TraitInjector {

    @Override
    Class getTrait() {
        EventLoggerTrait
    }

    @Override
    String[] getArtefactTypes() {
        //TODO: When domain is included tests are failing
        [/*DomainClassArtefactHandler.TYPE,*/ ControllerArtefactHandler.TYPE, ServiceArtefactHandler.TYPE] as String[]
    }
}
