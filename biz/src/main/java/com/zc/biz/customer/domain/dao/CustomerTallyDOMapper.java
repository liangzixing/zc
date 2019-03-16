package com.zc.biz.customer.domain.dao;

import com.zc.biz.customer.domain.dataobject.CustomerTallyDO;
import com.zc.biz.customer.domain.dataobject.CustomerTallyDOExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

public interface CustomerTallyDOMapper {
    long countByExample(CustomerTallyDOExample example);

    int deleteByExample(CustomerTallyDOExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CustomerTallyDO record);

    int insertSelective(CustomerTallyDO record);

    List<CustomerTallyDO> selectByExample(CustomerTallyDOExample example);

    CustomerTallyDO selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CustomerTallyDO record,
                                 @Param("example") CustomerTallyDOExample example);

    int updateByExample(@Param("record") CustomerTallyDO record, @Param("example") CustomerTallyDOExample example);

    int updateByPrimaryKeySelective(CustomerTallyDO record);

    int updateByPrimaryKey(CustomerTallyDO record);
}