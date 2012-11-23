package experimental.domain;

public class Dropoff {

	private final Integer campaign;
	private final double factor;

	public Dropoff(Integer campaign, double factor) {
		super();
		this.campaign = campaign;
		this.factor = factor;
	}

	public Integer getCampaign() {
		return campaign;
	}

	public double getFactor() {
		return factor;
	}

}
