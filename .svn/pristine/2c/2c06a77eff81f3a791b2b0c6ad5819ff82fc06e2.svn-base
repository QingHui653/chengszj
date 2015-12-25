package com.hengshuo.chengszj.common.util;



	/*
	 *  date time tools
	 */
	import java.text.ParseException;
	import java.text.SimpleDateFormat;
	import java.util.Calendar;
	import java.util.Date;
	import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Random;

	/**
	 * 日期时间工具类
	 * 
	 * @author sunflower
	 * 
	 */
	public class DateTimeUtil {
		private static final SimpleDateFormat datetimeFormat = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		private static final SimpleDateFormat dateFormat = new SimpleDateFormat(
				"yyyy-MM-dd");
		private static final SimpleDateFormat timeFormat = new SimpleDateFormat(
				"HH:mm:ss");

		/**
		 * 获得当前日期时间
		 * <p>
		 * 日期时间格式yyyy-MM-dd HH:mm:ss
		 * 
		 * @return
		 */
		public static String currentDatetime() {
			return datetimeFormat.format(now());
			
		}

		/**
		 * 格式化日期时间
		 * <p>
		 * 日期时间格式yyyy-MM-dd HH:mm:ss
		 * 
		 * @return
		 */
		public static String formatDatetime(Date date) {
			return datetimeFormat.format(date);
		}

		/**
		 * 格式化日期时间
		 * 
		 * @param date
		 * @param pattern
		 *            格式化模式，详见{@link SimpleDateFormat}构造器
		 *            <code>SimpleDateFormat(String pattern)</code>
		 * @return
		 */
		public static String formatDatetime(Date date, String pattern) {
			SimpleDateFormat customFormat = (SimpleDateFormat) datetimeFormat
					.clone();
			customFormat.applyPattern(pattern);
			return customFormat.format(date);
		}

		/**
		 * 获得当前日期
		 * <p>
		 * 日期格式yyyy-MM-dd
		 * 
		 * @return
		 */
		public static String currentDate() {
			return dateFormat.format(now());
		}

		/**
		 * 格式化日期
		 * <p>
		 * 日期格式yyyy-MM-dd
		 * 
		 * @return
		 */
		public static String formatDate(Date date) {
			return dateFormat.format(date);
		}

		/**
		 * 获得当前时间
		 * <p>
		 * 时间格式HH:mm:ss
		 * 
		 * @return
		 */
		public static String currentTime() {
			return timeFormat.format(now());
		}

		/**
		 * 格式化时间
		 * <p>
		 * 时间格式HH:mm:ss
		 * 
		 * @return
		 */
		public static String formatTime(Date date) {
			return timeFormat.format(date);
		}

		/**
		 * 获得当前时间的<code>java.util.Date</code>对象
		 * 
		 * @return
		 */
		public static Date now() {
			return new Date();
		}

		public static Calendar calendar() {
			Calendar cal = GregorianCalendar.getInstance(Locale.CHINESE);
			cal.setFirstDayOfWeek(Calendar.MONDAY);
			return cal;
		}

		/**
		 * 获得当前时间的毫秒数
		 * <p>
		 * 详见{@link System#currentTimeMillis()}
		 * 
		 * @return
		 */
		public static long millis() {
			return System.currentTimeMillis();
		}

		/**
		 * 
		 * 获得当前Chinese月份
		 * 
		 * @return
		 */
		public static int month() {
			return calendar().get(Calendar.MONTH) + 1;
		}

		/**
		 * 获得月份中的第几天
		 * 
		 * @return
		 */
		public static int dayOfMonth() {
			return calendar().get(Calendar.DAY_OF_MONTH);
		}

		/**
		 * 今天是星期的第几天
		 * 
		 * @return
		 */
		public static int dayOfWeek() {
			return calendar().get(Calendar.DAY_OF_WEEK);
		}

		/**
		 * 今天是年中的第几天
		 * 
		 * @return
		 */
		public static int dayOfYear() {
			return calendar().get(Calendar.DAY_OF_YEAR);
		}

		/**
		 *判断原日期是否在目标日期之前
		 * 
		 * @param src
		 * @param dst
		 * @return
		 */
		public static boolean isBefore(Date src, Date dst) {
			return src.before(dst);
		}

		/**
		 *判断原日期是否在目标日期之后
		 * 
		 * @param src
		 * @param dst
		 * @return
		 */
		public static boolean isAfter(Date src, Date dst) {
			return src.after(dst);
		}

		/**
		 *判断两日期是否相同
		 * 
		 * @param date1
		 * @param date2
		 * @return
		 */
		public static boolean isEqual(Date date1, Date date2) {
			return date1.compareTo(date2) == 0;
		}

		/**
		 * 判断某个日期是否在某个日期范围
		 * 
		 * @param beginDate
		 *            日期范围开始
		 * @param endDate
		 *            日期范围结束
		 * @param src
		 *            需要判断的日期
		 * @return
		 */
		public static boolean between(Date beginDate, Date endDate, Date src) {
			return beginDate.before(src) && endDate.after(src);
		}

		/**
		 * 获得当前月的最后一天
		 * <p>
		 * HH:mm:ss为0，毫秒为999
		 * 
		 * @return
		 */
		public static Date lastDayOfMonth() {
			Calendar cal = calendar();
			cal.set(Calendar.DAY_OF_MONTH, 0); // M月置零
			cal.set(Calendar.HOUR_OF_DAY, 0);// H置零
			cal.set(Calendar.MINUTE, 0);// m置零
			cal.set(Calendar.SECOND, 0);// s置零
			cal.set(Calendar.MILLISECOND, 0);// S置零
			cal.set(Calendar.MONTH, cal.get(Calendar.MONTH) + 1);// 月份+1
			cal.set(Calendar.MILLISECOND, -1);// 毫秒-1
			return cal.getTime();
		}

		/**
		 * 获得当前月的第一天
		 * <p>
		 * HH:mm:ss SS为零
		 * 
		 * @return
		 */
		public static Date firstDayOfMonth() {
			Calendar cal = calendar();
			cal.set(Calendar.DAY_OF_MONTH, 1); // M月置1
			cal.set(Calendar.HOUR_OF_DAY, 0);// H置零
			cal.set(Calendar.MINUTE, 0);// m置零
			cal.set(Calendar.SECOND, 0);// s置零
			cal.set(Calendar.MILLISECOND, 0);// S置零
			return cal.getTime();
		}

		private static Date weekDay(int week) {
			Calendar cal = calendar();
			cal.set(Calendar.DAY_OF_WEEK, week);
			return cal.getTime();
		}

		/**
		 * 获得周五日期
		 * <p>
		 * 注：日历工厂方法{@link #calendar()}设置类每个星期的第一天为Monday，US等每星期第一天为sunday
		 * 
		 * @return
		 */
		public static Date friday() {
			return weekDay(Calendar.FRIDAY);
		}

		/**
		 * 获得周六日期
		 * <p>
		 * 注：日历工厂方法{@link #calendar()}设置类每个星期的第一天为Monday，US等每星期第一天为sunday
		 * 
		 * @return
		 */
		public static Date saturday() {
			return weekDay(Calendar.SATURDAY);
		}

		/**
		 * 获得周日日期
		 * <p>
		 * 注：日历工厂方法{@link #calendar()}设置类每个星期的第一天为Monday，US等每星期第一天为sunday
		 * 
		 * @return
		 */
		public static Date sunday() {
			return weekDay(Calendar.SUNDAY);
		}

		/**
		 * 将字符串日期时间转换成java.util.Date类型
		 * <p>
		 * 日期时间格式yyyy-MM-dd HH:mm:ss
		 * 
		 * @param datetime
		 * @return
		 */
		public static Date parseDatetime(String datetime) throws ParseException {
			return datetimeFormat.parse(datetime);
		}

		/**
		 * 将字符串日期转换成java.util.Date类型
		 *<p>
		 * 日期时间格式yyyy-MM-dd
		 * 
		 * @param date
		 * @return
		 * @throws ParseException
		 */
		public static Date parseDate(String date) throws ParseException {
			return dateFormat.parse(date);
		}

		/**
		 * 将字符串日期转换成java.util.Date类型
		 *<p>
		 * 时间格式 HH:mm:ss
		 * 
		 * @param time
		 * @return
		 * @throws ParseException
		 */
		public static Date parseTime(String time) throws ParseException {
			return timeFormat.parse(time);
		}

		/**
		 * 根据自定义pattern将字符串日期转换成java.util.Date类型
		 * 
		 * @param datetime
		 * @param pattern
		 * @return
		 * @throws ParseException
		 */
		public static Date parseDatetime(String datetime, String pattern)
				throws ParseException {
			SimpleDateFormat format = (SimpleDateFormat) datetimeFormat.clone();
			format.applyPattern(pattern);
			return format.parse(datetime);
		}
		
		/**
		 * 根据日期判断相差时间
		 * 
		 * @param fDate 激活时间
		 * @param oDate 到期时间
		 * @return
		 * @throws ParseException
		 */
		public static int getIntervalDays(Date fDate, Date oDate) {

		       if (null == fDate || null == oDate) {

		           return -1;

		       }

		       long intervalMilli = oDate.getTime() - fDate.getTime();

		       return (int) (intervalMilli / (24 * 60 * 60 * 1000));

		    }
		public static Date getDaoQiTime(int year){
			Calendar c = Calendar.getInstance();
			 c.add(Calendar.YEAR, year);
			 return c.getTime();
		}
		
		
		/**
		 * 根据日期判断相差时间秒
		 * 
		 * @param fDate 激活时间
		 * @param oDate 到期时间
		 * @return
		 * @throws ParseException
		 */
		public static int getTimeDelta(Date date1,Date date2){  
	        long timeDelta=(date1.getTime()-date2.getTime())/1000;//单位是秒  
	        int secondsDelta=timeDelta>0?(int)timeDelta:(int)Math.abs(timeDelta);  
	        return secondsDelta;  
	    }  
		
		/**
		 * 根据日期判断相差时间秒SS
		 * 
		 * @param fDate 激活时间
		 * @param oDate 到期时间
		 * @return
		 * @throws ParseException
		 */
		
		public static int getSecond(Date fDate, Date oDate) {

		       if (null == fDate || null == oDate) {

		           return -1;

		       }

		       long intervalMilli = oDate.getTime() - fDate.getTime();

		       return (int) (intervalMilli / 1000);

		    }
		
		//公历生日多少天
		public static int getsr(String time) throws ParseException {
			SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd");
	        String clidate = time;
	        Calendar cToday = Calendar.getInstance(); // 存今天
	        Calendar cBirth = Calendar.getInstance(); // 存生日
	        cBirth.setTime(myFormatter.parse(clidate)); // 设置生日
	        cBirth.set(Calendar.YEAR, cToday.get(Calendar.YEAR)); // 修改为本年
	        int days; 
	        if (cBirth.get(Calendar.DAY_OF_YEAR) < cToday.get(Calendar.DAY_OF_YEAR)) {
	            // 生日已经过了，要算明年的了
	            days = cToday.getActualMaximum(Calendar.DAY_OF_YEAR) - cToday.get(Calendar.DAY_OF_YEAR);
	            days += cBirth.get(Calendar.DAY_OF_YEAR);
	        } else {
	            // 生日还没过
	            days = cBirth.get(Calendar.DAY_OF_YEAR) - cToday.get(Calendar.DAY_OF_YEAR);
	        }
	        System.out.println("距离生日还有：" + days + "天");
	        return  days;
	       /* // 输出结果
	        if (days == 0) {
	            System.out.println("今天生日");
	        } else {
	            System.out.println("距离生日还有：" + days + "天");
	        }  */
	
		 
			
			
			
		}
		
		public static String getliutime(String Now,String bij){
			
			  SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			   java.util.Date now;
			   StringBuffer sb = new StringBuffer();
			try {
			   now = df.parse(Now);
			   java.util.Date date=df.parse(bij);
			   long l=now.getTime()-date.getTime();
			   long day=l/(24*60*60*1000);
			   long hour=(l/(60*60*1000)-day*24);
			   long min=((l/(60*1000))-day*24*60-hour*60);
			   long s=(l/1000-day*24*60*60-hour*60*60-min*60);
			   
			 
			   /*sb.append("发表于：");*/
			   if(day > 0){
				   sb.append(day+"天");
			
			   }
			   if(hour > 0&&day<1 )
				   sb.append(hour+"小时");
			   if(min > 0&&day<1&&hour<1 )
				   sb.append(min+"分钟");
			   if (s>0&&day<1&&min<1) 
			   sb.append(s+"秒 ");
			
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			sb.append("前");
			return sb.toString();

		}
		
		public static String toRandom(int x){
			 Random random = new Random();
			 String result="";
			 for(int i=0;i<x;i++){
			 result+=random.nextInt(10);
			 }
			  return result;
			}	
	}


