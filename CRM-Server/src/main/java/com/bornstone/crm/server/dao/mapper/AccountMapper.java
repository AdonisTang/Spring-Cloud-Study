package com.bornstone.crm.server.dao.mapper;

import com.bornstone.crm.server.dao.domain.Account;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * Created by king on 17-6-23.
 */
@Mapper
public interface AccountMapper {
    @Insert("insert into account (id, createTime, updateTime, username, password, accountType) " +
            "values (#{id,jdbcType=VARCHAR}, now(), now(), #{username,jdbcType=VARCHAR},#{password,jdbcType=VARCHAR},#{accountType,jdbcType=INTEGER})")
    String insert(Account account);

    @Update("update account set password = #{password,jdbcType=VARCHAR}, updateTime = now() where id = #{id,jdbcType=VARCHAR}")
    int update(Account account);

    @Select("select * from account where id=#{0}")
    Account selectByPK(String id);

    @Select("select * from account where username = #{username} and password = #{password} and accountType = #{accountType}")
    Account selectByUsernameAndPwd(Account account);
}
