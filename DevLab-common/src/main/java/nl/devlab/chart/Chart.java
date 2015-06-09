package nl.devlab.chart;

import java.util.UUID;

public class Chart {

	private String id;
	private String description;
	private Object chartData;
	private ChartType chartType;
	private String errorChartId;
	
	public static String newline = System.getProperty("line.separator");
	
	public Chart(String description) {
		super();
		this.id = UUID.randomUUID().toString();
		this.description = description;
		this.chartType = ChartType.LINE;
		this.chartData = null;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Object getChartData() {
		return chartData;
	}
	public void setChartData(Object chartData) {
		this.chartData = chartData;
	}
	public ChartType getChartType() {
		return chartType;
	}
	public void setChartType(ChartType chartType) {
		this.chartType = chartType;
	}
	public String getErrorChartId() {
		return errorChartId;
	}
	public void setErrorChartId(String errorChartId) {
		this.errorChartId = errorChartId;
	}

	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("{" + newline);
		sb.append("id: \"" + id + "\", " + newline );
		sb.append("errorChartId: \"" + errorChartId + "\", " + newline );
		switch (chartType) {
			case LINE:
			case POINT: 
			case BAR:
			case HORIZONTALBAR: sb.append("label: \"" + description + "\", " + newline ); break;
			case ERROR: break;
		}
		switch (chartType) {
			case LINE: sb.append("lines: {show: true}, " + newline); break;
			case POINT: sb.append("points: {show: true}, " + newline); break;
			case BAR: sb.append("bars: {show: true, barWidth: 15778463000, fill: true}, " + newline); break;
			case HORIZONTALBAR: sb.append("bars: {show: true, barWidth: 0.6, align: \"center\", horizontal: true,lineWidth: 1}," + newline); break;
			case ERROR: sb.append("points: {show: true, errorbars: 'x', xerr: {show:true, upperCap: '-', lowerCap: '-', radius: 5}	}," + newline); break;
		}
		sb.append("data : " + chartData + newline);
		sb.append("}");
		
		return sb.toString();
	}
}
