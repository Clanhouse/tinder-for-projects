package com.github.clanhouse.tinderforprojects.tinderforprojects.registration.token;

import com.github.clanhouse.tinderforprojects.tinderforprojects.applicationUser.ApplicationUser;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class ConfirmationToken {
    @SequenceGenerator(
            name = "confirmationToken",
            sequenceName = "confirmationToken",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY,
            generator = "confirmationToken")
    private Long id;
    @Column(nullable = false)
    private String token;
    @Column(nullable = false)
    private LocalDateTime createdAt;
    @Column(nullable = false)
    private LocalDateTime expiredAt;
    private LocalDateTime confirmedAt;

    @ManyToOne
    @JoinColumn(nullable = false,
            name = "Application User Id")
    private ApplicationUser applicationUser;

    public ConfirmationToken(String token, LocalDateTime createdAt, LocalDateTime expiredAt,
                             LocalDateTime confirmedAt, ApplicationUser applicationUser) {
        this.token = token;
        this.createdAt = createdAt;
        this.expiredAt = expiredAt;
        this.confirmedAt = confirmedAt;
        this.applicationUser = applicationUser;
    }
}
