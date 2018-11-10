package br.com.alura.gaming.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

import br.com.alura.gaming.enums.TypeEnum;

@Embeddable
public class Point implements Serializable {
	
	private Long value;
	private TypeEnum type;
	
	private Point() {
	}

	public Point(TypeEnum type) {
		super();
		this.value = type.getPoint();
		this.type = type;
	}

	public Long getValue() {
		return value;
	}
}
