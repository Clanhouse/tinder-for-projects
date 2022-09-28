import Keycloak from "keycloak-js";

const keycloakConfig = {
  url: "https://unicorn-auth.cytr.us/auth",
  realm: "dev",
  clientId: "tfp-app",
};
const keycloak = new Keycloak(keycloakConfig);

export default keycloak;
