package service;

public class ScoreBoard{
	
	private static ScoreBoard scoreBoard;
	
	private ScoreBoard() {
		
	}
	
	//Singlenton Instance ScoreBoard
	public static ScoreBoard getScoreBoard() {
		if(scoreBoard == null) {
			scoreBoard = new ScoreBoard();
		}
		return scoreBoard;
	}
	
	
	
	
	public void startMatch(String localTeam, String visitorTeam) {
		
		
	}
	
	
}