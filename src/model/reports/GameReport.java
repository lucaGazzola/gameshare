package model.reports;

import java.util.Date;

import javax.persistence.*;

@Entity(name="GAME_REPORT") 
@TableGenerator(name="gameReportGen",pkColumnName="key",pkColumnValue="ID_game_report",initialValue=0,table="counters",valueColumnName="value")
public class GameReport {
	
	@Id @Column(name="ID_game_report")
	@GeneratedValue(strategy=GenerationType.TABLE, generator="gameReportGen")
	private long ID_game_report;
	
	@Temporal(TemporalType.DATE)
	@Column(name="date")
	private Date date;
	
	@Column(name="publishedGames")
	private int publishedGames;
	
	@Column(name="submittedGames")
	private int submittedGames;

	public long getID_game_report() {
		return ID_game_report;
	}

	public void setID_game_report(long game_reportID) {
		this.ID_game_report = game_reportID;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getPublishedGames() {
		return publishedGames;
	}

	public void setPublishedGames(int publishedGames) {
		this.publishedGames = publishedGames;
	}

	public int getSubmittedGames() {
		return submittedGames;
	}

	public void setSubmittedGames(int submittedGames) {
		this.submittedGames = submittedGames;
	}

}
