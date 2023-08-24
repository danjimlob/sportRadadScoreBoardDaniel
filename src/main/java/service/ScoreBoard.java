package service;

import java.util.Optional;
import java.util.Set;

import javax.management.RuntimeErrorException;

import dto.Match;

public class ScoreBoard{
	
	private static ScoreBoard scoreBoard;
	//initial order to match set
	private static int Order = 1;
	
	private static Set<Match> matchesBoard;
	
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
		
		//Before create a Match, check if any team are playing now
		if(validateMatch(localTeam).isPresent() || validateMatch(visitorTeam).isPresent()) {
			System.out.println("You cannot register a match with a team that is already playing a match currently");
		}
		
		Match newMatch = new Match(localTeam, visitorTeam, 0);
		matchesBoard.add(newMatch);
		System.out.println("Match started: " + newMatch);
		
	}
	
	public void updateMatches(String localTeam, int localScore, String visitorTeam, int visitorScore) {
		
		// First we need search the match
		Match executingMatch = findMatch(localTeam);
		executingMatch.setLocalScore(localScore);
		executingMatch.setVisitorScore(visitorScore);
		
		System.out.println("Match updated: " + executingMatch);
		
		
		
		
	}
	
	private Match findMatch(final String localTeam) {
		return matchesBoard.stream()
				.filter(match -> match.getLocalTeam().equals(localTeam))
				.findFirst()
				.orElseThrow(()-> new RuntimeException("No match found"));
		
	}
	
	private Optional<Match> validateMatch(final String team){
		return matchesBoard.stream()
				.filter(match -> match.getLocalTeam().equalsIgnoreCase(team) 
						|| match.getVisitorTeam().equalsIgnoreCase(team))
				.findFirst();
	}
	
	
}