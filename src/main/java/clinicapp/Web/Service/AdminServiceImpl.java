package clinicapp.Web.Service;


import clinicapp.Web.entity.Admin;

public class AdminServiceImpl implements AdminService{
    @Override
    public Admin getAdmin(String adminLogin) {
        Admin admin = new Admin();
        admin.setAdminLogin(adminLogin);
        admin.setAdminPassword("d033e22ae348aeb5660fc2140aec35850c4da997"); //SHA1 "admin"

        return admin;
    }
}
