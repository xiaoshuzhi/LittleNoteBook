# 小小在线笔记
**小小是一个在线做笔记的网站，用户无需下载安装即可使用其提供的富文本编辑器记录自己的学习心得。它风格简约，功能实用，专注笔记软件的基本功能，即提供富文本的编辑功能，笔记和文件夹创建、修改、删除和恢复，全文检索功能以及在笔记中高亮显示匹配的关键字。未来，我们将提供更多使用的功能，提升用户体验。**

## 项目概述
+ #### 开发环境
    + Spring+SpringMVC+Mybatis
    + Thymeleaf模板引擎
    + Lucene实现笔记的全文检索以及高亮显示
    + KindEditer富文本编辑器插件，提供文本编辑功能
+ #### 功能模块概述 
    + ==登录、注册、用户个人信息模块==。注册成功初始化用户各个默认文件夹，用户密码使用MD5简单加密。
    + ==笔记编辑以及文本编辑模块==。笔记的创建、打开、重命名、删除、保存、预览，文本编辑则有字体、字体颜色、图片上传等功能。
    + ==文件夹模块==。文件夹的打开、新建笔记、创建、重命名、删除的功能
    + ==回收站模块==。文件或文件夹的恢复和彻底删除
+ #### 项目亮点
    + 全文检索以及高亮显示
    + 局部刷新
    + 插件样式修改
+ #### 点击显示效果展示
    + 文件打开![image](http://116.62.170.236:8080/showgif/%E6%96%87%E4%BB%B6%E6%89%93%E5%BC%80.gif)
    + 全文索引及高亮显示![image](http://116.62.170.236:8080/showgif/全文检索以及高亮显示.gif)
    + 笔记的创建、删除、彻底删除![image](http://116.62.170.236:8080/showgif/笔记的创建与删除和彻底删除.gif)
+ #### 访问项目
    + 注意事项
        + 请勿删除默认文件夹：我的文件夹，否则在使用新建文档中的新建笔记功能时会出现系统错误。后期开发中会删除该文件夹的删除按钮
        + 请勿使用设置阅读锁，该功能存在一定的逻辑错误，后续开发会修复该错误
        + 标签功能还在开发中，暂不支持对标签的操作以及为文章添加标签
    + 访问方式
        + 使用测试账号 2947274496@qq.com ，  测试密码：xiao123<br> 登录地址<http://116.62.170.236:8080/MyNoteNook/login.jsp>
        + 注册新用户的访问地址:<http://116.62.170.236:8080/MyNoteNook/toRejister>
+ #### 项目总结
    + 不足
        + 前端页面不美观，不时尚。
        + 功能不完善，还存在bug
        + 缺少友好的界面提示
        + 后端没有优化，拖慢响应速度
