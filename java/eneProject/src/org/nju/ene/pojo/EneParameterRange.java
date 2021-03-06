package org.nju.ene.pojo;

public class EneParameterRange {
	//股票代号
	private String code;
	//上限的最高值
	private int upperMax;
	//上限的最低值
	private int upperMin;
	//下限的最高值
	private int lowerMax;
	//下限的最低值
	private int lowerMin;
	//天数的最高值
	private int daysMax;
	//天数的最低值
	private int daysMin;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public int getUpperMax() {
		return upperMax;
	}
	public void setUpperMax(int upperMax) {
		this.upperMax = upperMax;
	}
	public int getUpperMin() {
		return upperMin;
	}
	public void setUpperMin(int upperMin) {
		this.upperMin = upperMin;
	}
	public int getLowerMax() {
		return lowerMax;
	}
	public void setLowerMax(int lowerMax) {
		this.lowerMax = lowerMax;
	}
	public int getLowerMin() {
		return lowerMin;
	}
	public void setLowerMin(int lowerMix) {
		this.lowerMin = lowerMix;
	}
	public int getDaysMax() {
		return daysMax;
	}
	public void setDaysMax(int daysMax) {
		this.daysMax = daysMax;
	}
	public int getDaysMin() {
		return daysMin;
	}
	public void setDaysMin(int daysMin) {
		this.daysMin = daysMin;
	}
	
	
}
