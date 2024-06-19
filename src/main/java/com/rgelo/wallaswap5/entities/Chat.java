package com.rgelo.wallaswap5.entities;

import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table(name="Chat")
@ToString	
@EqualsAndHashCode
@NoArgsConstructor
public class Chat implements Serializable {/**
	 * 
	 */
	private static final long serialVersionUID = -6247898888099720745L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="Id_Chat")
	@Getter @Setter
	private Long Id;
	
	 @ManyToOne
	 @JoinColumn(name = "Usuario1_Id")
	 @Getter @Setter
	 private Usuario usuario1;
	 
	 @ManyToOne
	 @JoinColumn(name = "Usuario2_Id")
	 @Getter @Setter
	 private Usuario usuario2;

}
