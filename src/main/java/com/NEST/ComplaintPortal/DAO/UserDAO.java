package com.NEST.ComplaintPortal.DAO;

import com.NEST.ComplaintPortal.Model.UserModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserDAO extends CrudRepository<UserModel, Integer> {
    @Query(value = "SELECT `id`, `address`, `dob`, `email`, `name`, `password`, `phone_number` FROM `user_table` WHERE `email`=:email AND `password`=:password ",nativeQuery = true)
    List<UserModel>UserReg(@Param("email")String email,@Param("password")String password);
}
