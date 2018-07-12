package br.com.scio.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
import br.com.scio.repository.PartidaRepository;

/**Classe de controle para Partida.

 * @author Solon Junior

 * @version 1.00

 */
@Named
@ViewScoped
public class PartidaMB implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	private PartidaRepository partidaRepository;
	
	private List<Partida> partidas = new ArrayList<Partida>();
	private List<Palpites> palpitesVencedoresList = new ArrayList<Palpites>();
	
	private Partida partida = new Partida();
	
	/** Método para carregar lista de partidas */
	@PostConstruct
	public void init() {
		setPartidas(partidaRepository.findAll());
	}
	
	/** Método para persistir Partida */
	public void salvar(){
		
		partidaRepository.saveOrUpdate(partida);
		partidas.add(partida);
		partida = new Partida();
		
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Salvo Com Sucesso", ""));
		
	}
	
	/** Método para persistir resultado da Partida */
	public void salvarResultado(){
		
		partidaRepository.saveOrUpdate(partida);
		setPartidas(partidaRepository.findAll());
		
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Salvo Com Sucesso", ""));
		
	}
	
	/** Método para carregar usuários que acertaram o placar e 
	 ordena pela data de inserção, sendo o primero da lista o vencedor*/
	public void visualizarVencedores() {
		
		for (Palpites palpites : partida.getPalpites()) {
			if(partida.getResultadoTime1() == palpites.getPalpiteTime1() && partida.getResultadoTime2() == palpites.getPalpiteTime2()) {
				palpitesVencedoresList.add(palpites);
			}
		}
		
		Collections.sort( palpitesVencedoresList , new Comparator<Palpites>() {    
		     public int compare(Palpites p1, Palpites p2) {    
		         return p1.getDataInsercao().compareTo(p2.getDataInsercao());    
		        }    
		    }  
		);
		
	}

	public Partida getPartida() {
		return partida;
	}

	public void setPartida(Partida partida) {
		this.partida = partida;
	}

	public List<Partida> getPartidas() {
		return partidas;
	}

	public void setPartidas(List<Partida> partidas) {
		this.partidas = partidas;
	}

	public List<Palpites> getPalpitesVencedoresList() {
		return palpitesVencedoresList;
	}

	public void setPalpitesVencedoresList(List<Palpites> palpitesVencedoresList) {
		this.palpitesVencedoresList = palpitesVencedoresList;
	}




}
