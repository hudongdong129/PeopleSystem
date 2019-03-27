package com.hu.dao;

import com.hu.dao.provider.DeptDynaSqlProvider;
import com.hu.domain.Dept;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

import static com.hu.util.HrmConstants.DEPTTABLE;

public interface DeptDao {
    
    /**
     * 动态查询
     * @author huDong
     * @date 2018/10/10 下午9:47
     * @param [params]
     * @return java.util.List<com.hu.domain.Dept>
     */
    @SelectProvider(type=DeptDynaSqlProvider.class,method = "selectWhitParam")
    List<Dept> selectByPage(Map<String,Object> params);


    /**
     * 获得总数
     * @author huDong
     * @date 2018/10/10 下午9:49
     * @param [params]
     * @return java.lang.Integer
     */
    @SelectProvider(type = DeptDynaSqlProvider.class,method = "count")
    Integer count(Map<String,Object> params);

    /**
     * 根据id查询部门
     * @author huDong
     * @date 2018/10/10 下午9:51
     * @param [id]
     * @return com.hu.domain.Dept
     */
    @Select("select * from "+DEPTTABLE+" where id = #{id}")
    Dept selectById(Integer id);

    /**
     * 根据id删除部门
     * @author huDong
     * @date 2018/10/10 下午9:52
     * @param [id]
     * @return void
     */
    @Delete("delete from "+DEPTTABLE+" where id = #{id}")
    void deleteById(Integer id);

    /**
     * 动态插入一个部门
     * @author huDong
     * @date 2018/10/10 下午9:53
     * @param [dept]
     * @return void
     */
    @InsertProvider(type = DeptDynaSqlProvider.class,method = "insertDept")
    void save(Dept dept);


    /**
     * 动态修改用户
     * @author huDong
     * @date 2018/10/10 下午9:55
     * @param [dept]
     * @return void
     */
    @UpdateProvider(type = DeptDynaSqlProvider.class,method = "updateDept")
    void update(Dept dept);

}
