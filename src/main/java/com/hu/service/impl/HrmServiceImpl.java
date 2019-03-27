package com.hu.service.impl;

import com.hu.dao.*;
import com.hu.domain.*;
import com.hu.service.HrmService;
import com.hu.util.tag.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 人事管理系统服务层接口实现类
 */
@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT)
@Service("hrmService")
public class HrmServiceImpl implements HrmService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private DeptDao deptDao;

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private JobDao jobDao;

    @Autowired
    private NoticeDao noticeDao;

    @Autowired
    private DocumentDao documentDao;


    /**
     * 登录接口的实现
     * @author huDong
     * @date 2018/10/15 下午9:19
     * @param [loginname, password]
     * @return com.hu.domain.User
     */
    @Transactional(readOnly = true)
    @Override
    public User login(String loginname, String password) {
        System.out.println("HrmServiceImple login -- >>");

        return userDao.selectByLoginnameAndPassword(loginname,password);
    }

    /**
     *
     * @author huDong
     * @date 2018/10/15 下午9:21
     * @param [id]
     * @return com.hu.domain.User
     */
    @Transactional(readOnly = true)
    @Override
    public User findUserById(Integer id) {
        return userDao.selectById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> findUser(User user, PageModel pageModel) {
        Map<String,Object> params = new HashMap<>();
        params.put("user",user);
        int recordCount = userDao.count(params);
        System.out.println("recordCount -- >>"+recordCount);
        pageModel.setRecordCount(recordCount);
        if (recordCount > 0) {
            params.put("pageModel",pageModel);
        }
        List<User> users = userDao.selectByPage(params);
        return users;
    }

    @Override
    public void removeUserById(Integer id) {
        userDao.deleteById(id);
    }

    @Override
    public void modifyUser(User user) {
        userDao.update(user);
    }

    @Override
    public void addUser(User user) {
        userDao.save(user);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Employee> findEmployee(Employee employee, PageModel pageModel) {
        Map<String,Object> params = new HashMap<>();
        params.put("employee",employee);
        int recordCount = employeeDao.count(params);
        System.out.println("recordCount -->>"+recordCount);
        pageModel.setRecordCount(recordCount);
        if (recordCount > 0) {
            params.put("pageModel",pageModel);
        }
        List<Employee> employees = employeeDao.selectByPage(params);
        return employees;
    }

    @Override
    public void removeEmployeeById(Integer id) {
        employeeDao.delete(id);
    }

    @Override
    public Employee findEmployeeById(Integer id) {
        return employeeDao.selectById(id);
    }

    @Override
    public void addEmployee(Employee employee) {
        employeeDao.save(employee);
    }

    @Override
    public void modifyEmployee(Employee employee) {
        employeeDao.update(employee);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Dept> findDept(Dept dept, PageModel pageModel) {

        return null;
    }

    @Override
    public List<Dept> findAllDept() {
        return null;
    }

    @Override
    public void removeDeptById(Integer id) {

    }

    @Override
    public void addDept(Dept dept) {

    }

    @Override
    public Dept findDeptById(Integer id) {
        return null;
    }

    @Override
    public void modifyDept(Dept dept) {

    }

    @Override
    public List<Job> findAllJob() {
        return null;
    }

    @Override
    public List<Job> findJob(Job job, PageModel pageModel) {
        return null;
    }

    @Override
    public void removeJobById(Integer id) {

    }

    @Override
    public void addJob(Job job) {

    }

    @Override
    public Job findJobById(Integer id) {
        return null;
    }

    @Override
    public void modifyJob(Job job) {

    }

    @Override
    public List<Notice> findNotice(Notice notice, PageModel pageModel) {
        return null;
    }

    @Override
    public Notice findNoticeById(Integer id) {
        return null;
    }

    @Override
    public void removeNoticeById(Integer id) {

    }

    @Override
    public void addNotice(Notice notice) {

    }

    @Override
    public void modifyNotice(Notice notice) {

    }

    @Override
    public List<Document> findDocument(Document document, PageModel pageModel) {
        return null;
    }

    @Override
    public void addDocument(Document document) {

    }

    @Override
    public Document findDocumentById(Integer id) {
        return null;
    }

    @Override
    public void removeDocumentById(Integer id) {

    }

    @Override
    public void modifyDocument(Document document) {

    }
}
