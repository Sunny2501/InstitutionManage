package studentgoogler;

public class StudentBean 
{
	String tid;
	String name;
	String mobile;
	String college;
	String sem;
	String branch;
	String tech;
	String picpath;
	
	public StudentBean() {}

	public StudentBean(String tid, String name, String mobile, String college, String sem, String branch, String tech, String picpath) 
	{
		super();
		this.tid = tid;
		this.name = name;
		this.mobile = mobile;
		this.college = college;
		this.sem = sem;
		this.branch = branch;
		this.tech = tech;
		this.picpath = picpath;
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

	public String getPicpath() {
		return picpath;
	}

	public void setPicpath(String picpath) {
		this.picpath = picpath;
	}
	
}
