package main.datamodels.dtos;

import java.util.Objects;

import main.datamodels.interfaces.Blacklist;

public class BlacklistDTO implements Blacklist {
	
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

	public void setNumReports(int num) {
		this.reports = num;
	}

	public void setReportedSite(String site) {
		this.site = site;
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
