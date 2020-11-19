package br.edu.ifpr.entities;

import java.util.Date;
import java.util.UUID;

public class Task {
  private String id;
  private String title;
  private String description;
  private Date createdAt;
  private TaskStatus status;
  
  public Task() {
    this.id = UUID.randomUUID().toString();
    this.createdAt = new Date();
    this.status = TaskStatus.NOT_STARTED;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Date getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }

  public TaskStatus getStatus() {
    return status;
  }

  public void setStatus(TaskStatus status) {
    this.status = status;
  }
}