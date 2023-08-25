package com.sportradar.service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import com.sportradar.dto.Match;

public class ScoreBoard {

	private static ScoreBoard scoreBoard;
	// initial order to match set
	private static int Order = 0;

	private static int ZERO = 0;

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

	/**
	 * Create a new Match with score 0-0
	 * 
	 * @param localTeam
	 * @param visitorTeam
	 */
	public void startMatch(String localTeam, String visitorTeam) {

		// Before create a Match, check if any team are playing now
		if (matchesBoard != null && (validateMatch(localTeam).isPresent() || validateMatch(visitorTeam).isPresent())) {
			System.out.println("You cannot register a match with a team that is already playing a match currently");
			return;
		}

		Match newMatch = new Match(localTeam, visitorTeam, Order++);
		matchesBoard.add(newMatch);
		System.out.println("Match started: " + newMatch);

	}

	/**
	 * Update an existing match.
	 * 
	 * @param localTeam
	 * @param localScore
	 * @param visitorTeam
	 * @param visitorScore
	 */
	public void updateMatch(String localTeam, int localScore, String visitorTeam, int visitorScore) {

		if (localScore < ZERO || visitorScore < ZERO) {
			System.out.println("Score can't be negative");
			return;
		}
		try {
			// First we need search the match
			Match executingMatch = findMatch(localTeam);
			executingMatch.setLocalScore(localScore);
			executingMatch.setVisitorScore(visitorScore);

			System.out.println("Match updated: " + executingMatch);
		} catch (RuntimeException e) {
			System.out.println("This match is not exist at the moment");

		}

	}

	/**
	 * Delete a match from scoreBoard
	 * 
	 * @param localTeam
	 */
	public void finishMatch(String localTeam) {
		Match matchToRemove = findMatch(localTeam);
		matchesBoard.remove(matchToRemove);
		System.out.println("Match finished " + matchToRemove);

	}

	public void getSummary() {
		matchesBoard.stream().sorted().forEach(System.out::println);
	}

	/**
	 * Find an active match
	 * 
	 * @param localTeam
	 * @return
	 */
	private Match findMatch(final String localTeam) {
		return matchesBoard.stream().filter(match -> match.getLocalTeam().equals(localTeam)).findFirst()
				.orElseThrow(() -> new RuntimeException("No match found"));

	}

	/**
	 * Validate if a match could be added to scoreBoard. Is localTeam or VisitorTeam
	 * are playing a match, it can't be register
	 * 
	 * @param team
	 * @return
	 */
	private Optional<Match> validateMatch(final String team) {
		return matchesBoard.stream().filter(
				match -> match.getLocalTeam().equalsIgnoreCase(team) || match.getVisitorTeam().equalsIgnoreCase(team))
				.findFirst();
	}

}