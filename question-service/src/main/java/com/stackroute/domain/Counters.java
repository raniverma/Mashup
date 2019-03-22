package com.stackroute.domain;

import lombok.Builder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="counters")
@Builder
/*counter entity class for storing sequence value*/
public class Counters {

    @Id
    public String id;
    public int seq;
    public Counters(String id, int seq) {
        this.id = id;
        this.seq = seq;
    }
}
