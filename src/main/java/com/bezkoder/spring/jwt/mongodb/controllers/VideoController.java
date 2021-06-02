package com.bezkoder.spring.jwt.mongodb.controllers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Criteria ;
import java.util.ArrayList;
import com.bezkoder.spring.jwt.mongodb.models.Video;
import com.bezkoder.spring.jwt.mongodb.payload.request.LoginRequest;
import com.bezkoder.spring.jwt.mongodb.payload.request.InsertVideoRequest;

import com.bezkoder.spring.jwt.mongodb.payload.response.MessageResponse;
import com.bezkoder.spring.jwt.mongodb.repository.VideoRepository;
import com.bezkoder.spring.jwt.mongodb.security.services.UserDetailsImpl;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/video")
public class VideoController {
	
	@Autowired
	VideoRepository videoRepository;

	@PostMapping("/insert")
	public ResponseEntity<?> insetVideo(@Valid @RequestBody InsertVideoRequest insertVideoRequest) {
		Video video = new Video(insertVideoRequest.getId(),
                             insertVideoRequest.getTitulo(), 
							               insertVideoRequest.getDescription(),
                             insertVideoRequest.getUrl(),
                             insertVideoRequest.getThumbnail(),
                             insertVideoRequest.getLevel(),
                             insertVideoRequest.getUser());


		videoRepository.save(video);

		return ResponseEntity.ok(new MessageResponse("Inserted"));
	}

    @PostMapping("/public")
	public ResponseEntity<List<Video>> getAllTutorials(@RequestBody(required = true) InsertVideoRequest insertVideoRequest) {
        try {
          List<Video> videos = new ArrayList<Video>();
      
          
            videoRepository.findByLevelContaining(insertVideoRequest.getLevel()).forEach(videos::add);
      
          if (videos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
          }
      
          return new ResponseEntity<>(videos, HttpStatus.OK);
        } catch (Exception e) {
          return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
      }

      @PostMapping("/private")
	public ResponseEntity<List<Video>> getMyvideos(@RequestBody(required = true) InsertVideoRequest insertVideoRequest) {
        try {
          List<Video> videos = new ArrayList<Video>();
      
          
            videoRepository.findByUserContaining(insertVideoRequest.getUser()).forEach(videos::add);
      
          if (videos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
          }
      
          return new ResponseEntity<>(videos, HttpStatus.OK);
        } catch (Exception e) {
          return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
      }

      @PostMapping("/show")
	public ResponseEntity<List<Video>> showall(@RequestBody(required = true) InsertVideoRequest insertVideoRequest) {
        try {
          List<Video> videos = new ArrayList<Video>();
      
          
            videoRepository.findAll().forEach(videos::add);
      
          if (videos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
          }
      
          return new ResponseEntity<>(videos, HttpStatus.OK);
        } catch (Exception e) {
          return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
      }
      
}
