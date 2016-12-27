#-*- coding:utf-8 -*-
import MySQLdb
from MySQLHelperUtil import MySQLHelperUtil
from StockEneInfo import StockEneInfo

class MySQLUtil():
    '''获取数据库的连接'''
    def getConnection(self):
        connection=False
        try:
            connection = MySQLdb.connect(host="121.42.143.164",port=3306,user="admin",passwd="NJU2016",db="stock",charset="utf8")
            print "connect database successfully" 
        except Exception, data: 
            connection=False 
            print "connect database failed, %s" % data  
        return connection
    
    '''释放数据库连接'''
    def releaseConnection(self,connection):
        if connection!=False:
            connection.close()
            
    def getStockEneInfos(self,stockCode):
        stockEneInfos = []
        helper = MySQLHelperUtil()
        stockName = helper.getStockInfoTableName(stockCode)
        connection = self.getConnection()
        cursor = connection.cursor()
        sql = "select * from " + stockName + " where code='%s'" %stockCode
        
        try:
            cursor.execute(sql)
            results = cursor.fetchall()
            for row in results:
                code = row[0]
                date = row[1]
                high = row[3]
                low = row[5]
                open = row[2]
                close = row[4]
                stockEneInfo = StockEneInfo()
                stockEneInfo.setCode(code)
                stockEneInfo.setDate(date)
                stockEneInfo.setHigh(high)
                stockEneInfo.setLow(low)
                stockEneInfo.setOpen(open)
                stockEneInfo.setClose(close)
                stockEneInfos.append(stockEneInfo)
        except:
            print "Error: unable to fecth data"
        self.releaseConnection(connection)
        return stockEneInfos
#         print stockEneInfos[0].getDate()
# p=MySQLUtil()
# p.getStockEneInfos("sh600011")
