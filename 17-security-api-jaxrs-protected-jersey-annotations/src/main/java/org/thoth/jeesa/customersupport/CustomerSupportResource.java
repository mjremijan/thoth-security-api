package org.thoth.jeesa.customersupport;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("customersupport")
public class CustomerSupportResource {

    @Context
    private UriInfo context;

    public CustomerSupportResource() {
    }

    @GET
    @Path("help")
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed({"CustomerSupportRole"})
    public CustomerSupportHelp getHelpInformation() {
        return new CustomerSupportHelp("555-1212","help@internet.com");
    }
}
