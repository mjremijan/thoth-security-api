package org.thoth.jeesa.security.identitystore;

import static java.util.Arrays.asList;
import java.util.HashSet;
import javax.security.enterprise.credential.Credential;
import javax.security.enterprise.identitystore.CredentialValidationResult;
import static javax.security.enterprise.identitystore.CredentialValidationResult.INVALID_RESULT;
import javax.security.enterprise.identitystore.IdentityStore;
import org.apache.log4j.Logger;
import org.thoth.jeesa.security.credential.TestCredential;

/**
 *
 * @author Michael Remijan mjremijan@yahoo.com @mjremijan
 */
public class TestIdentityStore implements IdentityStore {

    private static final Logger log = Logger.getLogger(TestIdentityStore.class);

    @Override
    public CredentialValidationResult validate(Credential credential) {
        log.info("ENTER #validate()");

        TestCredential testCredential
            = (TestCredential)credential;

        if (testCredential.compareTo("security-api-user")) {
            return new CredentialValidationResult(
                  testCredential.getCaller()
                , new HashSet<>(asList("GROUP_CUSTOMER_SUPPORTS", "GROUP_SALARY_EMPLOYEES")));
        }

        return INVALID_RESULT;
    }
}
