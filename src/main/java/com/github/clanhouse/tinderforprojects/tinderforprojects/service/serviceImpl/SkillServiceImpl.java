package com.github.clanhouse.tinderforprojects.tinderforprojects.service.serviceImpl;


import com.github.clanhouse.tinderforprojects.tinderforprojects.dto.mapper.SkillMapper;
import com.github.clanhouse.tinderforprojects.tinderforprojects.dto.model.skill.SkillDTO;
import com.github.clanhouse.tinderforprojects.tinderforprojects.exception.ControllerError;
import com.github.clanhouse.tinderforprojects.tinderforprojects.exception.ControllerException;
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
        List<SkillDTO> skills = skillMapper.toSkillDTOs(skillRepository.findAll());
        if(skills.isEmpty()) throw new ControllerException(ControllerError.EMPTY);
        return skills;
    }

    @Override
    public SkillDTO findById(Integer id) {
        return skillMapper.toSkillDTO(skillRepository.findById(id)
                .orElseThrow(() -> new ControllerException(ControllerError.NOT_FOUND)));
    }

    @Override
    public SkillDTO create(SkillDTO skillDTO) {
        if(isExistByName(skillDTO.getName())) throw new ControllerException(ControllerError.EXISTS);
        return skillMapper.toSkillDTO(skillRepository.save(skillMapper.toSkill(skillDTO)));
    }

    private boolean isExistByName(String name) {
        return skillRepository.findByName(name).isPresent();
    }

}
