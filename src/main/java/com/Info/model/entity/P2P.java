package com.Info.model.entity;

import com.fasterxml.jackson.databind.ser.Serializers;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "p2p")
@EqualsAndHashCode(callSuper = false)
public class P2P extends BaseEntity<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "check_id", referencedColumnName = "id")
    private Check check;

    @OneToOne
    @JoinColumn(name = "checking_peer", referencedColumnName = "id")
    private Peer checkingPeer;

    @Column(name = "state")
    private String state;

    @Column(name = "time")
    private LocalDate time;
}
