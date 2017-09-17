package com.zc.biz.customer.domain.dao;

import java.util.List;

import com.zc.biz.customer.domain.dataobject.CustomerManageDO;
import com.zc.biz.customer.domain.dataobject.CustomerManageDOExample;
import org.apache.ibatis.annotations.Param;

public interface CustomerManageDOMapper {
    long countByExample(CustomerManageDOExample example);

    int deleteByExample(CustomerManageDOExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CustomerManageDO record);

    void insertBatch(List<CustomerManageDO> records);

    int insertSelective(CustomerManageDO record);

    List<CustomerManageDO> selectByExample(CustomerManageDOExample example);

    CustomerManageDO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CustomerManageDO record,
                                 @Param("example") CustomerManageDOExample example);

    int updateByExample(@Param("record") CustomerManageDO record, @Param("example") CustomerManageDOExample example);

    int updateByPrimaryKeySelective(CustomerManageDO record);

    int updateByPrimaryKey(CustomerManageDO record);
}