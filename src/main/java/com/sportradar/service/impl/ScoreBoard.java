package com.sportradar.service.impl;

import java.util.HashSet;
import java.util.Set;

import com.sportradar.dto.Match;
import com.sportradar.service.IScoreBoard;
import com.sportradar.utilities.Utilities;

public class ScoreBoard implements IScoreBoard {

	private static ScoreBoard scoreBoard;
	// initial order to match set
	private static int Order = 0;


	private static Set<Match> matchesBoard;


	private ScoreBoard() {
		matchesBoard = new HashSet<>();
	}

	// Singlenton Instance ScoreBoard
	public static ScoreBoard getScoreBoard() {
		if (scoreBoard == null) {
			scoreBoard = new ScoreBoard();
		}
		return scoreBoard;
	}

	public static void resetScoreBoard() {
		matchesBoard.clear();
	}

	@Override
	public void startMatch(String localTeam, String visitorTeam) {

		// Before create a Match, check if any team are playing now
		
			if (matchesBoard != null && (Utilities.validateMatch(localTeam,matchesBoard).isPresent() || Utilities.validateMatch(visitorTeam,matchesBoard).isPresent())) {
				System.out.println(Utilities.ERROR_VALIDATE_MATCH_EXISTING);
				return;
			}
		

		Match newMatch = new Match(localTeam, visitorTeam, Order++);
		matchesBoard.add(newMatch);
		System.out.println(Utilities.MATCH_STARTED + newMatch);

	}

	@Override
	public void updateMatch(String localTeam, int localScore, String visitorTeam, int visitorScore) {

		if (localScore < Utilities.ZERO || visitorScore < Utilities.ZERO) {
			System.out.println(Utilities.ERROR_SCORE_NEGATIVE);
			return;
		}
		try {
			// First we need search the match
			Match executingMatch = Utilities.findMatch(localTeam, matchesBoard);
			executingMatch.setLocalScore(localScore);
			executingMatch.setVisitorScore(visitorScore);

			System.out.println(Utilities.MATCH_UPDATED + executingMatch);
		} catch (RuntimeException e) {
			System.out.println(Utilities.MATCH_NO_EXIST);

		}

	}

	@Override
	public void finishMatch(String localTeam) {
		Match matchToRemove = Utilities.findMatch(localTeam, matchesBoard);
		matchesBoard.remove(matchToRemove);
		System.out.println(Utilities.MATCH_FINISHED + matchToRemove);

	}

	@Override
	public void getSummary() {
		matchesBoard.stream().sorted().forEach(System.out::println);
	}

}