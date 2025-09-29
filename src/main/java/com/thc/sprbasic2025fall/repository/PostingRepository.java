package com.thc.sprbasic2025fall.repository;

import com.thc.sprbasic2025fall.domain.Posting;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// JpaRepository를 상속했기 때문에 모든 기능을 사용할 수 있다.
public interface PostingRepository extends JpaRepository<Posting, Long> {
    /*
    Posting findByTitle(String title); // title이 unique한 경우에 사용 필수!
    List<Posting> findByContent(String title); // title이 unique 하지 않고, 겹치는 title이 있어도 List가 알아서 해결해줌.
     */
}
