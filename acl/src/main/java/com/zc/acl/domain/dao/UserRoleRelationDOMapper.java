package com.zc.acl.domain.dao;

import com.zc.acl.domain.dataobject.UserRoleRelationDO;
import com.zc.acl.domain.dataobject.UserRoleRelationDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserRoleRelationDOMapper {
    long countByExample(UserRoleRelationDOExample example);

    int deleteByExample(UserRoleRelationDOExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserRoleRelationDO record);

    void insertBatch(List<UserRoleRelationDO> records);

    int insertSelective(UserRoleRelationDO record);

    List<UserRoleRelationDO> selectByExample(UserRoleRelationDOExample example);

    UserRoleRelationDO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserRoleRelationDO record,
                                 @Param("example") UserRoleRelationDOExample example);

    int updateByExample(@Param("record") UserRoleRelationDO record, @Param("example") UserRoleRelationDOExample example);

    int updateByPrimaryKeySelective(UserRoleRelationDO record);

    int updateByPrimaryKey(UserRoleRelationDO record);
}