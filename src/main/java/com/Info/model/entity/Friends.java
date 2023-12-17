package com.Info.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@Table(name = "friends", uniqueConstraints = @UniqueConstraint(columnNames = {"peer1", "peer2"}))
@EqualsAndHashCode(callSuper = false)
public class Friends extends BaseEntity<Long> {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "peer1", referencedColumnName = "id")
    private Peer peer1;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "peer2", referencedColumnName = "id")
    private Peer peer2;
}
