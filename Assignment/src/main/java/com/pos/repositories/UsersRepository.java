package com.pos.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.pos.entities.Users;

public interface UsersRepository extends JpaRepository<Users, Long> {


	@Query("select A from  Users A where A.username =:username and A.password=:Password  and A.isactive = '1' ")
	Users findbyuserandpass(String username, String Password);

	@Query("select A from  Users A where A.username =:username and A.isactive = '1' ")
	Users findbyname(String username);

	@Query("select u from Users u where u.username = ?1 order by u.users_id")
	List<Users> findUserByName(String name);

	@Query("select u from Users u where u.username = ?1 and u.password = ?2 order by u.users_id")
	Users findUserByNameAndPassword(String name, String password);

	@Query("select u from Users u where u.name=:name and u.users_id =:USERSID")
	Users findUserByNameandId(@Param("name") String name, @Param("USERSID") Long USERSID);

	@Query("select u from Users u where u.username=:NAME and u.password =:PASSWORD")
	Users findUserByNameandPassword(@Param("NAME") String NAME, @Param("PASSWORD") String PASSWORD);

	@Query("select u from Users u where u.name =:NAME")
	List<Users> findUserByFullname(@Param("NAME") String name);

	@Query("select u from Users u where u.username = ?1")
	Users getTheUserByNameOnly(String name);


}
