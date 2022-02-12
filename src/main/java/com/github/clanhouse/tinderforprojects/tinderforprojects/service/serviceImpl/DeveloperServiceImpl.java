package com.github.clanhouse.tinderforprojects.tinderforprojects.service.serviceImpl;

import com.github.clanhouse.tinderforprojects.tinderforprojects.dto.mapper.AchievementMapper;
import com.github.clanhouse.tinderforprojects.tinderforprojects.dto.mapper.DeveloperMapper;

import com.github.clanhouse.tinderforprojects.tinderforprojects.dto.mapper.SkillMapper;
import com.github.clanhouse.tinderforprojects.tinderforprojects.dto.model.achievement.AchievementDTO;

import com.github.clanhouse.tinderforprojects.tinderforprojects.dto.mapper.PhotoMapper;

import com.github.clanhouse.tinderforprojects.tinderforprojects.dto.model.developer.DeveloperDTO;
import com.github.clanhouse.tinderforprojects.tinderforprojects.dto.model.likedProject.ProjectToLikedProjectDTO;
import com.github.clanhouse.tinderforprojects.tinderforprojects.dto.model.skill.SkillDTO;
import com.github.clanhouse.tinderforprojects.tinderforprojects.exception.ControllerError;
import com.github.clanhouse.tinderforprojects.tinderforprojects.exception.ControllerException;
import com.github.clanhouse.tinderforprojects.tinderforprojects.repository.DeveloperRepository;
import com.github.clanhouse.tinderforprojects.tinderforprojects.repository.PhotoRepository;
import com.github.clanhouse.tinderforprojects.tinderforprojects.repository.TableToMatchRepository;
import com.github.clanhouse.tinderforprojects.tinderforprojects.service.DeveloperService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DeveloperServiceImpl implements DeveloperService {

    private final DeveloperRepository developerRepository;
    private final DeveloperMapper developerMapper;
    private final TableToMatchRepository tableToMatchRepository;

    private final AchievementMapper achievementMapper;
    private final SkillMapper skillMapper;

    private final PhotoRepository photoRepository;
    private final PhotoMapper photoMapper;


    @Override
    public List<DeveloperDTO> findAll() {
        List<DeveloperDTO> developers = developerMapper.toDeveloperDTOs(developerRepository.findAll());
        if (developers.isEmpty()) throw new ControllerException(ControllerError.EMPTY);
        for (DeveloperDTO developerDTO : developers) {
            developerDTO.setLikedProjects(developerMapper.toProjectDTOs(tableToMatchRepository.getAllLikedProjectsByDevId(developerDTO.getId())));
        }
        return developers;
    }


    @Override
    public DeveloperDTO findById(Integer id) {
        if (developerRepository.findById(id).isPresent()) {
            DeveloperDTO developerDTO = developerMapper.toDeveloperDTO(developerRepository.getById(id));
            List<ProjectToLikedProjectDTO> likedProjectDTOs = developerMapper.toProjectDTOs(tableToMatchRepository.getAllLikedProjectsByDevId(id));
            developerDTO.setLikedProjects(likedProjectDTOs);
            developerDTO.setPhotos(photoMapper.toPhotoDTOs(photoRepository.findByDeveloperId(id)));
            return developerDTO;
        } else {
            throw new ControllerException(ControllerError.NOT_FOUND);
        }
    }

    @Override
    public DeveloperDTO findRandom() {
        return developerMapper.toDeveloperDTO(developerRepository.getFirstRandomDeveloper());
    }

    @Override
    public DeveloperDTO create(DeveloperDTO developerDTO) {
        return developerMapper.toDeveloperDTO(developerRepository.save(developerMapper.toDeveloper(developerDTO)));
    }

    @Override
    public DeveloperDTO updatePersonalInformation(Integer id, DeveloperDTO developerDTO) {
        return developerMapper.toDeveloperDTO(developerRepository.findById(id)
                .map(developerFromDb -> {
                    developerFromDb.setFirstName(developerDTO.getFirstName());
                    developerFromDb.setLastName(developerDTO.getLastName());
                    developerFromDb.setDescription(developerDTO.getDescription());
                    developerFromDb.setProfession(developerDTO.getProfession());
                    return developerRepository.save(developerFromDb);
                }).orElseThrow(() -> new ControllerException(ControllerError.NOT_FOUND)));
    }

    @Override
    public DeveloperDTO updateAchievements(Integer id, List<AchievementDTO> achievementDTOs) {
        return developerMapper.toDeveloperDTO(developerRepository.findById(id)
        .map(developerFromDb -> {
            developerFromDb.setAchievements(achievementMapper.toAchievements(achievementDTOs));
            return developerRepository.save(developerFromDb);
        }).orElseThrow(() -> new ControllerException(ControllerError.NOT_FOUND)));
    }

    @Override
    public DeveloperDTO updateSkills(Integer id, List<SkillDTO> skillDTOs) {
        return developerMapper.toDeveloperDTO(developerRepository.findById(id)
                .map(developerFromDb -> {
                    developerFromDb.setSkills(skillMapper.toSkills(skillDTOs));
                    return developerRepository.save(developerFromDb);
                }).orElseThrow(() -> new ControllerException(ControllerError.NOT_FOUND)));
    }


}
