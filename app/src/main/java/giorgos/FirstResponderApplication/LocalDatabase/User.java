package giorgos.FirstResponderApplication.LocalDatabase;


public class User
{

    private int id;
    private String FirstName;
    private String LastName;
    private String email;
    private String password;
    private String birthday;




    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {return FirstName;}
    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getLastName() {return LastName;}
    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public String getBirthday() {
        return birthday;
    }
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }


}
