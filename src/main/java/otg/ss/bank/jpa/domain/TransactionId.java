package otg.ss.bank.jpa.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Embeddable
public class TransactionId implements Serializable {

	@Column(name = "ID_AMOUNT", nullable = false)
	private Long accountId;
	@Column(name = "ID_AGENCY", nullable = false)
	private Long agencyId;
	@Column(name = "DATE", nullable = false)
	@Temporal(TemporalType.TIME)
	private Date date;

	public TransactionId() {
	}

	public Long getAgencyId() {
		return agencyId;
	}

	public void setAgencyId(Long agencyId) {
		this.agencyId = agencyId;
	}

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof TransactionId))
			return false;
		TransactionId that = (TransactionId) o;
		return Objects.equals(agencyId, that.agencyId) && Objects.equals(accountId, that.accountId)
				&& Objects.equals(date, that.date);
	}

	@Override
	public int hashCode() {

		return Objects.hash(agencyId, accountId, date);
	}
}
