package io.vimero.intercorp.api.data;

/**
 * @author Rony Villanueva <rony@vimero.io>
 * @since 15/12/2019
 */

public class CustomerData {

    private String firstName;
    private String lastName;
    private Integer age;
    private String dateBirthday;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getDateBirthday() {
        return dateBirthday;
    }

    public void setDateBirthday(String dateBirthday) {
        this.dateBirthday = dateBirthday;
    }
}
