package projeto.clinica.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "physiotherapists")
public class Physiotherapist {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "name")
  private String name;

  @Column(name = "cpf")
  private String cpf;

  @Column(name = "coffito")
  private String coffito;

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

  @Column(name = "is_active")
  private Boolean isActive;

  // Constructors
  public Physiotherapist() {
  }

  public Physiotherapist(String name, String cpf, String coffito, String streetAddress, String numberAddress,
      String districtAddress, String cityAddress, String zipCode, Boolean isActive) {
    this.name = name;
    this.cpf = cpf;
    this.coffito = coffito;
    this.streetAddress = streetAddress;
    this.numberAddress = numberAddress;
    this.districtAddress = districtAddress;
    this.cityAddress = cityAddress;
    this.zipCode = zipCode;
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

  public String getCoffito() {
    return coffito;
  }

  public void setCoffito(String coffito) {
    this.coffito = coffito;
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
    Physiotherapist other = (Physiotherapist) obj;
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
    return "Physiotherapist [id=" + id + ", name=" + name + ", cpf=" + cpf + ", coffito=" + coffito + ", streetAddress="
        + streetAddress + ", numberAddress=" + numberAddress + ", districtAddress=" + districtAddress + ", cityAddress="
        + cityAddress + ", zipCode=" + zipCode + ", isActive=" + isActive + "]";
  }
}