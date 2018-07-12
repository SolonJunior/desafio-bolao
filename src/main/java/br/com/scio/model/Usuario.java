package br.com.scio.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**Classe para objetos do tipo Usuario.

 * @author Solon Junior

 * @version 1.00

 */
@Entity
public class Usuario {
	
	@Id
	@GeneratedValue
    private int id;
     
    private String name;
     
    private String password;
	
    private boolean admin;
    
    @OneToMany(mappedBy = "usuario")
	private List<Palpites> palpites;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public List<Palpites> getPalpites() {
		return palpites;
	}

	public void setPalpites(List<Palpites> palpites) {
		this.palpites = palpites;
	}
	
	

}
