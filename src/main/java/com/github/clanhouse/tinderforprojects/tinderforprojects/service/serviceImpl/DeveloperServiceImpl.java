package com.github.clanhouse.tinderforprojects.tinderforprojects.service.serviceImpl;

import com.github.clanhouse.tinderforprojects.tinderforprojects.dto.mapper.DeveloperMapper;
import com.github.clanhouse.tinderforprojects.tinderforprojects.dto.model.developer.DeveloperDTO;
import com.github.clanhouse.tinderforprojects.tinderforprojects.dto.model.likedProject.ProjectToLikedProjectDTO;
import com.github.clanhouse.tinderforprojects.tinderforprojects.exception.ControllerError;
import com.github.clanhouse.tinderforprojects.tinderforprojects.exception.ControllerException;
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
    private final DeveloperMapper developerMapper;
    private final TableToMatchRepository tableToMatchRepository;

    @Override
    public List<DeveloperDTO> findAll() {
        List<DeveloperDTO> developers = developerMapper.toDeveloperDTOs(developerRepository.findAll());
        if(developers.isEmpty()) throw new ControllerException(ControllerError.EMPTY);
        for(DeveloperDTO developerDTO : developers){
            developerDTO.setLikedProjects(developerMapper.toProjectDTOs(tableToMatchRepository.getAllLikedProjectsByDevId(developerDTO.getId())));
        }
        return developers;
    }

    @Override
    public DeveloperDTO findById(Integer id) {
        if(developerRepository.findById(id).isPresent()){
            DeveloperDTO developerDTO = developerMapper.toDeveloperDTO(developerRepository.getById(id));
            List<ProjectToLikedProjectDTO> likedProjectDTOs = developerMapper.toProjectDTOs(tableToMatchRepository.getAllLikedProjectsByDevId(id));
            developerDTO.setLikedProjects(likedProjectDTOs);
            return developerDTO;
        }else{
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
    public DeveloperDTO update(DeveloperDTO developerDTO) {
        DeveloperDTO developer = developerMapper.toDeveloperDTO(developerRepository.findById(developerDTO.getId())
                .orElseThrow(() -> new ControllerException(ControllerError.NOT_FOUND)));
        return developerMapper.toDeveloperDTO(developerRepository.save(developerMapper.toDeveloper(developer)));
    }


}
