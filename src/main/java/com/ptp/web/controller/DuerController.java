package com.ptp.web.controller;


import com.ptp.Enum.StatusCodeEnum;
import com.ptp.service.PayLogService;
import com.ptp.service.UserService;
import com.ptp.web.advice.DemoException;
import com.ptp.mode.*;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.groups.Default;


@Slf4j
@Controller
@RequestMapping("/demo")
public class DuerController extends  BaseController {
//    @Value("${user.addr}")
//    String ll;
//    @Value("${user.job}")
//    String ps;
//    @Autowired
//    private  UploadFileConfig uploadFileConfig;
//    @Autowired
//    private UserService userService;
//    @Autowired
//    private PayLogService payLogService;
//
//@PostMapping("/hello")
//@ResponseBody
//public User hello(@RequestBody User user){
//System.out.print(user);
//    return user;
//}
//
//
//    @PostMapping("/pay")
//    @ResponseBody
//    public User hello1( User user){
//        System.out.print(user);
//        return User.builder().userName("sfdf").passWord("gg").build();
//    }
//    /*
//    表单
//     */
//    @PostMapping("/login")
//    @ResponseBody
//    public Ddmode logs(Ddmode user){
//        System.out.print(user);
//        return user;
//    }
//
//    /**
//     json类型的post接口，参数为json，定义一个对象来接收，需要给对象添加@RequestBody注解
//    使用@RequestBody后，客户端调用接口必须添加信息头 Content-type: application/json
// **/
//    @PostMapping("/login2")
//    @ResponseBody
//    public Ddmode dd(@RequestBody Ddmode user){
//        System.out.println(user);
//        log.info("sfdsfdf,%s,%d","ddf",3);
//        log.info(user.toString());
//
//
//        return user;
//    }
//
//    @PostMapping("/login4")
//    @ResponseBody
//    public DeamResponse dd1(@RequestBody Ddmode user){
//        System.out.println(user);
//        log.info("sfdsfdf,%s,%d","ddf",3);
//        log.info(user.toString());
//
//
//        return success();
//    }
//
//    @PostMapping("/login3")
//    @ResponseBody
//    public DeamResponse dd2(@RequestBody Ddmode user){
//        System.out.println(user);
//      //  log.info("sfdsfdf,%s,%d","ddf",3);
//        log.info(user.toString());
//
//
//        return fail();
//    }
//    @PostMapping(value = "/login5" , produces ="application/json;charset=utf-8" )
//    @ResponseBody
//    public DeamResponse dd4(@RequestBody Ddmode user){
//        System.out.println(user);
//        //  log.info("sfdsfdf,%s,%d","ddf",3);
//        log.info(user.toString());
//
//
//        return execption();
//    }
//
//    @PostMapping(value = "/login6", produces ="application/json;charset=utf-8" )
//    @ResponseBody
//    public DeamResponse dd6(@RequestBody Ddmode user){
//        System.out.println(user);
//        //  log.info("sfdsfdf,%s,%d","ddf",3);
//        log.info(user.toString());
//
//
//        return execption("参数错误",user);
//    }
//
//    @PostMapping(value = "/add", produces ="application/json;charset=utf-8" )
//    @ResponseBody
//    public DeamResponse add( @Validated({Default.class, AddGroup.class}) @RequestBody Ddmode user){
//        System.out.println(user);
//        //  log.info("sfdsfdf,%s,%d","ddf",3);
//        log.info(user.toString());
//        int a = 1/0;
//
//
//        return success();
//    }
//    @PostMapping(value = "/update", produces ="application/json;charset=utf-8" )
//    @ResponseBody
//    public DeamResponse update( @Validated({Default.class})  @RequestBody Ddmode user){
//        System.out.println(user);
//
//        log.info(user.toString());
//
//
//        return success();
//    }
//
//    @PostMapping("/hello1")
//    @ResponseBody
//    public String hello1(String  user){
//        log.info(ll);
//        log.info(ps);
//        log.info(ps);
//        log.info(uploadFileConfig.getFileCount());
//        log.info(uploadFileConfig.getFileEncoding());
//        log.info(uploadFileConfig.getFileMaxSize());
//        log.info(uploadFileConfig.getFilePath());
//        log.info(uploadFileConfig.getFileType());
//        log.info("请求参数user:{}",user);
//        if( "admin".equals(user)){
//            throw  new DemoException(StatusCodeEnum.EXCEPTION.getCode(),"此用户不能登录");
//        }
//        return user;
//    }
//
//
//    @PostMapping(value = "/uadd", produces ="application/json;charset=utf-8" )
//    @ResponseBody
//    public DeamResponse uadd( @Validated({Default.class, AddGroup.class}) @RequestBody Duser user){
//
//        userService.add(user);
//        return success();
//    }
//
//    @GetMapping(value = "/select", produces ="application/json;charset=utf-8" )
//    @ResponseBody
//    public DeamResponse select(Integer id){
//
//        log.info("查到用户:{}",userService.select(id));
//        return success("查询成功",userService.select(id));
//    }
//
//    @PostMapping(value = "/update1", produces ="application/json;charset=utf-8" )
//    @ResponseBody
//    public DeamResponse update1( @Validated({Default.class, AddGroup.class}) @RequestBody Duser user){
//
//        userService.update(user);
//        log.info("更新用户:{}",user);
//        return success();
//    }
//    @GetMapping(value = "/delete", produces ="application/json;charset=utf-8" )
//    @ResponseBody
//    public DeamResponse delete( Integer id){
//
//        userService.delete(id);
//        log.info("删除用户:{}",id);
//        return success();
//    }
//
//
//    @PostMapping(value = "/padd", produces ="application/json;charset=utf-8" )
//    @ResponseBody
//    public DeamResponse padd(@RequestBody PayLog payLog){
//
//        payLogService.insert(payLog);
//        return success();
//    }
//    /*
//    表单
//     */
//    @PostMapping("/dlogin")
//    @ResponseBody
//    public DeamResponse logs(String userName, String passWord, HttpSession session){
//        log.info("用户名:{}，密码:{}",userName,passWord);
//        session.setAttribute("isLogin","true");
//        log.info("login登录成功");
//        return success();
//    }

}
