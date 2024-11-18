package model;

import jakarta.annotation.Priority;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    private String description;
    private LocalDateTime creationDate;
    private LocalDateTime deadline;

    @Enumerated(EnumType.STRING)
    private TaskStatus status;

    @Enumerated(EnumType.STRING)
    private Priority priority;

    public Task() {
        this.creationDate = LocalDateTime.now();
        this.status = TaskStatus.TODO;
    }
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}

