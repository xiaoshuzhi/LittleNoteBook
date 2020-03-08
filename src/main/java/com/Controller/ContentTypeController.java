package com.Controller;

import Utils.MyLogger;
import Utils.Result;
import com.Dao.ContentTypeMapper;
import com.Entity.ContentType;
import com.Entity.ContentTypeExample;
import com.Entity.Project;
import com.Entity.ProjectExample;
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
public class ContentTypeController {
    @Autowired
    private ContentTypeMapper contentTypeMapper;

    private MyLogger logger = new MyLogger("com.Controller.ProjectController");

    /*根据uid获取所有的project
    * */
    @GetMapping(value="/api/allContentTypes")
    @ResponseBody
    public Map<String,Object> getAllProjects(){
        Map<String, Object> data = new HashMap<>();
        ContentTypeExample example = new ContentTypeExample();
        List<ContentType> contentTypes = contentTypeMapper.selectByExample(example);
        data.put("contentTypes", contentTypes);
        return Result.createResult(20000, "success", data);
    }

    /*根据projectid，获取单个project信息
     @param id
    * */
    @GetMapping(value="/api/contentType/{id}")
    @ResponseBody
    public Map<String,Object> getProject(@PathVariable Integer id){
        Map<String, Object> data = new HashMap<>();
        ContentType contentType = contentTypeMapper.selectByPrimaryKey(id);
        data.put("contentType",contentType);
        return Result.createResult(20000,"success",data);
    }

    @PostMapping(value="/api/contentType")
    @ResponseBody
    public Map<String,Object> updateProject(@RequestBody ContentType contentType){
        int line = contentTypeMapper.updateByPrimaryKeySelective(contentType);
        return Result.createResult(20000,"success",null);
    }

    @PutMapping(value="/api/contentType")
    @ResponseBody
    public Map<String,Object> createProject(HttpServletRequest request,@RequestBody ContentType contentType){
        Map<String, Object> data = new HashMap<>();
        contentType.setCreateTime(new SimpleDateFormat( "yyyy-MM-DD HH:mm:ss").format(new Date()));
        int line = contentTypeMapper.insert(contentType);
        data.put("id", line);
        return Result.createResult(20000, "success", data);
    }

    @DeleteMapping(value="/api/contentType/{id}")
    @ResponseBody
    public Map<String,Object> deleteProject(@PathVariable Integer id){
        int line = contentTypeMapper.deleteByPrimaryKey(id);
        return Result.createResult(20000,"success",null);
    }
}
