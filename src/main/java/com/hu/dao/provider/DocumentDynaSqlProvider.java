package com.hu.dao.provider;

import com.hu.domain.Document;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

import static com.hu.util.HrmConstants.DOCUMENTTABLE;
import static com.hu.util.HrmConstants.NOTICETABLE;

public class DocumentDynaSqlProvider {

    /**
     * 分页查询全部
     * @author huDong
     * @date 2018/10/13 下午3:00
     * @param [params]
     * @return java.lang.String
     */
    public String selectWhitParam(final Map<String,Object> params) {
        String sql = new SQL(){
            {
                SELECT("*");
                FROM(DOCUMENTTABLE);
                if (params.get("document") != null) {
                    Document document = (Document) params.get("document");
                    if (document.getTitle() != null && !document.getTitle().equals("")) {
                        WHERE(" title lile concat('%',#{document.title},'%') ");
                    }

                }
            }
        }.toString();
        if (params.get("pageModel") != null) {
            sql += " limit #{pageModel.firstLimitParam}, #{pageModel.pageSize} ";
        }
        return sql;
    }

    /**
     * 获得总数
     * @author huDong
     * @date 2018/10/13 下午3:03
     * @param [params]
     * @return java.lang.String
     */
    public String count(final Map<String,Object> params) {
        return new SQL(){
            {
                SELECT("count(*)");
                FROM(NOTICETABLE);
                if (params.get("document") != null) {
                    Document document = (Document) params.get("document");
                    if (document.getTitle() != null && !document.getTitle().equals("")) {
                        WHERE("title like concat('%',#{document.title},'%') ");
                    }

                }
            }
        }.toString();
    }

    /**
     * 动态插入
     * @author huDong
     * @date 2018/10/13 下午3:17
     * @param [document]
     * @return java.lang.String
     */
    public String insertDocument(final Document document) {
        return new SQL(){
            {
                INSERT_INTO(NOTICETABLE);
                if (document.getTitle() != null && !document.getTitle().equals("")) {
                    VALUES("title","#{title}");
                }
                if (document.getFileName() != null && !document.getFileName().equals("")) {
                    VALUES("filename","#{fileName}");
                }
                if (document.getRemark() != null && !document.getRemark().equals("")) {
                    VALUES("remark","#{remark}");
                }
                if (document.getUser() != null && !document.getUser().getId().equals("")) {
                    VALUES("user_id","#{user.id}");
                }
            }
        }.toString();

    }

    /**
     * 更新文件
     * @author huDong
     * @date 2018/10/13 下午3:26
     * @param [document]
     * @return java.lang.String
     */
    public String updateDocument(final Document document) {
        return new SQL(){
            {
                UPDATE(NOTICETABLE);
                if (document.getTitle() != null && !document.getTitle().equals("")) {
                    SET(" title = #{title}");
                }
                if (document.getFileName() != null && !document.getFileName().equals("")) {
                    SET(" filename = #{fileName}");
                }
                if (document.getUser() != null && !document.getUser().getId().equals("")) {
                    SET(" user_id = #{user.id}");
                }
                WHERE(" id = #{id}");
            }
        }.toString();
    }
}
