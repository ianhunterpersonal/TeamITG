package com.totnesjava.teamitg.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode
@Table(name = "users")
public class UserEntity {

	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(
			name = "UUID", strategy = "org.hibernate.id.UUIDGenerator"
	)
	@EqualsAndHashCode.Exclude
	private String				id;

	private String				name;

	private String				email;

	private String				password;

	private String				loginToken;

}
