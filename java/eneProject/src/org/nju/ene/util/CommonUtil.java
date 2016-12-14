package org.nju.ene.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class CommonUtil {
	/**
	 * 将java.sql.Date类型转换为java.util.Date类型
	 * 
	 * @param date
	 * @return java.util.Date
	 */
	public static Date transformDate(java.sql.Date date) {
		Date utilDate = new Date(date.getTime());
		return utilDate;
	}

	/**
	 * 获取指定日期前后n天日期
	 * 
	 * @param date
	 *            指定日期
	 * @param days
	 *            n天
	 * @return 日期
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
	 * 获得一个ArrayList<Double>型中的最大值的位置
	 * 
	 * @param list
	 *            列表集合
	 * @return 位置集合
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
