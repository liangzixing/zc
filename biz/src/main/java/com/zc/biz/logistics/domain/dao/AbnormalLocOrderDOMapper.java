package com.zc.biz.logistics.domain.dao;

import com.zc.biz.logistics.domain.dataobject.AbnormalLocOrderDO;
import com.zc.biz.logistics.domain.dataobject.AbnormalLocOrderDOExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AbnormalLocOrderDOMapper {
    long countByExample(AbnormalLocOrderDOExample example);

    int deleteByExample(AbnormalLocOrderDOExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AbnormalLocOrderDO record);

    int insertSelective(AbnormalLocOrderDO record);

    List<AbnormalLocOrderDO> selectByExample(AbnormalLocOrderDOExample example);

    AbnormalLocOrderDO selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AbnormalLocOrderDO record,
                                 @Param("example") AbnormalLocOrderDOExample example);

    int updateByExample(@Param("record") AbnormalLocOrderDO record, @Param("example") AbnormalLocOrderDOExample example);

    int updateByPrimaryKeySelective(AbnormalLocOrderDO record);

    int updateByPrimaryKey(AbnormalLocOrderDO record);
}