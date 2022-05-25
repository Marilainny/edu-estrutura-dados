package edu.mms.estruturadados.model;

import java.util.Objects;

public class Contato {
	
	private String name;
	private String telefone;
	private String email;
	
	
	public Contato() {}
	
	
	public Contato(String name, String telefone, String email) {
		super();
		this.name = name;
		this.telefone = telefone;
		this.email = email;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}


	@Override
	public String toString() {
		return "Contato [name=" + name + ", telefone=" + telefone + ", email=" + email + "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(email, name, telefone);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contato other = (Contato) obj;
		return Objects.equals(email, other.email) && Objects.equals(name, other.name)
				&& Objects.equals(telefone, other.telefone);
	}


}
