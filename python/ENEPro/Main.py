#-*- coding:utf-8 -*-
from EneQuotaUtil import EneQuotaUtil
from EneParameter import EneParameter
from EneParameterRange import EneParameterRange

if __name__ == '__main__':
    ene_quato = EneQuotaUtil()
    ene = EneParameter()
    ene.set_code('sh600011')
    ene.set_days(10)
    ene.set_upper(11)
    ene.set_lower(9)
    ene.set_end_date('2016-6-6')
    ene.set_start_date('2015-6-6')
    # ene = EneParameterRange()
    # ene.set_days_min(8)
    # ene.set_days_max(10)
    # ene.set_lower_min(8)
    # ene.set_lower_max(10)
    # ene.set_upper_min(10)
    # ene.set_upper_max(12)
    # ene.set_end_date(2016,6,6)
    # ene.set_start_date(2015,6,6)
    # ene.set_code('sh600011')
#     ene_quato.getAllStocksParam()

    ene_quato.get_profit(ene, 10000, 10, 10, 10)