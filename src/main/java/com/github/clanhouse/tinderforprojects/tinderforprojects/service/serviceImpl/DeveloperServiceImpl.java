package com.github.clanhouse.tinderforprojects.tinderforprojects.service.serviceImpl;

import com.github.clanhouse.tinderforprojects.tinderforprojects.dto.mapper.DeveloperMapper;
import com.github.clanhouse.tinderforprojects.tinderforprojects.dto.model.developer.DeveloperDTO;
import com.github.clanhouse.tinderforprojects.tinderforprojects.dto.model.likedProject.ProjectToLikedProjectDTO;
import com.github.clanhouse.tinderforprojects.tinderforprojects.exception.ResourceNotFoundException;
import com.github.clanhouse.tinderforprojects.tinderforprojects.repository.DeveloperRepository;
import com.github.clanhouse.tinderforprojects.tinderforprojects.repository.TableToMatchRepository;
import com.github.clanhouse.tinderforprojects.tinderforprojects.service.DeveloperService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DeveloperServiceImpl implements DeveloperService {

    private final DeveloperRepository developerRepository;
    private final TableToMatchRepository tableToMatchRepository;
    private final DeveloperMapper developerMapper;

    @Override
    public DeveloperDTO create(DeveloperDTO developerDTO) {
        developerDTO.setId(developerRepository.save(developerMapper.toDeveloper(developerDTO)).getId());
        return developerDTO;
    }


    @Override
    public DeveloperDTO findById(Integer id) {
        if(developerRepository.findById(id).isPresent()){
            DeveloperDTO developerDTO = developerMapper.toDeveloperDTO(developerRepository.getById(id));
            List<ProjectToLikedProjectDTO> likedProjectDTOs = developerMapper.toProjectDTOs(tableToMatchRepository.getAllLikedProjectsByDevId(id));
            developerDTO.setLikedProjects(likedProjectDTOs);
            return developerDTO;
        }else{
            throw new ResourceNotFoundException("Developer not found");
        }
    }

    @Override
    public DeveloperDTO findRandom() {
        return developerMapper.toDeveloperDTO(developerRepository.getFirstRandomDeveloper());
    }

    @Override
    public List<DeveloperDTO> findAll() {
        List<DeveloperDTO> developerDTOS = developerMapper.toDeveloperDTOs(developerRepository.findAll());
        for(DeveloperDTO developerDTO : developerDTOS){
            developerDTO.setLikedProjects(developerMapper.toProjectDTOs(tableToMatchRepository.getAllLikedProjectsByDevId(developerDTO.getId())));
        }
        return developerDTOS;
    }

    public boolean isExistById(Integer id){
        return developerRepository.findById(id).isPresent();
    }



}
