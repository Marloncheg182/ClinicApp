package clinicapp.Web.Service;

import clinicapp.Web.entity.User;
import clinicapp.Web.entity.type.WebUserStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userService.getUser("test");
        Set<GrantedAuthority> status = new HashSet();
        status.add(new SimpleGrantedAuthority(WebUserStatus.USER.name()));

        UserDetails userDetails = new org.springframework.security.core.userdetails.User(user.getUserLogin(),
                user.getUserPassord(),status);

        return userDetails;
    }
}
