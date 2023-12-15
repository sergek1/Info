package com.Info.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "tasks")
@Data
@EqualsAndHashCode(callSuper = false)
public class Task extends BaseEntity<String> {

    @Id
    @Column(name = "title")
    private String title;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "parent_task", referencedColumnName = "title")
//@NotNull
//@Column(name = "parenttask", nullable = false)
    private Task parentTask;

    @Column(name = "max_xp")
    private Integer maxXp;

    @Override
    public String getId() {
        return title;
    }
}
