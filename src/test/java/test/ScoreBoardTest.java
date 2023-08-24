package test;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import service.ScoreBoard;

class ScoreBoardTest{
	private ScoreBoard scoreBoard;
    private final ByteArrayOutputStream  outContent = new ByteArrayOutputStream ();

    @BeforeEach
    public void init() {
    	scoreBoard = ScoreBoard.getScoreBoard();
    }
    
	
	//Start a new Match
	@Test
	void startNewMatch() {
		String localTeam = "localTeam";
		String visitorTeam = "visitorTeam";
		
		scoreBoard.startMatch(localTeam, visitorTeam);
		
		assertEquals("Match started: " + localTeam, "0 -" + visitorTeam +" 0", outContent.toString());
		
	}
	
	//Update a Match
	 @Test
	 void updateMatch() {
		String localTeam = "localTeam";
		String visitorTeam = "visitorTeam";
	 }
}