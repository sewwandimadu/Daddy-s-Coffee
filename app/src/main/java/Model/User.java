package Model;

public class User {

    String uId;
    String uName;
    String pwd;

    public User(String uId, String uName, String pwd) {
        this.uId = uId;
        this.uName = uName;
        this.pwd = pwd;
    }

    public User() {
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
