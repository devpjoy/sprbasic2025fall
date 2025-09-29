package com.thc.sprbasic2025fall.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity // jpa를 활용하기 위한 짝 어노테이션 (테이블과 1:1 매칭)
// Jpa에서는 반드시 PK(primary key) 필요
public class Writing {
    @GeneratedValue(strategy = GenerationType.IDENTITY) // id 값 알아서 할당해줌
    @Id Long id; // PK 값 선언
    String title;
    String content;
}
