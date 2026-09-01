package com.prod_ready_feature.demo.auth;


import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class AuditorAwareImpl implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        // get SecurityContext
        // get Authentication
        // get Principal
        // get username
        return Optional.of("Priye Arya");
    }

}
