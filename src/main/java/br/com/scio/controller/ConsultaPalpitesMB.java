package br.com.scio.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.scio.model.Palpites;
import br.com.scio.model.Partida;
import br.com.scio.model.Usuario;
import br.com.scio.repository.PalpitesRepository;
import br.com.scio.repository.PartidaRepository;
import br.com.scio.repository.UsuarioRepository;

/**Classe de controle para Consulta de Palpites.

 * @author Solon Junior

 * @version 1.00

 */
@Named
@ViewScoped
public class ConsultaPalpitesMB implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private UsuarioRepository usuarioRepository;
	
	private List<Usuario> usuarioList = new ArrayList<Usuario>();
	
	private Usuario usuario = new Usuario();
	
	/** Método para carregar lista de usuarios, exceto usuários admin que não podem salvar palpites */
	@PostConstruct
	public void init() {
		setUsuarioList(usuarioRepository.findUserNotAdmin());
	}

	public List<Usuario> getUsuarioList() {
		return usuarioList;
	}

	public void setUsuarioList(List<Usuario> usuarioList) {
		this.usuarioList = usuarioList;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	

}
