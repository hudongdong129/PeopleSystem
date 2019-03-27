package com.hu.dao.provider;

import com.hu.domain.Job;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

import static com.hu.util.HrmConstants.JOBTABLE;


public class JobDynaSqlProvider {
    
    /**
     * 动态查询
     * @author huDong
     * @date 2018/10/10 下午10:01
     * @param [params]
     * @return java.lang.String
     */
    public String selectWhitParam(final Map<String,Object> params){
        String sql = new SQL(){
            {
                SELECT("*");
                FROM(JOBTABLE);
                if (params.get("job") != null) {
                    Job job = (Job) params.get("obj");
                    if (job.getName() != null && !job.getName().equals("")) {
                        WHERE(" name like concatO('%',#{job.name},'%') ");
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
     * 动态查询总数
     * @author huDong
     * @date 2018/10/10 下午10:09
     * @param [params]
     * @return java.lang.String
     */
    public String count(final Map<String,Object> params) {
        return new SQL(){
            {
                SELECT("count(*)");
                FROM(JOBTABLE);
                if (params.get("job") != null) {
                    Job job = (Job) params.get("job");
                    if (job.getName() != null && !job.getName().equals("")) {
                        WHERE(" name like concat('%',#{job.name},'%') ");
                    }
                }
            }
        }.toString();

    }

    /**
     * 动态插入
     * @author huDong
     * @date 2018/10/10 下午10:12
     * @param [job]
     * @return java.lang.String
     */
    public String insertJob(final Job job) {
        return new SQL() {
            {
                INSERT_INTO(JOBTABLE);
                if (job.getName() != null && !job.getName().equals("")) {
                    VALUES("name","#{name}");
                }
                if (job.getRemark() != null && !job.getRemark().equals("")) {
                    VALUES("remark","#{remark}");
                }

            }
        }.toString();

    }


    /**
     * 动态更新
     * @author huDong
     * @date 2018/10/10 下午10:15
     * @param [job]
     * @return java.lang.String
     */
    public String updateJob(final Job job) {
        return new SQL(){
            {
                UPDATE(JOBTABLE);
                if (job.getName() !=null && !job.getName().equals("")) {
                    SET(" name = #{name}");
                }
                if (job.getRemark() != null) {
                    SET(" remark = #{remark}");
                }
                WHERE(" id = #{id}");
            }
        }.toString();
    }
}
