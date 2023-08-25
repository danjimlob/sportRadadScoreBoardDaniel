package com.sportradar.application;

import com.sportradar.service.IScoreBoard;
import com.sportradar.service.impl.ScoreBoard;

public class ScoreBoardApp {
	
	public static void main(String[] args) {
		
		String local1 = "Spain";
		String visitor1 = "Brazil";
		
		String local2 = "Uruguay";
		String visitor2 = "Italy";
		
		IScoreBoard scoreBoard = new ScoreBoard();
		
		scoreBoard.startMatch(local1, visitor1);
		scoreBoard.startMatch(local2, visitor2);

		scoreBoard.updateMatch(local1, 10, visitor1, 2);
		scoreBoard.updateMatch(local2, 6, visitor2, 6);
		
		scoreBoard.getSummary();

		
				
	}
}