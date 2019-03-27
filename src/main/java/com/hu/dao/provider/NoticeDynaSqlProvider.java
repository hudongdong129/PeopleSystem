package com.hu.dao.provider;

import com.hu.domain.Notice;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

import static com.hu.util.HrmConstants.NOTICETABLE;


public class NoticeDynaSqlProvider {

    /**
     * 分页查询
     * @author huDong
     * @date 2018/10/13 下午1:59
     * @param [params]
     * @return java.lang.String
     */
    public String selectWhitParam(final Map<String ,Object> params){
        String sql = new SQL(){

            {
                SELECT("*");
                FROM(NOTICETABLE);
                if (params.get("notice") != null) {
                    Notice notice = (Notice) params.get("notice");
                    if (notice.getTitle() != null && !notice.getTitle().equals("")) {
                        WHERE(" title Like concat('%',#{notice.title},'%') ");
                    }
                    if (notice.getContent() != null && !notice.getContent().equals("")) {
                        WHERE(" content like concat('%',#{notice.content},'%') ");
                    }
                }
            }
        }.toString();

        if (params.get("pageModel") != null) {
            sql += " limit #{pageModel.firstLimitParam} ,#{pageModel.pageSize} ";
        }
        return sql;

    }

    /**
     * 动态查询总数
     * @author huDong
     * @date 2018/10/13 下午2:03
     * @param [params]
     * @return java.lang.String
     */
    public String count(final Map<String,Object> params){
        return new SQL(){
            {
                SELECT("count(*)");
                FROM(NOTICETABLE);
                if (params.get("notice") != null) {
                    Notice notice = (Notice) params.get("notice");
                    if (notice.getTitle() != null && !notice.getTitle().equals("")) {
                        WHERE(" title like concat('%',#{notice.title},'%') ");
                    }
                    if (notice.getContent() != null && !notice.getContent().equals("")) {
                        WHERE(" notice like concat('%',#{notice.content},'%')");
                    }
                }
            }
        }.toString();
    }

    /**
     * 动态的插入
     * @author huDong
     * @date 2018/10/13 下午2:08
     * @param [notice]
     * @return java.lang.String
     */
    public String insertNotice(final Notice notice) {
        return new SQL(){
            {
                INSERT_INTO(NOTICETABLE);
                if (notice.getTitle() != null && !notice.getTitle().equals("")) {
                    VALUES("title","#{title}");
                }
                if (notice.getContent() != null && !notice.getContent().equals("")) {
                    VALUES("content","#{content}");
                }
                if (notice.getUser() != null && notice.getUser().getId().equals("")) {
                    VALUES("user_id","#{user_id}");
                }
            }
        }.toString();

    }

    /**
     * 动态的更新
     * @author huDong
     * @date 2018/10/13 下午2:12
     * @param [notice]
     * @return java.lang.String
     */
    public String updateNotice(final Notice notice){
        return new SQL(){
            {
                UPDATE(NOTICETABLE);
                if (notice.getContent() != null && !notice.getContent().equals("")) {
                    SET(" content = #{content}");
                }
                if (notice.getTitle() != null && !notice.getTitle().equals("")) {
                    SET(" title = #{title}");
                }
                if (notice.getUser() != null && !notice.getUser().equals("")) {
                    SET(" user_id = #{user.id}");
                }
                WHERE("id = #{id}");
            }
        }.toString();

    }
}
