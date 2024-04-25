package com.CRUD_Operation.CRUD.controller;

import com.CRUD_Operation.CRUD.entity.AllData;
import com.CRUD_Operation.CRUD.serivces.Logic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class makeApiController {
    @Autowired
    private Logic logic;

    @GetMapping("/getdata")
    public List<AllData> bringData()
    {
        return logic.getAllData();
    }
    @GetMapping("/getData/{id}")
    public AllData getDataById(@PathVariable Long id)
    {
        return logic.getDatabyId(id).orElse(null);
    }
    @PostMapping("/postData")
    public AllData postTheData(@RequestBody AllData allData)
    {
        return logic.postAllData(allData);
    }
    @DeleteMapping("/DeleteById/{id}")
    public void deletById(@PathVariable Long id)
    {
        logic.deleteById(id);
    }

    @GetMapping("/CustomApi")
    public List<AllData> FatchData()
    {
        return logic.callCustomQuert2();
    }
    @GetMapping("/getLname/{lname}")
    public List<AllData> fatchLname(@PathVariable String lname){
        return logic.bringCity(lname);
    }
    @GetMapping("GetIdLname/{id}/{lname}")
    public List<AllData> fatchIdLname(@PathVariable int id,@PathVariable String lname){
        return logic.callToIdLname(id,lname);
    }

}
