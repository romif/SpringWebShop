package by.itm.webshop.domain;

import static javax.persistence.GenerationType.AUTO;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import static org.apache.commons.lang.builder.HashCodeBuilder.*;
import static org.apache.commons.lang.builder.EqualsBuilder.*;

@Entity
@Table(name = "users", schema = "WEBSHOP")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;

	@Size(min = 3, max = 20, message = "Login must be between 3 and 20 characters long.")
	@Pattern(regexp = "^[a-zA-Z0-9]+$", message = "Login must be alphanumeric with no spaces")
	private String login;
	// @Size(min=3, max=20,
	// message="Password must be between 3 and 20 characters long.")
	private String password;

	private boolean enabled;
	private String name;
	private String surname;
	private String patronymic;
	private String tel;

	@Pattern(regexp = "[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}", message = "Invalid email address.")
	private String email;
	@DateTimeFormat(pattern = " MMM dd, YYYY hh:mma")
	private Date creationDate;

	private Set<Authority> authorities = new HashSet<Authority>();

	public User() {
	}

	@Id
	@GeneratedValue(strategy = AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "login", unique = true)
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	@Column(name = "password")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "surname")
	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	@Column(name = "patronymic")
	public String getPatronymic() {
		return patronymic;
	}

	public void setPatronymic(String patronymic) {
		this.patronymic = patronymic;
	}

	@Column(name = "tel")
	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Column(name = "email")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "enabled")
	public boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	@Column(name = "creationDate")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date date) {
		this.creationDate = date;
	}

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "userid", referencedColumnName = "id")
	public Set<Authority> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(Set<Authority> authorities) {
		this.authorities = authorities;
	}

	public boolean equals(Object obj) {
		/*if (obj == this)
			return true;
		if (obj == null)
			return false;
		if (!(getClass() == obj.getClass()))
			return false;
		else {
			User tmp = (User) obj;
			if (tmp.login.equals(this.login))
				return true;
			else
				return false;
		}*/
		return reflectionEquals(this, obj);
	}

	public int hashCode() {
		return reflectionHashCode(this);
	}

}
