package com.github.clanhouse.tinderforprojects.tinderforprojects.service;

import com.github.clanhouse.tinderforprojects.tinderforprojects.dto.model.achievement.AchievementDTO;
import com.github.clanhouse.tinderforprojects.tinderforprojects.dto.model.benefit.BenefitDTO;
import com.github.clanhouse.tinderforprojects.tinderforprojects.dto.model.project.ProjectDTO;
import com.github.clanhouse.tinderforprojects.tinderforprojects.dto.model.skill.SkillDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProjectService {

    ProjectDTO create(Integer companyId, ProjectDTO projectDTO);

    ProjectDTO findById(Integer id);

    List<ProjectDTO> findAll();

    ProjectDTO updateBasicInformation(Integer id, ProjectDTO projectDTO);

    ProjectDTO updateSkills(Integer id, List<SkillDTO> skillDTOs);

    ProjectDTO updateBenefits(Integer id, List<BenefitDTO> benefitDTOs);


}
