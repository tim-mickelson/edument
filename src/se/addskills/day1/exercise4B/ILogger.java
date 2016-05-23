package se.addskills.day1.exercise4B;

import java.util.Locale;

public interface ILogger {

	void log(TradeMessage msg);

	void setLocale(Locale locale);

	boolean isEnabled();

	void setEnabled();

	int count();

}  // end interface ILogger