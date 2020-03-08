package com.Dao;

import com.Entity.Zan;
import com.Entity.ZanExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ZanMapper {
    int countByExample(ZanExample example);

    int deleteByExample(ZanExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Zan record);

    int insertSelective(Zan record);

    List<Zan> selectByExample(ZanExample example);

    Zan selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Zan record, @Param("example") ZanExample example);

    int updateByExample(@Param("record") Zan record, @Param("example") ZanExample example);

    int updateByPrimaryKeySelective(Zan record);

    int updateByPrimaryKey(Zan record);
}