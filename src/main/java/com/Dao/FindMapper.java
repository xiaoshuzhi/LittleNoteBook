package com.Dao;

import com.Entity.Find;
import com.Entity.FindExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FindMapper {
    int countByExample(FindExample example);

    int deleteByExample(FindExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Find record);

    int insertSelective(Find record);

    List<Find> selectByExampleWithBLOBs(FindExample example);

    List<Find> selectByExample(FindExample example);

    Find selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Find record, @Param("example") FindExample example);

    int updateByExampleWithBLOBs(@Param("record") Find record, @Param("example") FindExample example);

    int updateByExample(@Param("record") Find record, @Param("example") FindExample example);

    int updateByPrimaryKeySelective(Find record);

    int updateByPrimaryKeyWithBLOBs(Find record);

    int updateByPrimaryKey(Find record);
}