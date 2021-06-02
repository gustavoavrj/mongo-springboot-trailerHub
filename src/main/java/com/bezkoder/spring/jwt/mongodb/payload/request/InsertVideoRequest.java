package com.bezkoder.spring.jwt.mongodb.payload.request;

import java.util.Set;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.*;
 
public class InsertVideoRequest {
    @Id
    private String id;

    @NotBlank
    @Size(min = 3, max = 50)
    private String titulo;
 
    @NotBlank
    @Size(max = 100)
    private String description;
        
    @NotBlank
    @Size(max = 400)
    private String url;

    @NotBlank
    @Size(max = 4000)
    private String thumbnail;


    @NotBlank
    @Size(max = 20)
    private String level;


    @NotBlank
    @Size(max = 20)
    private String user;
  
    public String getTitulo() {
        return titulo;
      }
    
      public void setTitulo(String titulo) {
        this.titulo = titulo;
      }
    
      public String getDescription() {
        return description;
      }
    
      public void setDescription(String description) {
        this.description = description;
      }
    
      public String getUrl() {
        return url;
      }
    
      public void setUrl(String url) {
        this.url = url;
      }
    
      public String getThumbnail() {
        return thumbnail;
      }
    
      public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
      }
      public String getLevel() {
        return level;
      }
    
      public void setLevel(String level) {
        this.level = level;
      }
      public String getUser() {
        return user;
      }
    
      public void setUser(String user) {
        this.user = user;
      }

      public String getId() {
        return id;
      }
    
      public void setId(String id) {
        this.id = id;
      }
    
    
}
