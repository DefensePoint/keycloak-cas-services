package io.github.johnjcool.keycloak.broker.cas;

import org.keycloak.models.IdentityProviderModel;

public class CasIdentityProviderConfig extends IdentityProviderModel {

    private static final long serialVersionUID = 1L;

    private static final String DEFAULT_CAS_LOGIN_SUFFFIX = "login";
    private static final String DEFAULT_CAS_LOGOUT_SUFFFIX = "logout";
    private static final String DEFAULT_CAS_SERVICE_VALIDATE_SUFFFIX = "serviceValidate";
    private static final String DEFAULT_CAS_3_PROTOCOL_PREFIX = "p3";

    public static final String CAS_SERVER_URL_PREFIX = "casServerUrlPrefix";
    public static final String CAS_SERVER_PROTOCOL_3 = "casServerProtocol3";
    public static final String CAS_GATEWAY = "gateway";
    public static final String CAS_RENEW = "renew";

    public CasIdentityProviderConfig() {
    }

    public CasIdentityProviderConfig(final IdentityProviderModel model) {
        super(model);
    }

    public void setCasServerUrlPrefix(final String casServerUrlPrefix) {
        getConfig().put(CAS_SERVER_URL_PREFIX, casServerUrlPrefix);
    }
    
    public String getCasServerUrlPrefix() {
        return getConfig().get("casServerUrlPrefix");
    }

    public void setCasServerProtocol3(final boolean casServerProtocol3) {
        getConfig().put(CAS_SERVER_PROTOCOL_3, String.valueOf(casServerProtocol3));
    }
    
    public boolean isCasServerProtocol3() {
        return Boolean.valueOf(getConfig().get(CAS_SERVER_PROTOCOL_3));
    }

    public void setGateway(final boolean gateway) {
        getConfig().put(CAS_GATEWAY, String.valueOf(gateway));
    }
    
    public boolean isGateway() {
        return Boolean.valueOf(getConfig().get(CAS_GATEWAY));
    }

    public void setRenew(final boolean renew) {
        getConfig().put(CAS_RENEW, String.valueOf(renew));
    }
    
    public boolean isRenew() {
        return Boolean.valueOf(getConfig().get(CAS_RENEW));
    }

    public String getCasServerLoginUrl() {
        return String.format("%s/%s", getCasServerUrlPrefix(), DEFAULT_CAS_LOGIN_SUFFFIX);
    }

    public String getCasServerLogoutUrl() {
        return String.format("%s/%s", getCasServerUrlPrefix(), DEFAULT_CAS_LOGOUT_SUFFFIX);
    }

    public String getCasServiceValidateUrl() {
        return isCasServerProtocol3() ?
                String.format("%s/%s/%s", getCasServerUrlPrefix(), DEFAULT_CAS_3_PROTOCOL_PREFIX, DEFAULT_CAS_SERVICE_VALIDATE_SUFFFIX)
                : String.format("%s/%s", getCasServerUrlPrefix(), DEFAULT_CAS_SERVICE_VALIDATE_SUFFFIX);
    }
}
