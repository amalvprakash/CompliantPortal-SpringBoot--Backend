package com.NEST.ComplaintPortal.DAO;

import com.NEST.ComplaintPortal.Model.ComplaintModel;
import com.NEST.ComplaintPortal.Model.UserModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface ComplaintDAO extends CrudRepository<ComplaintModel, String> {

    @Query(value = "SELECT `id`, `complaint`, `user_id` FROM `complaints` WHERE `user_id` =:userId",nativeQuery = true)
    List<ComplaintModel> Complaints(@Param("userId") Integer id);

    @Query(value = "SELECT c.`complaint`, u.name, u.email FROM `complaints` c join user_table u ON u.id=c.user_id",nativeQuery = true)
    List<Map<String, String>> ViewAllComplaints();
}
