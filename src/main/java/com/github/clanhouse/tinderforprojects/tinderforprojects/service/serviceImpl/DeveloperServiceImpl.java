package com.github.clanhouse.tinderforprojects.tinderforprojects.service.serviceImpl;

import com.github.clanhouse.tinderforprojects.tinderforprojects.dto.mapper.DeveloperMapper;
import com.github.clanhouse.tinderforprojects.tinderforprojects.dto.model.developer.DeveloperDTO;
import com.github.clanhouse.tinderforprojects.tinderforprojects.exception.ControllerError;
import com.github.clanhouse.tinderforprojects.tinderforprojects.exception.ControllerException;
import com.github.clanhouse.tinderforprojects.tinderforprojects.repository.DeveloperRepository;
import com.github.clanhouse.tinderforprojects.tinderforprojects.service.DeveloperService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DeveloperServiceImpl implements DeveloperService {

    private final DeveloperRepository developerRepository;
    private final DeveloperMapper developerMapper;

    @Override
    public List<DeveloperDTO> findAll() {
        List<DeveloperDTO> developers = developerMapper.toDeveloperDTOs(developerRepository.findAll());
        if(developers.isEmpty()) throw new ControllerException(ControllerError.EMPTY);
        return developers;
    }

    @Override
    public DeveloperDTO findById(Integer id) {
        return developerMapper.toDeveloperDTO(developerRepository.findById(id)
                .orElseThrow(() -> new ControllerException(ControllerError.NOT_FOUND)));
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
