package nl.devlab.form;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

public class YearList {

	public enum YearListType {
		CURRENTYEAR, FIXEDYEAR
	}

	public static List<Integer> getYears(int beginYear) {
		return getYears(YearList.YearListType.FIXEDYEAR, beginYear, YearList.YearListType.CURRENTYEAR, 0);
	}
	
	public static List<Integer> getYears(int beginYear, int endYear) {
		return getYears(YearList.YearListType.FIXEDYEAR, beginYear, YearList.YearListType.FIXEDYEAR, endYear);
	}

	public static List<Integer> getYears(YearList.YearListType beginType, int beginYear, YearList.YearListType endType, int endYear) {

		GregorianCalendar gc = new GregorianCalendar();
		
		int beginLoop = beginYear;
		int endLoop = endYear;
		if (beginType == YearListType.CURRENTYEAR) {
			beginLoop = gc.get(GregorianCalendar.YEAR) + beginYear; 
		}
		if (endType == YearListType.CURRENTYEAR) {
			endLoop = gc.get(GregorianCalendar.YEAR) + endYear;
		}
		
		List<Integer> yearList = new ArrayList<Integer>();
		for (int i = beginLoop; i <= endLoop; i++) {
			yearList.add(i);
		}
		
		return yearList;
	}
	
}
