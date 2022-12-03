package vn.iotstar.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Bills
 *
 */
@Entity
@NamedQuery(name="Bills.findAll", query="SELECT s FROM Bills s")

public class Bills implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bill_Id;
	private double total;
	private Timestamp date;
	@ManyToOne
	@JoinColumn(name="cartId")
	private Cart cart;
	@ManyToOne
	@JoinColumn(name="userId")
	private User user;
	private int paymentmethod;
	private int status;
	


	public Bills(int bill_Id, double total, Timestamp date, Cart cart, User user, int paymentmethod, int status) {
		super();
		this.bill_Id = bill_Id;
		this.total = total;
		this.date = date;
		this.cart = cart;
		this.user = user;
		this.paymentmethod = paymentmethod;
		this.status = status;
	}



	public Bills() {
		super();
	}



	public int getBill_Id() {
		return bill_Id;
	}



	public void setBill_Id(int bill_Id) {
		this.bill_Id = bill_Id;
	}



	public double getTotal() {
		return total;
	}



	public void setTotal(double total) {
		this.total = total;
	}



	public Timestamp getDate() {
		return date;
	}



	public void setDate(Timestamp date) {
		this.date = date;
	}



	public Cart getCart() {
		return cart;
	}



	public void setCart(Cart cart) {
		this.cart = cart;
	}



	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}



	public int getPaymentmethod() {
		return paymentmethod;
	}



	public void setPaymentmethod(int paymentmethod) {
		this.paymentmethod = paymentmethod;
	}



	public int getStatus() {
		return status;
	}



	public void setStatus(int status) {
		this.status = status;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}
   
}
