package br.com.alura.gaming.enums;

public enum TypeEnum {

	STARTED_COURSE(1L), COMPLETED_COURSE(15L), CREATED_FORUM(5L), ANSWER_QUESTION(10L), SOLVED_FORUM(15L);

	private Long point;

	private TypeEnum(Long point) {
		this.point = point;
	}
	

	public Long getPoint() {
		return point;
	}

}
