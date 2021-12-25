package fr.eql.projet01.entity;

import java.io.Serializable;
import java.util.Arrays;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
public class Support implements Serializable {
	private static final long serialVersionUID = 1L;
	public static final String NAME = "support";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String typeSupport;
	private String chemin;
	@Lob // save files to db
	private byte[] image;

	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="idPublicationSupport")
	private Publication publicationSupport;
	

	//	@JsonIgnore
	//@ManyToOne(fetch = FetchType.LAZY)
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="idAnnonceSupport")
	private Annonce annonceSupport;
}