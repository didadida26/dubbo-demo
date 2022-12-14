package cn.itcast.user.controller;


import cn.itcast.user.domain.User;
import cn.itcast.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @DubboReference // 引用服务
    private UserService userService;

    /**
     * 路径： /user/110
     * @param id 用户id
     * @return 用户
     */
    @GetMapping("/{id}")
    public User queryById(@PathVariable("id") Long id) {
        return userService.queryById(id);
    }

    @GetMapping("/username/{id}")
    public String queryUserName(@PathVariable("id") Long id) {
        return userService.queryUserName(id);
    }
}
