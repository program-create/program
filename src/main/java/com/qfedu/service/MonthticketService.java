package com.qfedu.service;


import java.util.List;
import java.util.Map;

public interface MonthticketService {


    boolean saveMonthticket(int bookid, int votename, int uid);

    List<Map<String, Object>> queryLastMonthticket(int param);

    List<Map<String, Object>> queryCurrentMonthticket(int param);

}
