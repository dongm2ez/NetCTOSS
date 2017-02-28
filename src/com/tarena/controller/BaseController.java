package com.tarena.controller;

import com.tarena.util.DateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import java.sql.Date;

/**
 * Controller的父类，用于封装一些公共的逻辑。
 */
public class BaseController {

    /**
     * @InitBinder注解的含义是，在请求开始时先调用此方法， 然后再调用Controller的业务方法。
     */
    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        //注册一个自定义的处理类
        //使用DateEditor来处理Date类型的日期转换
        //即将Spring默认处理日期的类型换成DateEditor
        binder.registerCustomEditor(Date.class, new DateEditor());
    }

}
