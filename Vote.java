
package com.voting.model;

import java.sql.Timestamp;

public class Vote {
    private int voteId;
    private int voterId;
    private int candidateId;
    private int electionId;
    private Timestamp castAt;

    public Vote() {}

    public Vote(int voteId, int voterId, int candidateId, int electionId, Timestamp castAt) {
        this.voteId = voteId;
        this.voterId = voterId;
        this.candidateId = candidateId;
        this.electionId = electionId;
        this.castAt = castAt;
    }

    public int getVoteId() { return voteId; }
    public void setVoteId(int voteId) { this.voteId = voteId; }
    public int getVoterId() { return voterId; }
    public void setVoterId(int voterId) { this.voterId = voterId; }
    public int getCandidateId() { return candidateId; }
    public void setCandidateId(int candidateId) { this.candidateId = candidateId; }
    public int getElectionId() { return electionId; }
    public void setElectionId(int electionId) { this.electionId = electionId; }
    public java.sql.Timestamp getCastAt() { return castAt; }
    public void setCastAt(java.sql.Timestamp castAt) { this.castAt = castAt; }
}
