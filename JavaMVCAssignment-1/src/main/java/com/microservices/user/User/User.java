package com.microservices.user.User;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="micro_user")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
	@Id
	private String userId;
	private String name;
	private String email;
	@Column(name="ABOUT",length = 100)
	private String about;
	@Transient
	private List<Rating> ratings;
	

}
