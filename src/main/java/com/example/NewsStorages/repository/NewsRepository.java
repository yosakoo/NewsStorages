package com.example.NewsStorages.repository;

import com.example.NewsStorages.model.News;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsRepository extends JpaRepository<News,Long> {

}
