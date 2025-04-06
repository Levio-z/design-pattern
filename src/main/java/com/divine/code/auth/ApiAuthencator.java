package com.divine.code.auth;

public interface ApiAuthencator {

    void auth(String baseUrl);

    void auth(ApiRequest apiRequest);

}
