package br.com.dsa.charge.model;

public enum RegistryStatus {

	PENDING("Pending"), RECEIVED("Received");

	private String description;

	private RegistryStatus(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

}
