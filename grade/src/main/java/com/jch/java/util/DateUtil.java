package com.jch.java.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.TimeZone;

import org.apache.log4j.Logger;

public class DateUtil {
    /**
     * Logger for this class
     */
    private static final Logger logger = Logger.getLogger(DateUtil.class);

    /**
     * 年月日时分秒 返回String类型
     */
    public static String Symdhms() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String str = sdf.format(new Date());
        return str;
    }

    /**
     * 年月日时分秒 返回Timestamp类型
     */
    public static Timestamp Tymdhms() {
        return Timestamp.valueOf(DateUtil.Symdhms());
    }

    /**
     * 年月日 返回String类型
     */
    public static String Symd() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String str = sdf.format(new Date());
        return str;
    }

    /**
     * 年月日 返回Date类型
     */
    public static Date Dymd() {
        return DateUtil.stringToDate(DateUtil.Symd());
    }
    
    /**
     * 年月 返回字符串类型
     * description:
     *
     * @author jiachenghao	
     * @return
     */
    public static String SymdMonth() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        String str = sdf.format(new Date());
        return str;
    }

//    //年月日小时分钟秒返回 date 类型
//    public static Date Dateymdhms() {
//        Date endDate = null;
//        try {
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//            Calendar date = Calendar.getInstance();
//            date.setTime(new Date());
//            date.set(Calendar.DATE, date.get(Calendar.DATE));
//            endDate = sdf.parse(sdf.format(date.getTime()));
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        return endDate;
//    }
//
//    public static String Sdatetring(Date sdate) throws Exception {
//        String sDate = null;
//        try {
//            //SimpleDateFormat sdf = new SimpleDateFormat (sdate,Locale.US);
//            //Date date=sdf.parse(sdate);
//            SimpleDateFormat sdff = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//            sDate = sdff.format(sdate);
//            //System.out.println("时间日期字符转换:"+sDate);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return sDate;
//    }

//    //jiachenghao 暂时解日期有.0问题
//    public static String date2str(Date date) {
//        if (date == null) {
//            return null;
//        }
//
//        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        dateformat.setTimeZone(TimeZone.getTimeZone("GMT+8"));
//
//        return dateformat.format(date);
//    }
//
//
//    //jiachenghao 暂时解日期有.0问题
//    public static String string2str(String date) {
//       String dateResult=null;
//
//    	if (date == null) {
//            return "1900-01-01 11:10:10";
//        }
//
//        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        dateformat.setTimeZone(TimeZone.getTimeZone("GMT+8"));
//
//        try {
//        	dateResult= dateformat.format(dateformat.parse(date));
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return dateResult;
//
//    }
//
//
//    //jiachenghao 暂时解日期有.0问题
//    public static String string2strdate(String date) {
//       String dateResult=null;
//
//    	if (date == null) {
//            return "1900-01-01";
//        }
//
//        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
//        dateformat.setTimeZone(TimeZone.getTimeZone("GMT+8"));
//
//        try {
//        	dateResult= dateformat.format(dateformat.parse(date));
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return dateResult;
//
//    }


//    /**
//     * date转Timestamp
//     * @param date
//     * @return
//     */
//    public static Timestamp date2Timestamp(Date date) {
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        return Timestamp.valueOf(sdf.format(date));
//    }

//    /**
//     * date必须是yyyy-MM-dd HH:mm:ss格式
//     * @param date
//     * @return
//     */
//    public static Timestamp String2Timestamp(String date) {
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Timestamp timestamp = null;
//        try {
//            timestamp = Timestamp.valueOf(sdf.format(sdf.parse(date)));
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        return timestamp;
//    }
//
//    public static Timestamp String2Timestamp2(String date) {
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
//        Timestamp timestamp = null;
//        try {
//            timestamp = Timestamp.valueOf(sdf.format(sdf.parse(date)));
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        return timestamp;
//    }
//    /**
//     * 统计两个时间之间的天数间隔，包含开始日期和截止日期
//     * @param begin_time
//     * @param end_time
//     * @eg yyyy-MM-dd
//     * @return List<String> 存放两个时间之间的每一天
//     */
//    public static List<String> dateCount1(String begin_time,String end_time){
//    	List<String> dateList = new ArrayList<>();
//    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//	  	Calendar calendar = Calendar.getInstance();
//	  	//设置截止日期
//	  	String end_date = end_time.substring(0, 10);
//	  	try {
//	  		//设置开始日期
//	  		calendar.setTime(sdf.parse(begin_time));
//	  		String date = sdf.format(calendar.getTime());
//	  		dateList.add(date);
//	  		//若开始日期不等于截止日期，则继续添加进dateList中
//	  		while(!date.equals(end_date)){
//	  			calendar.add(Calendar.DATE, + 1);
//	  		  	date = sdf.format(calendar.getTime());
//	  		  	dateList.add(date);
//	  		}
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
//    	return dateList;
//    }
//
//    /**
//     * 统计两个时间之间的天数间隔，包含开始日期和截止日期
//     * @param begin_time
//     * @param end_time 为null时默认当前月份
//     * @eg yyyy-MM-dd
//     * @return List<String> 存放两个时间之间的每一天
//     */
//    public static List<String> monthCount1(String begin_time,String end_time){
//    	List<String> dateList = new ArrayList<>();
//    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
//	  	Calendar calendar = Calendar.getInstance();
//	  	//设置截止日期
//	  	if(end_time==null){
//	  		end_time = sdf.format(new Date());
//	  	}
//	  	try {
//	  		//设置开始日期
//	  		calendar.setTime(sdf.parse(begin_time));
//	  		String date = sdf.format(calendar.getTime());
//	  		dateList.add(date);
//	  		//若开始日期不等于截止日期，则继续添加进dateList中
//	  		while(!date.equals(end_time)){
//	  			calendar.add(Calendar.MONTH, + 1);
//	  		  	date = sdf.format(calendar.getTime());
//	  		  	dateList.add(date);
//	  		}
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
//    	return dateList;
//    }
//
//    /**
//     *
//     * description: 获取指定年月的天数
//     *
//     * @author jiachenghao
//     * @param month
//     * @return
//     */
//    public static int maxDays(String month){
//    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
//    	Calendar calendar = new GregorianCalendar();
//    	Date date1;
//		try {
//			date1 = sdf.parse(month);
//			calendar.setTime(date1); //放入你的日期
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//    	return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
//    }
//
//    /**
//     * 统计两个时间之间的天数间隔，包含开始日期和截止日期
//     * @param begin_time
//     * @param end_time
//     * @eg yyyy-MM-dd HH:mm:ss
//     * @return List<String> 存放两个时间之间的每一天
//     */
//    public static List<String> dateCount2(String begin_time,String end_time){
//    	List<String> dateList = new ArrayList<>();
//    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//	  	Calendar calendar = Calendar.getInstance();
//	  	//设置截止日期
//	  	String end_date = end_time.substring(0, 10);
//	  	try {
//	  		//设置开始日期
//	  		calendar.setTime(sdf.parse(begin_time));
//	  		String date = sdf.format(calendar.getTime());
//	  		dateList.add(begin_time);
//	  		//若开始日期不等于截止日期，则继续添加进dateList中
//	  		while(!date.equals(end_date)){
//	  			calendar.add(Calendar.DATE, + 1);
//	  		  	date = sdf.format(calendar.getTime());
//	  		  	dateList.add(date+" 00:00:00");
//	  		}
//	  		if(!dateList.get(dateList.size()-1).equals(end_time)){
//	  			dateList.add(end_time);
//	  		}
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
//    	return dateList;
//    }
    

//
//    /**
//     * 获取当天的开始时间 比如2017-03-06 00:00:00
//     * @param date
//     * @return
//     */
//    public static String getTodayStartTime() {
//    	  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//    	  Calendar todayStart = Calendar.getInstance();
//          todayStart.set(Calendar.HOUR_OF_DAY, 0);
//          todayStart.set(Calendar.MINUTE, 0);
//          todayStart.set(Calendar.SECOND, 0);
//          todayStart.set(Calendar.MILLISECOND, 0);
//		  return sdf.format(todayStart.getTime());
//    }
//    /**
//     * 获取前一天的开始时间
//     * @param date
//     * @return
//     */
//    public static String getYesterdayStartTime() {
//    	  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//    	  Calendar todayStart = Calendar.getInstance();
//    	  todayStart.add(Calendar.DAY_OF_MONTH, -1);
//          todayStart.set(Calendar.HOUR_OF_DAY, 0);
//          todayStart.set(Calendar.MINUTE, 0);
//          todayStart.set(Calendar.SECOND, 0);
//          todayStart.set(Calendar.MILLISECOND, 0);
//		  return sdf.format(todayStart.getTime());
//    }
//    /**
//     * 获取前一天的时间
//     * @param date
//     * @return
//     */
//    public static String getYesterdayTime() {
//    	  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//    	  Calendar todayStart = Calendar.getInstance();
//    	  todayStart.add(Calendar.DAY_OF_MONTH, -1);
//		  return sdf.format(todayStart.getTime());
//    }
//
//    /**
//     *
//     */
//    public static String getTomorrow(String today){
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        Calendar calendar = Calendar.getInstance();
//        try {
//            calendar.setTime(sdf.parse(today));
//        } catch (ParseException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//        calendar.add(Calendar.DATE, + 1);
//        String tomorrow = sdf.format(calendar.getTime());
//        return tomorrow;
//    }
//
//
//    /**
//     * 获取N天前或N天后的日期
//     * @param n>0 N天后，n < 0 N天前
//     * @return
//     */
//    public static String getDateFrontOrBehindToday(int n) {
//  	  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//  	  Calendar todayStart = Calendar.getInstance();
//  	  todayStart.add(Calendar.DAY_OF_MONTH, n);
//	  return sdf.format(todayStart.getTime());
//    }
//
//    /**
//     * 获取月份的第一天
//     * @param date
//     * @return
//     */
//    public static String getFirstDayOfMonth(String date){
//    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//    	Calendar calendar = Calendar.getInstance();
//    	try {
//			calendar.setTime(sdf.parse(date));
//			calendar.set(Calendar.DAY_OF_MONTH, 1);
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
//    	return sdf.format(calendar.getTime());
//    }
//    /**
//     * 获取月份的最后一天
//     * @param date
//     * @return
//     */
//    public static String getLastDayOfMonth(String date){
//    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//    	Calendar calendar = Calendar.getInstance();
//    	try {
//			calendar.setTime(sdf.parse(date));
//			calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
//    	return sdf.format(calendar.getTime());
//    }
//
//    public static String getFirstDayOfYear(int year){
//    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//    	Calendar calendar = Calendar.getInstance();
//		calendar.clear();
//		calendar.set(Calendar.YEAR, year);
//    	return sdf.format(calendar.getTime());
//    }
//    public static String getLastDayOfYear(int year){
//    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//    	Calendar calendar = Calendar.getInstance();
//    	calendar.clear();
//		calendar.set(Calendar.YEAR, year);
//		calendar.roll(Calendar.DAY_OF_YEAR, -1);
//    	return sdf.format(calendar.getTime());
//    }
    
    public static Date stringToDate(String str){
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    	try {
    		 Date date = sdf.parse(str);
    		 return date;
		} catch (ParseException e) {
			e.printStackTrace();
		}
    	return null;
    }
//    /**
//     *
//     * description:获取当前月份 yyyy-MM格式
//     *
//     * @author jiachenghao
//     * @param str
//     * @return
//     */
//    public static Date string3Date(String str){
//    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
//    	try {
//    		 Date date = sdf.parse(str);
//    		 return date;
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
//    	return null;
//    }
//
//    /**
//     *
//     * description:获取当前月份的上几个月份或下几个月份
//     *
//     * @author jiachenghao
//     * @param str
//     * @param j j<0表示前几个月份，j>0表示后几个月份
//     * @return
//     */
//	public static String getBeforeMonth(String str, int j) {
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
//		Calendar calendar = Calendar.getInstance();
//		int k = 0;
//		if(j>0){
//			k = 1;
//		}else{
//			k = -1;
//		}
//		try {
//			Date date = sdf.parse(str);
//			for (int i = 0; i < Math.abs(j); i++) {
//				calendar.setTime(date);
//
//				calendar.add(Calendar.MONTH, k);
//				date = calendar.getTime();
//			}
//			String mon = sdf.format(date);
//			return mon;
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
//		return null;
//	}
//
//    public static String date2str(Date date, String format) {
//        if (date == null) {
//            return null;
//        }
//        SimpleDateFormat dateformat = new SimpleDateFormat(format);
//        return dateformat.format(date);
//    }
    
//    public static Date string2Date(String str, String format){
//    	SimpleDateFormat sdf = new SimpleDateFormat(format);
//    	try {
//    		 Date date = sdf.parse(str);
//    		 return date;
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
//    	return null;
//    }
    
//    /**
//     * 获取两个日期之间的日期-包含起始日期和结束日期
//     * @param start 开始日期
//     * @param end 结束日期
//     * @return 日期集合
//     */
//    public static List<Date> getBetweenDates(Date start, Date end) {
//        List<Date> result = new ArrayList<Date>();
//        Calendar tempStart = Calendar.getInstance();
//        tempStart.setTime(start);
//        result.add(tempStart.getTime());
//        tempStart.add(Calendar.DAY_OF_YEAR, 1);
//
//        Calendar tempEnd = Calendar.getInstance();
//        tempEnd.setTime(end);
//        while (tempStart.before(tempEnd)) {
//            result.add(tempStart.getTime());
//            tempStart.add(Calendar.DAY_OF_YEAR, 1);
//        }
//        if(!start.equals(end)){
//        	result.add(tempEnd.getTime());
//        }
//        return result;
//    }
//    /**
//     * 获取当前月份 前x个月
//     * @param x 前几个月
//     * @author shancong
//     * @return  前几个月集合
//     */
//    public static List<String> getBeforeMonth(int x){
//    	 List<String> monthList =new ArrayList<>();
// 		Calendar instance = Calendar.getInstance();
//    	 	SimpleDateFormat df=new SimpleDateFormat("yyyy-MM");
// 		   for (int i = 0; i>-x;i--) {
// 				 String month = df.format(instance.getTime());
// 				 monthList.add(month);
// 				 instance.add(Calendar.MONTH, -1);
// 			}
// 		   return monthList;
//    }
//
//    /**
//     * 获取两个日期之间的日期-包含起始日期和结束日期
//     * @param start 开始日期
//     * @param end 结束日期
//     * @return 之间的相差天数
//     */
//    public static int getBetweenDays(Date start, Date end)  {
//    	long intervalMilli = start.getTime() - end.getTime();
//    	int a = (int) (intervalMilli / (24 * 60 * 60 * 1000));
//        return a;
//    }
//
//    public static String getDateFromlong(long time){
//    	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//    	return format.format(time);
//    }
//
//    /**
//     * 根据时间段遍历每一天
//     * @author   fengyongge@ediankai.com
//     * @param startTime 开始时间
//     * @param endTime 结束时间
//     * @return 含字符串的数组list
//     */
//    public static List<String> display(String startTime, String endTime){
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        List<String> list = new ArrayList<>();
//
//        try{
//            Date dateOne = dateFormat.parse(startTime);
//            Date dateTwo = dateFormat.parse(endTime);
//            Calendar calendar = Calendar.getInstance();
//            calendar.setTime(dateOne);
//            while(calendar.getTime().before(dateTwo)){
//                list.add(dateFormat.format(calendar.getTime()));
//
//                calendar.add(Calendar.DAY_OF_MONTH, 1);
//            }
//            list.add(endTime);
//        }
//        catch(Exception e){
//            e.printStackTrace();
//        }
//        return  list;
//    }
///**
// * 获得本周 周一
// * @return
// */
//    public static String getWeekMonday() {
//   	 SimpleDateFormat formater=new SimpleDateFormat("yyyy-MM-dd");
//   	 Calendar cal=new GregorianCalendar();
//   	 cal.setFirstDayOfWeek(Calendar.MONDAY);
//   	 cal.setTime(new Date());
//   	 cal.set(Calendar.DAY_OF_WEEK, cal.getFirstDayOfWeek());
//   	 Date first=cal.getTime();
//   	 return formater.format(first);
//   }
//    //获得前一个月的26号
//    public static String getBeforeMonthBy26() {
//   	 SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd");
//   	 Calendar cld = Calendar.getInstance();
//   	 cld.set(Calendar.MONTH,cld.get(Calendar.MONTH)-1);
//    	 cld.set(Calendar.DATE,26) ;
//   	String day = sf.format(cld.getTime());
//   	 return day;
//
//   }
//    //获得本月26号
//    public static String getMonthBy26() {
//   	 SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd");
//   	 Calendar cld = Calendar.getInstance();
//    	 cld.set(Calendar.DATE,26) ;
//   	String day = sf.format(cld.getTime());
//   	 return day;
//
//   }
//    //当前时间大于等于date返回true
//    public static boolean compareDataSize(String correntDate,String date){
// 	   int correntIndex = getlastNumber(correntDate);
// 	   int endIndex = getlastNumber(date);
// 	   String correntDateStr = correntDate.substring(correntIndex+1);
// 	   String endDateStr = date.substring(endIndex+1);
// 	     if(Integer.parseInt(correntDateStr)>=Integer.parseInt(endDateStr)){
// 	    	 return true;
// 	     }
// 	   return false;
//    }
//    //获得日期最后一位数的索引
//    public static int getlastNumber(String str){
// 	   int index =-1;
// 	    if(str.contains("-")){
// 	    	index= str.lastIndexOf("-");
// 	    }
// 	   return index;
//    }
//
//    /**
//     *
//     * description:传入的月份比较
//     *
//     * @author jiachenghao
//     * @param before
//     * @param after
//     * @return before < after 返回 true，否则返回false 相等返回true
//     */
//    public static boolean compareMonth(String before, String after){
//    	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM");
//        Calendar before_month = Calendar.getInstance();
//        Calendar after_month = Calendar.getInstance();
//        try {
//			before_month.setTime(dateFormat.parse(before));
//			after_month.setTime(dateFormat.parse(after));
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
//        if(before_month.get(Calendar.YEAR) > after_month.get(Calendar.YEAR)){
//        	return false;
//        }else if(before_month.get(Calendar.MONTH) > after_month.get(Calendar.MONTH)){
//        	return false;
//        }
//    	return true;
//    }
//
//
//    /**
//     * description 传入两个时间，返回时间间隔，单位为天
//     * @author fengyongge@ediankai.com
//     * @param smdate
//     * @param bdate
//     * @return
//     */
//    public static int compareData(Date smdate,Date bdate){
//        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
//        try {
//            smdate=sdf.parse(sdf.format(smdate));
//            bdate=sdf.parse(sdf.format(bdate));
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        Calendar cal = Calendar.getInstance();
//        cal.setTime(smdate);
//        long time1 = cal.getTimeInMillis();
//        cal.setTime(bdate);
//        long time2 = cal.getTimeInMillis();
//        long between_days=(time2-time1)/(1000*3600*24);
//        return Integer.parseInt(String.valueOf(between_days));
//    }
//
//
//    /**
//     * description 获取当天的起始时间
//     * @author fengyongge@ediankai.com
//     * @return
//     */
//    public static Date getStartTime() {
//        Calendar todayStart = Calendar.getInstance();
//        todayStart.set(Calendar.HOUR_OF_DAY, 0);
//        todayStart.set(Calendar.MINUTE, 0);
//        todayStart.set(Calendar.SECOND, 0);
//        todayStart.set(Calendar.MILLISECOND, 0);
//        return todayStart.getTime();
//    }
//    /**
//     * description 获取当天的结束时间
//     * @author fengyongge@ediankai.com
//     * @return
//     */
//     public static Date getEndTime() {
//        Calendar todayEnd = Calendar.getInstance();
//        todayEnd.set(Calendar.HOUR_OF_DAY, 23);
//        todayEnd.set(Calendar.MINUTE, 59);
//        todayEnd.set(Calendar.SECOND, 59);
//        todayEnd.set(Calendar.MILLISECOND, 999);
//        return todayEnd.getTime();
//    }


    /**
     * 测试程序
     *
     * @return
     * @throws ParseException 
     **/

    public static void main(String[] args) throws ParseException {
//    	System.out.println(getDateFromlong(System.currentTimeMillis()));
    	String d1 = "2015-05";
    	String d2 = "2015-05";
//    	String d2 = "2017-05-14 05:00:00";
//    	List<String> dateCount = DateUtil.monthCount1(d1, null);
//    	for (String string : dateCount) {
//			System.out.println(string);
//		}
//    	int num = maxDays(d1);
//    	String month = getBeforeMonth(d1,-5);
//    	System.out.println(month);
//    	System.out.println(DateUtil.getYesterdayStartTime());
    }
}
