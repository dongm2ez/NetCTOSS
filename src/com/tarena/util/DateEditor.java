package com.tarena.util;

import java.beans.PropertyEditorSupport;
import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 * 表单向Controller传参时，Spring对日期的处理类。
 * 其默认的类存在问题，无法处理空的日期，因此这里
 * 写一个自定义的处理类。
 */
public class DateEditor extends PropertyEditorSupport {

    //默认的日期格式
    private String pattern = "yyyy-MM-dd";

    public DateEditor() {

    }

    public DateEditor(String pattern) {
        this.pattern = pattern;
    }

    /*
     * @param text
     * 	是页面文本框中的值
     * 将文本框输入的值格式化后，再设置给Spring
     */
    @Override
    public void setAsText(String text)
            throws IllegalArgumentException {
        if (text == null || text.length() == 0) {
            //如果输入的是空值，则将空值设置给Spring
            //Spring默认的处理类实际上就是少了这一步，才报错
            setValue(null);
        } else {
            SimpleDateFormat sf = new SimpleDateFormat(this.pattern);
            String dateStr = sf.format(Date.valueOf(text));
            setValue(Date.valueOf(dateStr));
        }
    }

}
