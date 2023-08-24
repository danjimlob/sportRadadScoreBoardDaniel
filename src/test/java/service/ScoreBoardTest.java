package service;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

class ScoreBoardTest {
	private ScoreBoard scoreBoard;
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

	@BeforeEach
	public void init() {
		scoreBoard = ScoreBoard.getScoreBoard();
	}

	// Start a new Match
	@Test
	void startNewMatch() {
		String localTeam = "localTeam";
		String visitorTeam = "visitorTeam";

		scoreBoard.startMatch(localTeam, visitorTeam);

		assertEquals("Match started: " + localTeam, "0 -" + visitorTeam + " 0", outContent.toString());

	}

	// Check we can't create a match with a team that is already playing
	void startNewMatchWithTeamPlaying() {
		String localTeam = "localTeam";
		String visitorTeam = "visitorTeam";
		String visitorTeam2 = "visitorTeam";

		scoreBoard.startMatch(localTeam, visitorTeam);

		scoreBoard.startMatch(localTeam, visitorTeam2);
		
		assertEquals("You cannot register a match with a team that is already playing a match currently", outContent.toString());

	}

	// Update a Match
	@Test
	 void updateMatch() {
		String localTeam = "localTeam";
		String visitorTeam = "visitorTeam";
		int localScore = 0;
		int visitorScore = 0;
		
		scoreBoard.updateMatch(localTeam, localScore, visitorTeam, visitorScore);
		
		assertEquals("Match updated: " + localTeam, "0 -" + visitorTeam +" 0", outContent.toString());

	 }
	
	//Test update with negative Score
	@Test
	void updateMatchWithNegativeScore() {
		
	}
	
	
	//Test update with a no playing team
	@Test
	void updateMatchWithNoValidTeam() {
		
	}
	
	//Finish a Match
	@Test
	void finishMatch() {
		String localTeam = "localTeam";
		String visitorTeam = "visitorTeam";
		
		scoreBoard.startMatch(localTeam, visitorTeam);
		
		scoreBoard.finishMatch(localTeam);
		
		assertEquals("Match finished: " + localTeam, "0 -" + visitorTeam +" 0", outContent.toString());

		
	}
}