package by.itm.webshop.domain;

import static javax.persistence.GenerationType.AUTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usersroles")
public class Authority {
	
	public Authority(){
		
	}
	
	public Authority(String rolename){
		this.rolename=rolename;
	}

	private Long id;
	private String rolename;
	

	@Id
	@GeneratedValue(strategy = AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name="rolename")
	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

}
