package dao;

import static DBUtil.DbUtil.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pojo.Candidate;

public class Candidate_Dao_Implementation implements Candidate_Dao {
	private Connection conn;
	private PreparedStatement pst1, pst2;

	public Candidate_Dao_Implementation() throws SQLException {
		conn = getConnection();

		pst1 = conn.prepareStatement("select * from candidates");
		pst2 = conn.prepareStatement("update candidates set votes=votes+1 where id=?");
		System.out.println("Candidate dao created!");
	}

	@Override
	public List<Candidate> getAllCandidates() throws SQLException {
		List<Candidate> candidates = new ArrayList<Candidate>();

		try (ResultSet rs = pst1.executeQuery()) {
			while (rs.next()) {
				candidates.add(new Candidate(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
			}
		}

		return candidates;
	}

	@Override
	public String incrementVotes(int candidateId) throws SQLException {

		pst2.setInt(1, candidateId);

		int rowCount = pst2.executeUpdate();
		if (rowCount == 1)
			return "Row Incremented";

		return "Incrementing Votes failed !!!!!!!!!";

	}

	// clean up
	public void cleanUp() throws SQLException {
		if (pst1 != null)
			pst1.close();
		if (pst2 != null)
			pst2.close();
		System.out.println("candidate dao cleaned up !");
	}
}