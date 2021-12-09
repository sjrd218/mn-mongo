package rd.auth.entities

import grails.gorm.annotation.Entity
import io.micronaut.core.annotation.Introspected

@Entity
@Introspected
class Tenant {
    String id = UUID.randomUUID().toString().substring(0,8)
    String name
    String subdomain
}
