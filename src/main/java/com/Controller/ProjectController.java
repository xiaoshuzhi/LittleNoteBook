package com.Controller;

import Utils.MyLogger;
import Utils.Result;
import com.Dao.ProjectMapper;
import com.Dao.UserMapper;
import com.Entity.Project;
import com.Entity.ProjectExample;
import com.sun.org.apache.regexp.internal.RE;
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
public class ProjectController {
    @Autowired
    private ProjectMapper projectMapper;
    @Autowired
    private UserMapper userMapper;

    private MyLogger logger = new MyLogger("com.Controller.ProjectController");

    /*根据uid获取所有的project
    * */
    @GetMapping(value="/api/allProjects")
    @ResponseBody
    public Map<String,Object> getAllProjects(HttpServletRequest request){
        Map<String, Object> data = new HashMap<>();
        String uid = (String) request.getAttribute("uid");
        ProjectExample projectExample = new ProjectExample();
        ProjectExample.Criteria projectCriteria = projectExample.createCriteria();
        projectCriteria.andUseridEqualTo(uid);
        List<Project> projectList = projectMapper.selectByExample(projectExample);
        data.put("projects", projectList);
        return Result.createResult(20000, "success", data);
    }

    /*根据projectid，获取单个project信息
     @param id
    * */
    @GetMapping(value="/api/project/{id}")
    @ResponseBody
    public Map<String,Object> getProject(@PathVariable Integer id){
        Map<String, Object> data = new HashMap<>();
        Project project = projectMapper.selectByPrimaryKey(id);
        data.put("project", project);
        return Result.createResult(20000,"success",data);
    }

    @PostMapping(value="/api/project")
    @ResponseBody
    public Map<String,Object> updateProject(@RequestBody Project project){
        int line = projectMapper.updateByPrimaryKeySelective(project);
        return Result.createResult(20000,"success",null);
    }

    @PutMapping(value = "/api/project")
    @ResponseBody
    public Map<String, Object> createProject(HttpServletRequest request, @RequestBody Project project) {
        String uid = (String) request.getAttribute("uid");
        ProjectExample projectExample = new ProjectExample();
        ProjectExample.Criteria projectCriteria = projectExample.createCriteria();
        projectCriteria.andUseridEqualTo(uid);
        Map<String, Object> data = new HashMap<>();
        int num = projectMapper.countByExample(projectExample);

        if (num < 3) {
            project.setCreateTime(new SimpleDateFormat("yyyy-MM-DD HH:mm:ss").format(new Date()));
            project.setUserid(uid);
            int line = projectMapper.insert(project);
            data.put("id", line);
        }else{
            return Result.createResult(20400, "数量已满", null);
        }
        return Result.createResult(20000, "success", data);
    }

    @DeleteMapping(value="/api/project/{id}")
    @ResponseBody
    public Map<String,Object> deleteProject(@PathVariable Integer id){
        int line = projectMapper.deleteByPrimaryKey(id);
        return Result.createResult(20000,"success",null);
    }
}
