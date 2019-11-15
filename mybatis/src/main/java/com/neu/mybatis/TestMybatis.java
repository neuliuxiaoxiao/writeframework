package com.neu.mybatis;

import com.neu.mybatis.bean.User;
import com.neu.mybatis.mapper.UserMapper;
import com.neu.mybatis.sqlSession.MySqlsession;

/**
 * @Title TestMybatis
 * @Description TODO
 * @Author liuxi58
 * @Date 2019/11/12 15:49
 **/

public class TestMybatis {

    public static void main(String[] args) {
        MySqlsession sqlsession=new MySqlsession();
        UserMapper mapper = sqlsession.getMapper(UserMapper.class);
        User user = mapper.getUserById("2");
        System.out.println(user);
    }

}