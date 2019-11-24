package com.nwu.quantum.serviceImpl;
import com.nwu.quantum.common.DataUtils;
import com.nwu.quantum.dao.UserMapper;
import com.nwu.quantum.entity.User;
import com.nwu.quantum.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    /**
     * 用户登录
     * @param email 邮箱
     * @param password 密码
     * @return UserInfo 用户信息
     */
    @Override
    public User login(String email,String password){
        if (email.equals("") || password.equals("")){
            System.out.println("邮箱或密码为空！");
            return null;
        }
        else {
            User user = new User();                 //实例化user，传入邮箱和密码值
            user.setEmail(email);
            user.setPassword(password);
            User userInfo = userMapper.selectByEmailAndPwd(user);     // 执行sql
            if (userInfo == null) {
                System.out.println("邮箱或密码错误！");
            }
            return userInfo;
        }
    }

    /**
     * 用户注册
     * @param email 邮箱
     * @param password 密码
     */
    @Override
    public  int  register(String email,String password){
        int count = 0;
        if(email.equals("") || password.equals(""))
        {
            //TODO异常处理后续完成
            System.out.println("邮箱和密码不能为空！");
        }
        else {
            User user = new User();
            Date RegistTime = DataUtils.getCurrentDate();
            user.setEmail(email);
            user.setPassword(password);
            user.setRegistTime(RegistTime);
            user.setRole(1);
            user.setStatus(1);
            count = userMapper.insert(user);
            if (count == 0) {
                //TODO异常处理后续完成
                System.out.println("注册失败！");
            }
            System.out.println("注册成功！");
        }
        return count;
    }
}
