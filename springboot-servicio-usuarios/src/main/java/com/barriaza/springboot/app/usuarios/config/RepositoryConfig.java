package com.barriaza.springboot.app.usuarios.config;

import com.barriaza.springboot.app.usuarios.commons.models.entity.Role;
import com.barriaza.springboot.app.usuarios.commons.models.entity.Usuario;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;

@Configuration
public class RepositoryConfig implements RepositoryRestConfigurer {

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config.exposeIdsFor(Usuario.class, Role.class);
    }

}