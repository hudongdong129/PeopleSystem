package com.hu.dao;

import com.hu.dao.provider.EmployeeDynaSqlProvider;
import com.hu.domain.Employee;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;
import java.util.Map;

import static com.hu.util.HrmConstants.EMPLOYEETABLE;

public interface EmployeeDao {


    /**
     * 根据参数查询员工总数
     * @author huDong
     * @date 2018/10/13 下午1:22
     * @param [params]
     * @return java.lang.Integer
     */
    @SelectProvider(type=EmployeeDynaSqlProvider.class,method = "count")
    Integer count(Map<String,Object> params);


    /**
     * 查询员工总数
     * @author huDong
     * @date 2018/10/13 下午1:33
     * @param [params]
     * @return java.util.List<com.hu.domain.Employee>
     */
    @SelectProvider(type = EmployeeDynaSqlProvider.class,method = "selectWhitParam")
    @Results({
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "card_id",property = "cardId"),
            @Result(column = "post_code",property = "postCode"),
            @Result(column = "qq_num",property = "qqNum"),
            @Result(column = "birthday",property = "birthday",javaType = java.util.Date.class),
            @Result(column = "create_date",property = "createDate",javaType = java.util.Date.class),
            @Result(column = "dept_id",property = "dept",one = @One(select = "com.hu.dao.DeptDao.selectById",fetchType = FetchType.EAGER)),
            @Result(column = "job_id",property = "job",one = @One(select = "com.hu.dao.JobDao.selectById",fetchType = FetchType.EAGER)),

    })
    List<Employee> selectByPage(Map<String,Object> params);


    /**
     * 动态插入员工
     * @author huDong
     * @date 2018/10/13 下午1:36
     * @param [employee]
     * @return void
     */
    @InsertProvider(type = EmployeeDynaSqlProvider.class,method = "insertEmployee")
    void save(Employee employee);

    /**
     * 根据id删除一个员工
     * @author huDong
     * @date 2018/10/13 下午1:38
     * @param [id]
     * @return void
     */
    @Delete(" delete from "+EMPLOYEETABLE+" where id=#{id}")
    void delete(Integer id);


    /**
     * 根据id查询一个员工
     * @author huDong
     * @date 2018/10/13 下午1:39
     * @param [id]
     * @return com.hu.domain.Employee
     */
    @Select("select * from "+EMPLOYEETABLE+" where id = #{id}")
    @Results({
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "card_id",property = "cardId"),
            @Result(column = "post_code",property = "postCode"),
            @Result(column = "qq_num",property = "qqNum"),
            @Result(column = "birthday",property = "birthday",javaType = java.util.Date.class),
            @Result(column = "create_date",property = "createDate",javaType = java.util.Date.class),
            @Result(column = "dept_id",property = "dept",
                one = @One(select = "com.hu.dao.DeptDao.selectById",fetchType = FetchType.EAGER)),
            @Result(column = "job_id",property = "job",
                one = @One(select = "com.hu.dao.JobDao.selectById",fetchType = FetchType.EAGER)),

    })
    Employee selectById(Integer id);


    /**
     * 动态修改员工
     * @author huDong
     * @date 2018/10/13 下午1:47
     * @param [employee]
     * @return void
     */
    @UpdateProvider(type = EmployeeDynaSqlProvider.class,method = "upateEmployee")
    void update(Employee employee);

}
