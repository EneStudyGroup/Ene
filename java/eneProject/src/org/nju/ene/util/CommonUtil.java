package org.nju.ene.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class CommonUtil {
	/**
	 * ��java.sql.Date����ת��Ϊjava.util.Date����
	 * 
	 * @param date
	 * @return java.util.Date
	 */
	public static Date transformDate(java.sql.Date date) {
		Date utilDate = new Date(date.getTime());
		return utilDate;
	}

	/**
	 * ��ȡָ������ǰ��n������
	 * 
	 * @param date
	 *            ָ������
	 * @param days
	 *            n��
	 * @return ����
	 */
	public static Date getDaysAfter(Date date, int days) {
		// SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, days);
		Date date1 = calendar.getTime();
		return date1;
	}

	/**
	 * ���һ��ArrayList<Double>���е����ֵ��λ��
	 * 
	 * @param list
	 *            �б�����
	 * @return λ�ü���
	 */
	public static ArrayList<Integer> getArrayListMax(ArrayList<Double> list) {
		ArrayList<Integer> indexList = new ArrayList<>();
		double max = 0.0;
		for (int i = 0; i < list.size(); i++) {
			double temp = list.get(i);
			if (temp > max) {
				indexList.clear();
				max = temp;
				indexList.add(i);
			}
			else if(temp == max){
				max = temp;
				indexList.add(i);
			}
		}
		return indexList;
	}
}