# encoding: UTF-8

class EneParameterRange :
    #股票代号
    #code=''
    #上限的最高值
    #upperMax=0
    #上限的最低值
    #upperMin=0
    #下限的最高值
    #lowerMax=0
    #下限的最低值
    #lowerMin=0
    #天数的最高值
    #daysMax=0
    #天数的最低值
    #daysMin=0
    def getCode(self) :
        return self.code
    
    def setCode(self,code) :
        self.code = code
    
    def getUpperMax(self) :
        return self.upperMax;
    
    def setUpperMax(self,upperMax) :
        self.upperMax = upperMax
    
    def getUpperMin(self) :
        return self.upperMin
    
    def setUpperMin(self,upperMin) :
        self.upperMin = upperMin
    
    def getLowerMax(self) :
        return self.lowerMax
    
    def setLowerMax(self,lowerMax) :
        self.lowerMax = lowerMax
    
    def getLowerMin(self) :
        return self.lowerMin
    
    def setLowerMin(self,lowerMix) :
        self.lowerMin = lowerMix
    
    def getDaysMax(self) :
        return self.daysMax
    
    def setDaysMax(self,daysMax) :
        self.daysMax = daysMax
    
    def getDaysMin(self) :
        return self.daysMin;
    
    def setDaysMin(self,daysMin) :
        self.daysMin = daysMin
    
