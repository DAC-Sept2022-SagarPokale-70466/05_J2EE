package beans;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import dao.CandidateDaoImpl;
import pojos.Candidate;

public class CandidateBean {
	// properties
	private CandidateDaoImpl candidateDao;

	// def ctor
	public CandidateBean() throws SQLException {
		// create dao instance
		candidateDao = new CandidateDaoImpl();
		System.out.println("candidate bean created !");
	}

//	-------------------------------------------------------------------------------s
	
	// getters n setters
	public CandidateDaoImpl getCandidateDao() {
		return candidateDao;
	}

	public void setCandidateDao(CandidateDaoImpl candidateDao) {
		this.candidateDao = candidateDao;
	}
//-------------------------------------------------------------------------------

//	Creating a getter Method to use Under the JavaBeance (i.e To use under the EL syntax to get the values when entered at Admin Page.

	// add B.L method to get top 2 candidates
	public List<Candidate> getCandidatesByVotes() throws SQLException {
		return candidateDao.top2CandidatesByVote();
	}

	// add B.L method for getting party wise analysis
	public Map<String, Integer> getPartyAnalysis() throws SQLException {
		return candidateDao.partywiseAnalysis();
	}

}