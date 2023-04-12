package com.isep.votecommand.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.isep.votecommand.model.ReviewCommand;


import java.util.List;
import java.util.Optional;

public interface ReviewRepository extends CrudRepository<ReviewCommand, Long> {

    @Query("SELECT r FROM Review r WHERE r.approvalStatus='pending'")
    Optional<List<ReviewCommand>> findPendingReviews();

    @Query("SELECT r FROM Review r WHERE r.approvalStatus='active'")
    Optional<List<ReviewCommand>> findActiveReviews();

}
