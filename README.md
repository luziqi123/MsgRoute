# MsgRoute主要为了解决更换号码带来的各种困扰
所以应用场景是这样的，用一个月租很便宜的卡装到废弃的Android机上，然后今后的所有需要绑定号码的地方都用这个号码绑定，来了验证码就会转发给你现在用的手机。
你可以通过软件设置，也可以通过短信对软件进行远程设置。

进入编辑：直接发送密码
离开编辑：out

设置分为
绑定：bind
解绑：unbind
查询用户组：userGroup
发送信息到邮箱(个体)：sent2email
发送信息到短信(个体)：sent2msg
发送信息到邮箱(全局)：sent2emailAll
发送信息到短信(全局)：sent2msgAll
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
