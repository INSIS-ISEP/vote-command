package com.isep.votecommand.repositories;

import org.springframework.data.repository.CrudRepository;
import com.isep.votecommand.model.VoteCommand;

public interface VoteCommandRepository extends CrudRepository<VoteCommand, Long> {

    VoteCommand saveVote(VoteCommand vote);

    VoteCommand updateVote(VoteCommand vote);

    void deleteVote(VoteCommand vote);


}
