package clinicapp.Web.Service;

import clinicapp.Web.entity.User;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public User getUser(String userLogin) {
        User user = new User();
        user.setUserLogin(userLogin);
        user.setUserPassord("test");
        return user;
    }
}
