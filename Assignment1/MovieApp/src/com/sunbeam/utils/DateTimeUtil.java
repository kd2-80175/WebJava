package com.sunbeam.utils;


import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeUtil {
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	public static String toString(java.util.Date date) {
		return sdf.format(date);
	}
	public static java.util.Date parse(String dateStr) {
		try {
			return sdf.parse(dateStr);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	//converting sql date to util date 
	public static Date sqlToUtilDate(Date date) {
		return new java.util.Date(date.getTime());
	}
	
	//converting util date to sql date
	public static java.sql.Date utilToSqlDate(java.util.Date uDate) {
		return new java.sql.Date(uDate.getTime());
	}
	
	public static Date sqlToUtilDate(Timestamp timestamp) {
		if (timestamp == null) {
	        return null; // return null if the input timestamp is null
	    } else {
	        return new Date(timestamp.getTime()); // return java.util.Date created from the Timestamp's time in milliseconds
	    }
	}
	
}
	
