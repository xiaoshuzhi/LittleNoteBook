package com.Controller;

import Utils.MyLogger;
import Utils.Result;
import com.Dao.CommitMapper;
import com.Entity.Commit;
import com.Entity.CommitExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
@CrossOrigin
public class CommitController {
    @Autowired
    private CommitMapper commitMapper;
    private MyLogger my = new MyLogger("com.Controller.CommitController");


    @PostMapping(value = "/api/commit")
    @ResponseBody
    public Map<String, Object> updateCommit(@RequestBody Commit commit) {
        commit.setCreatetime(new SimpleDateFormat("yyyy-MM-DD HH:mm:ss").format(new Date()));
        int line = commitMapper.updateByPrimaryKeySelective(commit);
        return Result.createResult(20000, "success", null);
    }

    @PutMapping(value = "/api/commit")
    @ResponseBody
    public Map<String, Object> createCommit(@RequestBody Commit commit) {
        Map<String, Object> data = new HashMap<>();
        commit.setCreatetime(new SimpleDateFormat("yyyy-MM-DD HH:mm:ss").format(new Date()));
        int line = commitMapper.insertSelective(commit);
        data.put("id", line);
        return Result.createResult(20000, "success", data);
    }

    @DeleteMapping(value = "/api/commit/{id}")
    @ResponseBody
    public Map<String, Object> deleteCommit(@PathVariable Integer id) {
        int line = commitMapper.deleteByPrimaryKey(id);
        return Result.createResult(20000, "success", null);
    }


    @DeleteMapping(value = "/api/commit/deleteAll/{noteid}")
    @ResponseBody
    public Map<String, Object> deleteAllCommit(@PathVariable Integer noteid) {
        CommitExample commitExample = new CommitExample();
        CommitExample.Criteria commitCriteria = commitExample.createCriteria();
        commitCriteria.andNoteidEqualTo(noteid);
        int line = commitMapper.deleteByExample(commitExample);
        return Result.createResult(20000, "success", null);
    }
}
