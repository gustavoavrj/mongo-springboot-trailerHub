package com.bezkoder.spring.jwt.mongodb.models;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "videos")
public class Video {
  @Id
  private String id;

  @NotBlank
  @Size(max = 60)
  private String titulo;

  @NotBlank
  @Size(max = 100)
  private String description;

  @NotBlank
  @Size(max = 400)
  private String url;

  @NotBlank
  @Size(max = 2000)
  private String thumbnail;

  @NotBlank
  @Size(max = 20)
  private String level;

  @NotBlank
  @Size(max = 20)
  private String user;

  public Video() {
  }

  public Video(String id, String titulo, String description, String url, String thumbnail, String level, String user) {
    this.id = id;
    this.titulo = titulo;
    this.description = description;
    this.url = url;
    this.thumbnail = thumbnail;
    this.level = level;
    this.user = user;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

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


}
