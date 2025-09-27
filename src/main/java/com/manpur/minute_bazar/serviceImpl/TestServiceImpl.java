package com.manpur.minute_bazar.serviceImpl;

import com.manpur.minute_bazar.model.TestModel;
import com.manpur.minute_bazar.repository.TestRepository;
import com.manpur.minute_bazar.service.TestService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TestServiceImpl implements TestService {

    private final TestRepository testRepository;

    /**
     *
     */
    @Override
    public void saveTestData(String name) {

        testRepository.save(
                TestModel.builder()
                .name(name)
        .build());
    }
}
