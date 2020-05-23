package com.xzsd.app.register.service;


import com.xzsd.app.register.Dao.RegisterDao;
import com.xzsd.app.register.entity.RegisterEntity;
import com.xzsd.app.util.PasswordUtils;
import com.xzsd.app.util.ResponceData;
import java.lang.String;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import static com.xzsd.app.util.AuthUtils.generateMixString;
/**
 * @author scout
 * @date 2020年4月20日
 */
@Service
public class RegisterService {
    @Resource
    private RegisterDao registerDao;
    /***
     * 新增用户
     * @ClassName
     * @param registerEntity
     * @Return :
     * @Author : scout
     * @Date : 2020年4月20日
     */
    @Transactional(rollbackFor = Exception.class)
    public ResponceData addUser(RegisterEntity registerEntity) {
        //检查用户是否存在
        int countUserById = registerDao.countById(registerEntity.getUserAcct());
        if (0 != countUserById) {
            return ResponceData.bizError("用户账号存在,请重新输入");
        }
        registerEntity.setUserCode(generateMixString(4));
        String pwd = PasswordUtils.generatePassword(registerEntity.getUserPwd());
        registerEntity.setUserPwd(pwd);
        registerEntity.setIs_deleted(0);
        int count = registerDao.clientRegister(registerEntity);
        int num=registerDao.addCustomer(registerEntity.getUserCode(),registerEntity.getInviteCode());
        if (0 == count||0==num) {
            return ResponceData.bizError("注册失败，请重试");
        }
        return ResponceData.success("注册成功");
    }
}
