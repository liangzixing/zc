package com.zc.biz.customer.domain.dao;

import com.zc.biz.customer.domain.dataobject.CustomerDO;
import com.zc.biz.customer.domain.dataobject.CustomerDOExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

public interface CustomerDOMapper {
    long countByExample(CustomerDOExample example);

    int deleteByExample(CustomerDOExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CustomerDO record);

    int insertSelective(CustomerDO record);

    List<CustomerDO> selectByExample(CustomerDOExample example);

    CustomerDO selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CustomerDO record, @Param("example") CustomerDOExample example);

    int updateByExample(@Param("record") CustomerDO record, @Param("example") CustomerDOExample example);

    int updateByPrimaryKeySelective(CustomerDO record);

    int updateByPrimaryKey(CustomerDO record);
}