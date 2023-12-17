package com.Info.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "peers")
@EqualsAndHashCode(callSuper = false)
public class Peer extends BaseEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "nickname", nullable = false)
    public String nickname;

    @Column(name = "birthday", nullable = false)
    public LocalDate birthday;
}
