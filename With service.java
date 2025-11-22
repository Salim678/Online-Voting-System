package service;

import dao.VoterDAO;
import model.Voter;

public class AuthService {
    VoterDAO voterDAO = new VoterDAO();

    public boolean register(Voter voter) {
        return voterDAO.registerVoter(voter);
    }

    public Voter login(String email, String password) {
        return voterDAO.login(email, password);
    }
}
