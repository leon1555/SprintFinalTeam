package com.keyin.team3.model.mysql;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "history")
public class History {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="id")
  private long Id;

  @NotNull
  private Integer userId;

  @NotNull
  private String db;

  @NotNull
  private String searchQuery;

  @Column(nullable = false, updatable = false, insertable = false)
  @CreationTimestamp
  private Timestamp queryDateTime;
}
