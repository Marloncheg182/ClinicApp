package clinicapp.Web.entity;


public class User {
    private String userLogin;
    private String userPassord;

    public User(String userLogin, String userPassord) {
        this.userLogin = userLogin;
        this.userPassord = userPassord;
    }

    public User() {
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public String getUserPassord() {
        return userPassord;
    }

    public void setUserPassord(String userPassord) {
        this.userPassord = userPassord;
    }
}
