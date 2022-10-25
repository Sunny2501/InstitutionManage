package allbatches;

import java.sql.Time;

public class batchBean
{
	String B_name;
	String Sdate;
	String Stime;
	int Tseats;
	int Booked;
	String Fee;
	
	public batchBean() {}
	
	public batchBean(String b_name, String sdate, String stime, int tseats, int booked, String fee)
	{
		super();
		this.B_name = b_name;
		this.Sdate = sdate;
		this.Stime = stime;
		this.Tseats = tseats;
		this.Booked = booked;
		this.Fee = fee;
	}
	
	
	public String getB_name() {
		return B_name;
	}
	public void setB_name(String b_name) {
		B_name = b_name;
	}
	public String getSdate() {
		return Sdate;
	}
	public void setSdate(String sdate) {
		Sdate = sdate;
	}
	public String getStime() {
		return Stime;
	}
	public void setStime(String stime) {
		Stime = stime;
	}
	public int getTseats() {
		return Tseats;
	}
	public void setTseats(int tseats) {
		Tseats = tseats;
	}
	public int getBooked() {
		return Booked;
	}
	public void setBooked(int booked) {
		Booked = booked;
	}
	public String getFee() {
		return Fee;
	}
	public void setFee(String fee) {
		Fee = fee;
	}
	
	
}
