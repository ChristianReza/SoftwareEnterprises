package datamodels.dtos;

import datamodels.interfaces.Blacklist;

public class BlacklistDTO implements Blacklist{
	
	private String site;
	
	private int reports;

	@Override
	public String getReportedSite() {
		return this.site;
	}

	@Override
	public int getNumReports() {
		return this.reports;
	}

	public int setNumReports() {
		return reports;
	}

	public void setReportedSite(int reports) {
		this.reports = reports;
	}
	
	// May need a method to bump reports by one as well as a setter if a site was wrongfully blocked

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + reports;
		result = prime * result + ((site == null) ? 0 : site.hashCode());
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
		BlacklistDTO other = (BlacklistDTO) obj;
		if (reports != other.reports)
			return false;
		if (site == null) {
			if (other.site != null)
				return false;
		} else if (!site.equals(other.site))
			return false;
		return true;
	}
	
	

}
