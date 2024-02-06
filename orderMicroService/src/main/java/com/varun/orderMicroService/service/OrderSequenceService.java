package com.varun.ordermicroservice.service;

import com.varun.ordermicroservice.entity.OrderSequence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class OrderSequenceService {
    @Autowired
    private MongoOperations mongoOperations;

    public int getOrderSequence(){
        Query query = new Query(Criteria.where("id").is("Order_sequence"));
        Update update = new Update().inc("seq",1);
        OrderSequence orderSequence = mongoOperations.
                findAndModify(query,
                        update,
                        FindAndModifyOptions.options().returnNew(true).upsert(true),
                        OrderSequence.class);
        return orderSequence.getSeq();
    }
}
