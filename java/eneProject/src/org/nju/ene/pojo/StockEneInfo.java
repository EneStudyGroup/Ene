package org.nju.ene.pojo;

import java.util.Date;

public class StockEneInfo {
	//��Ʊ�Ĵ���
	private String code;
	//��Ʊ������
	private Date date;
	//��Ʊ����߼�
	private double high;
	//��Ʊ����ͼ�
	private double low;
	//��Ʊ�Ŀ��̼�
	private double open;
	//��Ʊ�����̼�
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