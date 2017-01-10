package com.finleash.batch.springdatabatch.persist;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * 
 * @author Vaquar.khan@gmail.com
 *
 */
@Entity
@Table(name="mutual_fund_nav")
//@NamedQuery(name="MutualFundNav.findAll", query="SELECT u FROM Mutual_Fund_Nav u")
public class MutualFundNav  implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	@Column(name="scheme_code")
	private String schemeCode;
	
	@Column(name="isin_div_payout_isin_growth")
	private String isinDivPayoutISINGrowth;
	
	@Column(name="status")
	private String isinDivReinvestment;
	
	@Column(name="scheme_name")
	private String schemeName;
	
	@Column(name="net_assset_value")
	private String netAssetValue;
	
	@Column(name="repurchase_price")
	private String repurchasePrice;
	
	@Column(name="sale_price")
	private String salePrice;
	
	@Column(name="date")
	private String date;

	@Column(name="updated_date")
	private String updatedDate;
	
	
	/**
	 * @return the updatedDate
	 */
	public String getUpdatedDate() {
		return updatedDate;
	}

	/**
	 * @param updatedDate the updatedDate to set
	 */
	public void setUpdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getSchemeCode() {
		return schemeCode;
	}

	public void setSchemeCode(String schemeCode) {
		this.schemeCode = schemeCode;
	}

	public String getIsinDivPayoutISINGrowth() {
		return isinDivPayoutISINGrowth;
	}

	public void setIsinDivPayoutISINGrowth(String isinDivPayoutISINGrowth) {
		this.isinDivPayoutISINGrowth = isinDivPayoutISINGrowth;
	}

	public String getIsinDivReinvestment() {
		return isinDivReinvestment;
	}

	public void setIsinDivReinvestment(String isinDivReinvestment) {
		this.isinDivReinvestment = isinDivReinvestment;
	}

	public String getSchemeName() {
		return schemeName;
	}

	public void setSchemeName(String schemeName) {
		this.schemeName = schemeName;
	}

	public String getNetAssetValue() {
		return netAssetValue;
	}

	public void setNetAssetValue(String netAssetValue) {
		this.netAssetValue = netAssetValue;
	}

	public String getRepurchasePrice() {
		return repurchasePrice;
	}

	public void setRepurchasePrice(String repurchasePrice) {
		this.repurchasePrice = repurchasePrice;
	}

	public String getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(String salePrice) {
		this.salePrice = salePrice;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((isinDivPayoutISINGrowth == null) ? 0 : isinDivPayoutISINGrowth.hashCode());
		result = prime * result + ((isinDivReinvestment == null) ? 0 : isinDivReinvestment.hashCode());
		result = prime * result + ((netAssetValue == null) ? 0 : netAssetValue.hashCode());
		result = prime * result + ((repurchasePrice == null) ? 0 : repurchasePrice.hashCode());
		result = prime * result + ((salePrice == null) ? 0 : salePrice.hashCode());
		result = prime * result + ((schemeCode == null) ? 0 : schemeCode.hashCode());
		result = prime * result + ((schemeName == null) ? 0 : schemeName.hashCode());
		result = prime * result + ((updatedDate == null) ? 0 : updatedDate.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MutualFundNav other = (MutualFundNav) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (isinDivPayoutISINGrowth == null) {
			if (other.isinDivPayoutISINGrowth != null)
				return false;
		} else if (!isinDivPayoutISINGrowth.equals(other.isinDivPayoutISINGrowth))
			return false;
		if (isinDivReinvestment == null) {
			if (other.isinDivReinvestment != null)
				return false;
		} else if (!isinDivReinvestment.equals(other.isinDivReinvestment))
			return false;
		if (netAssetValue == null) {
			if (other.netAssetValue != null)
				return false;
		} else if (!netAssetValue.equals(other.netAssetValue))
			return false;
		if (repurchasePrice == null) {
			if (other.repurchasePrice != null)
				return false;
		} else if (!repurchasePrice.equals(other.repurchasePrice))
			return false;
		if (salePrice == null) {
			if (other.salePrice != null)
				return false;
		} else if (!salePrice.equals(other.salePrice))
			return false;
		if (schemeCode == null) {
			if (other.schemeCode != null)
				return false;
		} else if (!schemeCode.equals(other.schemeCode))
			return false;
		if (schemeName == null) {
			if (other.schemeName != null)
				return false;
		} else if (!schemeName.equals(other.schemeName))
			return false;
		if (updatedDate == null) {
			if (other.updatedDate != null)
				return false;
		} else if (!updatedDate.equals(other.updatedDate))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "MutualFundNav [id=" + id + ", schemeCode=" + schemeCode + ", isinDivPayoutISINGrowth="
				+ isinDivPayoutISINGrowth + ", isinDivReinvestment=" + isinDivReinvestment + ", schemeName="
				+ schemeName + ", netAssetValue=" + netAssetValue + ", repurchasePrice=" + repurchasePrice
				+ ", salePrice=" + salePrice + ", date=" + date + ", updatedDate=" + updatedDate + "]";
	}

	
}
