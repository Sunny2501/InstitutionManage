package payment;

public class PaymentBean 
{
	String tid;
	String name;
	String mobile;
	String college;
	String sem;
	String branch;
	String tech;
	int totalfee;
	int adv;
	float bal;
	String pmode;
	
	public PaymentBean(String tid, String name, String mobile, String college, String sem, String branch, String tech, int totalfee, int adv, float bal, String pmode) 
	{
		super();
		this.tid = tid;
		this.name = name;
		this.mobile = mobile;
		this.college = college;
		this.sem = sem;
		this.branch = branch;
		this.tech = tech;
		this.totalfee = totalfee;
		this.adv = adv;
		this.bal = bal;
		this.pmode = pmode;
	}
	
	
	public String getTid() {
		return tid;
	}
	public void setTid(String tid) {
		this.tid = tid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getCollege() {
		return college;
	}
	public void setCollege(String college) {
		this.college = college;
	}
	public String getSem() {
		return sem;
	}
	public void setSem(String sem) {
		this.sem = sem;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getTech() {
		return tech;
	}
	public void setTech(String tech) {
		this.tech = tech;
	}
	public int getTotalfee() {
		return totalfee;
	}
	public void setTotalfee(int totalfee) {
		this.totalfee = totalfee;
	}
	public int getAdv() {
		return adv;
	}
	public void setAdv(int adv) {
		this.adv = adv;
	}
	public float getBal() {
		return bal;
	}
	public void setBal(float bal) {
		this.bal = bal;
	}
	public String getPmode() {
		return pmode;
	}
	public void setPmode(String pmode) {
		this.pmode = pmode;
	}
	
}
