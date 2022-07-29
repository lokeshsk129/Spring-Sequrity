package com.iSteer.mail.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.iSteer.mail.model.UserPojo;
import com.iSteer.mail.user.UserSession;

public interface UserSessionRepository extends JpaRepository<UserSession, Long> {

	@Query(value = "select u.userEmail from UserSession u where u.userEmail=?1")
	public String findById(String userid);

	@Modifying()
	@Query(value = "update UserSession u set token=:token,login =:login, logout =:logout where u.useremail=:userEmail", nativeQuery = true)
	@Transactional
	void updateToken(@Param("userEmail") String userEmail, @Param("token") String token, @Param("login") String login,
			@Param("logout") String logout);

	@Modifying()
	@Query(value = "insert into UserSession(useremail,token,login) values(:userEmail,:token,:login)", nativeQuery = true)
	@Transactional
	void insertToken(@Param("userEmail") String userEmail, @Param("token") String token, @Param("login") String login);

	public void save(UserPojo user);

}
