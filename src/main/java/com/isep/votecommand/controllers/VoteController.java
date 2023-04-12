package com.isep.votecommand.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.isep.votecommand.model.*;
import com.isep.votecommand.repositories.VoteCommandRepository;
import com.isep.votecommand.services.VoteCommandService;



@Tag(name = "Vote", description = "Endpoints for managing Review")
@RestController
class VoteController {

    @Autowired
    private VoteCommandService vService;

    @Autowired
    private VoteCommandRepository voteRepository;

    
    //  endpoint to get a reviews by ID
    @GetMapping(value = "/{id}")
    public ResponseEntity<VoteCommand> getbyID(@PathVariable Long id){

        // GetReviewsQuery query = new GetReviewsQuery();
        // query.setId(id);
        // Reviews review = ReviewService.getbyID(query);
        // return ResponseEntity.ok(review);

        return ResponseEntity.ok(voteRepository.findById(id).get());
    }

    @Operation(summary = "add vote") 
    @PutMapping("/reviews/{reviewID}/vote")
    public ResponseEntity<Boolean> addVote(@PathVariable(value = "reviewID") final Long reviewID, @RequestBody VoteCommandDTO voteCommandDTO){

        boolean added = this.vService.addVoteToReview(reviewID, voteCommandDTO);

        if(!added){
            return ResponseEntity.badRequest().build();
        }

        return new ResponseEntity<Boolean>(added, HttpStatus.CREATED);
    }   
}
