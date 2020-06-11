package bean;

public class User {
	private int id;
	private String xi;
	private String qudui;
	private String username;
	private String sno;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getXi() {
		return xi;
	}
	public void setXi(String xi) {
		this.xi = xi;
	}
	public String getQudui() {
		return qudui;
	}
	public void setQudui(String qudui) {
		this.qudui = qudui;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getSno() {
		return sno;
	}
	public void setSno(String sno) {
		this.sno = sno;
	}
	public User(int id, String xi, String qudui, String username, String sno) {
		super();
		this.id = id;
		this.xi = xi;
		this.qudui = qudui;
		this.username = username;
		this.sno = sno;
	}
	public User() {
		super();
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", xi=" + xi + ", qudui=" + qudui + ", username=" + username + ", sno=" + sno + "]";
	}
	
}
