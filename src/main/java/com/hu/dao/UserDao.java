package com.hu.dao;

import com.hu.dao.provider.UserDynaSqlProvider;
import com.hu.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

import static com.hu.util.HrmConstants.USERTABLE;

public interface UserDao {

    /**
     * 根据登录名和密码查询员工
     * @param loginname
     * @param password
     * @return
     */
    @Select("select * from "+USERTABLE+" where loginname = #{loginname} and password = #{password}")
    User selectByLoginnameAndPassword(
            @Param("loginname") String loginname,
            @Param("password") String password );

    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    @Select("select * from "+USERTABLE+" where id = #{id}")
    User selectById(Integer id);

    /**
     * 根据id去删除用户
     * @param id
     */
    @Delete("delete from "+USERTABLE+" where id = #{id}")
    void deleteById(Integer id);

    /**
     * 动态更新
     * @param user
     */
    @UpdateProvider( type = UserDynaSqlProvider.class,method = "updateUser")
    void update(User user);

    /**
     * 动态分页查询
     * @param params
     * @return
     */
    @SelectProvider(type = UserDynaSqlProvider.class,method = "selectWhitParam")
    List<User> selectByPage(Map<String,Object> params);

    /**
     * 动态查询用户总数
     * @param params
     * @return
     */
    @SelectProvider(type = UserDynaSqlProvider.class,method = "count")
    Integer count(Map<String,Object> params);

    /**
     * 动态插入用户
     * @param user
     */
    @InsertProvider(type = UserDynaSqlProvider.class,method = "insertUser")
    void save(User user);

}
