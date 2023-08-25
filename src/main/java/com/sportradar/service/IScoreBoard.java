package com.sportradar.service;

public interface IScoreBoard {
	

	/**
	 * Create a new Match with score 0-0
	 * 
	 * @param localTeam
	 * @param visitorTeam
	 */
	void startMatch(String localTeam, String visitorTeam);
	
	/**
	 * Update an existing match.
	 * 
	 * @param localTeam
	 * @param localScore
	 * @param visitorTeam
	 * @param visitorScore
	 */
	void updateMatch(String localTeam, int localScore, String visitorTeam, int visitorScore);
	
	/**
	 * Delete a match from scoreBoard
	 * 
	 * @param localTeam
	 */
	public void finishMatch(String localTeam);
	
	/**
	 * Get Summary of matches order by score and order
	 */
	public void getSummary();
	


	


}
