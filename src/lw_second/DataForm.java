package lw_second;

import java.io.Serializable;

public class DataForm implements Serializable {
    private String name;
    private String phone;
    private String email;
    private String address;
    private String sex;
    private String occupation;



    public DataForm() {
        super();
    }

    public DataForm(String name, String phone, String email, String address, String sex, String occupation) {
        super();
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.sex = sex;
        this.occupation = occupation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    @Override
    public String toString() {
        return
                "name = " + name + '\n' +
                "phone = " + phone + '\n' +
                "email = " + email + '\n' +
                "address = " + address + '\n' +
                "sex = " + sex + '\n' +
                "occupation = " + occupation + "\n\n";
    }
}
