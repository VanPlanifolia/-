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

## JavaScript第二天

1. 我们第一天已经简单的了解了JavaScript的基础语法格式，比如输入输出方式，数据类型，字符串拼接，运算符等等对js脚本语言有了一个初步的认识，今天我们将进一步的学习JavaScript的语法知识。
2. if语句 几乎所有的高级语言都有if else语句，他是作为最基础的流程控制代表着 如果-否则，书写格式为if(表达式){程序体a}else{程序体b}，如果表达式为true那么执行程序体a，如果表达式为false那么执行程序体b。所以我们就可以使用这玩意来进行判断，比如判断某个数值的大小范围，比如判断输入是否正确，判断登录密码等等等。我们做一个简单的逻辑判断来演示，具体见下面代码

   ```javascript
   var javaPoint=prompt("输入你的java成绩");

   			var musicPoint=prompt("输入你的音乐成绩");

   			if(javaPoint>90&&musicPoint>90){
   				alert("奖励一次");
   			}else{
   				alert("自律");
   			}

   			if(javaPoint>90||musicPoint>90){
   				document.write("成绩优秀");
   			}else{
   				document.write("成绩都不优秀");
   			}
   ```
3. if() else if()语句这种适用于多重判断，也就是我一个if下面可以跟随多个else if并且如果其中的一个表达式不满足那么他会继续往下走知道找到满足的表达式并且执行对于的程序体，然后结束这个流程，也就是说无论后面还有判断语句无论是否满足那么都不会执行了会直接结束这个if else流程。最经典的例子就是判断成绩等级了。

   ```javascript
   var point = prompt("输入你的考试成绩");

   			if (point > 90) {
   				document.write("<h1>你的成绩为优秀</h1>");
   			} else if (point > 80) {
   				document.write("<h1>你的成绩为良好</h1>");
   			} else if (point > 70) {
   				document.write("<h1>你的成绩为一般</h1>");
   			} else if (point > 60) {
   				document.write("<h1>你的成绩为及格</h1>");
   			} else {
   				document.write("<h1>你的成绩为不及格</h1>");
   			}
   ```
4. 所以今天的内容大体就这么多，是不是很少，但是对于if else的应用可所谓是非常的丰富几乎所有的地方都会用到if else尤其是在数据结构与算法上，我们就使用两个简单的例子来对这个语法进行练习

   4.1 计算体重是否标准，通过输入身高体重，然后通过公式来进行计算公式如下 标准体重=身高-105上下浮动5kg，这个程序我们显然要先引入两个变量接收用户输入的身高与体重，然后通过公式计算出标准体重并且将真实体重减去标准体重，显然如果得数大于5则偏重，得数小于-5则偏瘦。

   ```javascript

   			var height=prompt("请输入你的身高");
   			var weight=prompt("请输入你的体重");

   			standard = Number(height)-105;

   			temp=Number(weight)-standard;

   			if(temp>5){
   				document.write("偏胖");
   			}else if(temp<-5){
   				document.write("偏瘦");
   			}else{
   				document.write("标准!");
   			}
   ```

* 4.2 根据公式计算出个人所得税以及公司所缴纳的五险一金以及个人所缴纳的三险一金，以及最终到手的工资，具体计算方法见下文字，显然我们分析题可知只有工资交完个人的三险一金之后超过3500元的才会进行纳税，然后纳税也是按照区间进行纳的，当然是工资越高纳的比例也就月高，所以我们实现这个功能首先要计算出他交完三险一金后的工资数，当然三险一金也有上线超过7662的按照7662的20%缴纳，不超过的按照工资的20%缴纳，然后计算出交完三险一金的工资后在进行比对然后按照税率区间以及公式进行计算。具体代码见下。

  ```txt
  个人所得税 =（工资 - 工资*0.2|7662*0.2 - 3500）x 税率 - 速算扣除数  
    6000 
  其中小括号里的“工资 - 三险一金 - 个税起征点”通常被称为“应纳税所得额”或“应纳税额”

  工资：即初始收入（合同上所写的收入）

  起征点：自2011年起，起征点由2000元上调至3500元

  起征点3500并不是工资超过3500就要交个人所得税
   而是 工资-三险一金之后 还超过3500 才交个人所得税
  税率：由3%上涨到45%，有7个等级，分别与7个不同区间的应纳税所得额对应

  速算扣除数：由0上涨到13505，也有7个等级，与不同税率相对应：
  全月应纳税所得额	                       税率	    速算扣除数（元）
  全月应纳税额不超过1500元	                  3%	     0
  全月应纳税额超过1500元至4500元	             10%	    105
  全月应纳税额超过4500元至9000元	             20%	    555
  全月应纳税额超过9000元至35000元	         25%	    1005
  全月应纳税额超过35000元至55000元	         30%	    2755
  全月应纳税额超过55000元至80000元	         35%	    5505
  全月应纳税额超过80000元	                  45%	     13505

  注：①表中所列含税级距、不含税级距，均为按照税法规定减除有关费用后的所得额。
  ②含税级距适用于由纳税人负担税款的工资、薪金所得；不含税级距适用于由他人（单位）代付税款的工资、薪金所得。

  工资不超过 7662  那么五险一金就按照工资*20%计算超过 7662 五险一金就按照 7662*20%
  五险一金
  养老：单位20%，个人8%。
  失业：单位2%，个人1%。
  医疗：单位6-4%，个人2-4%。
  工伤：单位1%，个人0%。
  生育：单位1%，个人0%。
  各地可能略有变动。
  一金一般是单位8%-12%，个人也一样。

  举例说明：假设月工资为6000元，工作地点是广州（养老保险8%、医疗保险2%、失业保险1%、住房公积金 8%），那么“应纳税额”=6000 - 6000x(8%+2%+1%+8%) - 3500=1360元。查上表可知，与1360元对应的税率和速算扣除数分别为3%和0，因此个税=1360x3% - 0=40.8元。也就是说，在广州月工资6000元需要缴纳个人所得税40.8元。虽然最后实际到手只有4000多元，但至少知道了，“少了的钱”几乎都用来缴纳五险一金了，只有极少一部分用来缴纳个税而已。
  ```

```javascript
<script type="text/javascript">
			var realMoney = 0;
			var sanMoney = 0;
			var tempMoney = 0;
			var wuMoney = 0;
			var taxLeave = 0;
			var realTax = 0;
			var basisMoney = prompt("输入你的工资");
			//判断基础工资，然后计算出扣除三险一金后的工资数,与公司帮你交的五险一金数
			if (basisMoney > 7662) {
				tempMoney = basisMoney - 7662 * 0.2;
				sanMoney = 7662 * 0.2;
				wuMoney = 7662 * 0.4;
			} else {
				tempMoney = basisMoney * 0.8;
				sanMoney = basisMoney * 0.2;
				wuMoney = basisMoney * 0.4;
			}
			//个人所得税的等级
			taxLeave = tempMoney - 3500;
			console.log("tenmp:"+tempMoney+",tax"+taxLeave);
			if (taxLeave <= 0) {
				document.writeln("不需要交税!");
			} else if (taxLeave <= 1500) {
				realTax = taxLeave * 0.03;
			} else if (taxLeave <= 4500) {
				realTax = taxLeave * 0.1 - 105;
			} else if (taxLeave <= 9000) {
				realTax = taxLeave * 0.2 - 555;
			} else if (taxLeave <= 35000) {
				realTax = taxLeave * 0.25 - 1005;
			} else if (taxLeave <= 55000) {
				realTax = taxLeave * 0.3 - 2755;
			} else if (taxLeave <= 80000) {
				realTax = taxLeave * 0.35 - 5505;
			} else {
				realTax = taxLeave * 0.45 - 13505;
			}
			alert("纳税金额为" + realTax);
			document.write("你的原始工资为:" + basisMoney + ",需要缴纳的三险一金为:" + sanMoney + ",公司为你交的五险一金为:" + wuMoney + ",你需要缴纳的所得税为:" +
				realTax +
				",你的实际工资为:" + (basisMoney - sanMoney - realMoney));
		</script>
```

## JavaScript第三天

1.我们在第二天已经学习了简单的流程控制 if 语句，当然学过其他高级语言的应该知道for循环，同样这样是进行流程控制的只不过是用来控制循环，for循环的应用之广泛是因为程序经常是用来处理人无法处理的大量重复性操作的，使用for循环就能根据一定的条件来循环的执行程序体里面的内容。for循环的使用方法如下 for(表达式1；表达式2；表达式3){循环体} 表达式1用于定义循环中的变量，表达式2用于进行逻辑判断，表达式3则是步长。显然这样说非常的空洞难以理解，所有下面我们就粘一块代码来进行展示。

```javascript
简单的打印10遍，你好世界，通过这个例子我们就很好理解上面描述的三个表达式的含义
		<script type="text/javascript">
			for (var i = 0; i < 10; i++) {
				document.writeln("你好世界" + i + "</br>");
			}
		</script>
```

2.我们学习了if循环能够进行多重嵌套，那么显然for语句也能够进行嵌套而且对于许多的算法题都是会用到for循环的嵌套。for循环的嵌套执行流程我们在此简单的介绍一下，他依然是按照程序从上到下的执行顺序执行的，就比如说先执行一次外部的for循环然后进入内部的for循环，将内部的for循环执行完毕之后会再次执行外部循环以此类推知道外层循环执行完毕。同样我们也是通过一个例子来进行演示。

```javascript
//打印矩形，通过双层循环来打印一个 ‘hang’ 高度 ‘kuan’宽度的 矩形，显然我们可以看到外层循环是来控制共有多少行的内部循环是用来控制一行有多少个*的
			var hang=prompt("输入行数");
			var kuan=prompt("输入一行多少个");
			for(var i=0;i<hang;i++){
				for(var j=0;j<kuan;j++){
					document.write("*");
				}
				document.write("<br>");
			}
```

3.与for循环搭配的还有两个比较常用的语法糖，break，continue 其中break是用来跳出整个循环的，而continue是用来跳出当前这一次循环的。这两个的用处同样也是在算法中，比如说我们需要从一个列表/数组中找到某一个值，首先需要循环的输出这个数组并且通过if进行判断是否是这个值是否为我们所需要的如果不是则continue跳出这一次循环如果是则直接break结束循环，同样我们在后面粘一块代码来进行展示。

```javascript
//找到array数组中 5 所在的下标并且打印出来，显然我们从数组中找到对应的元素首先要遍历这个数组然后进行if判断如果满足条件就终止循环，如果不满足就跳出循环
			var array=[3,6,2,3,4,5,8,9,0];
			alert(array.length);
			for(var a=0;a<array.length;a++){
				if(array[a]==5){
					document.write("5在数组中的下标为："+(a+1));
					break;
				}else{
					continue;
				}
			}
```

4.以上我们基本上就介绍完毕for循环的语法了，但是for循环的知识不仅仅是这些，那么我们接下来就通过一些例子来进行演练一下

* 4.1 输出1-100内的奇数偶数，这是个比较简单的练习没有设计到双层循环等等。首先偶数的定义为能够被2整除的数就是偶数，那么我们只需要判断他是否能够被2整除就行了然后不能被整除的就是奇数。

  ```javascript
                          document.write("偶数：")
  			for(var i=1;i<=100;i++){
  				if(i%2==0){
  					document.write(i+" ");
  				}
  			}

  			document.write("<br>奇数：")
  			for(var j=1;j<=100;j=j+1){
  				if(j%2==1){
  					document.write(j+" ");
  				}
  			}
  ```
* 4.2 打印三角形，想要打印一个正三角形，显然我们需要使用两层循环并且还要根据外层循环的次数来输出不同的内容，具体见下代码；

  ```javascript
                               for(var a=1;a<=9;a++){
  				for(var b=1;b<=a;b++){
  					document.write("*");
  				}
  				document.write("<br>");
  			     }
  ```
* 4.3 打印九九乘法表，九九乘法表实现原理和正三角形基本一样，我们只要吧三角形的组成成分替换成 i*j=i+‘x’+j ij分别为第i列第j行。

  ```javascript
                         for(var c=1;c<=9;c++){
  				for(var d=1;d<=c;d++){
  					document.write(d+"x"+c+"="+c*d+"\t");
  				}
  				document.write("<br>");
  			}
  ```
* 4.4 高斯累加，也就是累计 1-x 内所有数字的和，显然还是使用单层循环循环从1开始到x步长为1，然后使用一个变量sum保存和即可

  ```javascript
  			var a=prompt("输入你要累加的数");
  			var base=1;
  			for(var i=2;i<=a;i++){
  				base=base+i;
  			}
  			document.write(base);
  ```
* 4.4 输入若干成绩计算总数，平均数，最大值，最小值，总数与平均数都没有什么好说和上面的累加几乎一样，而最大最小值我们可以先把第一次输入的值暂存为最大最小值，然后后面如果每一次都有比他们大或者小的值就替换掉最大最小值然后最后输出最大最小值即可；

  ```javascript
                          var max;
  			var min;
  			var sum;
  			sum=max=min=Number(prompt("请输入第1次的考试成绩"));
  			var temp;
  			for(var b=2;b<=5;b++){
  				temp=Number(prompt("请输入第"+b+"次的考试成绩"));
  				if(temp<min){
  					min=temp;
  				}
  				if(temp>max){
  					max=temp;
  				}
  				sum=sum+temp;
  			}
  			document.write("你的考试总成绩为:"+sum+",平均分为:"+(sum/5)+",最大成绩为"+max+",最差成绩为"+min);
  ```

5.拓展语法糖，switch case，这个是多重if elseif的平替版，使用switch case可以大幅度的提高代码的整洁度与可读性，并且在阿里编程规范中规定了不允许出现三层以上的if嵌套，所有我们可以使用switch case这个语法糖来完善自己的代码，当然大部分情况都可以不用，做一个简单的演示

```javascript
                                                var a = 0;

						while(a<5){
							switch (a){
								case 0:
								case 3:	a=a+2;
								case 1:
								case 2: a=a+3
								default: a=a+5;
							}
						}
						// A 0  B 2  C 5 D 10
						document.write(a)
```
