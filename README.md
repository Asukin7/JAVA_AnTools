# JAVA_AnTools

## 前言

本项目为个人学习与自用项目，其中存在许多不足之处请谅解。

## 项目介绍

本项目为一个记账工具程序，后端使用SSM (SpringMvc + Spring + Mybatis) + Shiro框架、Mysql数据库、Redis缓存实现。

前端地址：[https://github.com/Asukin7/WX_AnTools](https://github.com/Asukin7/WX_AnTools)

### 目录结构

``` lua
AnTools
├─src─main─java─com─anTools
│     │             ├─common -- 通用工具类
│     │             ├─controller -- 控制层
│     │             ├─dao -- 持久层
│     │             ├─entity -- 实体类
│     │             ├─service -- 业务层
│     │             ├─sqlProvider -- 动态SQL语句
│     │             └─util -- 工具类
│     ├─resources┬─applicationContext.xml -- Spring的配置文件
│     │          ├─applicationContextShiro.xml -- Shiro的配置文件
│     │          ├─log4j.properties -- log4j的配置文件
│     │          └─springMvc.xml -- SpringMvc的配置文件
│     └─webapp─WEB─INF─web.xml -- JavaWeb主要配置文件
└──pom.xml -- Maven主要配置文件
```

## 开发环境

### 开发工具

| 工具   | 版本     |
| ------ | -------- |
| IDEA   | 2019.3.1 |
| Mysql  | 8.0.19   |
| Maven  | 3.6.3    |
| Tomcat | 9.0.30   |
| Redis  | 3.2.1    |

### 数据库建库语句

``` mysql
CREATE DATABASE db_antools DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;

USE db_antools;

CREATE TABLE t_user (#用户表
	id INT ( 11 ) NOT NULL AUTO_INCREMENT,#主键
	openId VARCHAR ( 128 ) UNIQUE,#用户唯一标识码
	nickName VARCHAR ( 32 ),#用户昵称
	gender INT ( 1 ),#用户的性别，值为1时是男性，值为2时是女性，值为0时是未知
	avatarUrl VARCHAR ( 256 ),#用户头像，最后一个数值代表正方形头像大小（有0、46、64、96、132数值可选，0代表132*132正方形头像），用户没有头像时该项为空。若用户更换头像，原有头像URL将失效。
	PRIMARY KEY ( id )
);

CREATE TABLE t_bookkeeping (#收支表
	id INT ( 11 ) NOT NULL AUTO_INCREMENT,#主键
	userId INT ( 11 ) NOT NULL,#用户主键
	incomeOrExpend varchar ( 6 ),#收入（income）或支出（expend）
	bkType VARCHAR ( 32 ),#账单类型
	bkDate DATETIME,#账单日期
	bkMoney FLOAT ( 11, 2 ),#账单金额
	bkremark TEXT,#备注文本
	FOREIGN KEY ( userId ) REFERENCES t_user ( id ),
	PRIMARY KEY ( id )
);
```

