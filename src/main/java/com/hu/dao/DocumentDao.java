package com.hu.dao;

import com.hu.dao.provider.DocumentDynaSqlProvider;
import com.hu.domain.Document;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;
import java.util.Map;

import static com.hu.util.HrmConstants.DOCUMENTTABLE;

public interface DocumentDao {

    
    /**
     * 动态分页查询
     * @author huDong
     * @date 2018/10/13 下午3:34
     * @param [params]
     * @return java.util.List<com.hu.domain.Document>
     */
    @SelectProvider(type = DocumentDynaSqlProvider.class,method = "selectWhitParam")
    @Results({
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "create_date",property = "createDate",javaType = java.util.Date.class),
            @Result(column = "user_id",property = "user",
                one = @One(select = "com.hu.dao.UserDao.selectById",fetchType = FetchType.EAGER))
    })
    List<Document> selectByPage(Map<String,Object> params);


    /**
     * 查询总量总和
     * @author huDong
     * @date 2018/10/13 下午3:36
     * @param [params]
     * @return java.lang.Integer
     */
    @SelectProvider(type = DocumentDynaSqlProvider.class,method = "count")
    Integer count(Map<String,Object> params);


    /**
     * 插入一个文档
     * @author huDong
     * @date 2018/10/13 下午3:38
     * @param [document]
     * @return void
     */
    @InsertProvider(type = DocumentDynaSqlProvider.class,method = "insertDocument")
    void save(Document document);

    /**
     * 动态更新文档
     * @author huDong
     * @date 2018/10/13 下午3:40
     * @param [document]
     * @return void
     */
    @UpdateProvider(type = DocumentDynaSqlProvider.class,method = "updateDocument")
    void update(Document document);

    /**
     * 根据id删除一个文档
     * @author huDong
     * @date 2018/10/13 下午3:44
     * @param [id]
     * @return void
     */
    @Delete(" delete from "+DOCUMENTTABLE+" where id = #{id}")
    void deleteById(Integer id);

    /**
     * 根据id查询一个公告
     * @author huDong
     * @date 2018/10/13 下午3:46
     * @param [id]
     * @return com.hu.domain.Document
     */
    @Select("select * from "+DOCUMENTTABLE+" where id = #{id}")
    Document selectById(Integer id);
}
