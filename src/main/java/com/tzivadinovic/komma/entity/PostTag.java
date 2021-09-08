package com.tzivadinovic.komma.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.*;
import java.util.*;
import javax.persistence.*;
import lombok.*;

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