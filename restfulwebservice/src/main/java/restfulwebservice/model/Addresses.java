package restfulwebservice.model;
// Generated May 26, 2017 8:19:28 AM by Hibernate Tools 5.2.1.Final

import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Addresses generated by hbm2java
 */
@XmlRootElement(name = "addresses")
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name = "addresses", catalog = "student_loans")
public class Addresses implements java.io.Serializable {
	@XmlElement
	private int addressId;
	@XmlElement
	private String line1;
	@XmlElement
	private String line2;
	@XmlElement
	private String line3;
	@XmlElement
	private String line4;
	@XmlElement
	private String city;
	@XmlElement
	private String zipPostcode;
	@XmlElement
	private String stateProvinceCountry;
	@XmlElement
	private String country;
	@XmlElement
	private String otherAddressDetails;
	private Set<StudentAddresses> studentAddresseses = new HashSet<StudentAddresses>(0);
	private Set<Guarantors> guarantorses = new HashSet<Guarantors>(0);

	public Addresses() {
	}

	public Addresses(int addressId) {
		this.addressId = addressId;
	}

	public Addresses(int addressId, String line1, String line2, String line3, String line4, String city,
			String zipPostcode, String stateProvinceCountry, String country, String otherAddressDetails,
			Set<StudentAddresses> studentAddresseses, Set<Guarantors> guarantorses) {
		this.addressId = addressId;
		this.line1 = line1;
		this.line2 = line2;
		this.line3 = line3;
		this.line4 = line4;
		this.city = city;
		this.zipPostcode = zipPostcode;
		this.stateProvinceCountry = stateProvinceCountry;
		this.country = country;
		this.otherAddressDetails = otherAddressDetails;
		this.studentAddresseses = studentAddresseses;
		this.guarantorses = guarantorses;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "address_id", unique = true, nullable = false)
	public int getAddressId() {
		return this.addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	@Column(name = "line_1", length = 45)
	public String getLine1() {
		return this.line1;
	}

	public void setLine1(String line1) {
		this.line1 = line1;
	}

	@Column(name = "line_2", length = 45)
	public String getLine2() {
		return this.line2;
	}

	public void setLine2(String line2) {
		this.line2 = line2;
	}

	@Column(name = "line_3", length = 45)
	public String getLine3() {
		return this.line3;
	}

	public void setLine3(String line3) {
		this.line3 = line3;
	}

	@Column(name = "line_4", length = 45)
	public String getLine4() {
		return this.line4;
	}

	public void setLine4(String line4) {
		this.line4 = line4;
	}

	@Column(name = "city", length = 45)
	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(name = "zip_postcode", length = 45)
	public String getZipPostcode() {
		return this.zipPostcode;
	}

	public void setZipPostcode(String zipPostcode) {
		this.zipPostcode = zipPostcode;
	}

	@Column(name = "state_province_country", length = 45)
	public String getStateProvinceCountry() {
		return this.stateProvinceCountry;
	}

	public void setStateProvinceCountry(String stateProvinceCountry) {
		this.stateProvinceCountry = stateProvinceCountry;
	}

	@Column(name = "country", length = 45)
	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Column(name = "other_address_details", length = 45)
	public String getOtherAddressDetails() {
		return this.otherAddressDetails;
	}

	public void setOtherAddressDetails(String otherAddressDetails) {
		this.otherAddressDetails = otherAddressDetails;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "addresses")
	public Set<StudentAddresses> getStudentAddresseses() {
		return this.studentAddresseses;
	}

	public void setStudentAddresseses(Set<StudentAddresses> studentAddresseses) {
		this.studentAddresseses = studentAddresseses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "addresses")
	public Set<Guarantors> getGuarantorses() {
		return this.guarantorses;
	}

	public void setGuarantorses(Set<Guarantors> guarantorses) {
		this.guarantorses = guarantorses;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Addresses other = (Addresses) obj;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (line1 == null) {
			if (other.line1 != null)
				return false;
		} else if (!line1.equals(other.line1))
			return false;
		if (line2 == null) {
			if (other.line2 != null)
				return false;
		} else if (!line2.equals(other.line2))
			return false;
		if (line3 == null) {
			if (other.line3 != null)
				return false;
		} else if (!line3.equals(other.line3))
			return false;
		if (line4 == null) {
			if (other.line4 != null)
				return false;
		} else if (!line4.equals(other.line4))
			return false;
		if (otherAddressDetails == null) {
			if (other.otherAddressDetails != null)
				return false;
		} else if (!otherAddressDetails.equals(other.otherAddressDetails))
			return false;
		if (stateProvinceCountry == null) {
			if (other.stateProvinceCountry != null)
				return false;
		} else if (!stateProvinceCountry.equals(other.stateProvinceCountry))
			return false;
		if (zipPostcode == null) {
			if (other.zipPostcode != null)
				return false;
		} else if (!zipPostcode.equals(other.zipPostcode))
			return false;
		return true;
	}

}
