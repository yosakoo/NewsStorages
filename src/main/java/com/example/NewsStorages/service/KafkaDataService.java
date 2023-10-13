package com.example.NewsStorages.service;


import com.example.NewsStorages.model.News;

public interface KafkaDataService {

    void handle(News news);

}