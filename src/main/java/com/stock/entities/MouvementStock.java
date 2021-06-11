package com.stock.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;
@Entity
public class MouvementStock {
	 public static final int ENTREE = 1;
	 public static final int SORTIE = 2;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Override
	public String toString() {
		return "MouvementStock [id=" + id + ", dateMouvement=" + date + ", quantite=" + quantite + ", type="
				+ type + ", article=" + article + "]";
	}
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date date;
	public Long getId() {
		return id;
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
	public BigDecimal getQuantite() {
		return quantite;
	}
	public void setQuantite(BigDecimal quantite) {
		this.quantite = quantite;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public Article getArticle() {
		return article;
	}
	public void setArticle(Article article) {
		this.article = article;
	}
	private BigDecimal quantite;
	private int type;
	@ManyToOne
	@JoinColumn(name = "idArticle")
	private Article article;
	

}
