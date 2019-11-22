package com.study.blog.util.uid;

public class SmallIdGenerator {
    private static SmallIdGenerator smallIdGenerator = new SmallIdGenerator();
    private volatile long start = 0L;
    private volatile long end = 0L;
    private volatile long current = 0L;
    private long capacity = 10L;

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
            long currentValue = DBTools.selectAsLong(conn, "select a.current_value from util_seq a where a.seq_id=? for update", -1L, new Object[]{this.id});
            if (currentValue < 0L) {
                throw new BaseException("core.e1003", "Can not find the sequece :" + this.id);
            }

            DBTools.update(conn, "update util_seq a set a.current_value=? where a.seq_id=?", new Object[]{currentValue + capacity, this.id});
            DBTools.insert(conn, "insert into util_seq_log(seq_id,start,end,update_date,client)values(?,?,?,now(),?)", new Object[]{this.id, currentValue, currentValue + capacity, this.client});
            DBTools.commit(conn);
            this.onPrepare(this.current, this.capacity);
            this.current = this.start;
            return (long)(this.current++);
        }
    }
}
