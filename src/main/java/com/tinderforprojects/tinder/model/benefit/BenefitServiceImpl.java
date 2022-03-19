package com.tinderforprojects.tinder.model.benefit;

import com.tinderforprojects.tinder.exception.ErrorMessage;
import com.tinderforprojects.tinder.exception.badRequest.BadRequestException;
import com.tinderforprojects.tinder.exception.notFound.NotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class BenefitServiceImpl implements BenefitService {

    private final BenefitRepository benefitRepository;

    @Override
    public List<Benefit> findAll() {
        log.info("Downloading all benfits");
        return benefitRepository.findAll();
    }

    @Override
    public Benefit findById(Long id) {
        log.info(String.format("Downloading benefit id: %d", id));
        return benefitRepository.findById(id)
                .orElseThrow(() -> {
            log.error(String.format("Benefit id: %d does not exists", id));
            return new NotFoundException(ErrorMessage.NOT_FOUND);
        });
    }

    @Override
    public Benefit create(String name) {
        log.info(String.format("Creating benefit: %s", name));
        validateName(name);
        return benefitRepository.save(
                Benefit.builder()
                        .name(name)
                        .build()
        );
    }

    @Override
    public Benefit update(Long id, String name) {
        log.info(String.format("Updating benefit: %s , id: %d", name, id));
        validateName(name);
        return benefitRepository.findById(id)
                .map(benefitFromDb -> {
                    benefitFromDb.setName(name);
                    return benefitRepository.save(benefitFromDb);
                }).orElseThrow(() -> {
                    log.error(String.format("Benefit id: %d does not exists", id));
                    return new NotFoundException(ErrorMessage.NOT_FOUND);
                });
    }

    private void validateName(String name) {
        if(name.length() < 3) {
            log.error(String.format("Invalid benefit name %s", name));
            throw new BadRequestException(ErrorMessage.BAD_REQUEST);
        }
    }
}
