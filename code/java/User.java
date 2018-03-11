package test3;

public class User{


	public String username;
	public String pwd;

	public String nickname;
	public String skill;
	public String signature;

	public String getUsername(){
		return this.username;
	}

	public void setUsername(String username){
		this.username = username;
	}

	public String getPwd(){
		return this.pwd;
	}

	public void setPwd(String pwd){
		this.pwd = pwd;
	}


	public String getSkill(){
		return this.skill;
	}
	public void setSkill(String skill){
		this.skill = skill;
	}	

	public String getNickname(){
		return this.nickname;
	}

	public void setNickname(String nickname){
		this.nickname = nickname;
	}	


	public String getSignature(){
		return this.signature;
	}

	public void setSignature(String signature){
		this.signature = signature;
	}

}