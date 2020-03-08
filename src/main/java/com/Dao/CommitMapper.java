package com.Dao;

import com.Entity.Commit;
import com.Entity.CommitExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CommitMapper {
    int countByExample(CommitExample example);

    int deleteByExample(CommitExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Commit record);

    int insertSelective(Commit record);

    List<Commit> selectByExample(CommitExample example);

    Commit selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Commit record, @Param("example") CommitExample example);

    int updateByExample(@Param("record") Commit record, @Param("example") CommitExample example);

    int updateByPrimaryKeySelective(Commit record);

    int updateByPrimaryKey(Commit record);
}