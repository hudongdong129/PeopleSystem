package com.hu.dao.provider;

import com.hu.domain.User;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

import static com.hu.util.HrmConstants.USERTABLE;

public class UserDynaSqlProvider {

    /**
     * 分页动态查询
     * @param params
     * @return
     */
    public String selectWhitParam(final Map<String,Object> params) {

        String sql = new SQL(){
            {
                SELECT("*");
                FROM(USERTABLE);
                if (params.get("user") != null) {
                    User user = (User) params.get("user");
                    if (user.getUsername() != null && !user.getUsername().equals("")) {
                        WHERE(" username like concat('%',#{user.username},'%') ");
                    }
                    if (user.getStatus() != null && !user.getStatus().equals("")) {
                        WHERE(" status like concat ('%',#{user.status},'%') ");
                    }
                }
            }

        }.toString();
        if (params.get("pageModel") != null) {
            sql += " limit #{pageModel.firstLimitParam} , #{pageModel.pageSize} ";
        }
        return sql;

    }

    /**
     * 动态查询总数量
     * @param params
     * @return
     */
    public String count(final Map<String,Object> params) {
        return new SQL(){
            {
                SELECT("count(*)");
                FROM(USERTABLE);
                if (params.get("user") != null) {
                    User user = (User) params.get("user");
                    if (user.getUsername() != null && !user.getUsername().equals("")) {
                        WHERE(" username LIKE CONCAT ('%',#{user.getUsername},'%') ");
                    }
                    if (user.getStatus() != null && !user.getStatus().equals("")) {
                        WHERE(" status LIKE CONCAT ('%',#{user.status},'%') ");
                    }
                }
            }
        }.toString();

    }

    /**
     * 动态插入一条user对象
     * @param user
     * @return
     */
    public String insertUser(final User user) {
        return new SQL(){
            {
                INSERT_INTO(USERTABLE);
                if (user.getUsername() != null && !user.getUsername().equals("")) {
                    VALUES("username","#{username}");
                }
                if (user.getStatus() != null && !user.getStatus().equals("")) {
                    VALUES("status","#{status}");
                }
                if (user.getLoginname() != null && !user.getLoginname().equals("")) {
                    VALUES("loginname","#{loginname}");
                }
                if (user.getPassword() != null && !user.getPassword().equals("")) {
                    VALUES("password","#{password}");
                }
            }
        }.toString();
    }

    /**
     * 动态更新
     * @param user
     * @return
     */
    public String updateUser(final User user) {
        return new SQL(){
            {
                UPDATE(USERTABLE);
                if (user.getUsername() != null) {
                    SET(" username = #{username} ");
                }
                if (user.getLoginname() != null) {
                    SET(" loginname = #{loginname}");
                }
                if (user.getPassword() != null) {
                    SET(" password = #{password}");
                }
                if (user.getStatus() != null) {
                    SET(" status = #{status} ");
                }
                if (user.getCreateDate() != null) {
                    SET(" create_date = #{createDate} ");
                }
                WHERE(" id = #{id}");
            }
        }.toString();
    }

}
