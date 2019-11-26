package com.study.blog.mapper;

import com.study.blog.data.Sequence;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SeqMapper {

	public Long getValueById(@Param("seqId") String seqId);


	public void update(@Param("sequence") Sequence sequence);

}
