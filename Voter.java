package model;

public class Voter {
    private int voterId;
    private String name;
    private String email;
    private String password;

    public Voter() {}

    public Voter(int voterId, String name, String email, String password) {
        this.voterId = voterId;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public int getVoterId() { 
        return voterId;
    }
    public void setVoterId(int voterId) {
        this.voterId = voterId;
    }
    public String getName() {
        return name; 
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) { 
        this.email = email;
    }
    public String getPassword() { 
        return password;
    }
    public void setPassword(String password) { 
        this.password = password;
    }
}
