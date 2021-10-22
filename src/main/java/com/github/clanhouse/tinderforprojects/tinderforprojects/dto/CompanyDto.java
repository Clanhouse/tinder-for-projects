package com.github.clanhouse.tinderforprojects.tinderforprojects.dto;

import java.util.List;

public class CompanyDto {

    private Integer companyId;
    private String name;
    private List<ProjectDto> projects;

    public CompanyDto() {
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ProjectDto> getProjects() {
        return projects;
    }

    public void setProjects(List<ProjectDto> projects) {
        this.projects = projects;
    }
}
