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


	
	public String getLocalTeam() {
		return localTeam;
	}


	public void setLocalTeam(String localTeam) {
		this.localTeam = localTeam;
	}


	public int getLocalScore() {
		return localScore;
	}


	public void setLocalScore(int localScore) {
		this.localScore = localScore;
	}


	public String getVisitorTeam() {
		return visitorTeam;
	}


	public void setVisitorTeam(String visitorTeam) {
		this.visitorTeam = visitorTeam;
	}


	public int getVisitorScore() {
		return visitorScore;
	}


	public void setVisitorScore(int visitorScore) {
		this.visitorScore = visitorScore;
	}


	public int getOrder() {
		return order;
	}


	public void setOrder(int order) {
		this.order = order;
	}

}