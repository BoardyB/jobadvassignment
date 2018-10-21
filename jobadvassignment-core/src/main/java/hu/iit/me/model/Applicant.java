package hu.iit.me.model;

import java.util.Date;

public class Applicant {

    private String id;
    private String foreName;
    private String surName;
    private Date birthDate;
    private String phoneNumber;
    private String taxId;
    private Gender gender;
    private String address;

    public Applicant() {
    }

    public Applicant(String id, String foreName, String surName, Date birthDate, String phoneNumber, String taxId, Gender gender, String address) {
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

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
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
