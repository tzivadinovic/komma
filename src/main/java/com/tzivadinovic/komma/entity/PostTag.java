package com.tzivadinovic.komma.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@Table(name = "post_tag")
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public class PostTag extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(name = "post_tag_id")
    private Integer id;
    @JoinColumn(name = "tag_fk", referencedColumnName = "tag_id")
    @ManyToOne
    private Tag tag;
    @JoinColumn(name = "post_fk", referencedColumnName = "post_id")
    @ManyToOne
    private Post post;

}