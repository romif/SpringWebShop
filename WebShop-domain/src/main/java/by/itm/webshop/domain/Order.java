package by.itm.webshop.domain;

import static javax.persistence.GenerationType.AUTO;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="orders", schema = "WEBSHOP")
public class Order implements Serializable {
	private static final long serialVersionUID = 2L;
	
	private Long id;
	private User user;
	private Long phoneId;
	private int qty;
	@DateTimeFormat(pattern=" MMM dd, YYYY hh:mma")
	private Date date;
	
	public Order(){
	}
	
	public Order(User user){
		this.user=user;
	}
	
	
	@Id
	@GeneratedValue(strategy = AUTO)
	public Long getId() {
	    return this.id;
	}
	  
	public void setId(Long id) {
	    this.id = id;
	}  
	
	@Column(name="phoneId")
	@NotNull
	public Long getPhoneId() {
		return this.phoneId;
	}
	  
	public void setPhoneId(Long phoneId) {
	    this.phoneId = phoneId;
	}
	
	@Column(name="qty")
	@NotNull
	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	@ManyToOne
	@JoinColumn(name="userid")
	public User getUser() {
	    return this.user;
	}

	public void setUser(User user) {
	    this.user = user;
	}
	
	@Column(name="creationDate")
	public Date getDate(){
		return date;
	}
	
	public void setDate(Date date){
		this.date=date;
	}
	
	public String toString(){
		return "Order #"+id+" for "+user.getName()+", phoneId="+phoneId+" phoneQty="+qty+" date= "+date;
		
	}
	
	public boolean equals(Object obj){
		if(obj == this) return true;
		  if(obj == null) return false;
		  if(!(getClass() == obj.getClass()))return false;
		  else {
			  Order tmp=(Order)obj;
			  if (tmp.getId()==this.getId())return true;
			  else return false;
		  }
	  }
	  
	
	

}
