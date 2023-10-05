package projeto.clinica.entities;

import java.time.Instant;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "clients")
public class Client {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "name")
  private String name;

  @Column(name = "cpf")
  private String cpf;

  @Column(name = "age")
  private int age;

  @Column(name = "street_address")
  private String streetAddress;

  @Column(name = "number_address")
  private String numberAddress;

  @Column(name = "district_address")
  private String districtAddress;

  @Column(name = "city_address")
  private String cityAddress;

  @Column(name = "zip_code")
  private String zipCode;

  @Column(name = "phone")
  private String phone;

  @Column(name = "payment_date")
  private Instant paymentDate;

  @Column(name = "payment_status")
  private Boolean paymentStatus;

  @Column(name = "is_active")
  private Boolean isActive;

  // Constructors
  public Client() {
  }

  public Client(String name, String cpf, int age, String streetAddress, String numberAddress, String districtAddress,
      String cityAddress, String zipCode, String phone, Instant paymentDate, Boolean paymentStatus, Boolean isActive) {
    this.name = name;
    this.cpf = cpf;
    this.age = age;
    this.streetAddress = streetAddress;
    this.numberAddress = numberAddress;
    this.districtAddress = districtAddress;
    this.cityAddress = cityAddress;
    this.zipCode = zipCode;
    this.phone = phone;
    this.paymentDate = paymentDate;
    this.paymentStatus = paymentStatus;
    this.isActive = isActive;
  }

  // Getters and Setters
  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getStreetAddress() {
    return streetAddress;
  }

  public void setStreetAddress(String streetAddress) {
    this.streetAddress = streetAddress;
  }

  public String getNumberAddress() {
    return numberAddress;
  }

  public void setNumberAddress(String numberAddress) {
    this.numberAddress = numberAddress;
  }

  public String getDistrictAddress() {
    return districtAddress;
  }

  public void setDistrictAddress(String districtAddress) {
    this.districtAddress = districtAddress;
  }

  public String getCityAddress() {
    return cityAddress;
  }

  public void setCityAddress(String cityAddress) {
    this.cityAddress = cityAddress;
  }

  public String getZipCode() {
    return zipCode;
  }

  public void setZipCode(String zipCode) {
    this.zipCode = zipCode;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public Instant getPaymentDate() {
    return paymentDate;
  }

  public void setPaymentDate(Instant paymentDate) {
    this.paymentDate = paymentDate;
  }

  public Boolean getPaymentStatus() {
    return paymentStatus;
  }

  public void setPaymentStatus(Boolean paymentStatus) {
    this.paymentStatus = paymentStatus;
  }

  public Boolean getIsActive() {
    return isActive;
  }

  public void setIsActive(Boolean isActive) {
    this.isActive = isActive;
  }

  // Equals
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Client other = (Client) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    return true;
  }

  // ToString
  @Override
  public String toString() {
    return "Client [id=" + id + ", name=" + name + ", cpf=" + cpf + ", age=" + age + ", streetAddress=" + streetAddress
        + ", numberAddress=" + numberAddress + ", districtAddress=" + districtAddress + ", cityAddress=" + cityAddress
        + ", zipCode=" + zipCode + ", phone=" + phone + ", paymentDate=" + paymentDate + ", paymentStatus="
        + paymentStatus + ", isActive=" + isActive + "]";
  }
}