package hu.iit.me.dto;

import hu.iit.me.exception.DTOConversionException;
import hu.iit.me.model.Applicant;
import hu.iit.me.model.Gender;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ApplicantDTO {

    private String foreName;
    private String surName;
    private String birthDate;
    private String phoneNumber;
    private String taxId;
    private String gender;
    private String address;

    public ApplicantDTO() {
    }

    public ApplicantDTO(String foreName, String surName, String birthDate, String phoneNumber, String taxId, String gender, String address) {
        this.foreName = foreName;
        this.surName = surName;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
        this.taxId = taxId;
        this.gender = gender;
        this.address = address;
    }

    public static ApplicantDTO convertModelToDTO(Applicant applicant) {
        ApplicantDTO applicantDTO = new ApplicantDTO();
        String[] applicantName = applicant.getFullName().split("\\s+", 2);
        applicantDTO.setForeName(applicantName[0]);
        applicantDTO.setSurName(applicantName[1]);
        applicantDTO.setBirthDate(applicant.getBirthDate().toString());
        applicantDTO.setPhoneNumber(applicant.getPhoneNumber());
        applicantDTO.setTaxId(applicant.getTaxId());
        applicantDTO.setGender(applicant.getGender().toString());
        applicantDTO.setAddress(applicant.getAddress());
        return applicantDTO;
    }

    public Applicant toApplicant() {
        try {
            String fullName = this.foreName + " " + this.surName;
            Gender gender = Gender.valueOf(this.gender);
            LocalDate birthDate = LocalDate.parse(this.birthDate, DateTimeFormatter.ISO_LOCAL_DATE);
            return new Applicant(fullName, birthDate, phoneNumber, taxId, gender, address);
        } catch (Exception e) {
            throw new DTOConversionException("Converting DTO to Applicant has failed, please provide valid property values", e);
        }

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

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
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
        final StringBuilder sb = new StringBuilder("ApplicantDTO{");
        sb.append("foreName='").append(foreName).append('\'');
        sb.append(", surName='").append(surName).append('\'');
        sb.append(", birthDate=").append(birthDate);
        sb.append(", phoneNumber='").append(phoneNumber).append('\'');
        sb.append(", taxId='").append(taxId).append('\'');
        sb.append(", gender='").append(gender).append('\'');
        sb.append(", address='").append(address).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
