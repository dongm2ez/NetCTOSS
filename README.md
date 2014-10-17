NetCTOSS
========

#电信运营支撑系统-网络版

##项目背景
    电信公司有UNIX服务器的出租业务,在 使用上需要先去营业厅开通帐号,然后 用自己公司的电脑远程访问服务器,部署 软件.针对这项出租业务,需要一套办公 系统来支持,以实现办公自动化. 
	
	
作用
    主要用来给客户开户，使用此账号可以登录UNIX服务器，以及实现 后续的计费工作。
使用者
    电信营业厅的营业员
部署
    应用服务器
		
##技术架构
    1）所用技术
      Java+Spring+MyBatis+JSP+JQuery
    2）开发环境
      windows+MyEclipse2014+tomcat8+JDK7
    3）采用MVC思想，对代码分层
      --视图层(V)
 JSP
      --控制层(C)
 DispatcherServlet+Controller
      --业务层(C)
 Controller
      --持久层(M)
 MyBatis