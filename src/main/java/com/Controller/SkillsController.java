package com.Controller;

import Utils.ListConvertUtil;
import Utils.Result;
import com.Dao.SkillsMapper;
import com.Dao.UserMapper;
import com.Entity.Skills;
import com.Entity.SkillsExample;
import com.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller
@CrossOrigin
public class SkillsController {
    @Autowired
    private SkillsMapper skillsMapper;
    @Autowired
    private UserMapper userMapper;

    @GetMapping(value = "/api/allSkills")
    @ResponseBody
    public Map<String, Object> getAllSkills(HttpServletRequest request) {
        String uid = (String) request.getAttribute("uid");
        SkillsExample skillsExample = new SkillsExample();
        List<Skills> skillsList = skillsMapper.selectByExample(skillsExample);
        User user = userMapper.selectByPrimaryKey(uid);
        List<Integer> selectedSkills = new ArrayList<>();
        Arrays.stream(user.getSkills().split(",")).forEach(item -> {
            selectedSkills.add(Integer.valueOf(item));
        });
        Map<String, Object> data = new HashMap<>();
        List<Map<String, Object>> datas = ListConvertUtil.gettest("getId", skillsList, selectedSkills);
        data.put("skills", datas);
        return Result.createResult(20000, "success", data);
    }

    @PutMapping(value = "/api/skills")
    @ResponseBody
    public Map<String, Object> createSkills(@RequestBody Skills skills) {
        int line = skillsMapper.insert(skills);
        return Result.createResult(20000, "skills创建成功", null);
    }


}
