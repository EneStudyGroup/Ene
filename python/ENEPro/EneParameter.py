# encoding: UTF-8
class EneParameter:
    #股票代号
    #code=''
    #ENE指标上限
    #upper=0
    #ENE指标下限
    #lower=0
    #ENE天数
    #days=0
    
    def getUpper(self) :
        return self.upper
    
    def setUpper(self,upper) :
        self.upper = upper
    
    def getLower(self) :
        return self.lower
    
    def setLower(self,lower) :
        self.lower = lower
    
    def getDays(self) :
        return self.days
    
    def setDays(self,days) :
        self.days = days
    
    def getCode(self) :
        return self.code
    
    def setCode(self,code) :
        self.code = code
    