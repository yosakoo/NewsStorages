package com.example.NewsStorages.service;

import com.example.NewsStorages.model.News;

import com.example.NewsStorages.repository.NewsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class KafkaDataServiceImpl implements KafkaDataService {

    @Autowired
    private final NewsRepository newsRepository;

    @Override
    public void handle(News news) {
        log.info("Data object {} was saved", news.toString());
        newsRepository.save(news);
    }

}