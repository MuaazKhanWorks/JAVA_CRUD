package com.CRUD_Operation.CRUD.serivces;

import com.CRUD_Operation.CRUD.entity.AllData;
import com.CRUD_Operation.CRUD.repository.CallJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Logic {
    @Autowired
    private CallJpa callJpa;

    public List<AllData> getAllData()
    {
        return callJpa.findAll();
    }

    public Optional<AllData> getDatabyId(Long id)
    {
        return callJpa.findById(id);
    }

    public AllData postAllData(AllData allData)
    {
        return callJpa.save(allData);
    }

    public void deleteById(Long id)
    {
        callJpa.deleteById(id);
    }

    public List<AllData> callCustomQuert2()
    {
        return callJpa.callCustomQuery();
    }
    public List<AllData> bringCity(String lname){
        return callJpa.fatchCity(lname);
    }
    public List<AllData> callToIdLname(int id,String lname){
        return callJpa.CallForIdLname(id,lname);
    }
}
