package com.example.userservice.config.security;

import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.keycloak.OAuth2Constants;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;

public class KeycloakConfig {

    //TODO move it to properties

    static Keycloak keycloak = null;
    static final String SERVER_URL = "https://unicorn-auth.cytr.us/auth";
    public static final String REALM = "dev";
    static final String CLIENT_ID = "tfp-app";
    static final String CLIENT_SECRET = "JAkGuczT07GwsGrNS6QSSdieWU2ThBnV";
    static final String SERVICE_USER = "service-admin";
    static final String SERVICE_USER_PASSWORD = "12345678";

    public KeycloakConfig() {
    }

    public static Keycloak getInstance() {
        if (keycloak == null) {
            keycloak = KeycloakBuilder.builder()
                    .serverUrl(SERVER_URL)
                    .realm(REALM)
                    .grantType(OAuth2Constants.PASSWORD)
                    .username(SERVICE_USER)
                    .password(SERVICE_USER_PASSWORD)
                    .clientId(CLIENT_ID)
                    .clientSecret(CLIENT_SECRET)
                    .resteasyClient(new ResteasyClientBuilder()
                            .connectionPoolSize(10)
                            .build())
                    .build();
        }
        return keycloak;
    }
}
