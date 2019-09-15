package com.Dao;

import com.Entity.Directory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DirectoryDao {

    /*新建文件夹
    * 传入文件夹名，插入一条数据*/
    boolean insertOneDirectory(@Param("directory") Directory directory);

    /*重命名。根据文件夹id，修改文件夹名字*/
    boolean changeDirectory(@Param("directoryid") String directoryid,@Param("directory") String directory);

    /*删除。根据文件夹id，设置是否删除*/
    boolean changeIsdDele(@Param("directoryid") String directoryid,@Param("isddele")String isddele);

    /*设置阅读锁*/
    boolean changeIsdLocked(@Param("directoryid") String directoryid,@Param("isdlocked")String isdlocked);

    /*根据id获取文件夹名*/
    String getDirectory(@Param("directoryid")String directoryid);

    List<Directory> getAllDeletesDir(@Param("userid")String userid);

    List<Directory> getAllDirs(@Param("userid")String userid);

    Directory checkDir(@Param("userid")String userid,@Param("directory") String directory);

    boolean deletOneDir(@Param("directoryid")String directoryid);

    String getDefaultForder(@Param("userid")String userid);

}
