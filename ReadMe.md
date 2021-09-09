## MD是一种神奇的文本格式
### git拷贝文件
1. 使用命令行
    1. 使用git bash(推荐)或命令行（cmd） `cd 你需要拷贝的目录` 
    2. `git clone GitHub/gitee的代码库 带.git的地址`
    3. 等待拷贝完成
2. 使用GitHub desktop工具
    1. 打开软件
    2. file->Clone reposit
    3. 点击URL，输入第一行输入代码库git地址，第二行选择文件夹
    4. 点击Clone
### git创建仓库，在GitHub上创建后，按命令提示进行
### git上传
 - 小贴上：有时github会出现SSL错误，可以使用`git config --global http.sslVerity false`临时取消github的SSL检查
 - 命令行
   1. git bash或命令行 `cd 本地仓库`
   2. `git push orgin master`(只有一个分支时省略远程分支名，其实master就是远程分支名)
 - 工具
    * 工具会直接显示你的修改
    * 写好描述后，点击commit to main保存修改
    * 然后点击push orgin提交