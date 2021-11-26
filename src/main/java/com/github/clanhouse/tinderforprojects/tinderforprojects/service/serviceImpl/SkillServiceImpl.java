package com.github.clanhouse.tinderforprojects.tinderforprojects.service.serviceImpl;


import com.github.clanhouse.tinderforprojects.tinderforprojects.dto.mapper.SkillMapper;
import com.github.clanhouse.tinderforprojects.tinderforprojects.dto.model.skill.SkillDTO;
import com.github.clanhouse.tinderforprojects.tinderforprojects.exception.ResourceNotFoundException;
import com.github.clanhouse.tinderforprojects.tinderforprojects.repository.SkillRepository;
import com.github.clanhouse.tinderforprojects.tinderforprojects.service.SkillService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SkillServiceImpl implements SkillService {

    private final SkillRepository skillRepository;
    private final SkillMapper skillMapper;

    @Override
    public List<SkillDTO> findAll() {
        return skillMapper.toSkillDTOs(skillRepository.findAll());
    }

    @Override
    public SkillDTO findById(Integer id) {
        if(isExistById(id)){
            return skillMapper.toSkillDTO(skillRepository.getById(id));
        }else {
            throw new ResourceNotFoundException("Skill not found");
        }
    }

    @Override
    public SkillDTO create(SkillDTO skillDTO) {
        skillDTO.setId(skillRepository.save(skillMapper.toSkill(skillDTO)).getId());
        return skillDTO;
    }

    @Override
    public boolean isExistById(Integer id) {
        return skillRepository.findById(id).isPresent();
    }
    
}
