package com.tzivadinovic.komma.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.*;
import java.util.*;
import javax.persistence.*;
import lombok.*;

@Data
@Entity
@NoArgsConstructor
@Table(name = "category")
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public class Category extends Auditable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	@Column(name = "category_id")
	private Integer id;
	@Column(name = "name")
	private String name;
	
}