package se.addskills.day2.excercise6;

/**
 * Just keep some patterns to validate
 */
public enum Patterns {
	// [A-Z][a-z]+ Start with capital followed by lower cases until a space (first name)
	// \\s+ One or more space
	// [A-Z][a-z]+ Last name if starts with capital letter followed by lower case
	// ((-\\s)[A-Z][a-z]+)? Match if the surname is followed by space or '-' and One uppercase followed by lowercase letters the '?' says it can exist 0 or one time this match
	NAMEPATTERN ("[A-Z][a-z]+\\s+[A-Z][a-z]+((-|\\s)[A-Z][a-z]+)?"),
	// (19|20)? SSN can optionally start with 19 or 20
	// \\d{2} Then there must be 2 digits
	// (0[1-9]|1(0|1|2)) The it must be two digits starting with 01, ...09 OR 10, 11, 12
	// (0[1-9]|(1|2)[0-9]|3(0|1)) Again start with 01, ...09 or next two digits start with 1 or two followed by 0-9 i.e. 10...19 or 20....29, or finally 3 followed by 0 or 1, i.e. 30 or 31
	// -? There could be a '-' or all numbers are attached (THIS MEANS THAT STRING OF MANY DIGITS GIVES MATCH)
	// \\d{4} end with four digits
	SSNPATTERN ("(19|20)?\\d{2}(0[1-9]|1(0|1|2))(0[1-9]|(1|2)[0-9]|3(0|1))-?\\d{4}"),
	// [A-Z]{3} Three upper case letters
	// \\s Space
	// [0-9]{3} Three integers through 0 to 9 (could also be \\d{3}
	REGPATTERN ("[A-Z]{3}\\s[0-9]{3}"),
	// (?i) Case insensitive mode
	// \\d+ one or more digits
	// \\s(skr|usd|eur)  Blank followd by skr or usd or eur
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
