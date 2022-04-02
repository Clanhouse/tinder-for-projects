package com.tinderforprojects.tinder.config.security;

import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.keycloak.OAuth2Constants;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;

public class KeycloakConfig {

    //TODO
    //Move it to encrypted file
    static Keycloak keycloak = null;
    final static String serverUrl = "https://tinder-auth.cytr.us/auth";
    public final static String realm = "tinder";
    final static String clientId = "tinder-app";
    final static String clientSecret = "3Nqsg1frENrbSWBpnvYOEGcgCpsB0aMy";
    final static String userName = "service-admin";
    final static String password = "12345678";

    public KeycloakConfig() {

    }

    public static Keycloak getInstance() {
        if (keycloak == null) {
            keycloak = KeycloakBuilder.builder()
                    .serverUrl(serverUrl)
                    .realm(realm)
                    .grantType(OAuth2Constants.PASSWORD)
                    .username(userName)
                    .password(password)
                    .clientId(clientId)
                    .clientSecret(clientSecret)
                    .resteasyClient(new ResteasyClientBuilder()
                            .connectionPoolSize(10)
                            .build())
                    .build();
        }
        return keycloak;
    }

}
