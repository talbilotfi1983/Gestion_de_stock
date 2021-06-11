package com.stock.entities;

import java.io.IOException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Entity
public class CommandeFournisseur implements Serializable {
	/**
	 * 
	 */
	
	private BigDecimal totalCommande_;
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String code;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date date;
	@ManyToOne
	@JoinColumn(name = "idFournisseur")
	private Fournisseur fournisseur;

	@OneToMany(mappedBy = "commandeFournisseur", fetch = FetchType.EAGER)
	@Cascade(value = { CascadeType.REMOVE, CascadeType.SAVE_UPDATE })
	private List<LigneCommandeFournisseur> ligneCommandeFournisseurs;
	
	
	public List<LigneCommandeFournisseur> getLigneCommandeFournisseurs() {
		return ligneCommandeFournisseurs;
	}

	public void setLigneCommandeFournisseurs(List<LigneCommandeFournisseur> ligneCommandeFournisseurs) {
		this.ligneCommandeFournisseurs = ligneCommandeFournisseurs;
	}

	

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "CommandeFournisseur [id=" + id + ", code=" + code + ", date=" + date + ", fournisseur=" + fournisseur
				+ ", ligneCommandeFournisseurs=" + ligneCommandeFournisseurs + ", totalCommande=" + totalCommande_ + "]";
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Fournisseur getFournisseur() {
		return fournisseur;
	}

	public void setFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public BigDecimal getTotalCommande_() {
		totalCommande_ = BigDecimal.ZERO;
		if (!ligneCommandeFournisseurs.isEmpty()) {
			ligneCommandeFournisseurs.forEach(ligneCommandeFournisseur -> {
				if (ligneCommandeFournisseur.getPrixUnitaire() != null && ligneCommandeFournisseur.getQuantite() != null) {
					BigDecimal totalLigne = ligneCommandeFournisseur.getPrixUnitaire()
							.multiply(ligneCommandeFournisseur.getQuantite());
					totalCommande_ = totalCommande_.add(totalLigne);
				}
			});
		}
		return totalCommande_;
	}

	public void setTotalCommande_(BigDecimal totalcommande) {
	
		this.totalCommande_ = totalcommande;
	}


	public String getLigneCommandeJson_() {
		if(!ligneCommandeFournisseurs.isEmpty()){
			try {
		
				ObjectMapper mapper = new ObjectMapper();
				
				return mapper.writeValueAsString(ligneCommandeFournisseurs);
				} catch (JsonProcessingException e) {
					e.printStackTrace();
				}
		
			}
		return "";
		 
		}
		
	}
