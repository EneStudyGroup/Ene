package org.nju.ene.pojo;

public class EneParameter {
	//股票代号
	private String code;
	//ENE指标上限
	private int upper;
	//ENE指标下限
	private int lower;
	//ENE天数
	private int days;
	
	public int getUpper() {
		return upper;
	}
	public void setUpper(int upper) {
		this.upper = upper;
	}
	public int getLower() {
		return lower;
	}
	public void setLower(int lower) {
		this.lower = lower;
	}
	public int getDays() {
		return days;
	}
	public void setDays(int days) {
		this.days = days;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
}
