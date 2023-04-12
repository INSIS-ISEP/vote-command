package com.isep.vote.voteserviceapi.model;

public class VoteDTO {

    private Long idVote;
    private Long userID;
    private String vote;


    public VoteDTO(Long idVote, Long userID, String vote) {
        this.idVote = idVote;
        this.userID = userID;
        this.vote = vote;
    }

    public void setIdVote(Long idVote) {
        this.idVote = idVote;
    }
    
    public Long getIdVote() {
        return this.idVote;
    }


    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public String getVote() {
        return vote;
    }

    public void setVote(String vote) {
        this.vote = vote;
    }
}