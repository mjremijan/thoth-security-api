/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.thoth.jeesa.security.principal;

import java.security.Principal;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;

/**
 * REST Web Service
 *
 * @author Michael Remijan mjremijan@yahoo.com @mjremijan
 */
@Path("principal")
public class PrincipalResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getPrincipalName(@Context SecurityContext securityContext) {
        String name = "UNKNOWN";
        if (securityContext == null) {
            name = "SecurityContext is null";
        }
        else {
            Principal p = securityContext.getUserPrincipal();
            if (p == null) {
                name = "Principal is null";
            }
            else {
                name = p.getName();
            }
        }
        return name;
    }
}
