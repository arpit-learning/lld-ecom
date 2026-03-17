package dev.arpit.ecom.models;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseModel {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  @LastModifiedDate
  @Column(nullable = false)
  private LocalDateTime updatedAt;
  @CreatedDate
  @Column(nullable = false)
  private LocalDateTime createdAt;
  @LastModifiedBy
  private String updatedBy;
  @CreatedBy
  private String createdBy;
}
