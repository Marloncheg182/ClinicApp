package clinicapp.Web.Service;

import clinicapp.Web.entity.User;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public User getUser(String userLogin) {
        User user = new User();
        user.setUserLogin(userLogin);
        user.setUserPassword("dc76e9f0c0006e8f919e0c515c66dbba3982f785"); // SHA1  "root"
        return user;
    }
}
