package br.com.scio.controller;


import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.scio.model.Usuario;
import br.com.scio.repository.UsuarioRepository;

/**Classe de controle para Login.

 * @author Solon Junior

 * @version 1.00

 */

@Named
@SessionScoped
public class LoginMB implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Inject
	private UsuarioRepository usuarioRepository;
	
	private Usuario usuario = new Usuario();
	
	/** Método para autenticação do Usuário */
	public String autenticar() {
		
		usuario = usuarioRepository.login(usuario.getName(), usuario.getPassword());
		
		if(usuario == null) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Usuário Não Encontrado", ""));
			return "login";
		}
		
		return "home";
	}
	
	public String logout() {
		
		return "login";
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
