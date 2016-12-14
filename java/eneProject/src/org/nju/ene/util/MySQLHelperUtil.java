package org.nju.ene.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MySQLHelperUtil {
	
	/**
	 * 将股票代号转为数据库表StocksKInfo0-9的表名
	 * 
	 * @param stockCode 股票代号
	 * @return 数据库表StocksKInfo0-9的表名
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
