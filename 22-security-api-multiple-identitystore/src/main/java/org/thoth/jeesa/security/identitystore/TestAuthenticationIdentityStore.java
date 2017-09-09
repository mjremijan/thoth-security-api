package org.thoth.jeesa.security.identitystore;

import static java.util.Arrays.asList;
import java.util.HashSet;
import java.util.Set;
import javax.enterprise.context.ApplicationScoped;
import javax.security.enterprise.credential.Credential;
import javax.security.enterprise.identitystore.CredentialValidationResult;
import javax.security.enterprise.identitystore.IdentityStore;
import static javax.security.enterprise.identitystore.IdentityStore.ValidationType.VALIDATE;
import org.apache.log4j.Logger;
import org.thoth.jeesa.security.credential.TestCredential;

/**
 *
 * @author Michael Remijan mjremijan@yahoo.com @mjremijan
 */
@ApplicationScoped
public class TestAuthenticationIdentityStore implements IdentityStore {

    private static final Logger log = Logger.getLogger(TestAuthenticationIdentityStore.class);

    @Override
    public Set<ValidationType> validationTypes() {
        return new HashSet<>(asList(VALIDATE));
    }
    
    @Override
    public CredentialValidationResult validate(Credential credential) {
        log.info("ENTER #validate(Credential)");

        return new CredentialValidationResult(
            ((TestCredential) credential).getCaller()
        );
    }
}
