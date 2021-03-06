package org.nju.ene.util;

import java.util.Date;
import java.util.ArrayList;

import org.nju.ene.pojo.EneParameter;
import org.nju.ene.pojo.EneParameterRange;
import org.nju.ene.pojo.StockEneInfo;

public class EneQuotaUtil {
	private static ArrayList<StockEneInfo> infoList;
	private static EneParameter parameter;

	/**
	 * 获取一个股票在指定ENE参数内的适宜程度
	 * 
	 * @param eneParameter
	 *            ENE参数
	 * @return 适宜程度
	 */
	public static double getStandardFrequency(EneParameter eneParameter) {
		int times = 0;
		double frequency = 0;
		infoList = MySQLUtil.getStockEneInfos(eneParameter.getCode());
		int length = infoList.size();
	//	System.out.println(length);
		
		for(int i=0;i<length;i++){
			int index = length - 1 - i;
			StockEneInfo info = infoList.get(index);
			double avgClose = getAvgClose(info, index, eneParameter.getDays());
			double upper = getUpperIndex(eneParameter.getUpper(), avgClose);
			double lower = getLowerIndex(eneParameter.getLower(), avgClose);
		//	System.out.println(avgClose+": "+upper+": "+info.getHigh()+": "+lower+": "+info.getLow());
			if(info.getHigh()<=upper && info.getLow()>=lower)
				times++;
		}
		//System.out.println(times);
		frequency = (double)times/length;
		return frequency;
	}

	/**
	 * 获取一个股票最适宜的ENE参数
	 * 
	 * @param stockCode
	 *            股票代号
	 * @return 最适宜的ENE参数
	 */
	public static ArrayList<EneParameter> getOptimumParameter(EneParameterRange range) {
		ArrayList<Double> frequencyList = new ArrayList<>();
		ArrayList<EneParameter> parameterList = new ArrayList<>();
		for(int i=range.getUpperMin();i<=range.getUpperMax();i++){
			for(int j=range.getLowerMin();j<=range.getLowerMax();j++){
				for(int k=range.getDaysMin();k<=range.getDaysMax();k++){
					EneParameter parameter = new EneParameter();
					parameter.setCode(range.getCode());
					parameter.setDays(k);
					parameter.setLower(j);
					parameter.setUpper(i);
					double frequecy = getStandardFrequency(parameter);
					frequencyList.add(frequecy);
					parameterList.add(parameter);
					System.out.println(k+"---"+j+"---"+i);
				}
			}
		}
		ArrayList<Integer> indexList = CommonUtil.getArrayListMax(frequencyList);
		ArrayList<EneParameter> optimumParameterList = new ArrayList<>();
		for(int index: indexList){
			EneParameter parameter = parameterList.get(index);
			optimumParameterList.add(parameterList.get(index));
			System.out.println(frequencyList.get(index));
			System.out.println(parameter.getCode()+"------ upper: "+parameter.getUpper()+"---- lower: "+parameter.getLower()+"---- days: "+parameter.getDays());
		}
		return optimumParameterList;
	}

	/**
	 * 获取ENE指标上限
	 * 
	 * @param upper
	 *            偏移程度
	 * @param avgClose
	 *            平均收盘价
	 * @return
	 */
	private static double getUpperIndex(int upper, double avgClose) {
		double floatDegree = (double)upper / 100;
	//	System.out.println("float: "+floatDegree);
		double upperIndex = (1 + floatDegree) * avgClose;
	//	System.out.println("avg: "+avgClose+"Upper: "+upperIndex);
		return upperIndex;
	}

	/**
	 * 获取ENE指标下限
	 * 
	 * @param lower
	 *            偏移程度
	 * @param avgClose
	 *            平均收盘价
	 * @return
	 */
	private static double getLowerIndex(int lower, double avgClose) {
		double floatDegree = (double)lower / 100;
		double lowerIndex = (1 - floatDegree) * avgClose;
		return lowerIndex;
	}

	/**
	 * 获取n天股票收盘价的均值
	 * 
	 * @param stockEneInfo
	 *            股票数据
	 * @param index
	 *            股票数据在股票数据集合中的下标
	 * @param days
	 *            n天
	 * @return 收盘价均值
	 */
	private static double getAvgClose(StockEneInfo stockEneInfo, int index, int days) {
		Date date = stockEneInfo.getDate();
//		System.out.println(index+"----"+date);
		Date dateBefore = CommonUtil.getDaysAfter(date, -days);
		ArrayList<Double> closeList = new ArrayList<>();
		double allClose = 0;

		for (int i = 0; i < days; i++) {
			StockEneInfo infoBefore = null;
			if (index >= i) {
				infoBefore = infoList.get(index - i);	
			}else{
				break;
			}
		//	System.out.print(date+"------"+infoBefore.getDate() +"------"+dateBefore+"/////");
			if (infoBefore.getDate().getTime() >= dateBefore.getTime()) {
		//		System.out.println(date+"------"+infoBefore.getDate() +"------"+dateBefore);
		//		System.out.println(infoBefore.getClose());
				closeList.add(infoBefore.getClose());
			}
		}

		for (double close : closeList) {
			allClose += close;
		}
		double avgClose = allClose / closeList.size();
	//	System.out.println(allClose+"---"+avgClose);
		return avgClose;
	}
}
