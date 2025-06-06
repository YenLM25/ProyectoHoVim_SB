package ac.cr.ucr.hoVim.model;

public class User {

    private int userId;
    private String name;
    private String email;
    private String telephone;
    private String userType;

    public User() {
    }

    public User(int userId, String name, String email, String telephone, String userType) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.telephone = telephone;
        this.userType = userType;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
}




