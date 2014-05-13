package model.reports;

//import java.util.Calendar;
import java.util.Date;
//import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.TableGenerator;

@Entity(name="USER_REPORT") 
@TableGenerator(name="userReportGen",pkColumnName="key",pkColumnValue="ID_user_report",initialValue=0,table="counters",valueColumnName="value")
public class UserReport {
	
	@Id @Column(name="ID_user_report")
	@GeneratedValue(strategy=GenerationType.TABLE, generator="userReportGen") 
	private int ID_user_report;
	
	@Column(name="date")
	private Date date;
	
	@Column(name="females")
	private int females;
	
	@Column(name="males")
	private int males;
	
	@Column(name="midAge")
	private int midAge;
	
	@Column(name="old")
	private int old;
	
	@Column(name="young")
	private int young;
	
	
	
	public void prova(){
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		System.out.println(sdf.format(date));
	}



	public int getID_user_report() {
		return ID_user_report;
	}



	public void setID_user_report(int user_reportID) {
		this.ID_user_report = user_reportID;
	}



	public Date getDate() {
		return date;
	}



	public void setDate(Date date) {
		this.date = date;
	}



	public int getFemales() {
		return females;
	}



	public void setFemales(int females) {
		this.females = females;
	}



	public int getMales() {
		return males;
	}



	public void setMales(int males) {
		this.males = males;
	}



	public int getMidAge() {
		return midAge;
	}



	public void setMidAge(int midAge) {
		this.midAge = midAge;
	}



	public int getOld() {
		return old;
	}



	public void setOld(int old) {
		this.old = old;
	}



	public int getYoung() {
		return young;
	}



	public void setYoung(int young) {
		this.young = young;
	}
}
