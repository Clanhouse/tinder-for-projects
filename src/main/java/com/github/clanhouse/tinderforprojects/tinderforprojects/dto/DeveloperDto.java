package com.github.clanhouse.tinderforprojects.tinderforprojects.dto;

import com.github.clanhouse.tinderforprojects.tinderforprojects.entities.Project;
import com.github.clanhouse.tinderforprojects.tinderforprojects.entities.Skill;

import java.util.List;

public class DeveloperDto {

    private Integer devId;
    private String firstName;
    private String lastName;
    private String description;
    private String achievements;
    private List<Skill> skills;
    private List<ProjectDto> likedProjects;

    public DeveloperDto(Integer devId, String firstName, String lastName, String description, String achievements, List<Skill> skills, List<ProjectDto> likedProjects) {
        this.devId = devId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.description = description;
        this.achievements = achievements;
        this.skills = skills;
        this.likedProjects = likedProjects;
    }

    public DeveloperDto() {
    }

    public Integer getDevId() {
        return devId;
    }

    public void setDevId(Integer devId) {
        this.devId = devId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAchievements() {
        return achievements;
    }

    public void setAchievements(String achievements) {
        this.achievements = achievements;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    public List<ProjectDto> getLikedProjects() {
        return likedProjects;
    }

    public void setLikedProjects(List<ProjectDto> likedProjects) {
        this.likedProjects = likedProjects;
    }
}
