package com.study.blog.service;

import com.study.blog.data.Sequence;
import com.study.blog.mapper.SeqMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SeqService {

    @Autowired
    private SeqMapper seqMapper;

    public Long getValueById(String seqId) {
        return this.seqMapper.getValueById(seqId);
    }

    public Sequence update(Sequence sequence) {
        this.seqMapper.update(sequence);
        return sequence;
    }
}
