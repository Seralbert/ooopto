package ys.project.model;

import org.springframework.security.core.GrantedAuthority;

/**
 * Created by zorrax on 26.09.2018.
 */
public enum Role implements GrantedAuthority {
    USER;

    @Override
    public String getAuthority() {
        return name();
    }
}
