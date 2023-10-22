package studentsystem;

/**
 * @Auther cxg
 * @DAte 2023/10/19
 */
public class User {
    private String username;
    private String password;
    private String personid;
    private String phonenum;

    public User() {
    }

    public User(String username, String password, String personid, String phonenum) {
        this.username = username;
        this.password = password;
        this.personid = personid;
        this.phonenum = phonenum;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPersonid() {
        return personid;
    }

    public void setPersonid(String personid) {
        this.personid = personid;
    }

    public String getPhonenum() {
        return phonenum;
    }

    public void setPhonenum(String phonenum) {
        this.phonenum = phonenum;
    }


}
