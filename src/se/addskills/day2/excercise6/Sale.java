package se.addskills.day2.excercise6;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Sale {
	private String seller;
	private String buyer;
	private String ssn;
	private String Reg;
	private String price;
	
	public boolean validate(Patterns pattern, String string) {
		Pattern p = Pattern.compile(pattern.toString());
		Matcher m = p.matcher(string);
		if (m.matches()) {
			return true;
		} else {
			System.out.println("Wrong input!");
			return false;
		}
	}

	public String getSeller() {
		return seller;
	}

	public void setSeller(String seller) {
		this.seller = seller;
	}

	public String getBuyer() {
		return buyer;
	}

	public void setBuyer(String buyer) {
		this.buyer = buyer;
	}

	public String getSSN() {
		return ssn;
	}

	public void setSSN(String ssn) {
		this.ssn = ssn;
	}

	public String getReg() {
		return Reg;
	}

	public void setReg(String reg) {
		Reg = reg;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		String out = String.format("Seller: %1$s\nBuyer: %2$s\nSSN: %3$s\nReg #:%4$s\nPrice sold: %5$s", 
				seller, buyer, ssn, Reg, price);
		return out;
	}
}
