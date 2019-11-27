package com.study.blog.data;

import java.io.Serializable;
import java.sql.Timestamp;

public class Sequence implements Serializable {

    private static final long serialVersionUID = 8025353891479934700L;

    private String seqId;

    private String name;

    private String note;

    private Long currentValue;

    private Timestamp createTime;

    private Timestamp updateTime;

    public String getSeqId() {
        return seqId;
    }

    public void setSeqId(String seqId) {
        this.seqId = seqId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Long getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(Long currentValue) {
        this.currentValue = currentValue;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public Sequence(String seqId, Long currentValue) {
        this.setSeqId(seqId);
        this.setName("");
        this.setNote("");
        this.setCurrentValue(currentValue);
    }

}
