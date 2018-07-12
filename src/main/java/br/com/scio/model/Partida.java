package br.com.scio.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;


/**Classe para objetos do tipo Partida.

 * @author Solon Junior

 * @version 1.00

 */
@Entity
public class Partida implements Serializable{
	
	@Id
	@GeneratedValue
    private Long id;
     
    private String time1;
     
    private String time2;
	
	private Integer resultadoTime1;
	
	private Integer resultadoTime2;
	
	@OneToMany(mappedBy = "partida")
	private List<Palpites> palpites;
	
	@Transient
	private Integer palpiteTime1;
	
	@Transient
	private Integer palpiteTime2;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTime1() {
		return time1;
	}

	public void setTime1(String time1) {
		this.time1 = time1;
	}

	public String getTime2() {
		return time2;
	}

	public void setTime2(String time2) {
		this.time2 = time2;
	}

	public Integer getResultadoTime1() {
		return resultadoTime1;
	}

	public void setResultadoTime1(Integer resultadoTime1) {
		this.resultadoTime1 = resultadoTime1;
	}

	public Integer getResultadoTime2() {
		return resultadoTime2;
	}

	public void setResultadoTime2(Integer resultadoTime2) {
		this.resultadoTime2 = resultadoTime2;
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

	public List<Palpites> getPalpites() {
		return palpites;
	}

	public void setPalpites(List<Palpites> palpites) {
		this.palpites = palpites;
	}
	
	

}
