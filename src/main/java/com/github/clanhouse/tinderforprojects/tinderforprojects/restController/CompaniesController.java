package com.github.clanhouse.tinderforprojects.tinderforprojects.restController;

import com.github.clanhouse.tinderforprojects.tinderforprojects.entities.Company;
import com.github.clanhouse.tinderforprojects.tinderforprojects.repository.CompanyRepository;
import com.github.clanhouse.tinderforprojects.tinderforprojects.service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;


@RestController
public class CompaniesController {

    private AuthenticationManager authenticationManager;

    private JwtUtil jwtUtil;

    private MyUserDetailsService userDetailsService;

    private CompanyService companyService;

    private CompanyRepository companyRepository;

    @Autowired
    public CompaniesController(AuthenticationManager authenticationManager, JwtUtil jwtUtil, MyUserDetailsService userDetailsService, CompanyService companyService, CompanyRepository companyRepository) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
        this.userDetailsService = userDetailsService;
        this.companyService = companyService;
        this.companyRepository = companyRepository;
    }

    @GetMapping("/company/{id}")
    public Company getCompanyById(@PathVariable String id){
        return companyService.getCompanyById(Integer.valueOf(id));
    }

    @PostMapping("/addCompany")
    public Company addCompany(@Valid @RequestBody Company company) {
       return companyRepository.save(company);
    }

    @GetMapping("/getCompanyById/{idCompany}")
    public Optional<Company> getCompanyById(@PathVariable Integer idCompany){
        return companyRepository.findById(idCompany);
    }

    @RequestMapping(value = "/auth", method = RequestMethod.POST)
    public ResponseEntity<?> createToken (@RequestBody AuthenticationRequest authenticationRequest) throws Exception{

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        final String jwt = jwtUtil.generateToken(userDetails);
        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }
}
