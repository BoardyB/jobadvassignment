package hu.iit.me.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Applicant")
public class Applicant extends PersistableEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    @Column
    private String foreName;
    @Column
    private String surName;
    @Column
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate birthDate;
    @Column
    private String phoneNumber;
    @Column
    private String taxId;
    @Enumerated(EnumType.STRING)
    @Column
    private Gender gender;
    @Column
    private String address;

    public Applicant() {
    }

    public Applicant(String id, String foreName, String surName, LocalDate birthDate, String phoneNumber, String taxId, Gender gender, String address) {
        this.id = id;
        this.foreName = foreName;
        this.surName = surName;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
        this.taxId = taxId;
        this.gender = gender;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getForeName() {
        return foreName;
    }

    public void setForeName(String foreName) {
        this.foreName = foreName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getTaxId() {
        return taxId;
    }

    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Applicant{");
        sb.append("id=").append(id).append('\'');
        sb.append(", foreName='").append(foreName).append('\'');
        sb.append(", surName='").append(surName).append('\'');
        sb.append(", birthDate=").append(birthDate);
        sb.append(", phoneNumber='").append(phoneNumber).append('\'');
        sb.append(", taxId='").append(taxId).append('\'');
        sb.append(", gender=").append(gender);
        sb.append(", address='").append(address).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
