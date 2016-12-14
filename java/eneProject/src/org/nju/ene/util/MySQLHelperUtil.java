package org.nju.ene.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MySQLHelperUtil {
	
	/**
	 * ����Ʊ����תΪ���ݿ��StocksKInfo0-9�ı���
	 * 
	 * @param stockCode ��Ʊ����
	 * @return ���ݿ��StocksKInfo0-9�ı���
	 */
	public static String getStocksKInfoTableName(String stockCode){
		Pattern p = Pattern.compile("[0-9]");
		Matcher m = p.matcher(stockCode);
		
		String tableName = "StocksKInfo";
		long code = 0;
		while(m.find()){
			code = Long.parseLong(m.group());
		}
		String index = String.valueOf(code%10);
		tableName += index;
		
		return tableName;
	}
}
