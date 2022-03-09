package com.tinderforprojects.tinder.model.skill.dto;

import com.tinderforprojects.tinder.model.skill.Skill;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SkillMapperTest {

    @Autowired
    private SkillMapper skillMapper;

    @Test
    void shouldReturnMappedSkillToSkillDto() {
        //given
        Skill skill = Skill.builder()
                .id(1L)
                .name("Java")
                .build();
        //when
        SkillDto skillDto = skillMapper.toSkillDto(skill);
        //then
        assertNotNull(skillDto);
        assertEquals(skillDto.getId(), 1L);
        assertEquals(skillDto.getName(), "Java");
        assertInstanceOf(SkillDto.class, skillDto);
    }

    @Test
    void shouldReturnMappedSkillDtoToSkill() {
        //given
        SkillDto skillDto = SkillDto.builder()
                .id(1L)
                .name("Java")
                .build();
        //when
        Skill skill = skillMapper.toSkill(skillDto);
        //then
        assertNotNull(skill);
        assertEquals(skill.getId(), 1L);
        assertEquals(skill.getName(), "Java");
        assertInstanceOf(Skill.class, skill);

    }

    @Test
    void shouldReturnMappedListOfSkillsToListOfSkillsDto() {
        //given
        List<Skill> skills = Arrays.asList(
                Skill.builder()
                        .id(1L)
                        .name("Java")
                        .build(),
                Skill.builder()
                        .id(2L)
                        .name("html")
                        .build());
        //when
        List<SkillDto> skillsDto = skillMapper.toSkillsDto(skills);
        //then
        assertEquals(2, skills.size());
        assertEquals(1L, skills.get(0).getId());
        assertEquals("html", skills.get(1).getName());
        assertInstanceOf(Skill.class, skills.get(0));

    }

    @Test
    void shouldReturnMappedListOfSkillsDtoToListOfSkills() {
        //given
        List<SkillDto> skillsDto = Arrays.asList(
                SkillDto.builder()
                        .id(1L)
                        .name("Java")
                        .build(),
                SkillDto.builder()
                        .id(2L)
                        .name("html")
                        .build());
        //when
        List<Skill> skills = skillMapper.toSkills(skillsDto);
        //then
        assertEquals(2, skillsDto.size());
        assertEquals(1L, skillsDto.get(0).getId());
        assertEquals("html", skillsDto.get(1).getName());
        assertInstanceOf(SkillDto.class, skillsDto.get(0));

    }

}