

package com.boaobra.backend.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "material_tests")
public class MaterialTest {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "material_id", nullable = false)
  private Material material;

  @Column(name = "test_type", nullable = false)
  private String testType;

  @Column(name = "test_date", nullable = false)
  private LocalDate testeDate;

  @Column(name = "result_value")
  private Double resultValue;

  @Column(name = "result_unit")
  private String resultUnit;

  @Column(name = "expected_value")
  private Double expectedValue;

  @Column(name = "is_approved")
  private Boolean isApproved;

  @Column(name = "tested_by")
  private String testedBy;

  private String laboratory;

  @Column(name = "report_url")
  private String reportUrl;

  @Column(columnDefinition = "TEXT")
  private String observations;

  @Column(name = "created_at", nullable = false, updatable = false)
  private LocalDateTime createdAt;

  @Column(name = "update_at", nullable = false)
  private LocalDateTime updateAt;

  @PrePersist
  protected void onCreate(){
    createdAt = LocalDateTime.now();
    updateAt = LocalDateTime.now();
  }


public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public String getTestType() {
        return testType;
    }

    public void setTestType(String testType) {
        this.testType = testType;
    }

    public LocalDate getTestDate() {
        return testDate;
    }

    public void setTestDate(LocalDate testDate) {
        this.testDate = testDate;
    }

    public Double getResultValue() {
        return resultValue;
    }

    public void setResultValue(Double resultValue) {
        this.resultValue = resultValue;
    }

    public String getResultUnit() {
        return resultUnit;
    }

    public void setResultUnit(String resultUnit) {
        this.resultUnit = resultUnit;
    }

    public Double getExpectedValue() {
        return expectedValue;
    }

    public void setExpectedValue(Double expectedValue) {
        this.expectedValue = expectedValue;
    }

    public Boolean getApproved() {
        return isApproved;
    }

    public void setApproved(Boolean approved) {
        isApproved = approved;
    }

    public String getTestedBy() {
        return testedBy;
    }

    public void setTestedBy(String testedBy) {
        this.testedBy = testedBy;
    }

    public String getLaboratory() {
        return laboratory;
    }

    public void setLaboratory(String laboratory) {
        this.laboratory = laboratory;
    }

    public String getReportUrl() {
        return reportUrl;
    }

    public void setReportUrl(String reportUrl) {
        this.reportUrl = reportUrl;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }


  
}
