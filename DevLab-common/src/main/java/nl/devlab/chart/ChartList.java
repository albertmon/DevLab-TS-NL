package nl.devlab.chart;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ChartList {

	private List<Chart> chartList = null;
	public static String newline = System.getProperty("line.separator");
	
	public ChartList() {
		super();
		chartList = new ArrayList<Chart>();
	}
	
	public void add(Chart graph) {
		chartList.add(graph);
	}
	public List<Chart> getChartList() {
		return chartList;
	}

	public String toString() {
		
		StringBuffer sb = new StringBuffer();
		
		Iterator<Chart> chart = chartList.iterator();
		while (chart.hasNext()) {
			sb.append(chart.next());
			if (chart.hasNext()) {
				sb.append(",");
			}
			sb.append(newline);
		}
		
		return sb.toString();
	}
	
}
