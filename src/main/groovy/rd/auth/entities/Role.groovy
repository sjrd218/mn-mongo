package rd.auth.entities

import grails.gorm.annotation.Entity
import io.micronaut.core.annotation.Introspected

@Entity
@Introspected
class Role {
    String id = UUID.randomUUID().toString()
    String tenantId
    String role

    static hasMany = [users:User]

}
