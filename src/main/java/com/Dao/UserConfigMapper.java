package com.Dao;

import com.Entity.UserConfig;
import com.Entity.UserConfigExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserConfigMapper {
    int countByExample(UserConfigExample example);

    int deleteByExample(UserConfigExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserConfig record);

    int insertSelective(UserConfig record);

    List<UserConfig> selectByExample(UserConfigExample example);

    UserConfig selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserConfig record, @Param("example") UserConfigExample example);

    int updateByExample(@Param("record") UserConfig record, @Param("example") UserConfigExample example);

    int updateByPrimaryKeySelective(UserConfig record);

    int updateByPrimaryKey(UserConfig record);
}