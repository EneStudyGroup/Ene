package org.nju.ene.test;

import java.util.ArrayList;

import org.nju.ene.pojo.EneParameter;
import org.nju.ene.pojo.EneParameterRange;
import org.nju.ene.util.EneQuotaUtil;

public class EneTest {
	public static void main(String[] args){
		EneParameter ene = new EneParameter();
		ene.setDays(10);
		ene.setLower(9);
		ene.setUpper(11);
		ene.setCode("sh600011");
		System.out.println(EneQuotaUtil.getStandardFrequency(ene));
//		EneParameterRange range = new EneParameterRange();
//		range.setCode("sh600011");
//		range.setDaysMax(11);
//		range.setDaysMin(9);
//		range.setUpperMax(12);
//		range.setUpperMin(10);
//		range.setLowerMax(10);
//		range.setLowerMin(8);
//		EneQuotaUtil.getOptimumParameter(range);
	}

}