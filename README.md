# **BFICheck**
+ 利用区块链进行真伪鉴别
+ 注意，所有的代码不一定都需要具体实现，可以只在里面定义函数（加注释，需要获得什么参数，干什么）就够了
+ 有加“（用户）”的是需要用户输入信息操作的，其他的都是被这些方法调用的
+ 所有的类我已经定义好了，剩下只需要添加function和变量即可
  
#### 第一轮任务列表Round1:
+  /* 输入个人信息（创建账户时）核验 （用户）   *读取tag的信息并链接到链上
+  /* 读取上一个block的信息   * 读取第一个block的信息    * 输出（验证）（用户）
+  /* 获取上一个block的hash    * 创建起始block（用户）    * 创建中间的block（用户）
+  /* 创建临时不可读取hash的block    * check isValid 检查链是否有效
  
    
# **Coding Convention**
#### *1.所有人必须写注释，注释内容为实现什么功能，注释用行注释"//"，写于函数或语句上方，中英文均可，尽量精炼。不建议一大块注释解释后面跟一大块代码*
#### *2.做基于cmd的即可，不需要图形化界面*
#### *3.整体结构：*
+ *3.1：创建几个类：constant常量类，用于保存所有用到的常量，只有成员没有方法 public static final*
                  *utilities工具类，一切复用率高的代码都放在这个类当中，方法修饰 public static*
+ *3.2：函数式编程，只要复用率高的代码都封装为函数放在utilities里面，通过"类名.函数名"调用，会用到switch case结构，case下面所有语句都封装成函数*
+ *3.3：降低函数的耦合，最好不要在函数外定义全局成员变量。常用对象如scan在main函数中创建，当作参数逐层传递给其他函数*
+ *3.4：block和account类先定义interface，规范function，再定义类XXXXImpl作为实例类*
#### ***4.naming convention：***
+ *function名，成员变量名：驼峰式命名，如getValue()，hashString*
+ *常量名：全大写，单词之间下划线分隔，如 MAX_VALUE*
+ *function名为动词或动词+名词，成员变量名为名词，必须有意义单词或单词缩写（前n个字母），拒绝拼音，拒绝abcde，即使是下标也要用index而不用i*
#### *5.开发环境统一Eclipse，没有的话就只能写函数的内部实现代码*
#### *6.风格：函数内部功能不同的代码块之间统一隔一行，不同函数之间隔两行，符号与变量之间敲空格*
