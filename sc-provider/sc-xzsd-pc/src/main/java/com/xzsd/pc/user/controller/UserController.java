package com.xzsd.pc.user.controller;

import com.xzsd.pc.user.entity.UserInfo;
import com.xzsd.pc.util.ResponceData;
import com.xzsd.pc.util.AuthUtils;
import com.xzsd.pc.user.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/user")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Resource
    private UserService userService;
    /**
     * 新增用户
     * @param userInfo
     * @return Response
     * @author scout
     * @Date 2020-03-25.
     */
    @PostMapping("saveUser")
    public ResponceData saveUser(UserInfo userInfo){
        try{
            //获取用户ID
            String userId = AuthUtils.getCurrentUserId();
            userInfo.setCreate_by(userId);
            ResponceData responce = userService.saveUser(userInfo);
            return  responce;
        }catch (Exception e){
            logger.error("用户新增失败",e);
            System.out.println(e.toString());
            throw  e;
        }
    }
    /**
     * 修改用户
     * @param userInfo
     * @return Response
     * @author scout
     * @Date 2020-03-25
     */
    @PostMapping("updateUser")
    public ResponceData updateUser(UserInfo userInfo){
        try{
            //获取用户id
            String user = AuthUtils.getCurrentUserId();
            userInfo.setLast_modified_by(user);
            return userService.updateUser(userInfo);
        }catch (Exception e){
            logger.error("修改用户失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
     * 删除用户
     * @param httpServletRequest
     * @return Response
     * @author scout
     * @Date 2020-03-25
     */
    @PostMapping("deleteUser")
    public ResponceData deleteUser(HttpServletRequest httpServletRequest){
        String userCode = httpServletRequest.getParameter("userCode");
        try{
            String user_code = AuthUtils.getCurrentUserId();
            return  userService.deleteUser(userCode,user_code);
        }catch (Exception e){
            logger.error("用户删除失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
     * 查询用户详情
     * @param userCode
     * @return AResponse
     * @author scout
     * @Date 2020-03-21
     */
    @PostMapping("getUserByUserCode")
    public ResponceData getUserByUserCode(String userCode) {
        try {
            return userService.getUserByUserCode(userCode);
        } catch (Exception e) {
            logger.error("用户查询失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
     * 用户列表(分页)
     * @param userInfo
     * @return Response
     * @author scout
     * @Date 2020-03-25
     */
    @PostMapping(value = "listUsers")
    public ResponceData listUsers(UserInfo userInfo){
        try{
            return userService.listUsers(userInfo);
        }catch (Exception e){
            logger.error("用户查询错误");
            System.out.println(e.toString());
            throw e;
        }
    }
}
