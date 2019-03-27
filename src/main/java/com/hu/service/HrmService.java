package com.hu.service;

import com.hu.domain.*;
import com.hu.util.tag.PageModel;

import java.util.List;

public interface HrmService {

    /**
     * 用户登录
     * @author huDong
     * @date 2018/10/14 下午1:58
     * @param [loginname, password]
     * @return com.hu.domain.User
     */
    User login(String loginname,String password);

    /**
     * 根据id查询用户
     * @author huDong
     * @date 2018/10/15 下午8:48
     * @param [id]
     * @return com.hu.domain.User
     */
    User findUserById(Integer id);


    /**
     * 获得所有用户
     * @author huDong
     * @date 2018/10/15 下午8:50
     * @param [user, pageModel]
     * @return java.util.List<com.hu.domain.User>
     */
    List<User> findUser(User user, PageModel pageModel);

    /**
     * 根据id删除用户
     * @author huDong
     * @date 2018/10/15 下午8:51
     * @param [id]
     * @return void
     */
    void removeUserById(Integer id);

    /**
     * 修改用户
     * @author huDong
     * @date 2018/10/15 下午8:52
     * @param [user]
     * @return void
     */
    void modifyUser(User user);


    /**
     * 添加用户
     * @author huDong
     * @date 2018/10/15 下午8:53
     * @param [user]
     * @return void
     */
    void addUser(User user);


    /**
     * 获得所有员工
     * @author huDong
     * @date 2018/10/15 下午8:54
     * @param [employee, pageModel]
     * @return java.util.List<com.hu.domain.Employee>
     */
    List<Employee> findEmployee(Employee employee, PageModel pageModel);

    /**
     * 根据id删除员工
     * @author huDong
     * @date 2018/10/15 下午8:54
     * @param [id]
     * @return void
     */
    void removeEmployeeById(Integer id);


    /**
     * 根据id查询员工
     * @author huDong
     * @date 2018/10/15 下午8:55
     * @param [id]
     * @return com.hu.domain.Employee
     */
    Employee findEmployeeById(Integer id);


    /**
     * 添加员工
     * @author huDong
     * @date 2018/10/15 下午8:56
     * @param [employee]
     * @return void
     */
    void addEmployee(Employee employee);


    /**
     * 修改员工
     * @author huDong
     * @date 2018/10/15 下午8:56
     * @param [employee]
     * @return void
     */
    void modifyEmployee(Employee employee);


    /**
     * 获得所有部门，分页查询
     * @author huDong
     * @date 2018/10/15 下午8:57
     * @param [dept, pageModel]
     * @return java.util.List<com.hu.domain.Dept>
     */
    List<Dept> findDept(Dept dept,PageModel pageModel);


    /**
     * 获得所有部门
     * @author huDong
     * @date 2018/10/15 下午8:58
     * @param []
     * @return java.util.List<com.hu.domain.Dept>
     */
    List<Dept> findAllDept();

    /**
     * 根据id删除部门
     * @author huDong
     * @date 2018/10/15 下午8:59
     * @param [id]
     * @return void
     */
    public void removeDeptById(Integer id);


    /**
     * 添加部门
     * @author huDong
     * @date 2018/10/15 下午8:59
     * @param [dept]
     * @return void
     */
    void addDept(Dept dept);


    /**
     * 根据id查询部门
     * @author huDong
     * @date 2018/10/15 下午9:00
     * @param [id]
     * @return com.hu.domain.Dept
     */
    Dept findDeptById(Integer id);


    /**
     * 修改部门
     * @author huDong
     * @date 2018/10/15 下午9:01
     * @param [dept]
     * @return void
     */
    void modifyDept(Dept dept);

    /**
     * 获得所有职位
     * @author huDong
     * @date 2018/10/15 下午9:01
     * @param []
     * @return java.util.List<com.hu.domain.Job>
     */
    List<Job> findAllJob();

    /**
     * 获得所有职位，分页查询
     * @author huDong
     * @date 2018/10/15 下午9:02
     * @param [job, pageModel]
     * @return java.util.List<com.hu.domain.Job>
     */
    List<Job> findJob(Job job,PageModel pageModel);

    /**
     * 根据id删除职位
     * @author huDong
     * @date 2018/10/15 下午9:03
     * @param [id]
     * @return void
     */
    void removeJobById(Integer id);


    /**
     * 添加职位
     * @author huDong
     * @date 2018/10/15 下午9:04
     * @param [job]
     * @return void
     */
    void addJob(Job job);


    /**
     * 根据id查询职位
     * @author huDong
     * @date 2018/10/15 下午9:04
     * @param [id]
     * @return com.hu.domain.Job
     */
    Job findJobById(Integer id);


    /**
     * 修改职位
     * @author huDong
     * @date 2018/10/15 下午9:05
     * @param [job]
     * @return void
     */
    void modifyJob(Job job);

    /**
     * 获得所有公告
     * @author huDong
     * @date 2018/10/15 下午9:06
     * @param [notice, pageModel]
     * @return java.util.List<com.hu.domain.Notice>
     */
    List<Notice> findNotice(Notice notice,PageModel pageModel);


    /**
     * 根据id查询公告
     * @author huDong
     * @date 2018/10/15 下午9:06
     * @param [id]
     * @return com.hu.domain.Notice
     */
    Notice findNoticeById(Integer id);


    /**
     * 根据id删除公告
     * @author huDong
     * @date 2018/10/15 下午9:07
     * @param [id]
     * @return void
     */
    void removeNoticeById(Integer id);


    /**
     * 添加公告
     * @author huDong
     * @date 2018/10/15 下午9:08
     * @param [notice]
     * @return void
     */
    void addNotice(Notice notice);

    /**
     * 修改公告
     * @author huDong
     * @date 2018/10/15 下午9:08
     * @param [notice]
     * @return void
     */
    void modifyNotice(Notice notice);


    /**
     * 获得所有文档
     * @author huDong
     * @date 2018/10/15 下午9:09
     * @param [document, pageModel]
     * @return java.util.List<com.hu.domain.Document>
     */
    List<Document> findDocument(Document document,PageModel pageModel);

    /**
     * 添加文档
     * @author huDong
     * @date 2018/10/15 下午9:10
     * @param [document]
     * @return void
     */
    void addDocument(Document document);


    /**
     * 根据id查询文档
     * @author huDong
     * @date 2018/10/15 下午9:11
     * @param [id]
     * @return com.hu.domain.Document
     */
    Document findDocumentById(Integer id);

    /**
     * 根据id删除文档
     * @author huDong
     * @date 2018/10/15 下午9:11
     * @param [id]
     * @return void
     */
    void removeDocumentById(Integer id);


    /**
     * 修改文档
     * @author huDong
     * @date 2018/10/15 下午9:12
     * @param [document]
     * @return void
     */
    void modifyDocument(Document document);
}
