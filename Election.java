package com.voting.model;

import java.sql.Date;

public class Election {
    private int electionId;
    private String title;
    private Date startDate;
    private Date endDate;

    public Election() {}

    public Election(int electionId, String title, Date startDate, Date endDate) {
        this.electionId = electionId;
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public int getElectionId() { return electionId; }
    public void setElectionId(int electionId) { this.electionId = electionId; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public Date getStartDate() { return startDate; }
    public void setStartDate(Date startDate) { this.startDate = startDate; }
    public Date getEndDate() { return endDate; }
    public void setEndDate(Date endDate) { this.endDate = endDate; }
}
