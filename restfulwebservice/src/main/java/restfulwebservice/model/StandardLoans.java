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

/**
 * StandardLoans generated by hbm2java
 */
@Entity
@Table(name = "standard_loans", catalog = "student_loans")
public class StandardLoans implements java.io.Serializable {

	private int standardLoanId;
	private String standardLoanName;
	private String standardLoanMinAmount;
	private String standardLoanMaxAmount;
	private String standardLoanPeriod;
	private String standardLoanDescription;
	private String standardLoanDetails;
	private Set<StudentLoans> studentLoanses = new HashSet<StudentLoans>(0);

	public StandardLoans() {
	}

	public StandardLoans(int standardLoanId) {
		this.standardLoanId = standardLoanId;
	}

	public StandardLoans(int standardLoanId, String standardLoanName, String standardLoanMinAmount,
			String standardLoanMaxAmount, String standardLoanPeriod, String standardLoanDescription,
			String standardLoanDetails, Set<StudentLoans> studentLoanses) {
		this.standardLoanId = standardLoanId;
		this.standardLoanName = standardLoanName;
		this.standardLoanMinAmount = standardLoanMinAmount;
		this.standardLoanMaxAmount = standardLoanMaxAmount;
		this.standardLoanPeriod = standardLoanPeriod;
		this.standardLoanDescription = standardLoanDescription;
		this.standardLoanDetails = standardLoanDetails;
		this.studentLoanses = studentLoanses;
	}

	@Id

	@Column(name = "standard_loan_id", unique = true, nullable = false)
	public int getStandardLoanId() {
		return this.standardLoanId;
	}

	public void setStandardLoanId(int standardLoanId) {
		this.standardLoanId = standardLoanId;
	}

	@Column(name = "standard_loan_name", length = 45)
	public String getStandardLoanName() {
		return this.standardLoanName;
	}

	public void setStandardLoanName(String standardLoanName) {
		this.standardLoanName = standardLoanName;
	}

	@Column(name = "standard_loan_min_amount", length = 45)
	public String getStandardLoanMinAmount() {
		return this.standardLoanMinAmount;
	}

	public void setStandardLoanMinAmount(String standardLoanMinAmount) {
		this.standardLoanMinAmount = standardLoanMinAmount;
	}

	@Column(name = "standard_loan_max_amount", length = 45)
	public String getStandardLoanMaxAmount() {
		return this.standardLoanMaxAmount;
	}

	public void setStandardLoanMaxAmount(String standardLoanMaxAmount) {
		this.standardLoanMaxAmount = standardLoanMaxAmount;
	}

	@Column(name = "standard_loan_period", length = 45)
	public String getStandardLoanPeriod() {
		return this.standardLoanPeriod;
	}

	public void setStandardLoanPeriod(String standardLoanPeriod) {
		this.standardLoanPeriod = standardLoanPeriod;
	}

	@Column(name = "standard_loan_description", length = 45)
	public String getStandardLoanDescription() {
		return this.standardLoanDescription;
	}

	public void setStandardLoanDescription(String standardLoanDescription) {
		this.standardLoanDescription = standardLoanDescription;
	}

	@Column(name = "standard_loan_details", length = 45)
	public String getStandardLoanDetails() {
		return this.standardLoanDetails;
	}

	public void setStandardLoanDetails(String standardLoanDetails) {
		this.standardLoanDetails = standardLoanDetails;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "standardLoans")
	public Set<StudentLoans> getStudentLoanses() {
		return this.studentLoanses;
	}

	public void setStudentLoanses(Set<StudentLoans> studentLoanses) {
		this.studentLoanses = studentLoanses;
	}

}
