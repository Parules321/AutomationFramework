package com.naveenAutomation.dateFormats;

public enum DateFormat {
	LONG_DATE("yyyy.MM.dd.HH.mm.ss"), 
	MED_DATE("yy.MM.dd.HH.mm.ss"), 
	SHORT_DATE("yy.MM.dd.HH.mm"),
	DATE_WITH_TIME_ZONE("yyyy.MM.dd.HH.mm.ss Z");

	private String format;

	DateFormat(String format) {
		this.format = format;

	}

	public String getFormat() {
		return format;
	}

}
