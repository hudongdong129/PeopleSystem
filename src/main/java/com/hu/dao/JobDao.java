package com.hu.dao;

import com.hu.dao.provider.JobDynaSqlProvider;
import com.hu.domain.Job;
import jdk.nashorn.internal.scripts.JO;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

import static com.hu.util.HrmConstants.JOBTABLE;

public interface JobDao {

    /**
     * 根据id查询工作
     * @author huDong
     * @date 2018/10/10 下午10:17
     * @param [id]
     * @return com.hu.domain.Job
     */
    @Select("select * from "+JOBTABLE+" where id =#{id}")
    Job selectById(Integer id);

    /**
     * 查询全部工作
     * @author huDong
     * @date 2018/10/10 下午10:19
     * @param []
     * @return java.util.List<com.hu.domain.Job>
     */
    @Select("select * from "+JOBTABLE +" ")
    List<Job> selectAllJob();


    /**
     * 动态的分页查询
     * @author huDong
     * @date 2018/10/10 下午10:20
     * @param [params]
     * @return java.util.List<com.hu.domain.Job>
     */
    @SelectProvider(type = JobDynaSqlProvider.class,method = "selectWhitParam")
    List<Job> selectByPage(Map<String,Object> params);


    /**
     * 动态总数
     * @author huDong
     * @date 2018/10/10 下午10:21
     * @param [params]
     * @return java.lang.Integer
     */
    @SelectProvider(type = JobDynaSqlProvider.class,method = "count")
    Integer count(Map<String,Object> params);

    /**
     * 动态插入一个部门
     * @author huDong
     * @date 2018/10/10 下午10:24
     * @param [job]
     * @return void
     */
    @InsertProvider(type = JobDynaSqlProvider.class,method = "insertJob")
    void save(Job job);


    /**
     * 动态更新一个部门
     * @author huDong
     * @date 2018/10/10 下午10:28
     * @param
     * @return
     */
    @UpdateProvider(type = JobDynaSqlProvider.class,method = "updateJob")
    void update(Job job);

    /**
     * 根据id删除一个部门
     * @author huDong
     * @date 2018/10/10 下午10:30
     * @param [id]
     * @return void
     */
    @Delete("delete from "+JOBTABLE+" where id = #{id}")
    void deleteById(Integer id);

}
