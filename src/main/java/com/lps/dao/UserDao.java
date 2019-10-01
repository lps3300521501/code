package com.lps.dao;

import com.lps.domain.OnglVo;
import com.lps.domain.User;

import java.util.List;
public interface UserDao {
    /**
     * 查询所有
     * @return
     */
    List<User> findAll();

    /**
     * 保存
     * @param user
     */
    void saveUser(User user);

    /**
     * 更新操作
     * @param user
     */
    void updateUser(User user);

    /**
     * 删除操作
     * @param id
     */
    void deleteUser(Integer id);

    /**
     * 跟据id查询用户
     * @param id
     * @return
     */
    User findById(Integer id);

    /**
     * 跟据名称模糊查询用户信息
     * @param username
     * @return
     */
    List<User> findByname(String username);

    /**
     * 查询总条数
     * @return
     */
    int findCount();

    /**
     *
     * @param vo
     * @return
     */
    List<User> findUserByVo(OnglVo vo);



}


