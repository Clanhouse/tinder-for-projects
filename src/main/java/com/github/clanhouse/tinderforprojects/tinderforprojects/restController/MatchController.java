package com.github.clanhouse.tinderforprojects.tinderforprojects.restController;

import com.github.clanhouse.tinderforprojects.tinderforprojects.dto.ProjectDevDto;
import com.github.clanhouse.tinderforprojects.tinderforprojects.entities.Developer;
import com.github.clanhouse.tinderforprojects.tinderforprojects.entities.Project;
import com.github.clanhouse.tinderforprojects.tinderforprojects.entities.TableToMatch;
import com.github.clanhouse.tinderforprojects.tinderforprojects.repository.CompanyRepository;
import com.github.clanhouse.tinderforprojects.tinderforprojects.repository.DeveloperRepository;
import com.github.clanhouse.tinderforprojects.tinderforprojects.repository.ProjectRepository;
import com.github.clanhouse.tinderforprojects.tinderforprojects.repository.TableToMatchRepository;
import com.github.clanhouse.tinderforprojects.tinderforprojects.service.TableToMatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping
public class MatchController {
    private DeveloperRepository developerRepository;

    private ProjectRepository projectRepository;

    private TableToMatchRepository tableToMatchRepository;

    private CompanyRepository companyRepository;


    private TableToMatchService tableToMatchService;

    @Autowired
    public MatchController(DeveloperRepository developerRepository, ProjectRepository projectRepository, TableToMatchRepository tableToMatchRepository, CompanyRepository companyRepository, TableToMatchService tableToMatchService) {
        this.developerRepository = developerRepository;
        this.projectRepository = projectRepository;
        this.tableToMatchRepository = tableToMatchRepository;
        this.companyRepository = companyRepository;
        this.tableToMatchService = tableToMatchService;
    }

    @PostMapping("/addDev")
    public void addDev(@RequestBody Developer developer) {
        developerRepository.save(developer);
    }


    @PostMapping("/addProject")
    public void addProject(@RequestBody Project project) {

        projectRepository.save(project);
    }


    @PostMapping("/addLikeForProject")
    public ResponseEntity addDevToMatch(@RequestBody ProjectDevDto projectDevDto) {
        tableToMatchService.match(projectDevDto);
        return new  ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping("/getMatchById/{idMatch}")
    public TableToMatch getMatchById(@PathVariable Integer idMatch){
        return tableToMatchRepository.getById(idMatch);
    }
}

