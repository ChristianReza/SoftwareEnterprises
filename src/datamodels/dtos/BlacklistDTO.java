package datamodels.dtos;

import datamodels.interfaces.Blacklist;

import java.util.Objects;

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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		BlacklistDTO that = (BlacklistDTO) o;
		return reports == that.reports &&
				Objects.equals(site, that.site);
	}

	@Override
	public int hashCode() {
		return Objects.hash(site, reports);
	}
}
