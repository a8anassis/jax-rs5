package gr.aueb.cf.jaxpro.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class TeacherInsertDTO {

    @Size(min = 6, max = 6, message = "SSN contains exactly six characters")
    private String ssn;

    @NotBlank(message = "Please fill the 'username'")
    private String firstname;

    @NotBlank(message = "Please fill the 'lastname'")
    private String lastname;


    public  TeacherInsertDTO() {

    }

    public TeacherInsertDTO(String ssn, String firstname, String lastname) {
        this.ssn = ssn;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
