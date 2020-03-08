package com.Controller;

import Utils.Result;
import com.Dao.DirectoryMapper;
import com.Dao.ImgMapper;
import com.Dao.NoteMapper;
import com.Entity.Directory;
import com.Entity.DirectoryExample;
import com.Entity.Note;
import com.Entity.NoteExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@CrossOrigin
public class DirectoryController {
    @Autowired
    private DirectoryMapper directoryMapper;
    @Autowired
    private NoteMapper noteMapper;
    @Autowired
    private ImgMapper imgMapper;

//    @GetMapping(value="/api/getDirectory/{directoryid}")
//    @ResponseBody
//    public Map<String,Object> getOneDirectory(@PathVariable Integer directoryid){
//
//    }

    @PostMapping(value="/api/Directory")
    @ResponseBody
    public Map<String,Object> updateOneDirectory(@RequestBody Directory directory){
        int line = directoryMapper.updateByPrimaryKeySelective(directory);
        return Result.createResult(20000, "success", null);
    }

    @PutMapping(value="/api/Directory")
    @ResponseBody
    public Map<String,Object> creatDirectory(@RequestBody Directory directory){
        directory.setCreateTime(new SimpleDateFormat("yyyy-MM-DD HH:mm:ss").format(new Date()));
        directory.setIsddele("N");
        directory.setDefuatforder("N");
        directory.setFileNum(0);
        int line = directoryMapper.insert(directory);
        return Result.createResult(20000, "success", null);
    }

    @DeleteMapping(value="/api/deleteDirectory/{directory}")
    @ResponseBody
    public Map<String,Object> deleteDirectory(@RequestBody Integer directory){
        Directory dribak = directoryMapper.selectByPrimaryKey(directory);
        if(dribak.getDefuatforder().equals("Y")){
            return Result.createResult(50000, "请勿删除默认文件夹", null);
        }
        /*设置文件夹为删除状态*/
        Directory directory1 = new Directory();
        directory1.setId(directory);
        directory1.setIsddele("Y");
        /*设置文件夹下的所有文件为删除状态，考虑到后期可能会恢复，不对图片进行状态设置*/
        NoteExample noteExample = new NoteExample();
        NoteExample.Criteria noteCriteria = noteExample.createCriteria();
        noteCriteria.andDirectoryIdEqualTo(directory);
        Note note = new Note();
        note.setIsdele("Y");
        noteMapper.updateByExampleSelective(note, noteExample);
        int line = directoryMapper.updateByPrimaryKeySelective(directory1);
        return Result.createResult(20000, "删除文件夹成功", null);
    }

    @GetMapping(value="/api/getAllDirectory")
    @ResponseBody
    public Map<String,Object> getOneDirectory(HttpServletRequest request){
        String uid = (String) request.getAttribute("uid");
        DirectoryExample directoryExample = new DirectoryExample();
        DirectoryExample.Criteria directoryCriteria = directoryExample.createCriteria();
        directoryCriteria.andUseridEqualTo(uid);
        directoryExample.setOrderByClause("");
        List<Directory> directoryList = directoryMapper.selectByExample(directoryExample);
        Map<String, Object> data = new HashMap<>();
        data.put("directoryList", directoryList);


        return Result.createResult(20000, "success",data);
    }

}
