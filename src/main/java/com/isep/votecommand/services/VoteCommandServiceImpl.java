package com.isep.votecommand.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.isep.votecommand.model.*;
import com.isep.votecommand.repositories.VoteCommandRepository;

import java.util.Optional;

@Service
public class VoteServiceImpl implements VoteService {

    @Autowired
    VoteCommandRepository voteRepository;

    @Override
    public Iterable<VoteCommand> getAll() {
        return voteRepository.findAll();
    }

    @Override
    public boolean addVoteToReview(Long reviewID, VoteCommandDTO voteReviewDTO) {
        

        Optional<VoteCommand> voteRepo = this.voteRepository.findById(reviewID);

        if (voteRepo.isEmpty()) return false;

        VoteCommand vote = new VoteCommand(voteReviewDTO.getVote(), voteReviewDTO.getUserID());
        if (voteReviewDTO.getVote().equalsIgnoreCase("upVote")) {
            boolean added = voteRepo.get().addUpVote(vote);
            if (added) {
                VoteCommand reviewUpdated = this.voteRepository.save(voteRepo.get());
                return reviewUpdated != null;
            }
        } else if (voteReviewDTO.getVote().equalsIgnoreCase("downVote")) {
            boolean added = voteRepo.get().addDownVote(vote);
            if (added) {
                VoteCommand reviewUpdated = this.voteRepository.save(voteRepo.get());
                return reviewUpdated != null;
            }
        }
        return false;
    }
}