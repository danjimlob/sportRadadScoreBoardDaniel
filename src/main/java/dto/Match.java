package dto;

public class Match {

	private String localTeam;
	private int localScore = 0;

	private String visitorTeam;
	private int visitorScore = 0;

	private int order;

	public Match(String localTeam, String visitorTeam, int order) {
		this.localTeam = localTeam;
		this.visitorTeam = visitorTeam;
		this.setOrder(order);
	}
	
	
	public String formatMessage() {
		return localTeam + " " + localScore + " - " + visitorTeam + " " + visitorScore;
		
	}


	
	public int getOrder() {
		return order;
	}


	public void setOrder(int order) {
		this.order = order;
	}

}