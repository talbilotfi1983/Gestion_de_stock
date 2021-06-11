package com.stock.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.springframework.format.annotation.DateTimeFormat;
@Entity
public class Vente {
	@Id@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Override
	public String toString() {
		return "Vente [id=" + id + ", code=" + code + ", dateVente=" + dateVente + ", ligneVentes=" + ligneVentes + "]";
	}
	private String code;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateVente;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Date getDateVente() {
		return dateVente;
	}

	public void setDateVente(Date dateVente) {
		this.dateVente = dateVente;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	@OneToMany(mappedBy = "vente",fetch = FetchType.EAGER)
	@Cascade(value = { CascadeType.REMOVE, CascadeType.SAVE_UPDATE })
	List<LigneVente> ligneVentes;

	public List<LigneVente> getLigneVentes() {
		return ligneVentes;
	}

	public void setLigneVentes(List<LigneVente> ligneVentes) {
		this.ligneVentes = ligneVentes;
	}


}
