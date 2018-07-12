package br.com.scio.model;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**Classe para objetos do tipo Palpites.

 * @author Solon Junior

 * @version 1.00

 */

@Entity
public class Palpites{
	
	@Id
	@GeneratedValue
    private Integer id;
	
	private Integer palpiteTime1;
	
	private Integer palpiteTime2;
	
	@ManyToOne
	@JoinColumn(name = "idusuario")
	private Usuario usuario;
		
	@ManyToOne
	@JoinColumn(name = "idpartida")
	private Partida partida;
	
	@Temporal(TemporalType.TIMESTAMP)
    private Calendar dataInsercao;
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPalpiteTime1() {
		return palpiteTime1;
	}

	public void setPalpiteTime1(Integer palpiteTime1) {
		this.palpiteTime1 = palpiteTime1;
	}

	public Integer getPalpiteTime2() {
		return palpiteTime2;
	}

	public void setPalpiteTime2(Integer palpiteTime2) {
		this.palpiteTime2 = palpiteTime2;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Partida getPartida() {
		return partida;
	}

	public void setPartida(Partida partida) {
		this.partida = partida;
	}

	public Calendar getDataInsercao() {
		return dataInsercao;
	}

	public void setDataInsercao(Calendar dataInsercao) {
		this.dataInsercao = Calendar.getInstance();
	}
	
	

}
