package clinicapp.Web.Service;


import clinicapp.Web.entity.User;

public interface UserService {
    User getUser(String userLogin);
}
