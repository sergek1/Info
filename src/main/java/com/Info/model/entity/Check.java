package com.Info.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "checks")
@EqualsAndHashCode(callSuper = false)
public class Check extends BaseEntity<Long>  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "peer", referencedColumnName = "id")
    private Peer peer;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "task", referencedColumnName = "id")
    private Task task;

    @Column(name = "date", nullable = false)
    private LocalDate date;
}
