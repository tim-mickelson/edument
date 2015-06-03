package se.addskills.day1.excercise4B;

public class TradeMessage {
	private Car car;
	private String seller;
	private String buyer;
	private double prize;
	
	public TradeMessage(Car car, String seller, String buyer, double prize) {
		this.setCar(car);
		this.setSeller(seller);
		this.setBuyer(buyer);
		this.setPrize(prize);
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
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

	public double getPrize() {
		return prize;
	}

	public void setPrize(double prize) {
		this.prize = prize;
	}
}
