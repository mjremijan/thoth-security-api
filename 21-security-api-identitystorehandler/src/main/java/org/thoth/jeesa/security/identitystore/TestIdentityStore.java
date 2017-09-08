package org.thoth.jeesa.security.identitystore;

import static java.util.Arrays.asList;
import java.util.HashSet;
import javax.security.enterprise.identitystore.CredentialValidationResult;
import javax.security.enterprise.identitystore.IdentityStore;
import org.apache.log4j.Logger;
import org.thoth.jeesa.security.credential.TestCredential;
import org.thoth.jeesa.security.principal.TestCallerPrincipal;

/**
 *
 * @author Michael Remijan mjremijan@yahoo.com @mjremijan
 */
public class TestIdentityStore implements IdentityStore {

    private static final Logger log = Logger.getLogger(TestIdentityStore.class);

    public CredentialValidationResult validate(TestCredential testCredential) {
        log.info("ENTER #validate()");

        return new CredentialValidationResult(
              new TestCallerPrincipal(testCredential.getCaller() + "/TestIdentityStore")
            , new HashSet<>(asList("GROUP_CUSTOMER_SUPPORTS", "GROUP_SALARY_EMPLOYEES")));
    }
}
