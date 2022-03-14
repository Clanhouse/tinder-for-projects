package com.tinderforprojects.tinder.model.skill;

import com.tinderforprojects.tinder.exception.ErrorMessage;
import com.tinderforprojects.tinder.exception.notFound.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SkillServiceImpl implements SkillService {

    private final SkillRepository skillRepository;

    @Override
    public List<Skill> findAll() {
        return skillRepository.findAll();
    }

    @Override
    public Skill findById(Long id) {
        return skillRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(ErrorMessage.NOT_FOUND));
    }

    @Override
    public Skill create(String name) {
        return skillRepository.save(Skill.builder()
                .name(name)
                .build());
    }

    @Override
    public Skill update(Long id, String name) {
        return skillRepository.findById(id)
                .map(skillFromDb -> {
                    skillFromDb.setName(name);
                    return skillRepository.save(skillFromDb);
                }).orElseThrow(() -> new NotFoundException(ErrorMessage.NOT_FOUND));
    }
}
