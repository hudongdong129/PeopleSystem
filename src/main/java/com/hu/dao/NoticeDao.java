package com.hu.dao;

import com.hu.dao.provider.NoticeDynaSqlProvider;
import com.hu.domain.Notice;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;
import java.util.Map;

import static com.hu.util.HrmConstants.NOTICETABLE;

public interface NoticeDao {

    /**
     * 动态查询
     * @author huDong
     * @date 2018/10/13 下午2:24
     * @param [params]
     * @return java.util.List<com.hu.domain.Notice>
     */
    @SelectProvider(type = NoticeDynaSqlProvider.class,method = "selectWhitParam")
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "create_date", property = "createDate", javaType = java.util.Date.class),
            @Result(column = "user_id", property = "user",
                    one = @One(select = "com.hu.dao.UserDao.selectById", fetchType = FetchType.EAGER))
    })
    List<Notice> selectByPage(Map<String,Object> params);


    /**
     * 查询总数
     * @author huDong
     * @date 2018/10/13 下午2:27
     * @param [params]
     * @return java.lang.Integer
     */
    @SelectProvider(type = NoticeDynaSqlProvider.class,method = "count")
    Integer count(Map<String,Object> params);


    /**
     * 根据id查询公告
     * @author huDong
     * @date 2018/10/13 下午2:46
     * @param [id]
     * @return com.hu.domain.Notice
     */
    @Select("select * from "+NOTICETABLE+" where id = #{id}")
    Notice selectById(Integer id);

    /**
     * 根据id删除一个公告
     * @author huDong
     * @date 2018/10/13 下午2:48
     * @param [id]
     * @return void
     */
    @Delete("delete from "+NOTICETABLE+" where id =#{id}")
    void deleteById(Integer id);

    /**
     * 插入一个公告
     * @author huDong
     * @date 2018/10/13 下午2:49
     * @param [notice]
     * @return void
     */
    @InsertProvider(type = NoticeDynaSqlProvider.class,method = "insertNotice")
    void save(Notice notice);

    /**
     * 跟新一个公告
     * @author huDong
     * @date 2018/10/13 下午2:50
     * @param [notice]
     * @return void
     */
    @UpdateProvider(type = NoticeDynaSqlProvider.class,method = "updateNotice")
    void update(Notice notice);

}
