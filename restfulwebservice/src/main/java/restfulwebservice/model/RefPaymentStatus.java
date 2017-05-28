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
 * RefPaymentStatus generated by hbm2java
 */
@Entity
@Table(name = "ref_payment_status", catalog = "student_loans")
public class RefPaymentStatus implements java.io.Serializable {

	private String paymentStatusCode;
	private String paymentStatusDescription;
	private Set<PlannedPayments> plannedPaymentses = new HashSet<PlannedPayments>(0);

	public RefPaymentStatus() {
	}

	public RefPaymentStatus(String paymentStatusCode) {
		this.paymentStatusCode = paymentStatusCode;
	}

	public RefPaymentStatus(String paymentStatusCode, String paymentStatusDescription,
			Set<PlannedPayments> plannedPaymentses) {
		this.paymentStatusCode = paymentStatusCode;
		this.paymentStatusDescription = paymentStatusDescription;
		this.plannedPaymentses = plannedPaymentses;
	}

	@Id

	@Column(name = "payment_status_code", unique = true, nullable = false, length = 45)
	public String getPaymentStatusCode() {
		return this.paymentStatusCode;
	}

	public void setPaymentStatusCode(String paymentStatusCode) {
		this.paymentStatusCode = paymentStatusCode;
	}

	@Column(name = "payment_status_description", length = 45)
	public String getPaymentStatusDescription() {
		return this.paymentStatusDescription;
	}

	public void setPaymentStatusDescription(String paymentStatusDescription) {
		this.paymentStatusDescription = paymentStatusDescription;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "refPaymentStatus")
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
		RefPaymentStatus other = (RefPaymentStatus) obj;
		if (paymentStatusCode == null) {
			if (other.paymentStatusCode != null)
				return false;
		} else if (!paymentStatusCode.equals(other.paymentStatusCode))
			return false;
		if (paymentStatusDescription == null) {
			if (other.paymentStatusDescription != null)
				return false;
		} else if (!paymentStatusDescription.equals(other.paymentStatusDescription))
			return false;
		return true;
	}

}
