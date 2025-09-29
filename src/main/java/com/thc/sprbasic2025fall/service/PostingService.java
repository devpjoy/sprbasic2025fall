package com.thc.sprbasic2025fall.service;

import com.thc.sprbasic2025fall.domain.Posting;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service // 모든 business, 연산을 service에서 함.
public interface PostingService {
    // create
    Long create(Map<String, Object> param);
    void update(Map<String, Object> param);
    void delete(Long id);
    Posting detail(Long id);
    List<Posting> list();
}
