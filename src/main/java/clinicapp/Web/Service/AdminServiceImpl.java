package clinicapp.Web.Service;


import clinicapp.Web.entity.Admin;

public class AdminServiceImpl implements AdminService{
    @Override
    public Admin getAdmin(String adminLogin) {
        Admin admin = new Admin();
        admin.setAdminLogin(adminLogin);
        admin.setAdminPassword("admin");

        return admin;
    }
}
