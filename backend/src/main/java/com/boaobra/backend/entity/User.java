

package com.boaobra.backend.entity;

import java.time.LocalDateTime;
import java.util.HashSet;

import jakarta.persistence.*;

enum UserRole {
  ADMIN, ENGINEER, SUPERVISOR, WORKER
}

@Entity
@Table(name = "users")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(unique = true, nullable = false)
  private String email;

  @Column(name = "password_hash", nullable = false)
  private String passwordHash;

  @Column(nullable = false)
  private String name;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private UserRole role;

  @Column(name = "cra_number")
  private String creaNumber;

  private String phone;

  @Column(name = "is_active")
  private boolean isActive = true;

  @Column(name = "created_at", nullable = false, updatable = false)
  private LocalDateTime createdAt;

  @Column(name = "updated_at", nullable = false)
  private LocalDateTime updatedAt;

  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ProjectMember> projectMembers = new HashSet<>();

  @PrePersist
  protected void onCreate() {
    createdAt = LocalDateTime.now();
    updatedAt = LocalDateTime.now();
  }

  @PreUpdate
  protected void onUpdate() {
    updatedAt = LocalDateTime.now();
  }

  
  public Long getId() {
    return id;
  }

  public void setId(Long id){
    this.id = id;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email){
    this.email = email;
  }

  public String getPasswordHash() {
    return passwordHash;
  }

  public void setPasswordHash(String passwordHash){
    this.passwordHash = passwordHash;
  }

  public String getName() {
    return name;
  }

  public void setName(String name){
    this.name = name;
  }

  public UserRole getRole(){
    return role;
  }

  public void setRole(UserRole role){
    this.role = role;
  }

  public String getCreaNumber() {
    return creaNumber;
  }

  public void setCreaNumber(String creaNumber){
    this.creaNumber = creaNumber;
  }

  public String getPhone(){
    return phone;
  }

  public void setPhone(String phone){
    this.phone = phone;
  }

  public boolean isActive() {
    return isActive;
  }

  public void setActive(boolean active){
    isActive = active;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(LocalDateTime createdAt){
    this.createdAt = createdAt;
  }

  public LocalDateTime getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(LocalDateTime updatedAt){
    this.updatedAt = updatedAt;
  }

  public Set<ProjectMember> getProjectMembers() {
    return projectMembers;
  }

  public void setProjectMembers(Set<ProjectMember> projectMembers){
    this.projectMembers = projectMembers;
  }
  
}
