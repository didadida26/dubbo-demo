package cn.itcast.user.service.impl;


import cn.itcast.user.domain.User;
import cn.itcast.user.mapper.UserMapper;
import cn.itcast.user.service.UserService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

//@Service
@DubboService // 暴露服务给其他服务
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    public User queryById(Long id) {
        return userMapper.findById(id);
    }

    @Override
    public String queryUserName(Long id) {
        return userMapper.findById(id).getUsername();
    }


}