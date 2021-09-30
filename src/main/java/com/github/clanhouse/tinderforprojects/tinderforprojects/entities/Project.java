package com.github.clanhouse.tinderforprojects.tinderforprojects.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "projects")
public class Project extends StampedModel{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String projectName;

    private String description;

    private String qualifications;

    private String benefits;

    @JsonIgnore
    @OneToOne
    private TableToMatch tableToMatch;

    @ManyToOne(fetch = FetchType.LAZY)
   // @JoinColumn(name = "company_id", nullable = false)
    @JsonIgnore
    private Company company;


    public Project() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TableToMatch getTableToMatch() {
        return tableToMatch;
    }

    public void setTableToMatch(TableToMatch tableToMatch) {
        this.tableToMatch = tableToMatch;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getQualifications() {
        return qualifications;
    }

    public void setQualifications(String qualifications) {
        this.qualifications = qualifications;
    }

    public String getBenefits() {
        return benefits;
    }

    public void setBenefits(String benefits) {
        this.benefits = benefits;
    }
}
