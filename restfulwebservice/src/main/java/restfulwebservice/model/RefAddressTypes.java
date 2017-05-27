package restfulwebservice.model;
// Generated May 26, 2017 8:19:28 AM by Hibernate Tools 5.2.1.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * RefAddressTypes generated by hbm2java
 */
@XmlRootElement(name = "ref_address_types")
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name = "ref_address_types", catalog = "student_loans")
public class RefAddressTypes implements java.io.Serializable {
	@XmlElement
	private String addressTypeCode;
	@XmlElement
	private String addressTypeDescription;
	private Set<StudentAddresses> studentAddresseses = new HashSet<StudentAddresses>(0);

	public RefAddressTypes() {
	}

	public RefAddressTypes(String addressTypeCode) {
		this.addressTypeCode = addressTypeCode;
	}

	public RefAddressTypes(String addressTypeCode, String addressTypeDescription,
			Set<StudentAddresses> studentAddresseses) {
		this.addressTypeCode = addressTypeCode;
		this.addressTypeDescription = addressTypeDescription;
		this.studentAddresseses = studentAddresseses;
	}

	@Id

	@Column(name = "address_type_code", unique = true, nullable = false, length = 45)
	public String getAddressTypeCode() {
		return this.addressTypeCode;
	}

	public void setAddressTypeCode(String addressTypeCode) {
		this.addressTypeCode = addressTypeCode;
	}

	@Column(name = "address_type_description", length = 45)
	public String getAddressTypeDescription() {
		return this.addressTypeDescription;
	}

	public void setAddressTypeDescription(String addressTypeDescription) {
		this.addressTypeDescription = addressTypeDescription;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "refAddressTypes")
	public Set<StudentAddresses> getStudentAddresseses() {
		return this.studentAddresseses;
	}

	public void setStudentAddresseses(Set<StudentAddresses> studentAddresseses) {
		this.studentAddresseses = studentAddresseses;
	}

}