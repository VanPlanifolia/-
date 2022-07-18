## JavaScript第一天

1.简介

JavaScript是一门面向对象的脚本语言，他如此强大不仅仅是用到浏览器的脚本编写也能进行网站后台开发等等等，我们常见的网页游戏都是通过js进行制作的。

2.js的编写位置

js脚本的编写和css类似，可以写在html页面内也可以写在单独的js文件里，然后在页面中引入。而且写在文件里也有两种方式，第一种写在body标签最下面，第二种写在head标签中。这两种写法有不同的用处写在head中能够让其先加载，以免影响页面中的js特效等等，而写在最后面则能够让出资源优先渲染html页面，所以要分情况使用。

3.js的数据类型

js是一款和java有部分相似之处的语言，一些常用的数据类型他都有，比如 Number数字类，String字符类，Boolen布尔值，Object对象类型，还有一个特殊的 未定义undefined 所有未赋值的数据类型都是undefined。显然这些数据类型都是老熟人了，在c语言，java中都有他们的身影。

```javascript
var b=20;
var name="崔震云";
var flag=false;
var undefined;
var object=new Object();
console.log(typeof a);
console.log(typeof name);
console.log(typeof flag);
console.log(typeof undefined);
console.log(typeof object);
```

4.js的常见语法格式

* 4.1 hollo，world！第一行代码自然是输出，你好世界！在js中有一下常见的几种输出方式，输出到控制台，输出到网页上，输出到警告框，输出到提示框。具体见下代码。

  ```javascript
  var hi="hello，world!";
  //控制台
  console.log(hi);
  //警告框
  alert(hi);
  //提示框
  confirm(hi);
  //可输入的提示框
  prompt(hi);

  ```
* 4.2 赋值与变量，js中的变量不需要区分类型来定义可以统一使用var来进行定义，这样虽然省去了一些声明变量的麻烦但是我个人感觉不如Java那样泾渭分明，而赋值则像是全宇宙统一一样，都是使用 变量名=变量值 来进行具体可以参考下面代码。

  ```javascript
  var a=18;
  var b=20;
  var name="崔震云";
  var flag=false;
  var undefined;
  var object=new Object();
  ```
* 4.3 运算符，js中也想大部分的高级语言一样大体可以分为三大类，一目运算符，二目运算符，三目运算发，顾名思义我们可以知道一目运算符就代表着只需要一个变量就可以进行，二目运算符需要两个....。一目运算符比较少只有++，--作为自加自减来使用。二目运算符则是最常见的比如+ - * / % =加减乘除取余赋值等等，而三目运算符则是最经典的 '(表达式)？A:B' 这个三目运算其实很好理解，我们从左往右读：表达式成立吗？成立的话执行A否则执行B。

  ```javascript
  //一目运算符
  a++;
  a--;
  //二目运算符
  a=a+b;
  a=a-b;
  a=a+b;
  a=a/b;
  a=a%b;
  console.log(a>b)
  console.log(b>a)
  //三目运算符
  a>b?console.log(a):console.log(b);
  ```
* 4.4 字符串游戏，我们首先来做最基础的也就是字符串的拼接，同样和高等语言一样js中的字符串拼接也是通过+来进行的而且对于字符串与数字类型进行拼接会直接合并成为字符串类型。具体代码如下

  ```javascript
  var name="张三";
  var age="18";
  var address="北京";
  var sql="insert into student values("
  +name+
  ","
  +age+
  ","
  +address+
  ")";
  var path="img/NUB.jpg";
  path=path.replace('NUB',age);
  console.log(path);
  console.log(sql);
  ```
* 4.5 数据类型转换，在js中同样提供了数据类型转换的方法，方法parseXxxx(var)将var变量转化为Xxxx类型的数据，了解了上面这些知识之后我们可以完成一个小联系，简易的计算器，分别输入 a b两个值得出运算结果并且以 sum=a+b 的形式输出到浏览器界面。

  ```javascript
  var a=prompt("输入第一个数字");
  var b=prompt("输入第二个数字");
  var c=parseFloat(a)+parseFloat(b);
  document.write(a+"+"+b+"="+c)
  ```
