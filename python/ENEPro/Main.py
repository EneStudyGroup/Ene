#-*- coding:utf-8 -*-
from EneQuotaUtil import EneQuotaUtil
from EneParameter import EneParameter
from EneParameterRange import EneParameterRange

if __name__ == '__main__':
    ene_quato = EneQuotaUtil()
    ene = EneParameterRange()
    ene.setDaysMin(8)
    ene.setDaysMax(10)
    ene.setLowerMin(8)
    ene.setLowerMax(10)
    ene.setUpperMin(10)
    ene.setUpperMax(12)
    ene.setCode('sh600011')
    ene_quato.get_Optimum_Param(ene)