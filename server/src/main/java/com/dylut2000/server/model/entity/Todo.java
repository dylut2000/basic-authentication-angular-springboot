package com.dylut2000.server.model.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "todos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private boolean done;

    @Column(nullable = false)
    private LocalDateTime createdAt;

   @Column(nullable = false)
    private LocalDateTime updatedAt;

   @ManyToOne
   @JoinColumn(name = "user_id")
   private User user;

   @PrePersist
    protected void onCreate() {
       LocalDateTime now = LocalDateTime.now();
        createdAt = now;
        updatedAt = now;
        done = false;
    }

    @PreUpdate
    protected void onUpdate() {
       updatedAt = LocalDateTime.now();
    }

}
