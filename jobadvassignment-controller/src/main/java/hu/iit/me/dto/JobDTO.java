package hu.iit.me.dto;

import hu.iit.me.exception.DTOConversionException;
import hu.iit.me.model.Job;
import hu.iit.me.model.JobType;

import java.time.LocalDate;

public class JobDTO {

    private String name;
    private String description;
    private String uploadDate;
    private String companyName;
    private String contact;
    private Integer wage;
    private String type;

    public JobDTO() {
    }

    public JobDTO(String name, String description, String uploadDate, String companyName, String contact, Integer wage, String type) {
        this.name = name;
        this.description = description;
        this.uploadDate = uploadDate;
        this.companyName = companyName;
        this.contact = contact;
        this.wage = wage;
        this.type = type;
    }

    public static JobDTO convertModelToDTO(Job job) {
        JobDTO jobDTO = new JobDTO();
        jobDTO.setName(job.getName());
        jobDTO.setDescription(job.getDescription());
        jobDTO.setUploadDate(job.getUploadDate().toString());
        jobDTO.setCompanyName(job.getCompanyName());
        jobDTO.setContact(job.getContact());
        jobDTO.setWage(job.getWage());
        jobDTO.setType(job.getType().toString());
        return jobDTO;
    }

    public Job toJob() {
        try {
            LocalDate uploadDate = LocalDate.now();
            JobType jobType = JobType.valueOf(type);
            return new Job(this.name, this.description, uploadDate, companyName, contact, wage, jobType);
        } catch (Exception e) {
            throw new DTOConversionException("Converting DTO to Job has failed, please provide valid property values", e);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(String uploadDate) {
        this.uploadDate = uploadDate;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Integer getWage() {
        return wage;
    }

    public void setWage(Integer wage) {
        this.wage = wage;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("JobDTO{");
        sb.append("name='").append(name).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append(", uploadDate='").append(uploadDate).append('\'');
        sb.append(", companyName='").append(companyName).append('\'');
        sb.append(", contact='").append(contact).append('\'');
        sb.append(", wage=").append(wage);
        sb.append(", type='").append(type).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
