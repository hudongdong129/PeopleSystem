package com.hu.dao.provider;

import com.hu.domain.Dept;
import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

import static com.hu.util.HrmConstants.DEPTTABLE;

public class DeptDynaSqlProvider {

    /**
     *
     * 分页动态查询
     * @author huDong
     * @date 2018/10/10 下午9:26
     * @param [params]
     * @return java.lang.String
     */
    public String selectWhitParam(final Map<String,Object> params){
        String sql = new SQL(){
            {
                SELECT("*");
                FROM(DEPTTABLE);
                if (params.get("dept") != null) {
                    Dept dept = (Dept) params.get("dept");
                    if (dept.getName() != null && !dept.getName().equals("")) {
                        WHERE(" name LIKE CONCAT('%',#{dept.name},'%') ");
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
     *
     * 动态查询总数量
     * @author huDong
     * @date 2018/10/10 下午9:32
     * @param [params]
     * @return java.lang.String
     */
    public String count(final Map<String,Object> params){
        return new SQL(){
            {
                SELECT("count(*)");
                FROM(DEPTTABLE);
                if (params.get("dept") != null) {
                    Dept dept = (Dept) params.get("dept");
                    if (dept.getName() != null && !dept.getName().equals("")) {
                        WHERE(" name LIKE CONCAT ('%',#{dept.name},'%') ");
                    }
                }
            }
        }.toString();
    }

    /**
     *
     * 动态插入
     * @author huDong
     * @date 2018/10/10 下午9:38
     * @param [dept]
     * @return java.lang.String
     */
    public String insertDept(final Dept dept) {
        return new SQL(){
            {
                INSERT_INTO(DEPTTABLE);
                if (dept.getName() != null && !dept.getName().equals("")) {
                    VALUES("name","#{name}");
                }
                if (dept.getRemark() != null && !dept.getRemark().equals("")) {
                    VALUES("remark","#{remark}");
                }
            }
        }.toString();
    }

    /**
     * 动态更新
     * @author huDong
     * @date 2018/10/10 下午9:44
     * @param [dept]
     * @return java.lang.String
     */
    public String updateDept(final Dept dept){
        return new SQL(){
            {
                UPDATE(DEPTTABLE);
                if (dept.getName() != null) {
                    SET("name = #{name}");
                }
                if (dept.getRemark() != null) {
                    SET("remakr = #{remark}");
                }
                WHERE("id = #{id}");
            }
        }.toString();
    }
}
