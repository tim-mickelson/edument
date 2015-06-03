package se.addskills.day1.excercise4B;

import java.util.Locale;

public interface ILogger {
	void Log(TradeMessage msg);
	void setLocale(Locale locale);
	boolean isEnabled();
	void setEnabled();
	int count();
}
