package org.thoth.jeesa.security.identitystore;

import static java.util.Arrays.asList;
import java.util.HashSet;
import java.util.Set;
import javax.enterprise.context.ApplicationScoped;
import javax.security.enterprise.identitystore.CredentialValidationResult;
import javax.security.enterprise.identitystore.IdentityStore;
import static javax.security.enterprise.identitystore.IdentityStore.ValidationType.PROVIDE_GROUPS;
import org.apache.log4j.Logger;

/**
 *
 * @author Michael Remijan mjremijan@yahoo.com @mjremijan
 */
@ApplicationScoped
public class TestGroupsIdentityStoreB implements IdentityStore {

    private static final Logger log = Logger.getLogger(TestGroupsIdentityStoreB.class);

    @Override
    public Set<String> getCallerGroups(CredentialValidationResult validationResult) {
        log.info("ENTER #getCallerGroups()");
        return new HashSet<>(asList("GROUP_EXECUTIVES"));
    }

    @Override
    public Set<ValidationType> validationTypes() {
        return new HashSet<>(asList(PROVIDE_GROUPS));
    }
}
