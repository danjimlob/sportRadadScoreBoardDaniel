package com.sportradar.service;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

class ScoreBoardTest {
	private ScoreBoard scoreBoard;
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();


	@BeforeEach
	public void init() {
		scoreBoard = ScoreBoard.getScoreBoard();
        System.setOut(new PrintStream(outContent));

	}
	
	@AfterEach
	public void clear() {
		ScoreBoard.resetScoreBoard();
	}

	// Start a new Match
	@Test
	void startNewMatch() {
		String localTeam = "localTeam";
		String visitorTeam = "visitorTeam";

		scoreBoard.startMatch(localTeam, visitorTeam);

		assertEquals("Match started: localTeam 0 - visitorTeam 0\r\n", outContent.toString());

	}

	// Check we can't create a match with a team that is already playing
	@Test
	void startNewMatchWithTeamPlaying() {
		String localTeam = "localTeam";
		String visitorTeam = "visitorTeam";
		String visitorTeam2 = "visitorTeam";

		scoreBoard.startMatch(localTeam, visitorTeam);

		scoreBoard.startMatch(localTeam, visitorTeam2);

		assertEquals("Match started: localTeam 0 - visitorTeam 0\r\n" + "You cannot register a match with a team that is already playing a match currently\r\n",
				outContent.toString());

	}

	// Update a Match
	@Test
	 void updateMatch() {
		String localTeam = "localTeam";
		String visitorTeam = "visitorTeam";
		int localScore = 0;
		int visitorScore = 0;
		
		scoreBoard.startMatch(localTeam, visitorTeam);

		scoreBoard.updateMatch(localTeam, localScore, visitorTeam, visitorScore);
		
		assertEquals("Match started: localTeam 0 - visitorTeam 0\r\n" + "Match updated: localTeam 0 - visitorTeam 0\r\n", outContent.toString());

	 }	

	
	//Test update with negative Score
	@Test
	void updateMatchWithNegativeScore() {
		String localTeam = "localTeam";
		String visitorTeam = "visitorTeam";
		int localScore = -5;
		int visitorScore = 2;
		
		scoreBoard.startMatch(localTeam, visitorTeam);

		scoreBoard.updateMatch(localTeam, localScore, visitorTeam, visitorScore);
		
		assertEquals("Match started: localTeam 0 - visitorTeam 0\r\n" + "Score can't be negative\r\n", outContent.toString());
		
	}
	
	
	//Test update with a no playing 
	@Test
	void updateMatchWithNoValidTeam() {
		String localTeam = "localTeam";
		String visitorTeam = "visitorTeam";
		int localScore = 1;
		int visitorScore = 2;
		String dummyTeam = "dummyTeam";
		
		scoreBoard.startMatch(localTeam, visitorTeam);

		scoreBoard.updateMatch(dummyTeam, localScore, visitorTeam, visitorScore);

		assertEquals("Match started: localTeam 0 - visitorTeam 0\r\n" + "This match is not exist at the moment\r\n", outContent.toString());

	}
	
	//Finish a Match
	@Test
	void finishMatch() {
		String localTeam = "localTeam";
		String visitorTeam = "visitorTeam";
		
		scoreBoard.startMatch(localTeam, visitorTeam);
		
		scoreBoard.finishMatch(localTeam);

		assertEquals("Match started: localTeam 0 - visitorTeam 0\r\n" + "Match finished localTeam 0 - visitorTeam 0\r\n", outContent.toString());

	}
	
	// Get order summary matches by total score
	@Test
	void getSummary() {
		createListMatches();
		scoreBoard.updateMatch("Mexico", 0, "Canada", 5);
		scoreBoard.updateMatch("Spain", 10, "Brazil", 2);
		scoreBoard.updateMatch("Germany", 2, "France", 2);
		scoreBoard.updateMatch("Uruguay", 6, "Italy", 6);
		scoreBoard.updateMatch("Argentina", 3, "Australia", 1);
		
		scoreBoard.getSummary();
		
		assertEquals("Match started: Mexico 0 - Canada 0\r\nMatch started: Spain 0 - Brazil 0\r\nMatch started: Germany 0 - France 0\r\nMatch started: Uruguay 0 - Italy 0\r\nMatch started: Argentina 0 - Australia 0\r\nMatch updated: Mexico 0 - Canada 5"
				+ "\r\nMatch updated: Spain 10 - Brazil 2\r\nMatch updated: Germany 2 - France 2\r\nMatch updated: Uruguay 6 - Italy 6\r\nMatch updated: Argentina 3 - Australia 1\r\n"
				+ "Uruguay 6 - Italy 6\r\nSpain 10 - Brazil 2\r\nMexico 0 - Canada 5\r\nArgentina 3 - Australia 1\r\nGermany 2 - France 2\r\n"
				+ "", 
				outContent.toString());


		

	}
	

	private void createListMatches() {
		String[] localList = {"Mexico","Spain","Germany","Uruguay","Argentina"};
		String[] visitorList = {"Canada","Brazil","France","Italy","Australia"};
		int i=0;
		for(;i<localList.length;i++) {
			scoreBoard.startMatch(localList[i], visitorList[i]);

		}
		
		
	}
	
}