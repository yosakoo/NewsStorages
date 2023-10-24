package com.example.NewsStorages.service;

import com.example.NewsStorages.model.News;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.kafka.receiver.KafkaReceiver;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class KafkaDataReceiverImpl implements KafkaDataReceiver {

    private final KafkaReceiver<String, Object> receiver;

    private final KafkaDataService kafkaDataService;

    @PostConstruct
    private void init() {
        fetch();
    }

    @Override
    public void fetch() {
        Gson gson = new GsonBuilder()
                .create();
        receiver.receive()
                .subscribe(r -> {
                    News news = gson
                            .fromJson(r.value().toString(), News.class);
                    System.out.println(news.toString());
                    kafkaDataService.handle(news);
                    r.receiverOffset().acknowledge();
                });
    }

}