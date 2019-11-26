package com.study.blog.util.uid;

import com.study.blog.data.Sequence;
import com.study.blog.service.SeqService;
import org.springframework.beans.factory.annotation.Autowired;

public class SmallIdGenerator {
    private static SmallIdGenerator smallIdGenerator = new SmallIdGenerator();
    private volatile long start = 0L;
    private volatile long end = 0L;
    private volatile long current = 0L;
    private long capacity = 10L;
    private static final String SEQ_ID = "int6";

    @Autowired
    private SeqService seqService;

    private SmallIdGenerator() {
    }
    public static SmallIdGenerator getGenerator() {
        if (smallIdGenerator == null) {
            smallIdGenerator = new SmallIdGenerator();
        }
        return smallIdGenerator;
    }

    String nextId() {
        return String.format("%d", this.nextLong());
    }

    public synchronized long nextLong() {
        if (this.current < this.end) {
            return (long)(this.current++);
        } else {
            long currentValue = seqService.getValueById(SEQ_ID);
            if (currentValue < 0L) {
                throw new RuntimeException("Can not find the sequece :" + SEQ_ID);
            }
            seqService.update(new Sequence(SEQ_ID,currentValue + capacity));
            this.current = this.start;
            return (long)(this.current++);
        }
    }
}
