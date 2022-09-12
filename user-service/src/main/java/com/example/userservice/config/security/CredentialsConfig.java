package com.example.userservice.config.security;

import lombok.val;
import org.keycloak.representations.idm.CredentialRepresentation;

public class CredentialsConfig {

    public static CredentialRepresentation createPasswordCredentials(String password) {
        val passwordCredentials = new CredentialRepresentation();
        passwordCredentials.setTemporary(false);
        passwordCredentials.setType(CredentialRepresentation.PASSWORD);
        passwordCredentials.setValue(password);
        return passwordCredentials;
    }
}
