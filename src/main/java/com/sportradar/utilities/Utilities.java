package com.sportradar.utilities;

import java.util.Optional;
import java.util.Set;

import com.sportradar.dto.Match;

public class Utilities {

	public static int ZERO = 0;

	public static String ERROR_VALIDATE_MATCH_EXISTING = "You cannot register a match with a team that is already playing a match currently";

	public static String MATCH_STARTED = "Match started: ";
	public static String MATCH_UPDATED = "Match updated: ";
	public static String MATCH_FINISHED = "Match finished ";
	public static String ERROR_SCORE_NEGATIVE = "Score can't be negative";
	public static String MATCH_NO_EXIST = "This match is not exist at the moment";

	/**
	 * Find an active match
	 * 
	 * @param localTeam
	 * @return
	 */
	public static Match findMatch(final String localTeam, Set<Match> matchesBoard) {
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
	public static Optional<Match> validateMatch(final String team, Set<Match> matchesBoard) {
		return matchesBoard.stream().filter(
				match -> match.getLocalTeam().equalsIgnoreCase(team) || match.getVisitorTeam().equalsIgnoreCase(team))
				.findFirst();
	}

}