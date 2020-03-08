package com.Dao;

import com.Entity.Directory;
import com.Entity.DirectoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DirectoryMapper {
    int countByExample(DirectoryExample example);

    int deleteByExample(DirectoryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Directory record);

    int insertSelective(Directory record);

    List<Directory> selectByExample(DirectoryExample example);

    Directory selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Directory record, @Param("example") DirectoryExample example);

    int updateByExample(@Param("record") Directory record, @Param("example") DirectoryExample example);

    int updateByPrimaryKeySelective(Directory record);

    int updateByPrimaryKey(Directory record);
}