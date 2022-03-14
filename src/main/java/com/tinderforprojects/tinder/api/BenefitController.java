package com.tinderforprojects.tinder.api;

import com.tinderforprojects.tinder.model.benefit.BenefitService;
import com.tinderforprojects.tinder.model.benefit.dto.BenefitDto;
import com.tinderforprojects.tinder.model.benefit.dto.BenefitMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/benefits")
public class BenefitController {
    
    private final BenefitService benefitService;
    private final BenefitMapper benefitMapper;

    @GetMapping
    public List<BenefitDto> findAll() {
        return benefitMapper.toBenefitsDto(
                benefitService.findAll());
    }

    @GetMapping("/{id}")
    public BenefitDto findById(@PathVariable Long id) {
        return benefitMapper.toBenefitDto(
                benefitService.findById(id));
    }

    @PostMapping
    public BenefitDto create(@RequestBody String name) {
        return benefitMapper.toBenefitDto(
                benefitService.create(name));
    }

    @PutMapping("/{id}")
    public BenefitDto update(@PathVariable Long id, @RequestBody String name) {
        return benefitMapper.toBenefitDto(
                benefitService.update(id, name));
    }
    
}
