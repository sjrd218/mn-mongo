package rd.auth

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import jakarta.inject.Inject
import rd.auth.entities.Tenant

@Controller("/tenant")
class TenantController {

    @Inject
    TenantService tenantService

    @Get("/")
    List<Tenant> listTenants() {
        return tenantService.listTenants()
    }
}
