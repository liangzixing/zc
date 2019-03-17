package com.zc.biz.logistics.domain.dao;

import com.zc.biz.logistics.domain.dataobject.AbLocOrderOPLogDO;
import com.zc.biz.logistics.domain.dataobject.AbLocOrderOPLogDOExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AbLocOrderOPLogDOMapper {
    long countByExample(AbLocOrderOPLogDOExample example);

    int deleteByExample(AbLocOrderOPLogDOExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AbLocOrderOPLogDO record);

    int insertSelective(AbLocOrderOPLogDO record);

    List<AbLocOrderOPLogDO> selectByExample(AbLocOrderOPLogDOExample example);

    AbLocOrderOPLogDO selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AbLocOrderOPLogDO record,
                                 @Param("example") AbLocOrderOPLogDOExample example);

    int updateByExample(@Param("record") AbLocOrderOPLogDO record, @Param("example") AbLocOrderOPLogDOExample example);

    int updateByPrimaryKeySelective(AbLocOrderOPLogDO record);

    int updateByPrimaryKey(AbLocOrderOPLogDO record);
}