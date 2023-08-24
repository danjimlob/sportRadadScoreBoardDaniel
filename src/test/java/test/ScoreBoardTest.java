package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import service.ScoreBoard;

class ScoreBoardTest{
	private ScoreBoard scoreBoard;
	
	
	//Start a new Match
	@Test
	void startNewMatch() {
		String localTeam = "localTeam";
		String visitorTeam = "visitorTeam";
		
		scoreBoard.startMatch(localTeam, visitorTeam);
		
		assertEquals("Match started: " + localTeam, "0 -" + visitorTeam +" 0", 0);
		
	}
}