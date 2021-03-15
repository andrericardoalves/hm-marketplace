package com.alvesinc.hmuser.entities.enuns;

public enum Role {

	ADMIN(1, "ROLE_ADMIN"),
	CLIENT(2, "ROLE_CLIENT"),
	SELLER(1, "ROLE_SELLER");
	
	private int id;
	private String description;
	
	private Role(int id, String description ) {
		this.id  = id;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
}
