package com.Dao;

import com.Entity.ContentType;
import com.Entity.ContentTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ContentTypeMapper {
    int countByExample(ContentTypeExample example);

    int deleteByExample(ContentTypeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ContentType record);

    int insertSelective(ContentType record);

    List<ContentType> selectByExample(ContentTypeExample example);

    ContentType selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ContentType record, @Param("example") ContentTypeExample example);

    int updateByExample(@Param("record") ContentType record, @Param("example") ContentTypeExample example);

    int updateByPrimaryKeySelective(ContentType record);

    int updateByPrimaryKey(ContentType record);
}