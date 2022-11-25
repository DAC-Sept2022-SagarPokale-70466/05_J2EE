package dao;

import java.sql.SQLException;
import java.util.List;

import pojo.Candidate;

public interface Candidate_Dao {

	//add a method to get list of all candidates
		List<Candidate> getAllCandidates() throws SQLException;
		//add a method to increment selected candidate votes
		String incrementVotes(int candidateId) throws SQLException;

	
}
