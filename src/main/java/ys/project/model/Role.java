package ys.project.model;

import org.springframework.security.core.GrantedAuthority;

/**
 * Created by Yuriy Smirnov on 13.03.2020.
 *
 */
public enum Role implements GrantedAuthority {
    GUEST, USER, ADMIN;

    @Override
    public String getAuthority() {
        return name();
    }
}
