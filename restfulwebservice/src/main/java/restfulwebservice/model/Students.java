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
import javax.transaction.Transactional;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlTransient;

import com.sun.jersey.api.provider.jaxb.XmlHeader;

/**
 * Students generated by hbm2java
 */
@XmlRootElement(name = "students")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = { "studentId", "studentName", "studentPhone", "studentEmail", "otherStudentDetails" })
@Entity
@Table(name = "students", schema = "student_loans", catalog = "student_loans")
public class Students implements java.io.Serializable {

	@XmlElement
	private int studentId;
	@XmlElement
	private String studentName;
	@XmlElement
	private String studentPhone;
	@XmlElement
	private String studentEmail;
	@XmlElement
	private String otherStudentDetails;
	@XmlTransient
	private Set<StudentAddresses> studentAddresseses = new HashSet<StudentAddresses>(0);
	@XmlTransient
	private Set<StudentLoans> studentLoanses = new HashSet<StudentLoans>(0);
	@XmlTransient
	private Set<ActualPayments> actualPaymentses = new HashSet<ActualPayments>(0);
	@XmlTransient
	private Set<Accounts> accountses = new HashSet<Accounts>(0);
	@XmlTransient
	private Set<PlannedPayments> plannedPaymentses = new HashSet<PlannedPayments>(0);

	public Students() {
	}

	public Students(int studentId) {
		this.studentId = studentId;
	}

	public Students(int studentId, String studentName, String studentPhone, String studentEmail,
			String otherStudentDetails, Set<StudentAddresses> studentAddresseses, Set<StudentLoans> studentLoanses,
			Set<ActualPayments> actualPaymentses, Set<Accounts> accountses, Set<PlannedPayments> plannedPaymentses) {
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentPhone = studentPhone;
		this.studentEmail = studentEmail;
		this.otherStudentDetails = otherStudentDetails;
		this.studentAddresseses = studentAddresseses;
		this.studentLoanses = studentLoanses;
		this.actualPaymentses = actualPaymentses;
		this.accountses = accountses;
		this.plannedPaymentses = plannedPaymentses;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "student_id", unique = true, nullable = false)
	public int getStudentId() {
		return this.studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	@Column(name = "student_name", length = 45)
	public String getStudentName() {
		return this.studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	@Column(name = "student_phone", length = 45)
	public String getStudentPhone() {
		return this.studentPhone;
	}

	public void setStudentPhone(String studentPhone) {
		this.studentPhone = studentPhone;
	}

	@Column(name = "student_email", length = 45)
	public String getStudentEmail() {
		return this.studentEmail;
	}

	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}

	@Column(name = "other_student_details", length = 45)
	public String getOtherStudentDetails() {
		return this.otherStudentDetails;
	}

	public void setOtherStudentDetails(String otherStudentDetails) {
		this.otherStudentDetails = otherStudentDetails;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "students")
	@Transactional
	public Set<StudentAddresses> getStudentAddresseses() {
		return this.studentAddresseses;
	}

	public void setStudentAddresseses(Set<StudentAddresses> studentAddresseses) {
		this.studentAddresseses = studentAddresseses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "students")
	@Transactional
	public Set<StudentLoans> getStudentLoanses() {
		return this.studentLoanses;
	}

	public void setStudentLoanses(Set<StudentLoans> studentLoanses) {
		this.studentLoanses = studentLoanses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "students")
	@Transactional
	public Set<ActualPayments> getActualPaymentses() {
		return this.actualPaymentses;
	}

	public void setActualPaymentses(Set<ActualPayments> actualPaymentses) {
		this.actualPaymentses = actualPaymentses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "students")
	@Transactional
	public Set<Accounts> getAccountses() {
		return this.accountses;
	}

	public void setAccountses(Set<Accounts> accountses) {
		this.accountses = accountses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "students")
	@Transactional
	public Set<PlannedPayments> getPlannedPaymentses() {
		return this.plannedPaymentses;
	}

	public void setPlannedPaymentses(Set<PlannedPayments> plannedPaymentses) {
		this.plannedPaymentses = plannedPaymentses;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Students other = (Students) obj;
		if (otherStudentDetails == null) {
			if (other.otherStudentDetails != null)
				return false;
		} else if (!otherStudentDetails.equals(other.otherStudentDetails))
			return false;
		if (studentEmail == null) {
			if (other.studentEmail != null)
				return false;
		} else if (!studentEmail.equals(other.studentEmail))
			return false;
		if (studentLoanses == null) {
			if (other.studentLoanses != null)
				return false;
		} else if (!studentLoanses.equals(other.studentLoanses))
			return false;
		if (studentName == null) {
			if (other.studentName != null)
				return false;
		} else if (!studentName.equals(other.studentName))
			return false;
		if (studentPhone == null) {
			if (other.studentPhone != null)
				return false;
		} else if (!studentPhone.equals(other.studentPhone))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Students [studentId=" + studentId + ", studentName=" + studentName + ", studentPhone=" + studentPhone
				+ ", studentEmail=" + studentEmail + ", otherStudentDetails=" + otherStudentDetails + "]";
	}
}
