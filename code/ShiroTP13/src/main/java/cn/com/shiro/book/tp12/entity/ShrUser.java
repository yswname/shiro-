package cn.com.shiro.book.tp12.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * ShrUser entity. @author MyEclipse Persistence Tools
 */

public class ShrUser implements java.io.Serializable {

	// Fields

	private Integer urId;
	private String urUserName;
	private String urPassword;
	private String urSalt;
	private Set shrRoles = new HashSet(0);
	private Set shrUserPermissions = new HashSet(0);

	// Constructors

	/** default constructor */
	public ShrUser() {
	}

	/** minimal constructor */
	public ShrUser(String urUserName) {
		this.urUserName = urUserName;
	}

	/** full constructor */
	public ShrUser(String urUserName, String urPassword, String urSalt,
			Set shrRoles, Set shrUserPermissions) {
		this.urUserName = urUserName;
		this.urPassword = urPassword;
		this.urSalt = urSalt;
		this.shrRoles = shrRoles;
		this.shrUserPermissions = shrUserPermissions;
	}

	// Property accessors

	public Integer getUrId() {
		return this.urId;
	}

	public void setUrId(Integer urId) {
		this.urId = urId;
	}

	public String getUrUserName() {
		return this.urUserName;
	}

	public void setUrUserName(String urUserName) {
		this.urUserName = urUserName;
	}

	public String getUrPassword() {
		return this.urPassword;
	}

	public void setUrPassword(String urPassword) {
		this.urPassword = urPassword;
	}

	public String getUrSalt() {
		return this.urSalt;
	}

	public void setUrSalt(String urSalt) {
		this.urSalt = urSalt;
	}

	public Set getShrRoles() {
		return this.shrRoles;
	}

	public void setShrRoles(Set shrRoles) {
		this.shrRoles = shrRoles;
	}

	public Set getShrUserPermissions() {
		return this.shrUserPermissions;
	}

	public void setShrUserPermissions(Set shrUserPermissions) {
		this.shrUserPermissions = shrUserPermissions;
	}

}