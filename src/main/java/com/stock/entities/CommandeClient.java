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
public class CommandeClient implements Serializable {
	/**
	 * 
	 */

	private BigDecimal totalCommande;
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String code;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date date;
	@ManyToOne
	@JoinColumn(name = "idClient")
	private Client client;

	@OneToMany(mappedBy = "commandeClient", fetch = FetchType.EAGER)
	@Cascade(value = { CascadeType.REMOVE, CascadeType.SAVE_UPDATE })
	private List<LigneCommandeClient> ligneCommandeClients;
	
	
	public List<LigneCommandeClient> getLigneCommandeClients() {
		return ligneCommandeClients;
	}

	public void setLigneCommandeClients(List<LigneCommandeClient> ligneCommandeClients) {
		this.ligneCommandeClients = ligneCommandeClients;
	}

	

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "CommandeClient [id=" + id + ", code=" + code + ", date=" + date + ", client=" + client
				+ ", ligneCommandeClients=" + ligneCommandeClients + ", totalCommande=" + totalCommande + "]";
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

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public BigDecimal getTotalCommande() {
		totalCommande = BigDecimal.ZERO;
		if (!ligneCommandeClients.isEmpty()) {
			ligneCommandeClients.forEach(ligneCommandeClient -> {
				if (ligneCommandeClient.getPrixUnitaire() != null && ligneCommandeClient.getQuantite() != null) {
					BigDecimal totalLigne = ligneCommandeClient.getPrixUnitaire()
							.multiply(ligneCommandeClient.getQuantite());
					totalCommande = totalCommande.add(totalLigne);
				}
			});
		}
		return totalCommande;
	}

	public void setTotalCommande(BigDecimal totalcommande) {
	
		this.totalCommande = totalcommande;
	}

	@Transient
	public String getLigneCommandeJson() {
		if(!ligneCommandeClients.isEmpty()){
			try {
		
				ObjectMapper mapper = new ObjectMapper();
				
				return mapper.writeValueAsString(ligneCommandeClients);
				} catch (JsonGenerationException e) {
					e.printStackTrace();
				} catch (JsonProcessingException e) {
					e.printStackTrace();
				}catch (IOException e) {
					e.printStackTrace();
				}
		
			}
		return "";
		 
		}
		
	}
