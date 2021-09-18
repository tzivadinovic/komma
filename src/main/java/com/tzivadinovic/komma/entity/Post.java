package com.tzivadinovic.komma.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@Table(name = "post")
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public class Post extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(name = "post_id")
    private Integer id;
    @JoinColumn(name = "user_fk", referencedColumnName = "user_id")
    @ManyToOne
    private User user;
    @JoinColumn(name = "category_fk", referencedColumnName = "category_id")
    @ManyToOne(cascade = CascadeType.ALL)
    private Category category;
    @Column(name = "title")
    private String title;
    @Column(name = "content")
    private String content;
    @Column(name = "excerpt")
    private String excerpt;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "post_tag", joinColumns = @JoinColumn(name = "post_fk"), inverseJoinColumns = @JoinColumn(name = "tag_fk"))
    private List<Tag> tags;


}