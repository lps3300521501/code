package com.lps.test;

import com.lps.dao.UserDao;
import com.lps.domain.OnglVo;
import com.lps.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class Mybatis_CRUDTest {
    private InputStream in;
    private SqlSession sqlSession;
    private UserDao userDao;

    @Before//用于在测试方法执行之前执行
    public void init() throws Exception {
        //1.读取配置文件，生成字节输入流
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.获取SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //3.获取SqlSession对象
        sqlSession = factory.openSession();
        //4.获取dao的代理对象
        userDao = sqlSession.getMapper(UserDao.class);
    }

    @After//用于在测试方法执行之后执行
    public void destroy() throws Exception {
        //提交事务
        sqlSession.commit();
        //6.释放资源
        sqlSession.close();
        in.close();
    }

    @Test
    public void testFindAll() {
        //5.执行查询所有方法
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println(user);
        }

    }

    @Test
    public void testSave() {
        User user = new User();
        user.setUsername("王文英");
        user.setUsersex("女");
        user.setUseraddress("火星");
        user.setUserbirthday(new Date());
        System.out.println("保存操作之前：" + user);
        //5.执行保存方法
        userDao.saveUser(user);
        System.out.println("保存操作之后：" + user);
        //会显示她的id 因为在dao.xml中配置了selectkey标签
    }

    @Test
    public void testUpdate() {
        User user = new User();
        user.setUserid(51);
        user.setUsername("Update");
        user.setUsersex("女");
        user.setUseraddress("火星");
        user.setUserbirthday(new Date());
        System.out.println("保存操作之前：" + user);
        //5.执行保存方法
        userDao.saveUser(user);
        System.out.println("保存操作之后：" + user);
    }

    /**
     * 删除操作
     */
    @Test
    public void testDelete() {
        userDao.deleteUser(43);
    }

    /**
     * 跟据id查询
     */
    @Test
    public void testById() {
        User byId = userDao.findById(50);
        System.out.println(byId);
    }

    /**
     * 模糊查询
     */
    @Test
    public void testByname() {
        List<User> users = userDao.findByname("%王%");
        for (User user : users) {
            System.out.println(user);
        }
    }

    /**
     * 查询有多少条数据
     */
    @Test
    public void testCount() {
        int count = userDao.findCount();
        System.out.println(count);
    }

    /**
     * 使用Ongl来实现模糊查询
     */
    @Test
    public void testOnglVo() {
        OnglVo vo = new OnglVo();
        User user = new User();
        user.setUsername("%王%");
        vo.setUser(user);
        List<User> users = userDao.findUserByVo(vo);
        for (User username : users) {
            System.out.println(username);
        }
    }


}
