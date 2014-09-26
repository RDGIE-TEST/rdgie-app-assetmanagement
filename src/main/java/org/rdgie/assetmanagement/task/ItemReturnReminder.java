package org.rdgie.assetmanagement.task;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.rdgie.assetmanagement.domain.Employee;
import org.rdgie.assetmanagement.domain.Entry;
import org.rdgie.assetmanagement.service.EntryService;
import org.rdgie.assetmanagement.util.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

public class ItemReturnReminder {

	@Autowired
	private EntryService entryService;

	@Scheduled(fixedDelay = 5000)
	public void demoServiceMethod() {
		List<Employee> employees = new ArrayList<Employee>();
		List<Entry> entries = entryService.listEntries();

		for (Entry entry : entries) {

			if (isToday(entry.getDate())) {
				Employee e = entry.getEmployee();
				employees.add(e);
				System.out.println("Message will be sent");
			}
		}

		//MessageUtil.sendMessage(employees);

	}

	public static boolean isSameDay(Date date1, Date date2) {
		if (date1 == null || date2 == null) {
			throw new IllegalArgumentException("The dates must not be null");
		}
		Calendar cal1 = Calendar.getInstance();
		cal1.setTime(date1);
		Calendar cal2 = Calendar.getInstance();
		cal2.setTime(date2);
		return isSameDay(cal1, cal2);
	}

	public static boolean isSameDay(Calendar cal1, Calendar cal2) {
		if (cal1 == null || cal2 == null) {
			throw new IllegalArgumentException("The dates must not be null");
		}
		return (cal1.get(Calendar.ERA) == cal2.get(Calendar.ERA)
				&& cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR) && cal1
					.get(Calendar.DAY_OF_YEAR) == cal2
				.get(Calendar.DAY_OF_YEAR));
	}

	public static boolean isToday(Date date) {
		return isSameDay(date, Calendar.getInstance().getTime());
	}

}
