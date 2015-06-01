package se.addskills.day2.excercise6;

public enum Patterns {
	NAMEPATTERN ("[A-Z][a-z]+\\s+[A-Z][a-z]+((-|\\s)[A-Z][a-z]+)?"),
	SSNPATTERN ("(19|20)?\\d{2}(0[1-9]|1(0|1|2))(0[1-9]|(1|2)[0-9]|3(0|1))-?\\d{4}"),
	REGPATTERN ("[A-Z]{3}\\s[0-9]{3}"),
	PRICEPATTERN ("(?i)\\d+\\s(skr|usd|eur)");
	
	private String pattern;
	private Patterns(String pattern) {
		this.pattern = pattern;
	}
	
	@Override
	public String toString() {
		return pattern;
	}
}
