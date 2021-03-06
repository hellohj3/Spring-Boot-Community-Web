package com.web.domain;

import com.web.domain.enums.SocialType;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    private String name;
    private String password;
    private String email;
    private String principal;

    @Enumerated(EnumType.STRING)
    private SocialType socialType;

    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;

    @Builder
    public User(Long idx, String name, String password, String email, String principal, SocialType socialType, LocalDateTime createdDate, LocalDateTime updatedDate) {
        this.idx = idx;
        this.name = name;
        this.password = password;
        this.email = email;
        this.principal = principal;
        this.socialType = socialType;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }
}
