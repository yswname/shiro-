package cn.com.shiro.book.tp12.entity;

/**
 * ShrSession entity. @author MyEclipse Persistence Tools
 */

public class ShrSession implements java.io.Serializable {

	// Fields

	private String sessionId;
	private String sessionValue;

	// Constructors

	/** default constructor */
	public ShrSession() {
	}

	/** full constructor */
	public ShrSession(String sessionValue) {
		this.sessionValue = sessionValue;
	}

	// Property accessors

	public String getSessionId() {
		return this.sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public String getSessionValue() {
		return this.sessionValue;
	}

	public void setSessionValue(String sessionValue) {
		this.sessionValue = sessionValue;
	}

}