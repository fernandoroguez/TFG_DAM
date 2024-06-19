package com.rgelo.wallaswap5.entities;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.*;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Entity
@Table(name="Usuario")
@EqualsAndHashCode
@NoArgsConstructor
public class Usuario implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2065783877220224356L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="Id_Usuario")
	@Getter @Setter
	private Long Id;
	
	@Column(name="NombreUsuario",nullable = false,unique = true)
	@Getter @Setter 
	private String nombreUsuario;
	
	@Column(name="Contrasenia", nullable = false)
	@Getter @Setter 
	private String Contrasenia;
	
	@Column(name="Nombre")
	@Getter @Setter
	private String Nombre;
	
	@Column(name="Apellidos")
	@Getter @Setter
	private String Apellidos;
	
	@Column(name="Locadidad")
	@Getter @Setter
	private String Localidad;
	
	@Column(name="Cod_postal")
	@Getter @Setter
	private int CodPostal;
	
	@Column(name="Info_Contacto")
	@Getter @Setter
	private String InfoContacto;
	
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
	@Getter @Setter
	private List<Anuncio> anuncios;
	

}
