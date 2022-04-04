package java_11;

import java.io.Serializable;

public class Friend  implements Serializable{
	private String name;
	private String birth;
	private String addr;
	private String tel;
	//getter
	public String getName() {
		return name;
	}
	public String getBirth() {
		return birth;
	}
	public String getAddr() {
		return addr;
	}
	public String getTel() {
		return tel;
	}
	//setter
	public void setName(String name) {
		this.name = name;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	@Override
	public String toString() {
		return "[이름 =" + name + ", "
				+ "생일 =" + birth + ", "
				+ "전화번호 =" + addr + ", "
				+ "주소 =" + tel + "]";
	}
}


