package com.neuedu.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SystemTime {
	public static String hour() {
		//获取系统当前时间
		Date date=new Date();
		//设置系统当前时间格式
		SimpleDateFormat sdf=new SimpleDateFormat("HH");
		//时间格式转化
		String timeHour=sdf.format(date);
		int timeHourNum=Integer.parseInt(timeHour);
		if(timeHourNum>=0&&timeHourNum<11) {
			String time="上午好";
			return time;
		}else if(timeHourNum>=11&&timeHourNum<=12) {
			String time="中午好";
			return time;
		}else if(timeHourNum>12&&timeHourNum<=17){
			String time="下午好";
			return time;
		}else {
			String time="晚上好";
			return time;
		}
		
	}
}
