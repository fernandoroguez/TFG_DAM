package com.rgelo.wallaswap5.entities;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="Anuncio")
@ToString	
@EqualsAndHashCode
@NoArgsConstructor
public class Anuncio implements Serializable {/**
	 * 
	 */
	private static final long serialVersionUID = -6231138966184644951L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="Id_Anuncio")
	@Getter @Setter
	private Long Id;
	
	@Column(name="Titulo")
	@Getter @Setter
	private String Titulo;
	
	@Column(name="Descripcion")
	@Getter @Setter
	private String Descripcion;
	
	@Column(name="Fotos")
	@Getter @Setter
	@ElementCollection
	private List<String> fotos;

	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Id_Usuario")
	@Getter @Setter
    private Usuario usuario;
	
}
