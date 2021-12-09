package rd.auth

import grails.gorm.transactions.Transactional
import io.micronaut.context.event.StartupEvent
import io.micronaut.runtime.event.annotation.EventListener
import jakarta.inject.Inject
import jakarta.inject.Singleton
import org.grails.datastore.mapping.mongo.MongoDatastore
import rd.auth.entities.Role
import rd.auth.entities.Tenant
import rd.auth.entities.User

@Singleton
class BootstrapService {

    @Inject
    MongoDatastore mongoDatastore

    @EventListener
    @Transactional
    void onStart(StartupEvent startEvt) {
        println "Bootstrap"
        if(Tenant.count() > 0) return
        Tenant global = new Tenant()
        global.name = "global"
        global.subdomain = "global.rundeck.cloud"
        global.insert()
        global.save()

        Role globalAdmin = new Role()
        globalAdmin.tenantId = global.id
        globalAdmin.role = "global.admin"
        globalAdmin.insert()
        globalAdmin.save()

        User gadmin = new User()
        gadmin.tenantId  = global.id
        gadmin.email = "global.admin@rundeck.com"
        gadmin.insert()
        gadmin.save()

        globalAdmin.addToUsers(gadmin)
        globalAdmin.save()
    }
}
