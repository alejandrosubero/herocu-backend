package com.backenwebmail.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "EMAIL_LIST")
public class ListaDeCorreos implements Serializable {

	private static final long serialVersionUID = -2413863548750816544L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	private Integer id;
	
	@Column(name = "EMAIL")
	private String coreo;

	@Column(name = "EMAIL_CATEGORIES")
	private String categoriaCorreo;
	
	
	public ListaDeCorreos() {}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCoreo() {
		return coreo;
	}

	public void setCoreo(String coreo) {
		this.coreo = coreo;
	}

	public String getCategoriaCorreo() {
		return categoriaCorreo;
	}

	public void setCategoriaCorreo(String categoriaCorreo) {
		this.categoriaCorreo = categoriaCorreo;
	}

	@Override
	public String toString() {
		return "ListaDeCorreos [id=" + id + ", coreo=" + coreo + ", categoriaCorreo=" + categoriaCorreo + "]";
	}
	
	
}
