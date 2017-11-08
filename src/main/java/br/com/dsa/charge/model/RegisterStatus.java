package br.com.dsa.charge.model;

public enum RegisterStatus {

	PENDING("Pending"), RECEIVED("Received");

	private String description;

	private RegisterStatus(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

}
