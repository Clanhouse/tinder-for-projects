package com.tinderforprojects.tinder.api;

import com.tinderforprojects.tinder.model.benefit.BenefitService;
import com.tinderforprojects.tinder.model.benefit.dto.BenefitDTO;
import com.tinderforprojects.tinder.model.benefit.dto.BenefitMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/benefits")
public class BenefitController {
    
    private final BenefitService benefitService;
    private final BenefitMapper benefitMapper;

    @GetMapping
    public List<BenefitDTO> findAll() {
        return benefitMapper.toBenefitsDTOs(
                benefitService.findAll());
    }

    @GetMapping("/{id}")
    public BenefitDTO findById(@PathVariable Long id) {
        return benefitMapper.toBenefitsDTO(
                benefitService.findById(id));
    }

    @PostMapping
    public BenefitDTO create(@RequestBody @Valid String name) {
        return benefitMapper.toBenefitsDTO(
                benefitService.create(name));
    }

    @PutMapping("/{id}")
    public BenefitDTO update(@PathVariable Long id, @RequestBody @Valid String name) {
        return benefitMapper.toBenefitsDTO(
                benefitService.update(id, name));
    }
    
}
