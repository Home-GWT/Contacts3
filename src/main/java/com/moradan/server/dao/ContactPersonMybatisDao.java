package com.moradan.server.dao;

import com.moradan.shared.domain.ContactPerson;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

/**
 * Это Persistence-модель (определение), реализована через 'Spring'
 * ****************************************************************
 * Mybatis + Spring (XML | Annotation) Mapper
 * {@link http://hmkcode.com/mybatis-spring-xml-annotation-mapper/}
 */
public interface ContactPersonMybatisDao {

    @Select("SELECT * FROM contacts WHERE id = #{id}")
    ContactPerson getContact(@Param("id") String id);

    @Select("INSERT INTO contacts (id,firstName,lastName,emailAddress) VALUES (#{id}, #{firstName}, #{lastName}, #{emailAddress})")
    void addContact(@Param("id") String id, @Param("firstName") String firstName, @Param("lastName") String lastName, @Param("emailAddress") String emailAddress);

    @Select("UPDATE contacts SET firstName = #{firstName}, lastName = #{lastName}, emailAddress = #{emailAddress} WHERE id = #{id}")
    void updateContact(@Param("id") String id, @Param("firstName") String firstName, @Param("lastName") String lastName, @Param("emailAddress") String emailAddress);

    @Select("DELETE FROM contacts WHERE id = #{id}")
    void deleteContact(@Param("id") String id);

    @Select("SELECT * FROM contacts")
    ArrayList<ContactPerson> getContactDetails();
}
