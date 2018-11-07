package hu.iit.me.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Job")
public class Job {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    @Column
    private String name;
    @Column
    private String description;
    @Column
    private Date uploadDate;
    @Column
    private String companyName;
    @Column
    private String contact;
    @Column
    private Integer wage;

    public Job() {
    }

    public Job(String id, String name, String description, Date uploadDate, String companyName, String contact, Integer wage) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.uploadDate = uploadDate;
        this.companyName = companyName;
        this.contact = contact;
        this.wage = wage;
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

    public Date getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Date uploadDate) {
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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Job{");
        sb.append("id=").append(id).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append(", uploadDate=").append(uploadDate);
        sb.append(", companyName='").append(companyName).append('\'');
        sb.append(", contact='").append(contact).append('\'');
        sb.append(", wage=").append(wage);
        sb.append('}');
        return sb.toString();
    }
}
