package com.pos.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@SequenceGenerator(name = "users-gen", sequenceName = "USERS_SEQ", initialValue = 200, allocationSize = 1)
@Table(name = "USERS")
public class Users {

	@Column(name = "USERS_ID")
	private Long users_id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "CREATED")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date CREATED;

	@Column(name = "CREATEDBY")
	private Long createdby;

	@Column(name = "UPDATED")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date UPDATED;

	@Column(name = "UPDATEDBY")
	private Long updatedby;

	@Column(name = "USERDATE")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date USERDATE;

	@Column(name = "PASSWORD")
	private String password;

	@Column(name = "ISACTIVE")
	private String isactive;

	@Column(name = "USERNAME")
	private String username;

	public Users() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users-gen")
	public Long getUsers_id() {
		return users_id;
	}

	public void setUsers_id(Long uSERS_ID) {
		users_id = uSERS_ID;
	}

	public String getName() {
		return name;
	}

	public void setName(String nAME) {
		name = nAME;
	}

	public Date getCREATED() {
		return CREATED;
	}

	public void setCREATED(Date cREATED) {
		CREATED = cREATED;
	}

	public Long getCreatedby() {
		return createdby;
	}

	public void setCreatedby(Long cREATEDBY) {
		createdby = cREATEDBY;
	}

	public Date getUPDATED() {
		return UPDATED;
	}

	public void setUPDATED(Date uPDATED) {
		UPDATED = uPDATED;
	}

	public Long getUpdatedby() {
		return updatedby;
	}

	public void setUpdatedby(Long uPDATEDBY) {
		updatedby = uPDATEDBY;
	}

	public Date getUSERDATE() {
		return USERDATE;
	}

	public void setUSERDATE(Date uSERDATE) {
		USERDATE = uSERDATE;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String pASSWORD) {
		password = pASSWORD;
	}


	

	public String getUsername() {
		return username;
	}

	public void setUsername(String uSERNAME) {
		username = uSERNAME;
	}

	public String getIsactive() {
		return isactive;
	}

	public void setIsactive(String iSACTIVE) {
		isactive = iSACTIVE;
	}

	
}
