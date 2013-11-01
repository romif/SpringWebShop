package by.itm.webshop.domain;

import static javax.persistence.GenerationType.AUTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "usersroles")
public class Authority {

	private Long id;
	private User user;
	private String rolename;
	

	@Id
	@GeneratedValue(strategy = AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne(optional = false)
	@JoinColumn(name = "userid", referencedColumnName = "id")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


	@Column(name="rolename")
	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

}
