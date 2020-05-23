package com.xzsd.pc.user.services;


import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.user.dao.UserDao ;
import com.xzsd.pc.user.entity.TopVo;
import com.xzsd.pc.user.entity.UserInfo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import com.xzsd.pc.util.ResponceData;
import java.util.Arrays;
import java.util.List;
import com.xzsd.pc.util.PasswordUtils;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import static com.xzsd.pc.util.AuthUtils.generateMixString;
@Service
public class UserService {
    private ResponceData responceData;
    @Resource
    private UserDao userDao;
    @Autowired
    //private RedisOperator redisOperator;
    private StringRedisTemplate redisTemplate;
    /**
     * 新增用户
     * @param userInfo
     * @return
     * @Author scout
     * @Date 2020-03-25
     */
    @Transactional(rollbackFor = Exception.class)
    public ResponceData saveUser(UserInfo userInfo) {
        //账号是否存在
        if(userDao.countUserAcct(userInfo.getUserAcct(),null)>0){
            return ResponceData.bizError("用户已存在，请重新输入！");
        }
        userInfo.setUserCode(generateMixString(4));
        String pwd = PasswordUtils.generatePassword(userInfo.getUserPwd());
        userInfo.setUserPwd(pwd);
        userInfo.setIs_deleted(0);
        //新增用户
        int count = userDao.saveUser(userInfo);
        if(userInfo.getRole() == 3){
            userDao.addCustomer(userInfo.getUserCode());
        }
        if (0 == count) {
            return ResponceData.bizError("新增失败，请重试");
        }
        return ResponceData.success("新增成功！");
    }
    /**
     * 删除用户
     * @param userCode,userId
     * @param userId
     * @return
     * @Author scout
     * @Date 2020-03-25
     */
    @Transactional(rollbackFor = Exception.class)
    public ResponceData deleteUser(String userCode, String userId) {
        List<String> listCode = Arrays.asList(userCode.split(","));
        ResponceData response = ResponceData.success("删除成功");
        //删除用户
        int count = userDao.deleteUser(listCode, userId);
        //demoDao.deleteUser(listCode,userId);
        if (0 == count) {
            response = ResponceData.bizError("删除失败，请重试！");
        }
        return response;
    }
    /**
     * 查询用户详情
     * @param userCode
     * @return
     * @Author scout
     * @Date 2020-03-25
     */
    public ResponceData getUserByUserCode(String userCode) {
        UserInfo userInfo = userDao.getUserByUserCode(userCode);
        int countUsercode = userDao.countUsercode(userCode);
        if (0 == countUsercode) {
            return ResponceData.bizError("用户已删除，请重新输入");
        }
        return ResponceData.success("查询成功", userInfo);
    }
    /**
     * 修改用户
     * @param userInfo
     * @return
     * @Author scout
     * @Date 2020-03-25
     */
    @Transactional(rollbackFor = Exception.class)
    public ResponceData updateUser(UserInfo userInfo) {
        ResponceData response = ResponceData.success("修改成功");
        //检验账号是否存在
        if(userDao.countUserAcct(userInfo.getUserAcct(),userInfo.getUserCode())>0){
            return ResponceData.bizError("用户已存在，请重新输入！");
        }
        int count = userDao.updateUser(userInfo);
        if (0 == count) {
            response = ResponceData.versionError("数据变化，请重新刷新");
            return response;
        }
        return response;
    }
    /**
     * 查询用户列表（分页）
     * @param userInfo
     * @return
     * @Author scout
     * @Date 2020-03-25
     */
    public ResponceData listUsers(UserInfo userInfo) {
        PageHelper.startPage(userInfo.getPageNum(), userInfo.getPageSize());
        List<UserInfo> userInfoList = userDao.listUsersByPage(userInfo);
        //包装Page对象
        PageInfo<UserInfo> pageData = new PageInfo<UserInfo>(userInfoList);
        return ResponceData.success("查询成功！", pageData);
    }
    /**
     * 顶部栏
     * @return
     */
    public ResponceData getTopOfColumn(){
        TopVo topVo=userDao.getTopOfColumn(SecurityUtils.getCurrentUserId());
        if(topVo==null){
            return ResponceData.bizError("顶部栏信息查询失败,topVo为空");
        }else {
            return ResponceData.success("顶部栏查询成功",topVo);
        }
    }
}
