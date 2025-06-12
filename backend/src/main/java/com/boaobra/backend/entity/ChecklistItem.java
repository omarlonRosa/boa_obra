package com.boaobra.backend.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "checklist_items")
public class ChecklistItem {

  @Id
  @GeneratedValue(strategy =  GenerationType.IDENTITY)
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "checklist_id", nullable = false)
  private Checklist checklist;

  @Column(columnDefinition = "TEXT", nullable = false)
  private String description;

  @Column(name = "norm_reference")
  private String normReference;

  @Column(name = "is_mandatory")
  private boolean isMandatory = true;

  @Column(name = "order_index")
  private Integer orderIndex = 0;

  @Column(name = "is_completed")
  private boolean isCompleted = false;

  @Column(name = "is_conforming")
  private boolean isConforming = true;

  @Column(columnDefinition = "TEXT")
  private String observations;

  @Column(columnDefinition = "photo_required")
  private boolean photoRequired = false;  

  @Column(name = "photo_url")
  private String photoUrl;

  @Column(name = "signature_required")
  private boolean signatureRequired = false;

  @Column(name = "signature_url")
  private String signatureUrl;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "verified_by")
  private User verifiedBy;

  @Column(name = "verified_at")
  private LocalDateTime verifiedAt;

  @Column(name = "created_at", nullable = false, updatable = false)
  private LocalDateTime createdAt;

  @Column(name = "update_at", nullable = false)
  private LocalDateTime updateAt;


  @PrePersist
  protected void onCreate() {
    createdAt = LocalDateTime.now();
    updateAt = LocalDateTime.now();
  }

  @PreUpdate
  protected void onUpdate() {
    updateAt = LocalDateTime.now();
  }

  

  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }

  public Checklist getChecklist(){
    return checklist;
  }
  public void setChecklist(Checklist checklist) {
    this.checklist = checklist;
  }

  public String getDescription(){
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }


  public String getNormReference() {
        return normReference;
    }

    public void setNormReference(String normReference) {
        this.normReference = normReference;
    }

    public boolean isMandatory() {
        return isMandatory;
    }

    public void setMandatory(boolean mandatory) {
        isMandatory = mandatory;
    }

    public Integer getOrderIndex() {
        return orderIndex;
    }

    public void setOrderIndex(Integer orderIndex) {
        this.orderIndex = orderIndex;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public boolean isConforming() {
        return isConforming;
    }

    public void setConforming(boolean conforming) {
        isConforming = conforming;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    public boolean isPhotoRequired() {
        return photoRequired;
    }

    public void setPhotoRequired(boolean photoRequired) {
        this.photoRequired = photoRequired;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public boolean isSignatureRequired() {
        return signatureRequired;
    }

    public void setSignatureRequired(boolean signatureRequired) {
        this.signatureRequired = signatureRequired;
    }

    public String getSignatureUrl() {
        return signatureUrl;
    }

    public void setSignatureUrl(String signatureUrl) {
        this.signatureUrl = signatureUrl;
    }

    public User getVerifiedBy() {
        return verifiedBy;
    }

    public void setVerifiedBy(User verifiedBy) {
        this.verifiedBy = verifiedBy;
    }

    public LocalDateTime getVerifiedAt() {
        return verifiedAt;
    }

    public void setVerifiedAt(LocalDateTime verifiedAt) {
        this.verifiedAt = verifiedAt;
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
