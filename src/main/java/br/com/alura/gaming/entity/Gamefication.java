package br.com.alura.gaming.entity;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
public class Gamefication implements Serializable {
	
	private static final long serialVersionUID = 9041599595288660601L;
	
	@Id
	@Column(columnDefinition = "BINARY(16)")
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	private UUID id;
	
	@Type(type="uuid-char")
	private UUID user;
	
	@Embedded
	private Point point; 
	
	public Gamefication() {
	}

	public Gamefication(UUID user, Point point) {
		this.user = user;
		this.point = point;
	}

	public Long getPoint() {
		return point.getValue();
	}
	
}
