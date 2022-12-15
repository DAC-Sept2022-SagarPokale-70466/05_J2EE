package dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import pojos.Candidate;

public interface CandidateDao {
//add a method to get list of all candidates
	List<Candidate> getAllCandidates() throws SQLException;
	//add a method to increment selected candidate votes
	String incrementVotes(int candidateId) throws SQLException;
	//add a method to get top 2 candidates by votes
	List<Candidate> top2CandidatesByVote() throws SQLException;
	//add a method to get party wise votes analysis
	Map<String,Integer> partywiseAnalysis() throws SQLException;
	
}
