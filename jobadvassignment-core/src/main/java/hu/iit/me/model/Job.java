package hu.iit.me.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Job")
public class Job extends PersistableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String name;
    private String description;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate uploadDate;
    private String companyName;
    private String contact;
    private Integer wage;
    @Enumerated(EnumType.STRING)
    private JobType type;

    public Job() {
    }

    public Job(String name, String description, LocalDate uploadDate, String companyName, String contact, Integer wage, JobType type) {
        this.name = name;
        this.description = description;
        this.uploadDate = uploadDate;
        this.companyName = companyName;
        this.contact = contact;
        this.wage = wage;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public LocalDate getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(LocalDate uploadDate) {
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

    public JobType getType() {
        return type;
    }

    public void setType(JobType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Job{");
        sb.append("id='").append(id).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append(", uploadDate=").append(uploadDate);
        sb.append(", companyName='").append(companyName).append('\'');
        sb.append(", contact='").append(contact).append('\'');
        sb.append(", wage=").append(wage);
        sb.append(", type=").append(type);
        sb.append('}');
        return sb.toString();
    }
}
