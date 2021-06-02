package com.bezkoder.spring.jwt.mongodb.repository;

import java.util.Optional;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.bezkoder.spring.jwt.mongodb.models.Video;

public interface VideoRepository extends MongoRepository<Video, String> {
  List<Video> findByLevelContaining(String level);
  List<Video> findByUserContaining(String user);
  List<Video> findByIdContaining(String id);


}
