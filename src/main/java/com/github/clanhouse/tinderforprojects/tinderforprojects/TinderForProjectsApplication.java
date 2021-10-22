package com.github.clanhouse.tinderforprojects.tinderforprojects;

import com.github.clanhouse.tinderforprojects.tinderforprojects.dto.CompanyDto;
import com.github.clanhouse.tinderforprojects.tinderforprojects.dto.DeveloperDto;
import com.github.clanhouse.tinderforprojects.tinderforprojects.dto.ProjectDto;
import com.github.clanhouse.tinderforprojects.tinderforprojects.entities.Company;
import com.github.clanhouse.tinderforprojects.tinderforprojects.entities.Developer;
import com.github.clanhouse.tinderforprojects.tinderforprojects.entities.Project;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.ArrayList;

@SpringBootApplication
@EnableJpaAuditing
public class TinderForProjectsApplication {


    public static void main(String[] args) {
        SpringApplication.run(TinderForProjectsApplication.class, args);
    }

    @Bean
    public ModelMapper getModelMapper(){
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.addMappings(new PropertyMap<Developer, DeveloperDto>() {
            @Override
            protected void configure() {
               map().setDevId(source.getId());
               map().setFirstName(source.getFirstName());
               map().setLastName(source.getLastName());
               map().setDescription(source.getDescription());
               map().setAchievements(source.getAchievements());
               map().setSkills(source.getSkills());
               map().setLikedProjects(new ArrayList<>());
            }
        });
        modelMapper.addMappings(new PropertyMap<Project, ProjectDto>() {
            @Override
            protected void configure() {
                map().setId(source.getId());
                map().setCompanyId(source.getCompany().getId());
                map().setProjectName(source.getProjectName());
                map().setDescription(source.getDescription());
                map().setQualifications(source.getQualifications());
                map().setBenefits(source.getBenefits());
            }
        });
        modelMapper.addMappings(new PropertyMap<Company, CompanyDto>() {
            @Override
            protected void configure() {
                map().setCompanyId(source.getId());
                map().setName(source.getCompanyName());
                map().setProjects(new ArrayList<>());
            }
        });
        return modelMapper;
    }

}
