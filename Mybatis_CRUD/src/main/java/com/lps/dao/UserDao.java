package com.lps.dao;

import com.lps.domain.User;

import java.util.List;

/**
 * @Author: LiuPeiSun
 * @Date: 2019/9/29 19:37
 */
public interface UserDao {
    List<User>  findAll();

}
