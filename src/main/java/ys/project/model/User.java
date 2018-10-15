package ys.project.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

/**
 * Created by zorrax on 26.09.2018.
 *
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
/*@Document*/
public class User implements UserDetails{
    @Id
    private String id;
    private List<Role> authorities;
    private String password;
    private String username;
    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;
    private boolean enabled;

    public boolean isAdmin(){
        return authorities.contains(Role.ADMIN);
    }
    public boolean isEditor() {
        return authorities.contains(Role.EDITOR);
    }
}
