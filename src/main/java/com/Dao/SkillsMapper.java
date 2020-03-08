package com.Dao;

import com.Entity.Skills;
import com.Entity.SkillsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SkillsMapper {
    int countByExample(SkillsExample example);

    int deleteByExample(SkillsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Skills record);

    int insertSelective(Skills record);

    List<Skills> selectByExample(SkillsExample example);

    Skills selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Skills record, @Param("example") SkillsExample example);

    int updateByExample(@Param("record") Skills record, @Param("example") SkillsExample example);

    int updateByPrimaryKeySelective(Skills record);

    int updateByPrimaryKey(Skills record);
}