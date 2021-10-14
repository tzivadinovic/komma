package com.tzivadinovic.komma.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@Entity
@NoArgsConstructor
@Table(name = "media")
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public class Media extends Auditable {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "media_id")
    private Integer id;
    @Column(name = "uri")
    private String uri;
}
