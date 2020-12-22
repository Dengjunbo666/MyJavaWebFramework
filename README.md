## 为光的java web框架

### 关于本项目

本项目是仿SSM框架的一个轻量级java web框架。

基于传统的Servlet+JSP实现，项目实现了类加载器，Bean容器，ioc与aop。

所涉及的功能其实都是spring与springMVC框架核心功能的简化版。

可以用来巩固java web相关知识，并以此了解spring，springMVC框架实现原理和运行流程。

原项目和教程来自黄勇老师所著的《架构探险-从零开始写Java web框架》。

预计实现的功能与当前进度：

- [x] 第一章：搭建一个简单的web应用
- [x] 第二章：为web应用添加业务功能，实现简单的crud。让该web应用实现以下功能：
  - [x] MVC分层
  - [x] 单元测试
  - [x] 日志打印功能
  - [x] properties文件数据的读取
  - [x] 优化原有的JDBC的代码，使用连接池将原来暴露在外的连接封装起来，并向外提供对数据库增删改查的静态方法。
- [x] 第三章：搭建轻量级的java web框架
  - [x] 加载配置项
  - [x] 实现类加载器
  - [x] 实现bean容器
  - [x] 实现依赖注入功能
  - [x] 加载Controller
  - [x] 初始化框架
  - [x] 请求转发器
- [ ] 第四章：使框架具备AOP特性以及事务管理
  - [ ] 开发AOP框架
  - [ ] 实现线程池
  - [ ] 事务控制
- [ ] 第五章：框架优化与功能扩展
  - [ ] 优化Action参数
  - [ ] 提供文件上传特性
  - [ ] 与ServletAPI解耦
  - [ ] Shiro
  - [ ] 提供安全控制特性
  - [ ] WEB服务框架-CXF

### 联系我

我的个人博客：https://www.dengjunbo.xyz/

wx：dengjunbo666

qq：1056233814