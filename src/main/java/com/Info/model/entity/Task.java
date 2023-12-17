package com.Info.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "tasks")
@Data
@EqualsAndHashCode(callSuper = false)
public class Task extends BaseEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @ManyToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "parent_task", referencedColumnName = "id")
    private Task parentTask;

    @Column(name = "max_xp")
    private Integer maxXp;

}
