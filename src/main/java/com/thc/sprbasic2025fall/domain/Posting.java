package com.thc.sprbasic2025fall.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
public class Posting {
    @GeneratedValue(strategy = GenerationType.IDENTITY) // id를 알아서 차곡차곡 채워줌
    @Id
    Long id;

    @Setter String title;
    @Setter String content;
}
