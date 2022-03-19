package com.tinderforprojects.tinder.model.benefit;

import com.tinderforprojects.tinder.exception.ErrorMessage;
import com.tinderforprojects.tinder.exception.badRequest.BadRequestException;
import com.tinderforprojects.tinder.exception.notFound.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BenefitServiceImpl implements BenefitService {

    private final BenefitRepository benefitRepository;

    @Override
    public List<Benefit> findAll() {
        return benefitRepository.findAll();
    }

    @Override
    public Benefit findById(Long id) {
        return benefitRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(ErrorMessage.NOT_FOUND));
    }

    @Override
    public Benefit create(String name) {
        validateName(name);
        return benefitRepository.save(
                Benefit.builder()
                        .name(name)
                        .build()
        );
    }

    @Override
    public Benefit update(Long id, String name) {
        validateName(name);
        return benefitRepository.findById(id)
                .map(benefitFromDb -> {
                    benefitFromDb.setName(name);
                    return benefitRepository.save(benefitFromDb);
                }).orElseThrow(() -> new NotFoundException(ErrorMessage.NOT_FOUND));
    }

    private void validateName(String name) {
        if(name.length() < 3) throw new BadRequestException(ErrorMessage.BAD_REQUEST);
    }
}
