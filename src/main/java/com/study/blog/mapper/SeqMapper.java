package com.study.blog.mapper;

import com.study.blog.data.Sequence;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SeqMapper {

	public Long getValueById(String seqId);


	public void update(Sequence sequence);

}
