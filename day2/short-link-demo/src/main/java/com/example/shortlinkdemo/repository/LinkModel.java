package com.example.shortlinkdemo.repository;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.*;
import java.io.Serializable;

@EnableAutoConfiguration
@Entity
@Table(name="TB_LINK_NEW")
//@Table(name="TB_LINK_NEW", schema = "shortenlinkapi")
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class LinkModel implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")	
	private String ID;
	@Column( length = 50 )
	private String shortLink;

	@Column( length = 100000 )
	private String realLink;
	
	public String getShortLink() {
		return shortLink;
	}

	public void setShortLink(String shortLink) {
		this.shortLink = shortLink;
	}

	public String getRealLink() {
		return realLink;
	}

	public void setRealLink(String realLink) {
		this.realLink = realLink;
	}

	public String getID() { return ID; }

	public void setID(String ID) { this.ID = ID; }


	
	
	
}
