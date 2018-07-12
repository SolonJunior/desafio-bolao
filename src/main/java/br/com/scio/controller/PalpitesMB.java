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

/**Classe de controle para Palpites.

 * @author Solon Junior

 * @version 1.00

 */
@Named
@ViewScoped
public class PalpitesMB implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	private PalpitesRepository palpitesRepository;
	
	@Inject
	private PartidaRepository partidaRepository;
	
	
	private List<Partida> partidas = new ArrayList<Partida>();

	
	private Palpites palpites = new Palpites();
	
	private Partida partida = new Partida();
	
	private Usuario usuario = new Usuario();
	
	/** Método para carregar lista de partidas */
	@PostConstruct
	public void init() {
		setPartidas(partidaRepository.findAll());
	}
	
	/** Método para persistir Palpites */
	public void salvar(){
		
		palpites.setDataInsercao(Calendar.getInstance());
		palpites.setUsuario(usuario);
		palpites.setPartida(partida);
		palpites.setPalpiteTime1(partida.getPalpiteTime1());
		palpites.setPalpiteTime2(partida.getPalpiteTime2());
		
		palpitesRepository.saveOrUpdate(palpites);
		
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Salvo Com Sucesso", ""));
		
	}

	public Palpites getPalpites() {
		return palpites;
	}

	public void setPalpites(Palpites palpites) {
		this.palpites = palpites;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Partida> getPartidas() {
		return partidas;
	}

	public void setPartidas(List<Partida> partidas) {
		this.partidas = partidas;
	}

	public Partida getPartida() {
		return partida;
	}

	public void setPartida(Partida partida) {
		this.partida = partida;
	}
	

}
