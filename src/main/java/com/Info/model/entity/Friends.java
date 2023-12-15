package com.Info.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@Table(name = "friends")
@EqualsAndHashCode(callSuper = false)
public class Friends extends BaseEntity<Long> {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "peer1", referencedColumnName = "id")
    private Peer peer1;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "peer2", referencedColumnName = "id")
    private Peer peer2;
}
