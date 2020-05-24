# **BFICheck**
### 第二轮任务列表：
+ 邓乐丰：数字签名加密算法，block和account的序列化和反序列化
+ 张毕特：验证模块的hash和生成新block
+ 艾拜都拉：reVerify再验证模块
+ 杨鑫海：paperwork
+ AGABEK杰伟：已完成，目前无任务
    
# **Coding Convention**
#### *1.所有人必须写注释，注释内容为实现什么功能，注释用行注释"//"，写于函数或语句上方，中英文均可，尽量精炼。块注释也可，主要阐述函数的功能*
#### *2.做基于cmd的即可，不需要图形化界面*
#### *3.整体结构：*
+ *3.1：创建几个类：constant常量类，用于保存所有用到的常量，只有成员没有方法 public static final*
                  *utilities工具类，一切复用率高的代码都放在这个类当中，方法修饰符 public static*
+ *3.2：函数式编程，只要复用率高的代码都封装为函数放在utilities里面，通过"类名.函数名"调用，会用到switch case结构，case下面所有语句都封装成函数*
+ *3.3：降低函数的耦合，最好不要在函数外定义全局成员变量。常用对象如scan在main函数中创建，当作参数逐层传递给其他函数*
+ *3.4：block和account类先定义interface，规范function，再定义类XXXXImpl作为实例类*
#### ***4.naming convention：***
+ *function名，成员变量名：驼峰式命名，如getValue()，hashString*
+ *常量名：全大写，单词之间下划线分隔，如 MAX_VALUE*
+ *function名为动词或动词+名词，成员变量名为名词，必须有意义单词或单词缩写（前n个字母），拒绝拼音，拒绝abcde，即使是下标也要用index而不用i*
#### *5.开发环境统一Eclipse，没有的话就只能写函数的内部实现代码*
#### *6.风格：函数内部功能不同的代码块之间统一隔一行，不同函数之间隔两行，符号与变量之间敲空格*

>>>>>>> 79af8aaa93673384e0e8bfd63b551e6df67ff9bb
