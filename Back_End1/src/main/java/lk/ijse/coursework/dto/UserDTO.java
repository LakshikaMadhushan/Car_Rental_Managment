package lk.ijse.coursework.dto;

public class UserDTO {

   private String user_id;
   private String name;
   private String address;
   private String email;
   private String password;
   private int contact_no;
   private String driving_licen_01;
   private String driving_licen_02;
   private String registrate_date;

    public UserDTO() {
    }

    public UserDTO(String user_id, String name, String address, String email, String password, int contact_no, String driving_licen_01, String driving_licen_02, String registrate_date) {
        this.user_id = user_id;
        this.name = name;
        this.address = address;
        this.email = email;
        this.password = password;
        this.contact_no = contact_no;
        this.driving_licen_01 = driving_licen_01;
        this.driving_licen_02 = driving_licen_02;
        this.registrate_date = registrate_date;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public int getContact_no() {
        return contact_no;
    }

    public void setContact_no(int contact_no) {
        this.contact_no = contact_no;
    }

    public String getDriving_licen_01() {
        return driving_licen_01;
    }

    public void setDriving_licen_01(String driving_licen_01) {
        this.driving_licen_01 = driving_licen_01;
    }

    public String getDriving_licen_02() {
        return driving_licen_02;
    }

    public void setDriving_licen_02(String driving_licen_02) {
        this.driving_licen_02 = driving_licen_02;
    }

    public String getRegistrate_date() {
        return registrate_date;
    }

    public void setRegistrate_date(String registrate_date) {
        this.registrate_date = registrate_date;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "user_id='" + user_id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", contact_no=" + contact_no +
                ", driving_licen_01='" + driving_licen_01 + '\'' +
                ", driving_licen_02='" + driving_licen_02 + '\'' +
                ", registrate_date='" + registrate_date + '\'' +
                '}';
    }
}
