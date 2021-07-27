package com.github.clanhouse.tinderforprojects.tinderforprojects.entities;

import javax.persistence.*;

@Entity
@Table(name = "teble_to_matches")
public class TableToMatch extends StampedModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Developer developer;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Project project;

    boolean isMatch;

    public TableToMatch() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Developer getDeveloper() {
        return developer;
    }

    public void setDeveloper(Developer developer) {
        this.developer = developer;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public boolean isMatch() {
        return isMatch;
    }

    public void setMatch(boolean match) {
        isMatch = match;
    }
}
