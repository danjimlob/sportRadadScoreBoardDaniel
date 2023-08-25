package com.sportradar.dto;

public class Match implements Comparable<Match> {

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
	
	/**
	 * Format message with match information
	 * @return
	 */
	@Override
	public String toString() {
		return localTeam + " " + localScore + " - " + visitorTeam + " " + visitorScore;
		
	}
	

	/**
	 * 
	 * @return
	 */
	@Override
	public int compareTo(Match match) {
		if(this.localScore + this.visitorScore == match.getLocalScore() + match.getVisitorScore()) {
			if(this.order > match.getOrder()) {
				return -1;
			}
			return 1;
		} else if (this.localScore + this.visitorScore > match.getLocalScore() + match.getVisitorScore()) {
			return -1;
		}
		return 1;
				
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