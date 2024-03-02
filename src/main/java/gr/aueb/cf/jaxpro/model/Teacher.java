package gr.aueb.cf.jaxpro.model;

import gr.aueb.cf.jaxpro.dto.TeacherInsertDTO;
import gr.aueb.cf.jaxpro.dto.TeacherReadOnlyDTO;
import gr.aueb.cf.jaxpro.dto.TeacherUpdateDTO;

public class Teacher {

    private Long id;
    private String ssn;
    private String firstname;
    private String lastname;

    public Teacher() {

    }

    public Teacher(Long id, String ssn, String firstname, String lastname) {
        this.id = id;
        this.ssn = ssn;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public TeacherInsertDTO toInsertDTO() {
        return new TeacherInsertDTO(ssn, firstname, lastname);
    }

    public TeacherReadOnlyDTO toReadOnlyDTO() {
        return new TeacherReadOnlyDTO(id, ssn, firstname, lastname);
    }

    public TeacherUpdateDTO toUpdateDTO() {
        return new TeacherUpdateDTO(id, ssn, firstname, lastname);
    }

}
