package br.com.gauge.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "users")
public class users {
	
	@Id
	@GeneratedValue
	private Long idusers;
	
	private String gender;
	private String title;
	private String first;
	private String last;
	private String street;
	private String city;
	private String state;
	private int postcode;
	private String email;
	private String username;
	private String password;
	private String salt;
	private String md5;
	private String sha1;
	private String sha256;
	private int registered;
	private int dob;
	private String phone;
	private String cell;
	private String pictureLarge;
	private String pictureMedium;
	private String pictureThumbnail;
	private String nat;
	
	
	public Long getIdusers() {
		return idusers;
	}
	public void setIdusers(Long idusers) {
		this.idusers = idusers;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getFirst() {
		return first;
	}
	public void setFirst(String first) {
		this.first = first;
	}
	public String getLast() {
		return last;
	}
	public void setLast(String last) {
		this.last = last;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getPostcode() {
		return postcode;
	}
	public void setPostcode(int postcode) {
		this.postcode = postcode;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public String getMd5() {
		return md5;
	}
	public void setMd5(String md5) {
		this.md5 = md5;
	}
	public String getSha1() {
		return sha1;
	}
	public void setSha1(String sha1) {
		this.sha1 = sha1;
	}
	public String getSha256() {
		return sha256;
	}
	public void setSha256(String sha256) {
		this.sha256 = sha256;
	}
	public int getRegistered() {
		return registered;
	}
	public void setRegistered(int registered) {
		this.registered = registered;
	}
	public int getDob() {
		return dob;
	}
	public void setDob(int dob) {
		this.dob = dob;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getCell() {
		return cell;
	}
	public void setCell(String cell) {
		this.cell = cell;
	}
	public String getPictureLarge() {
		return pictureLarge;
	}
	public void setPictureLarge(String pictureLarge) {
		this.pictureLarge = pictureLarge;
	}
	public String getPictureMedium() {
		return pictureMedium;
	}
	public void setPictureMedium(String pictureMedium) {
		this.pictureMedium = pictureMedium;
	}
	public String getPictureThumbnail() {
		return pictureThumbnail;
	}
	public void setPictureThumbnail(String pictureThumbnail) {
		this.pictureThumbnail = pictureThumbnail;
	}
	public String getNat() {
		return nat;
	}
	public void setNat(String nat) {
		this.nat = nat;
	}
	
	
	
}
