package com.Info.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@Table(name = "recommendations")
@EqualsAndHashCode(callSuper = false)
public class Recommendation extends BaseEntity<Long> {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "peer", referencedColumnName = "id")
    private Peer peer;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "recommended_peer", referencedColumnName = "id")
    private Peer recommendedPeer;
}
