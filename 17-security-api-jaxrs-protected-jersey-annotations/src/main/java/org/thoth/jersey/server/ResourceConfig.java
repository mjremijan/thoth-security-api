package org.thoth.jersey.server;

import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;

/**
 *
 * @author Michael Remijan mjremijan@yahoo.com @mjremijan
 */
@ApplicationPath("rest")
public class ResourceConfig  extends org.glassfish.jersey.server.ResourceConfig {
    public ResourceConfig() {
        super();
        register(RolesAllowedDynamicFeature.class);
        super.packages(true, "org.thoth.jeesa");
    }
}
