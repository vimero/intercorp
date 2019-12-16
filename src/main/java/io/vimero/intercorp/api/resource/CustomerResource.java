package io.vimero.intercorp.api.resource;

/**
 * @author Rony Villanueva <rony@vimero.io>
 * @since 15/12/2019
 */

public class CustomerResource {

    private String id;
    private String firstName;
    private String lastName;
    private Integer age;
    private String dateBirthday;
    private String dateDeath;
    private String dateCreated;
    private String dateUpdated;

    public CustomerResource(String id,String firstName, String lastName, Integer age, String dateBirthday,
                            String dateDeath, String dateCreated, String dateUpdated) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.dateBirthday = dateBirthday;
        this.dateDeath = dateDeath;
        this.dateCreated = dateCreated;
        this.dateUpdated = dateUpdated;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public String getDateDeath() {
        return dateDeath;
    }

    public void setDateDeath(String dateDeath) {
        this.dateDeath = dateDeath;
    }

    public String getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(String dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }
}
