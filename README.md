MsgRoute主要为了解决更换号码带来的各种困扰
安装它以后，所有收到的短信将会被转发给你指定的号码
所以应用场景是这样的，用一个月租很便宜的卡装到废弃的Android机上
然后将所有需要绑定号码的地方都用这个号码绑定，并保证这个号码不会经常更换
这样不管你现在正在使用的号码怎么改变
验证码都会转发给你现在用的手机
你可以通过软件设置，也可以通过短信对软件进行远程设置。

进入编辑：login-密码
离开编辑：out

设置分为
绑定：bind
解绑：unbind
查询用户组：userGroup
发送信息模式(个体)：sent2-msg|email
发送信息模式(全局)：sent2Group-msg|email
关闭：sleep
开启：wake
话费：query
来电挂断：hangup
来电不挂断：dot hangup
命令查询：help
发送信息到指定号码：sent-号码 内容
注：个体设置高于全局设置,默认全部为短信发送.

一般短信，拦截
根据设置的发送方式，发送给注册过的手机号或邮箱
发送方式有邮箱和短信。


拦截电话
有电话进来不会挂断，但是会发送给注册过的用户一个短信提醒。
如果在电话号码簿里有姓名则加上姓名，如果没有则只是发送号码。

----------------------------

后期添加，如果服务手机跟用户手机在同一局域网下，则不转发信息到这个用户
更换号码：update+密码

需要进入APP设置，将询问的权限改为允许



------------------------
关于短信的常量都在这个类里面
Telephony.Sms
[不要被他误导，字段总结全了，但是字段名称不对](http://blog.csdn.net/actual_/article/details/7967385)
[这个挺全](http://blog.csdn.net/mldxs/article/details/20214729)





#搭建
- 在color文件中建立自己的基础颜色，如文字颜色，高亮文字颜色，背景颜色等
- 在dimens中创建常用的大小，并且后期遵守这些大小
- 在styles中将一些基础属性写好
- 在string中写好文案
- 使项目可以在测试和正式状态之间切换
- 搭建初期，我决定用Fragment来写所有界面。其实也不是真的想用fragment，而是不想用传统的跳转模式。

---
#开发
- 对软件设置的设置项很多，并且设置项后期会频繁的改变或增减，如何管理？
- 当务之急是先封装一个ListView
##结构
###config
设置相关，凡是设置相关的操作都转由ConfigManager管理
###message
信息接收管理员，但凡来了消息，都经他分配，被他分配后的信息应该是各个部分想要的结果。
###sender
发送相关，凡是发送信息的操作都有sender来接手
###sys
配置相关的，跟逻辑无关
###util
通用的工具类

---

##问题
- 代码如何组织
- 发送长信息和静默发送邮件如何实现
- 需要开一个服务吗？
- 后期要不要将数据持久化做成数据库，而不是现在的Shard
- 界面如何搭建？
- 
-----------------------
#优化
