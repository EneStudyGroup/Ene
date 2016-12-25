# -*- coding: UTF-8 -*- 
'''
Created on 2016年12月21日

@author: Administrator
'''
from EneParameter import EneParameter
from StockEneInfo import StockEneInfo
from CommonUtil import CommonUtil
from MySQLUtil import MySQLUtil
from EneParameterRange import EneParameterRange
class EneQuotaUtil :
    
    global INFOLIST
    INFOLIST=[]
    '''
     * 获取一个股票在指定ENE参数内的适宜程度
     * 
     * @param eneParameter
     *            ENE参数
     * @return 适宜程度
    '''
    def get_Standard_Frequency(self,eneParam):
        times = 0
        mysqlutil = MySQLUtil()
        INFOLIST.extend(mysqlutil.getStockEneInfos(eneParam.getCode())) 
        length = len(INFOLIST);
#         print(length)
        
        for i in range(length):
            index = length -1 - i
            info = INFOLIST[index]
            avgClose = self.getAvgClose(info,index,eneParam.getDays())
            
            upper = self.getUpperIndex(eneParam.getUpper(),avgClose)
            lower = self.getLowerIndex(eneParam.getLower(),avgClose)
#             print(upper)
            if info.getHigh() <= upper and info.getLow() >= lower:
                times=times+1
       
        frequency = float(times)/length
        # lengthprint frequency
        return frequency
    
    
    '''
     * 获取一个股票最适宜的ENE参数
     * 
     * @param stockCode
     *            股票代号
     * @return 最适宜的ENE参数
    '''
    def get_Optimum_Param(self,r):
        frequencyList = []
        paramList = []
        for i in range(r.getUpperMin(),r.getUpperMax()+1):
            for j in range(r.getLowerMin(),r.getLowerMax()+1):
                for k in range(r.getDaysMin(),r.getDaysMax()+1):
                    # print str(i)+"---"+str(j)+"---"+str(k)
                    param = EneParameter()
                    param.setCode(r.getCode())
                    param.setDays(k)
                    param.setLower(j)
                    param.setUpper(i)
                    frequency = self.get_Standard_Frequency(param)
                    # print frequency
                    frequencyList.append(frequency)
                    paramList.append(param)
            
        commonutil = CommonUtil()
        indexList = commonutil.getArrayListMax(frequencyList)
        optimumParamList = []
        for index in indexList:
            param = paramList[index]
            optimumParamList.append(param)
            print(frequencyList[index])
            print(param.getCode())
            print(param.getUpper())
            print(param.getLower())
            print(param.getDays())
            print '---------------------------'
        return optimumParamList
        
    '''
     * 获取ENE指标上限
     * 
     * @param upper
     *            偏移程度
     * @param avgClose
     *            平均收盘价
     * @return
    '''
    def getUpperIndex(self,upper,avgClose) :
        floatDegree = float(upper)/100
        upperIndex = (1 + floatDegree) * avgClose
        return upperIndex

    '''
     * 获取ENE指标下限
     * 
     * @param lower
     *            偏移程度
     * @param avgClose
     *            平均收盘价
     * @return
    '''
    def getLowerIndex(self,lower,avgClose) :
        floatDegree = float(lower)/100
        lowerIndex = (1 - floatDegree) * avgClose
        return lowerIndex
    
    '''
     * 获取n天股票收盘价的均值
     * 
     * @param stockEneInfo
     *            股票数据
     * @param index
     *            股票数据在股票数据集合中的下标
     * @param days
     *            n天
     * @return 收盘价均值
    '''
    def getAvgClose(self,stockEneInfo, index, days) :
        date = stockEneInfo.getDate()
        commonUtil=CommonUtil()
        dateBefore=commonUtil.getDaysAfter(date, -days)
        closeList=[]
        allClose=0.0
#         print(len(INFOLIST))
        for i in range(0,days) :
            infoBefore=StockEneInfo()
            if index >= i :
                infoBefore = INFOLIST[index - i]    
            else :
                break
            
            if infoBefore.getDate()>= dateBefore :
                closeList.append(infoBefore.getClose());
        
        for close in closeList:
            allClose += close
        
        avgClose = allClose / len(closeList)
        return avgClose    


# p = EneQuotaUtil()
# eneparam = EneParameterRange()
# eneparam.setCode("sh600011")
# eneparam.setDaysMax(11)
# eneparam.setDaysMin(9)
# eneparam.setLowerMax(10)
# eneparam.setLowerMin(8)
# eneparam.setUpperMax(12)
# eneparam.setUpperMin(10)
# p.get_Optimum_Param(eneparam)







