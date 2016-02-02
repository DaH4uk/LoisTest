package com.myApplication.shared;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Date;

/**
 * Created by DaH4uk on 02.02.2016.
 */
@Entity
@javax.persistence.Table(name = "contracts", schema = "contracts", catalog = "")
public class ContractsDataSet implements Serializable {
    private int contractNumber;

    @Basic
    @javax.persistence.Column(name = "CONTRACT_NUMBER", nullable = false)
    public int getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(int contractNumber) {
        this.contractNumber = contractNumber;
    }

    private String premium;

    @Basic
    @javax.persistence.Column(name = "PREMIUM", nullable = false, length = 20)
    public String getPremium() {
        return premium;
    }

    public void setPremium(String premium) {
        this.premium = premium;
    }

    private Date conclusionDate;

    @Basic
    @javax.persistence.Column(name = "CONCLUSION_DATE", nullable = false)
    public Date getConclusionDate() {
        return conclusionDate;
    }

    public void setConclusionDate(Date conclusionDate) {
        this.conclusionDate = conclusionDate;
    }

    private String firstName;

    @Basic
    @javax.persistence.Column(name = "FIRST_NAME", nullable = false, length = 20)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    private String lastName;

    @Basic
    @javax.persistence.Column(name = "LAST_NAME", nullable = false, length = 20)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    private String middleName;

    @Basic
    @javax.persistence.Column(name = "MIDDLE_NAME", nullable = true, length = 20)
    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    private Date birthDate;

    @Basic
    @javax.persistence.Column(name = "BIRTH_DATE", nullable = false)
    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    private Integer passportSerial;

    @Basic
    @javax.persistence.Column(name = "PASSPORT_SERIAL", nullable = true)
    public Integer getPassportSerial() {
        return passportSerial;
    }

    public void setPassportSerial(Integer passportSerial) {
        this.passportSerial = passportSerial;
    }

    private int passportNumber;

    @Basic
    @javax.persistence.Column(name = "PASSPORT_NUMBER", nullable = false)
    public int getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(int passportNumber) {
        this.passportNumber = passportNumber;
    }

    private String country;

    @Basic
    @javax.persistence.Column(name = "COUNTRY", nullable = false, length = 20)
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    private String index;

    @Basic
    @javax.persistence.Column(name = "INDEX", nullable = true, length = 20)
    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    private String republic;

    @Basic
    @javax.persistence.Column(name = "REPUBLIC", nullable = false, length = 20)
    public String getRepublic() {
        return republic;
    }

    public void setRepublic(String republic) {
        this.republic = republic;
    }

    private String district;

    @Basic
    @javax.persistence.Column(name = "DISTRICT", nullable = true, length = 20)
    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    private String locality;

    @Basic
    @javax.persistence.Column(name = "LOCALITY", nullable = false, length = 20)
    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    private String street;

    @Basic
    @javax.persistence.Column(name = "STREET", nullable = false, length = 20)
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    private Integer house;

    @Basic
    @javax.persistence.Column(name = "HOUSE", nullable = true)
    public Integer getHouse() {
        return house;
    }

    public void setHouse(Integer house) {
        this.house = house;
    }

    private String housing;

    @Basic
    @javax.persistence.Column(name = "HOUSING", nullable = true, length = 20)
    public String getHousing() {
        return housing;
    }

    public void setHousing(String housing) {
        this.housing = housing;
    }

    private String building;

    @Basic
    @javax.persistence.Column(name = "BUILDING", nullable = true, length = 20)
    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    private int apartment;

    @Basic
    @javax.persistence.Column(name = "APARTMENT", nullable = false)
    public int getApartment() {
        return apartment;
    }

    public void setApartment(int apartment) {
        this.apartment = apartment;
    }

    private String comments;

    @Basic
    @javax.persistence.Column(name = "COMMENTS", nullable = true, length = 140)
    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    private int id;

    @Id
    @javax.persistence.Column(name = "ID", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContractsDataSet that = (ContractsDataSet) o;

        if (contractNumber != that.contractNumber) return false;
        if (passportNumber != that.passportNumber) return false;
        if (apartment != that.apartment) return false;
        if (id != that.id) return false;
        if (premium != null ? !premium.equals(that.premium) : that.premium != null) return false;
        if (conclusionDate != null ? !conclusionDate.equals(that.conclusionDate) : that.conclusionDate != null)
            return false;
        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
        if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;
        if (middleName != null ? !middleName.equals(that.middleName) : that.middleName != null) return false;
        if (birthDate != null ? !birthDate.equals(that.birthDate) : that.birthDate != null) return false;
        if (passportSerial != null ? !passportSerial.equals(that.passportSerial) : that.passportSerial != null)
            return false;
        if (country != null ? !country.equals(that.country) : that.country != null) return false;
        if (index != null ? !index.equals(that.index) : that.index != null) return false;
        if (republic != null ? !republic.equals(that.republic) : that.republic != null) return false;
        if (district != null ? !district.equals(that.district) : that.district != null) return false;
        if (locality != null ? !locality.equals(that.locality) : that.locality != null) return false;
        if (street != null ? !street.equals(that.street) : that.street != null) return false;
        if (house != null ? !house.equals(that.house) : that.house != null) return false;
        if (housing != null ? !housing.equals(that.housing) : that.housing != null) return false;
        if (building != null ? !building.equals(that.building) : that.building != null) return false;
        if (comments != null ? !comments.equals(that.comments) : that.comments != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = contractNumber;
        result = 31 * result + (premium != null ? premium.hashCode() : 0);
        result = 31 * result + (conclusionDate != null ? conclusionDate.hashCode() : 0);
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (middleName != null ? middleName.hashCode() : 0);
        result = 31 * result + (birthDate != null ? birthDate.hashCode() : 0);
        result = 31 * result + (passportSerial != null ? passportSerial.hashCode() : 0);
        result = 31 * result + passportNumber;
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (index != null ? index.hashCode() : 0);
        result = 31 * result + (republic != null ? republic.hashCode() : 0);
        result = 31 * result + (district != null ? district.hashCode() : 0);
        result = 31 * result + (locality != null ? locality.hashCode() : 0);
        result = 31 * result + (street != null ? street.hashCode() : 0);
        result = 31 * result + (house != null ? house.hashCode() : 0);
        result = 31 * result + (housing != null ? housing.hashCode() : 0);
        result = 31 * result + (building != null ? building.hashCode() : 0);
        result = 31 * result + apartment;
        result = 31 * result + (comments != null ? comments.hashCode() : 0);
        result = 31 * result + id;
        return result;
    }
}
