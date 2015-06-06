package se.addskills.day1.excercise4B;

import java.text.MessageFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class Logger implements ILogger {
	// Nice log pattern
	private final String MESSAGE_PATTERN = "Date:{0,date,short}\nTime:{0,time,short}\nBrand:{1}\nSeller: {2}\nBuyer: {3}\n" +
			                			  "Askingprize: {4,number, currency}\nSell: {5,number,currency}\n";
	private boolean enabled = false;
	private List<String> logs;
	private Locale locale;
	private MessageFormat logMessage;

	/**
	 * Constructor must give Locale
	 * @param locale
	 */
	public Logger(Locale locale) {
		this.locale = locale;
		// inject pattern and locale to formatter
		this.logMessage = new MessageFormat(MESSAGE_PATTERN, this.locale);
	}  // end constructor

	@Override
	public boolean isEnabled() {
		return enabled;
	}

	@Override
	public void setEnabled() {
		this.enabled = true;
	}

	@Override
	public int count() {
		return logs.size();
	}

	/**
	 * Log nice formatted log from TradeMessage bean.
	 * @param msg
	 */
	@Override
	public void log(TradeMessage msg) {
		Object[] data = {
				new Date(),
				msg.getCar().getCarBrand(),
				msg.getSeller(),
				msg.getBuyer(), 
				msg.getCar().getPrize(), 
				msg.getPrize(),
			};
		System.out.println(logMessage.format(data));
	}  // end function Log


	/**
	 * Set instance locale and more important change it on formatter.
	 * @param locale
	 */
	@Override
	public void setLocale(Locale locale) {
		this.locale = locale;
		logMessage.setLocale(locale);
	}  // end function setLocale

}  // end class Logger