package com.Dao;

import com.Entity.Label;
import org.apache.ibatis.annotations.Param;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.List;

public interface LabelDao {
    /*根据labelid修改labelname*/
    boolean changeLabelname(@Param("labelid") int labelid,@Param("labelname") String labelname);

    /*根据labelid设置是否删除了 */
    boolean changeLabeldele(@Param("labelid") int labelid,@Param("labeldele") String labeldele);

    /*新建一个标签*/
    boolean insertLabel(@Param("label")Label label);

    /*根据用户id查询该用户的所有标签*/
    List<Label> getAllLabel(@Param("userid") String userid);

    /*根据文章id,查询该文章的所有标签*/
    List<Label> getAllLabelOfNote(@Param("noteid") int noteid);

    boolean changeLabsOfNote(@Param("noteid") int noteid,@Param("labeldele") String labeldele);

    boolean deleteLabsOfNote(@Param("noteid")int noteid);

    List<Integer> getlanLids(@Param("noteid")int noteid);

    boolean deleteLabs(@Param("libs")List<Integer> libs);
}
