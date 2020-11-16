package datamodels.entities;

import datamodels.interfaces.Blacklist;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import java.util.Objects;

@Entity
@Table(name = "BLACKLIST")
public class BlacklistEntity implements Blacklist{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;

	@Column(name = "SITE")
	private String site;

	@Column(name = "REPORTS")
	private int reports;
	
	public BlacklistEntity() {
		// Default Constructor
	}

	public BlacklistEntity(String site) {
		this.site = site;
		this.reports = 1;
	}

	public Integer getId() {
		return id;
	}

	@Override
	public String getReportedSite() {
		return this.site;
	}

	@Override
	public int getNumReports() {
		return this.reports;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int setNumReports() {
		return reports;
	}

	public void setReportedSite(int reports) {
		this.reports = reports;
	}
	
	public void bumpReports() {
		reports++;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		BlacklistEntity that = (BlacklistEntity) o;
		return reports == that.reports &&
				Objects.equals(id, that.id) &&
				Objects.equals(site, that.site);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, site, reports);
	}
}
