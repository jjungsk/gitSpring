package com.ssafy.hello.dao;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.springframework.stereotype.Repository;

@Repository
public class HelloDaoImpl implements HelloDao {

	@Override
	public String Hello() {
		Calendar cal = new GregorianCalendar();
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		if (hour > 6 && hour < 12) {
			return "즐거운 아침";
		} else if (hour > 12 && hour < 18) {
			return "즐거운 오후";
		} else {
			return "굿밤";
		}
	}

}
