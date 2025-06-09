package com.boaobra.backend.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;

import org.springframework.cglib.core.Local;

import jakarta.persistence.*;

enum ProjectStatus {
  PLANNING, IN_PROGRESS, PAUSED, COMPLETED, CANCELLED 
}

enum ProjectType {
  RESIDENCIAL, COMMERCIAL, INDUSTRIAL, INFRASTRUCTURE
}

@Entity
@Table(name = "projects")
public class Project {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String name;

  @Column(columnDefinition = "TEXT")
  private String description;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private ProjectStatus status = ProjectStatus.PLANNING;

  @Enumerated(EnumType.STRING)
  @Column(name = "project_type", nullable = false)
  private ProjectType projectType;

  @Column(name = "start_date")
  private LocalDate startDate;

  @Column(name = "end_date")
  private LocalDate endDate;

  @Column(name = "estimated_completion")
  private LocalDate estimatedCompletion;

  private String address;
  private String city;
  private String state;

  @Column(name = "zip_code")
  private String zipCode;

  private Double latitude;
  private Double longitude;

  @Column(name = "total_area")
  private Double totalArea;

  @Column(name = "built_area")
  private Double builtArea;

  private Integer floors;

  @Column(name = "license_number")
  private String licenseNumber;

  @Column(name = "art_number")
  private LocalDateTime artNumber;

  @Column(name = "created_at", nullable = false, updatable = false)
  private LocalDateTime createdAt;

  @Column(name = "updated_at", nullable = false)
  private LocalDateTime updatedAt;

  @OneToMany(mappedBy = "project", cascade = CascadeType.ALL, orphanRemoval = true)
  private Set<ProjectMembers> projectMembers = new HashSet<>();

  @OneToMany(mappedBy = "project", cascade = CascadeType.ALL, orphanRemoval = true)
  private Set<Checklist> checklists = new HashSet<>();


  @PrePersist
  protected void onCreate() {
    createdAt = LocalDateTime.now();
    updatedAt = LocalDateTime.now();
  }

  @PreUpdate
  protected void onUpdate(){
    updatedAt = LocalDateTime.now();
  }



  public void setId(){
    return id;
  }

  public void setId(Long id){
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public ProjectStatus getStatus(){
    return status;
  }

  public void setStatus(ProjectStatus status) {
    this.status = status;
  }

  public ProjectType getProjectType(){
    return projectType;
  }

  public void setProjectType(ProjectType projectType) {
    this.projectType = projectType;
  }

  public LocalDate getStartDate() {
    return startDate;
  }

  public void setStartDate(LocalDate startDate){
    this.startDate = startDate;
  }

  public LocalDate getEndDate() {
    return endDate;
  }

  public void setEndDate(LocalDate endDate){
    this.endDate = endDate;
  }

  public LocalDate getEstimatedCompletion() {
    return estimatedCompletion;
  }

  public void setEstimatedCompletion(LocalDate estimatedCompletion){
    this.estimatedCompletion = estimatedCompletion;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city){
    this.city = city;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public String getZipCode(){
    return zipCode;
  }

  public void setZipCode(String zipCode){
    this.zipCode = zipCode;
  }

  public Double getLatitude() {
    return latitude;
  }

  public void setLatitude(Double latitude){
    this.latitude = latitude;
  }

  public Double getLongitude() {
    return longitude;
  }

  public void setLongitude(Double longitude){
    this.longitude = longitude;
  }

  public Double getTotalArea() {
    return totalArea;
  }

  public void setTotalArea(Double totalArea) {
    this.totalArea = totalArea;
  }

  public Double getBuiltArea() {
    return builtArea;
  }

  public void setBuiltArea(Double builtArea) {
    this.builtArea = builtArea;
  }

  public Integer getFloors(){
    return floors;
  }

  public void setFloors(Integer floors) {
    this.floors = floors;
  }

  public String getLicenseNumber() {
    return licenseNumber;
  }

  public void setLicenseNumber(String licenseNumber) {
    this.licenseNumber = licenseNumber;
  }

  public String getArtNumber() {
    return artNumber;
  }

  public void setArtNumber(String artNumber){
    this.artNumber = artNumber;
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

  public void setUpdatedAt(LocalDateTime updatedAt) {
    this.updatedAt = updatedAt;
  }

  public Set<ProjectMember> getProjectMembers() {
    return projectMembers;
  }

  public void setProjectMembers(Set<ProjectMember> projectMembers){
    this.projectMembers = projectMembers;
  }

  public Set<Checklist> getChecklists() {
    return checklists;
  }

  public void setChecklists(Set<Checklist> checklists){
    this.checklists = checklists;
  }

  public Set<Material> getMaterials(){
    return materials;
  }

  public void setMaterials(Set<Material> materials){
    this.materials = materials;
  }

  
  
}
