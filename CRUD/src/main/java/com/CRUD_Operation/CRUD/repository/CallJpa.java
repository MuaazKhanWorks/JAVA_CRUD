package com.CRUD_Operation.CRUD.repository;

import com.CRUD_Operation.CRUD.entity.AllData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CallJpa extends JpaRepository<AllData, Long> {

    @Query(nativeQuery = true, value = "select * from all_data where fname like '%M%';")
    public List<AllData> callCustomQuery();

    @Query("SELECT s FROM AllData s WHERE s.lname=:s")
    public List<AllData> fatchCity(@Param("s") String lname);

    @Query("select s from AllData s where s.id=:y and s.lname=:z")
    public List<AllData> CallForIdLname(@Param("y") int id,@Param("z") String lname);
}
