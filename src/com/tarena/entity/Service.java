package com.tarena.entity;

import java.sql.Timestamp;

/**
 * 业务账号实体类
 *
 * @author Administrator
 */
public class Service {
    private Integer service_id;
    private Integer account_id;
    private String unix_host;
    private String os_username;
    private String login_passwd;
    private String status;
    private Timestamp create_date;
    private Timestamp pause_date;
    private Timestamp close_date;
    private Integer cost_id;

    public Integer getService_id() {
        return service_id;
    }

    public void setService_id(Integer service_id) {
        this.service_id = service_id;
    }

    public Integer getAccount_id() {
        return account_id;
    }

    public void setAccount_id(Integer account_id) {
        this.account_id = account_id;
    }

    public String getUnix_host() {
        return unix_host;
    }

    public void setUnix_host(String unix_host) {
        this.unix_host = unix_host;
    }

    public String getOs_username() {
        return os_username;
    }

    public void setOs_username(String os_username) {
        this.os_username = os_username;
    }

    public String getLogin_passwd() {
        return login_passwd;
    }

    public void setLogin_passwd(String login_passwd) {
        this.login_passwd = login_passwd;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Timestamp getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Timestamp create_date) {
        this.create_date = create_date;
    }

    public Timestamp getPause_date() {
        return pause_date;
    }

    public void setPause_date(Timestamp pause_date) {
        this.pause_date = pause_date;
    }

    public Timestamp getClose_date() {
        return close_date;
    }

    public void setClose_date(Timestamp close_date) {
        this.close_date = close_date;
    }

    public Integer getCost_id() {
        return cost_id;
    }

    public void setCost_id(Integer cost_id) {
        this.cost_id = cost_id;
    }

}
