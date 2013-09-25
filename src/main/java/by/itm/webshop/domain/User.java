package by.itm.webshop.domain;

import static javax.persistence.GenerationType.AUTO;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="users")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	 
	@Size(min=3, max=20, message=
			"Login must be between 3 and 20 characters long.")
	@Pattern(regexp="^[a-zA-Z0-9]+$",
		          message="Login must be alphanumeric with no spaces") 
	private String login;
	
	private boolean isAdmin;
	private String name;
	private String surname;
	private String patronymic;
	private String tel;
	
	@Pattern(regexp="[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}", 
	          message="Invalid email address.")
	private String email;
	@DateTimeFormat(pattern=" MMM dd, YYYY hh:mma")
	private Date date;
	//private Map<Phone,Integer> items=new HashMap<Phone,Integer>();
	
	public User(){
	}
		/*public User(String login, String name, String surName, String patronymic, String tel, String e_mail){
		this.login=login;
		this.name=name;
		this.surName=surName;
		this.patronymic=patronymic;
		this.tel=tel;
		this.e_mail=e_mail;
	}*/
	
	
	@Id
	@GeneratedValue(strategy = AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name="login", unique=true)
	public String getLogin(){
		return login;
	}
	
	public void setLogin(String login){
		this.login=login;
	}

	@Column(name="name")
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name=name;
	}
	
	@Column(name="surname")
	public String getSurname(){
		return surname;
	}
	
	public void setSurname(String surname){
		this.surname=surname;
	}
	
	@Column(name="patronymic")
	public String getPatronymic(){
		return patronymic;
	}
	
	public void setPatronymic(String patronymic){
		this.patronymic=patronymic;
	}
	
	@Column(name="tel")
	public String getTel(){
		return tel;
	}
	
	public void setTel(String tel){
		this.tel=tel;
	}
	
	@Column(name="email")
	public String getEmail(){
		return email;
	}
	
	public void setEmail(String email){
		this.email=email;
	}
	
	@Column(name="isAdmin")
	public boolean getIsAdmin(){
		return isAdmin;
	}
	
	public void setIsAdmin(boolean isAdmin){
		this.isAdmin=isAdmin;
	}
	
	@Column(name="creationDate")
	public Date getDate(){
		return date;
	}
	
	public void setDate(Date date){
		this.date=date;
	}
	
	
	

	
	/*
	public Map<Phone,Integer> getItems(){
		return items;
	}
	
	public boolean updateItem(int phoneId, int number){
		Iterator<Phone> it=this.items.keySet().iterator();
		while (it.hasNext()){
			Phone phone=it.next();
			if (phone.getId()==phoneId){
				if (number==0)this.items.remove(phone);
				else this.items.put(phone, number);
				return true;
			}
		}
		return false;
		
	}
	
	public int getItemsPrice(){
		int price=0;
		Iterator<Entry<Phone, Integer>> it=items.entrySet().iterator();
		while (it.hasNext()){
			Entry<Phone, Integer> entry=it.next(); 
			price+=entry.getKey().getPriceUSD()*entry.getValue();
		}
		return price;
	}
	
	public int getItemsCount(){
		int count=0;
		Iterator<Entry<Phone, Integer>> it=items.entrySet().iterator();
		while (it.hasNext()){
			count+=it.next().getValue();
		}
		return count;
	}
	
	public boolean addItem(String phoneId){
		try {
			Phone phone=null;
			int id=Integer.parseInt(phoneId);
			if ((phone=SqlManager.GetPhone(id))!=null){
				if (items.containsKey(phone)) {
					items.put(phone, items.get(phone)+1);
				}
				else items.put(phone, 1);
				return true;
			}
			else return false;	
		}catch (NumberFormatException ex){
			ex.printStackTrace();
			return false;
		}	
	}*/
	
	public boolean equals(Object obj){
		if(obj == this) return true;
		  if(obj == null) return false;
		  if(!(getClass() == obj.getClass()))return false;
		  else {
			  User tmp=(User)obj;
			  if (tmp.login.equals(this.login))return true;
			  else return false;
		  }
	  }
	  
	public int hashCode(){
		return login.hashCode();
	}
	
	

}

