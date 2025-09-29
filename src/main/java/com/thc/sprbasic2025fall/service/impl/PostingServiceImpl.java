package com.thc.sprbasic2025fall.service.impl;

import com.thc.sprbasic2025fall.domain.Posting;
import com.thc.sprbasic2025fall.repository.PostingRepository;
import com.thc.sprbasic2025fall.service.PostingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class PostingServiceImpl implements PostingService {

    final PostingRepository postingRepository;

    @Override
    public Long create(Map<String, Object> param) {
        Posting posting = new Posting();
        posting.setTitle(param.get("title") + "");
        posting.setContent(param.get("content") + "");

        posting = postingRepository.save(posting);
        // postingRepository으로 repository한테 save를 부탁! (return type은 Entity)

        return posting.getId();
    }

    @Override
    public void update(Map<String, Object> param) {
        // update 하려면 일단 id 꼭 가져와야 함.
        Long id = Long.parseLong(param.get("id") + "");
        Posting posting = postingRepository.findById(id).orElseThrow(()-> new RuntimeException("no data"));
        // id가 null인 경우, null 처리를 위해 orElse(null)보다 orElseThrow()를 더 많이 사용.
        String title = (String) param.get("title");
        if(title != null){ posting.setTitle(title); }
        String content = (String) param.get("content");
        if(content != null){ posting.setContent(content); }
        postingRepository.save(posting);
    }

    @Override
    public void delete(Long id) {
        Posting posting = postingRepository.findById(id).orElseThrow(()-> new RuntimeException("no data"));
        postingRepository.delete(posting);
        // delete 메서드의 return type : void (원래는 entity 일 수도 있겠지만, delete로 entity가 지워졌으므로!)
    }

    @Override
    public Posting detail(Long id) {
        //Posting posting = postingRepository.findById(id).orElseThrow(()-> new RuntimeException("no data"));
        return postingRepository.findById(id).orElseThrow(()-> new RuntimeException("no data"));
    }

    @Override
    public List<Posting> list() {
        return postingRepository.findAll();
    }
    // 존재하는 모든 메서드를 구현해야 함.
}
