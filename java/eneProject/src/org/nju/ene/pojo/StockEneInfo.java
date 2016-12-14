package org.nju.ene.pojo;

import java.util.Date;

public class StockEneInfo {
	//股票的代号
	private String code;
	//股票的日期
	private Date date;
	//股票的最高价
	private double high;
	//股票的最低价
	private double low;
	//股票的开盘价
	private double open;
	//股票的收盘价
	private double close;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public double getHigh() {
		return high;
	}
	public void setHigh(double high) {
		this.high = high;
	}
	public double getLow() {
		return low;
	}
	public void setLow(double low) {
		this.low = low;
	}
	public double getOpen() {
		return open;
	}
	public void setOpen(double open) {
		this.open = open;
	}
	public double getClose() {
		return close;
	}
	public void setClose(double close) {
		this.close = close;
	}
}
