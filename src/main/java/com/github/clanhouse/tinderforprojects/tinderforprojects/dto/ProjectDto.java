package com.github.clanhouse.tinderforprojects.tinderforprojects.dto;


import java.util.List;

public class ProjectDto {

    private Integer id;
    private Integer companyId;
    private String projectName;
    private String description;
    private String qualifications;
    private String benefits;
    private List<DeveloperDto> likedDevs;


    public ProjectDto(Integer id, Integer companyId, String projectName, String description, String qualifications, String benefits) {
        this.id = id;
        this.companyId = companyId;
        this.projectName = projectName;
        this.description = description;
        this.qualifications = qualifications;
        this.benefits = benefits;
    }

    public ProjectDto() {
    }

    public void setLikedDevs(List<DeveloperDto> likedDevs) {
        this.likedDevs = likedDevs;
    }

    public List<DeveloperDto> getLikedDevs() {
        return likedDevs;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
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
