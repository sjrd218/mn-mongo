package rd.auth

import grails.gorm.transactions.Transactional
import jakarta.inject.Singleton
import rd.auth.entities.Tenant

@Transactional
@Singleton
class TenantService {

    List<Tenant> listTenants() {
        return Tenant.list()
    }
}
