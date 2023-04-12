package com.isep.votecommand.services;

import com.isep.votecommand.model.VoteCommand;
import com.isep.votecommand.model.VoteCommandDTO;

public interface VoteService {

    Iterable<VoteCommand> getAll();

    boolean addVoteToReview(Long reviewID, VoteCommandDTO voteCommandDTO);
}
