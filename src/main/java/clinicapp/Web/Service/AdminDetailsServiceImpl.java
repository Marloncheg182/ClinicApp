package clinicapp.Web.Service;


import clinicapp.Web.entity.Admin;
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
public class AdminDetailsServiceImpl implements UserDetailsService {


    private AdminService adminService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Admin admin = adminService.getAdmin("admin");
        Set<GrantedAuthority> status = new HashSet();
        status.add(new SimpleGrantedAuthority(WebUserStatus.ADMIN.name()));

        UserDetails userDetails = new org.springframework.security.core.userdetails.User(admin.getAdminLogin(),
                admin.getAdminPassword(), status);

        return userDetails;

    }
}
