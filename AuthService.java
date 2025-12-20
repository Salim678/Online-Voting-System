
package service;

import dao.VoterDAO;
import model.Voter;

public class AuthService {

    public Voter login(String email, String password) {

        if (email == null || email.trim().isEmpty()
                || password == null || password.trim().isEmpty()) {
            return null;
        }

        return VoterDAO.validateLogin(email.trim(), password.trim());
    }

    public boolean register(Voter voter) {
        if (voter == null) return false;

        if (voter.getEmail() == null || voter.getEmail().trim().isEmpty()
                || voter.getPassword() == null || voter.getPassword().trim().isEmpty()
                || voter.getName() == null || voter.getName().trim().isEmpty()) {
            return false;
        }

        if (VoterDAO.isEmailExists(voter.getEmail().trim())) {
            return false;
        }

        return VoterDAO.registerVoter(voter);
    }
}
