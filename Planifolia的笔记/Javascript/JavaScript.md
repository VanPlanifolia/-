## JavaScript第一天

1.简介

JavaScript是一门面向对象的脚本语言，他如此强大不仅仅是用到浏览器的脚本编写也能进行网站后台开发等等等，我们常见的网页游戏都是通过js进行制作的。

2.js的编写位置

js脚本的编写和css类似，可以写在html页面内也可以写在单独的js文件里，然后在页面中引入。而且写在文件里也有两种方式，第一种写在body标签最下面，第二种写在head标签中。这两种写法有不同的用处写在head中能够让其先加载，以免影响页面中的js特效等等，而写在最后面则能够让出资源优先渲染html页面，所以要分情况使用。

3.js的数据类型

js是一款和java有部分相似之处的语言，一些常用的数据类型他都有，比如 Number数字类，String字符类，Boolen布尔值，Object对象类型，还有一个特殊的 未定义undefined 所有未赋值的数据类型都是undefined。显然这些数据类型都是老熟人了，在c语言，java中都有他们的身影。

```javascript
321312var b=20;
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

  ```java-script
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

## JavaScript第四天

1.今天我们学习了js中函数的定义与使用，按照国际惯例首先讲一下它的语法格式，如何去定义一个函数在js中定义一个函数的关键字是function，定义函数的格式为 function 方法名(参数列表){方法体}，嗯确实和java中定义函数的方法相同，并且调用函数的方法就是方法名()来进行调用，接下来我们就通过一个简单的应用方法的例子来做展示。

```javascript
如下我们遵循js的函数定义方法定义了一个fun()函数，并且在下面进行了调用 
                       function fun(){
				for (var i = 0; i < 10; i++) {
					document.write("你好世界"+i);
					}
			}
			fun();
```

2.方法的事件绑定，我们写了个函数当然不能让他按照顺序进行执行调用，所以我们要进行方法的事件绑定比如说点击某一个按钮能够触发触发这个函数，显然这个需求是我们比较常用到的所以我们要介绍一下 onclick 事件，他常用于button标签上代表着点击这个button会去触发某一个事件。具体使用见下代码

```javascript
如下，我们在id为 a 的button上通过onclick事件绑定了方法blueRedChange(),也就是说当我们点击这个按钮的时候会执行方法blueRedChange()
并且去切换一下背景颜色

<button id="a" onclick="blueRedChange()">扣1送地狱火</button>

function blueRedChange(){
				if(document.body.style.background == "yellow"){
					document.body.style.background = "red";
				}else{
					document.body.style.background= "yellow";
				}
			}

```

3.当然细心的你看见我们用了一个我们暂时没有了解到的知识 document.body.style.background = "red"; 我们具体分析一下这行代码，document我们之前用到过是用来调用write方法的来往网页上输出具体信息但是不知道为啥可以这样使用，其实doucument是用来获取当前网页对象的而 . 的意思就是调取对应的方法或者访问这个网页对象的子对象那么显然这行代码的意思是 “网页主题的body标签的style标签中的background属性并且将它设置为red”。所以我们可以通过这个来改变网页的背景颜色。

了解了这个我们可以举一反三的来修改网页元素的样式或者内容，那么如果我们修改的样式过多不方便这样进行修改，那么我们可以通过id准确的获取到对应的网页标签并且修改它的类选择器来实现。具体代码如下

```javascript
<style type="text/css">
		.a1{
			background: red;
			color: white;
		}
		.a2{
			background: black;
			color: aqua;
		}
	</style>
	<body>
		<button onclick="fun()">扣一</button>
		<div id="k1">
			送地狱火！！！！！！！！！！！
		</div>
		<script type="text/javascript">
		var i=0;
			function fun(){
				if(i%2==0){
					document.getElementById("k1").className="a1";
				}else{
					document.getElementById("k1").className="a2";
				}
				i++;
			}
		</script>
	</body>
```

4.当你了解了上面的那些知识之后，js中函数理论基本上就讲完了我们接下来进行一些具体的应用。

* 4.1 实现点击按钮完成轮换的切换背景图片，比如从0-5 6张图片每点击一次按钮切换一张并且循环，具体代码如下。

  ```javascript
  显然这一题的难点不在切换比背景图片，切换图片我们可以很容易的通过doucment.body来进行设置，而难点在如何实现轮换切换，
  我们需要引入一个计数器，计数器是几我们就切换到第几张，并且让计数器跟5进行取余，来进行选择图片这样就实现了循环的切换图片。
  <button id="a" onclick="changeTextByTime()">扣1送地狱火</button>
  		<script type="text/javascript">

  		var time=0;
  function changeImageByTime(){
  				document.body.style.backgroundImage="url(img/"+time%5+".png)";
  				document.body.style.backgroundRepeat="no-repeat";
  				document.body.style.backGroundPosition="center";
  				document.body.style.backgroundSize="cover";
  				time++;
  			}

  		</script>
  ```
* 4.2 实现猜数小游戏，当猜中了输出猜的次数，具体代码如下

  ```javascript
  猜数游戏是很经典的一道程序题，在js中进行实现首先我们要随机生成一个被猜的数，可以通过Math.random()方法来生成，但是这个方法生成的数据是0-1
  内的小数，所以我们需要进行一些处理让他x100后取整我们就获取到了0-100的随机数。然后有了被猜的数。我们就要输入值了那么如何获取输入的值呢？同
  样和修改类选择器一样通过getElementById来获取到这个标签并且通过.value属性来获取到而且切记要转化一下获取到的值为number类型，将输入的值与被猜的值进行判断
  断如果相同则输出猜中了，不同则输出猜大了猜小了，具体的代码实现如下。

  输入你要猜的数:<input type="text" name="numberInput" id="numberInput" /><button onclick="gassNumber()">猜</button>
  		<div id="show"></div>
  		<script type="text/javascript">
  		//被猜数
  			var gass=parseInt(Math.random()*100);
  			var time=0;
  			function gassNumber(){
  				time++;
  				var inputNumber=document.getElementById("numberInput").value;
  				if(inputNumber>gass){
  					document.getElementById("show").innerHTML="猜大了！";
  					document.getElementById("show").style.color="#ff0004";
  				}else if(inputNumber<gass){
  					document.getElementById("show").innerHTML="猜小了！";
  					document.getElementById("show").style.color="#1100ff";
  				}else{
  					document.getElementById("show").innerHTML="恭喜你猜对了！你一共猜了"+time+"次";
  					document.getElementById("show").style.color="#afff7d";
  				}
  			}
  		</script>
  ```
* 4.3 简易计算器，两个输入框，四个按钮实现两个数的加减乘数。具体代码如下

  ```javascript
  我们想要实现加减乘除四个功能那么必然需要四个函数，四个按钮来调用这四个函数，而且需要两个输入框来获得到被运算的两个数并且根据我们点击的按钮进行判断执行不同的函数来实现加减乘除。
  <body>
  		输入第一个数:<input type="text" id="numbera" /><br>
  		输入第二个数:<input type="text" id="numberb" /><br>
  		<button onclick="add()">加</button>
  		<button onclick="jian()">减</button><br>
  		<button onclick="cheng()">乘</button>
  		<button onclick="chu()">除</button><br>
  		<div id="show"></div>

  		<script type="text/javascript">

  			function add(){
  				var number1=Number(document.getElementById("numbera").value);
  				var number2=Number(document.getElementById("numberb").value);
  				document.getElementById("show").innerHTML=number1+"+"+number2+"的结果为"+(number1+number2);
  			}
  			function jian(){
  				var number1=Number(document.getElementById("numbera").value);
  				var number2=Number(document.getElementById("numberb").value);
  				document.getElementById("show").innerHTML=number1+"-"+number2+"的结果为"+(number1-number2);
  			}
  			function cheng(){
  				var number1=Number(document.getElementById("numbera").value);
  				var number2=Number(document.getElementById("numberb").value);
  				document.getElementById("show").innerHTML=number1+"X"+number2+"的结果为"+(number1*number2);
  			}
  			function chu(){
  				var number1=Number(document.getElementById("numbera").value);
  				var number2=Number(document.getElementById("numberb").value);
  				document.getElementById("show").innerHTML=number1+"÷"+number2+"结果为"+(number1/number2);
  			}
  		</script>
  	</body>
  ```
* 4.4 计算机进阶版，显然我们上面的代码过于冗杂，光计算函数都写了四个，我们想要简化这些代码所以可以将运算符当作参数列表传入函数中，让函数根据不同的传入参数来实现不同的计算结果。具体代码如下

  ```javascript
  在下面的代码中我们使用了一个特殊的方法 eval(字符串表达式),这个方法可以将括号中的字符转化成可以执行的表达式然后进行运算，所以即使我们往函数
  传入的是字符串类型也能够正常的运算。
  <body>
  		输入第一个数:<input type="text" id="numbera" /><br>
  		输入第二个数:<input type="text" id="numberb" /><br>
  		<button onclick="jsq('+')">加</button>
  		<button onclick="jsq('-')">减</button><br>
  		<button onclick="jsq('*')">乘</button>
  		<button onclick="jsq('/')">除</button><br>
  		<div id="show">

  		</div>
  		<script type="text/javascript">

  			function jsq(a){
  				show.innerHTML = eval(numbera.value + a + numberb.value);
  			}
  		</script>

  	</body>
  ```

## JavaScript第五天

1.今天我们学习了js中的数组，数组是几乎所有语言中都有的一个数据结构，他能够存储若干相同数据类型的元素，并且支持随机访问等等，按照国际惯例我们先介绍一下js中数组的语法格式。数组的定义方法：像大多数的变量一样js中定义数组也是通过var关键字比如

var array=[]；这样就完成了一个数组的定义。当然定义数组不止这一种方法，还有如下：var array=new array();调用无参构造方法创建一个空数组，var array=new array(1,2,3,4);调用有参的构造方法来创建一个有初始值的数组。当然还有两种静态的创建方法比如

var array=[]；创建一个无参的数组，var array=[1,2,3];创建一个有初始值的数组。这样看来js是不是既有java的特性也有python的便捷。

```javascript
var arr1=[];
			var arr2=[1,2,3,4];
			var arr3=new Array(10);
			var arr4=new Array(1,2,3,4);
```

2.数组的赋值与随机访问，我们创建了数组但是如何进行随机的访问以及修改其中的值呢？显然js像大多数的高级语言一样，可以通过

a[下标索引]来进行随机访问，并且也可以通过 a[下标索引]=var 来进行修改已有的值。具体实现代码如下

```javascript
//使用指定下表存入数据
			arr1[6]=7;
			//读取指定下标的数组数据
			var temp=arr1[6];
```

```javascript
//循环输出数组中的内容
for(var i=0;i<arr1.length;i++){
				document.write(arr1[i]);
			}
```

3.数组中的常用的方法，array.push(a,b,c,d)王数组中追加元素，array.splice(arg1,arg2,args....) arg1：开始删除元素的索引，arg2，删去数组元素的长度，args....删除后插入的数组，这样看起来非常的抽象我们不妨举两个例子来进行展示

```javascript
//使用push存入数据，push的存入是追加
			arr1.push(1,2,3,4,5,6);

//splice方法的用法
			//1.删除数组中指定位置指定长度的数据
			//2.删除数组中指定位置指定长度的数据并且替换为其他内容
			console.log(arr1);
			//从下表为1的数组元素开始删除后面两个长度的元素
			arr1.splice(1,2);
			console.log(arr1);
			arr1.splice(3 ,2 , 3.5,3.6,3.7);
                        console.log(arr1);
```

4.其实数组的语法格式就这么多，但是利用数组我们能够完成很多数据结构与算法相关的问题比如搜索算法，排序算法等等，接下来我们就利用数组来完成一些操作

* 4.1 利用数组完成背景图片的轮换切换，虽然我们在之前已经做过了了一个按钮轮换切换背景图片，但是我们这次需要引入数组来实现，将图片的信息保存到数组中，这样我们只要循环遍历数组中的图片名就可以实现图片的轮换，并且我们在想要添加图片的时候只需要在数组中添加信息并且修改被除数就可以了。

  ```javascript
  <body id="boy">
  		<button id="cgbut">扣1</button>

  		<script type="text/javascript">
  		var bgarr1=["red","green","blue","yellow","pink"];
  		var bgarr2=[0,1,2,3,4];
  		var i=0;
  			cgbut.onclick= function(){
  				document.body.className=".imgrepace";
  				// document.body.style.background=bgarr[i%bgarr.length];
  				document.body.style.background="url(img/"+bgarr2[i%bgarr2.length]+".png)";
  				document.body.style.backgroundRepeat="no-repeat";
  				document.body.style.backGroundPosition="center";
  				document.body.style.backgroundSize="cover";
  				i++;
  			}
  		</script>
  	</body>
  ```
* 4.2 利用数组来实现所有按钮绑定事件

  现在有这样一个需求 当我们点击某一个按钮的时候被点击的按钮变样式,但是当点击其他按钮的时候,原本改变样式的那个按钮切换成默认的样式,并且最近一次被点击的那个按钮切换样式。显然我们需要将所有的按钮都绑定上事件，js中提供了一个方法
  (getElementsByTagName(tagname) )能够找到相同tag的元素，并且返回一个数组，这样我们就拿到了所有button的对象数组，然后我们遍历对象数组，为每一个元素都绑定上事件当点击的时候上样式，这样我们第一个需求就完成了点击添加样式，但是我们还要清除其他的按钮样式，这时我们就需要另一个方法了getElementsByClassName(classname)，同样这个方法会找到所有类名为classname的标签元素并且返回一个数组对象，但是我们之前说的是同时只会有一个带样式的按钮所以虽然我们获取到的是一个数组但是只有一个元素下标为 '0'，所以我们只要吧array[0]的class样式设置为""就ok了。口说无凭直接上代码！

  ```javascript
  <html>
  	<head>
  		<meta charset="utf-8">
  		<title></title>
  		<style type="text/css">
  			.commbut{
  				border: 1px solid aqua;
  				color: black;
  				background: orange;
  			}
  		</style>
  	</head>
  	<body>
  		<button class="commbut">扣</button>
  		<button>1</button>
  		<button>送</button>
  		<button>地</button>
  		<button>狱</button>
  		<button>火</button>
  	</body>
  	<script type="text/javascript">
  		//获取到所有标签名为button的控件，作为一个数组保存到arr中
  		var arr=document.getElementsByTagName("button");
  		//然后我们要遍历循环获取到的button控件数组然后一一为他们绑定上点击事件
  		for(var i=0;i<arr.length;i++){
  			//我们要实现点击那个为那个上style那么我们就需要使用this关键字，this关键字是用来指代当前的按钮对象的，并且如果我们想要同时只有一个按钮上特性
  			//那么我们要清除掉之前class为 commbut 的按钮的class，然后在给当前被点击的按钮上特效
  			arr[i].onclick = function(){
  				//为什么要使用【0】，因为浏览器不知道class为commbut的控件有几个所以会返回一个array，但是我们知道目前只有一个class为commbut
  				var temp=document.getElementsByClassName("commbut");
  				temp[0].className="";
  				this.className="commbut";
  			}
  		}
  	</script>
  </html>

  ```
* 4.3 接下来就涉及到算法相关的了，冒泡排序，冒泡排序是最经典的也是比较简单的排序方式，他的思想是让彼此相邻的两个数组元素从左到右依次的比较并且将比较大的元素移动到右边，然后第一轮下来之后整个数组中最大的元素就移动到最右边了，然后进行第二次循环将次二大的元素移动到倒数第二的位置以此循环即可。显然需要循环的次数为数组长度减一，而且第一次判断的次数为也为数组长度减一，并且第二次判断的次数比第一次减一。代码如下

  ```javascript
  <script type="text/javascript">
  			var a=[7,8,3,2,1,6,9,0,12,19,1.5];
  			//外层循环控制判断的轮数，总计判断 数组长度减一轮
  			for(var b=1;b<a.length;b++){
  				//内层循环判断一轮中比较的次数，并且每次都是从第一个开始比较，因为每轮都会把当前最大的值放在最后面
  				for(var c=0;c<a.length-b;c++){
  					if(a[c]>a[c+1]){
  						temp=a[c];
  						a[c]=a[c+1];
  						a[c+1]=temp;
  					}
  				}
  			}
  			document.write(a);
  		</script>
  ```
* 4.4 快速排序，快速排序也是非常经典的一个排序方式，他的效率相较于冒泡排序要高的多，但是同样也复杂的多。快速排序的思想却很容易他的思想是 ’分而治之‘，也就是第一次排序的时候选取一个值作为中间值，可以选第一个也可以选最后一个作为中间值，我们暂时将这个中间值起名为temp，后面我们的temp都代指中间值。在这里我们就选择第一个最为中间值了，然后他需要进行第一次便利，便利的时候将所有大于temp的移动到右边，小于的移动到左边，然后我们就得到了两块内容并且我们选取的中间值已经放到了最合适的位置，接下来我们只需要分别对左边与右边进行我们刚才进行的排序就行了，然后两边又会被分成两块内容这样我们就需要使用递归的思想来完成剩下的排序。代码如下

  ```javascript
  <script type="text/javascript">
  			var array = [7, 8, 9, 6,120,99,120,8,69];


  			function quickShort(leftb, rightb) {
  				//执行一便求中值
  				/**
  				 * 我们以最左边的数为基准,然后将所有大于这个数的移动到右边,将所有小于这个数的移动到他的左边
  				 * 然后我们交替的移动左右指针直到这两个指针相遇,即此时两指针值相等并且数组被分成了两个部分
  				 * 一个是大于基准值的区域一个是小于基准值的区域,然后我们在分别对这两个区域进行递归调用就获得到了
  				 * 一个排好序列的数组.
  				 */
  				//首先在进入方法的时候就进行判断若左边大于等于右边我们就直接退出方法
  				if (leftb >= rightb)
  					return;
  				var temp = array[leftb];
  				var l = leftb;
  				var r = rightb;
  				//while循环判断,当两个指针相遇的时候终止搜索
  				while (l < r) {

  					//因为我们以左边的数当作基准,所以我们的指针从有开始往左进行检索,当遇到比temp小的就与左指针指向的数进行交换,并将切换右指针移动
  					while (array[r] >= temp && l < r) {
  						r--;
  					}
  					if (l < r) {
  						array[l] = array[r];
  					}
  					//当右边的数交换了一次之后现在开始移动左指针，并且将所有大于temp的就将他移动到右边
  					while (array[l] <= temp && l < r) {
  						l++;
  					}
  					if (l < r) {
  						array[r] = array[l];
  					}
  					//在我们左右指针相遇的时候也就是所有比temp小的数都移动到了temp左边，所有比temp大的数都移动到了temp的右边，并且此时左指针等于右指针
  					//此时我们就将temp赋给我们得到的中间值的位置并且返回中间值，作为左边与右边进行进一步快排的左右指针！
  					if (l >= r) {
  						array[l] = temp;
  					}
  					//递归调用对左边部分进行排序
  					quickShort(leftb, r - 1);
  					//递归调用对右边部分进行排序
  					quickShort(r + 1, rightb);
  				}

  			}
  				document.write("排序前："+array);
  				quickShort(0, array.length - 1);
  				document.write("<br>"+"排序后："+array);
  				console.log(array)
  		</script>
  ```
* 4.5 代码是有限的但是算法思想是无限的剩下的就交给读者自己探索了........

## JavaScript第六天

1.BOM编程 浏览器对象编程，我们在使用浏览器的时候可以看到有一些常见的模块比如，地址栏，历史区域，前一步后一步，等等。但是我们毕竟不是专业前端这里只做了解与演示。

2.history对象，history对象顾名思义就是我们操作浏览器历史记录的对象，他的几个常用的方法比如，history.forward();向前历史跳转，history.back();向后一步的跳转history.go(index); 向index步的跳转，index可以为正数或者负数，正代表往前我们在这里可以实现向前一步向后一步等，实现前后跳转的代码如下。

```javascript
<body>
		<a href="history对象2.html">go2</a>
		<button id="backe">后退</button>
		<button id="forw">前进</button>
		1
		<script type="text/javascript">
			backe.onclick=function(){
				// window.history.back();
				window.history.go(-2);
			}
			forw.onclick=function(){
				window.history.forward();
				window.history.go(2);
			}
		</script>
	</body>
<body>
		<a href="history对象1.html">go1</a>
		<button id="backe">后退</button>
		<button id="forw">前进</button>
		2
		<script type="text/javascript">
			backe.onclick=function(){
				// window.history.back();
				window.history.go(-2);
			}
			forw.onclick=function(){
				window.history.forward();
				window.history.go(2);
			}
		</script>
	</body>
```

3.loaction对象，也就是地址栏对象用于对当前浏览器的地址栏进行一些操作，比如跳转 打开新窗口，重新载入当前页面等等，常用的方法：

打开一个新窗口 window.open("http://www.baidu.com"); 重新载入当前页面 window.location.reload();

网页跳转到某地址可以后退 window.location.href="http://www.baidu.com";

当前网页替换为某地址不可后退 location.replace("http://www.baidu.com");

```javascript
<body>
		<button id="btn">你好</button>

		<script type="text/javascript">

			btn.onclick=function(){
				//将本网页跳转到百度，可以后退
				window.location.href="http://www.baidu.com";
				//将本网页切换为百度不能后退
				location.replace("http://www.baidu.com");
				//重新加载本网页
				window.location.reload();
				//打开一个新的窗口，进入百度页面 
				window.open("http://www.baidu.com");
			}
		</script>
	</body>
```

4.定时器，定时器是bom编程中最重要的一环，我们通过定时器的参数设定可以完成让一个方法每隔一定的时间执行一次。如下，使用setInterval来声明一个定时器，而定时器方法体写的是定时器执行的内容times则是时间间隔，setInterval( function(){定时方法体} , times)。我们有了定时器之后就可以实现一些比较常见的特效了，比如实时显示当前的时间，一些动画等等具体看下面的例子。

* 4.1 网页时钟，编写js代码实现在网页中实时的显示当前的时间，时间格式为 yyyy-mm-dd hh-mm-ss;这个例子我们显然需要定时器的使用，每隔一秒创建一个date对象然后通过date对象中的方法与字符串拼接来完成时间的格式化，代码具体如下。

  ```javascript
  <body>
  		<div id="dates"></div>
  		<div id="clock"></div>
  		<script type="text/javascript">
  		/**
  		 * setInterval()函数的使用方法，setInterval函数有两个需要的参数，其中第一个是需要被调用的函数里面用来编写需要实现的业务逻辑，而第二个参数则是执行的时间间隔
  		 */
  			setInterval( function(){
  				var temp= new Date();
  				dates.innerHTML=temp;

  				var year=temp.getFullYear();
  				var month=temp.getMonth()+1;
  				var day=temp.getDate();
  				var hour=temp.getHours();
  				var minutes=temp.getMinutes();
  				var seconds=temp.getSeconds();

  				clock.innerHTML=year+"年 "+month+"月 "+day+"日 "+hour+":"+minutes+":"+seconds;
  			} , 1000);
  		</script>
  	</body>
  ```
* 4.2 网页帧动画，编写js代码在网页中点击不同的按钮播放不同的帧动画要求使用数据源思想; 这个案例我们通用也要使用定时器，因为要求我们制作帧动画，帧动画的意义就是1s中为你播放多少张连贯的动画从而让你感觉图片是动态的。显然我们可以通过修改定时器的time来实现，而我们只需要在定时器方法体中不停的切换图片就行了，而要求我们使用数据源思想那么我们就可以吧帧动画图片的名字公共部分保存到数组中，并且使用第二个数组保存图片的个数。然后便利数组为按钮绑定上时间与定时器就行了，还有一些需要注意的点请看代码的注释。

  ```javascript
  <img src="" id="video" width="320px">
  		<button id="0" class="image_video">1</button>
  		<button id="1" class="image_video">2</button>
  		<button id="2" class="image_video">3</button>

  		<script type="text/javascript">
  			//首先我们要获取到所有的控件按钮并且给他们绑定上点击事件
  			var array_btn=document.getElementsByClassName("image_video");
  			//显然我们想要让多个按钮绑定一个方法，并且按不同的按钮实现不同的效果我们就需要引入数据源，将一些具有相同特性但是又不相同的内容放到一个数组中
  			/**
  			 * 很明显我们要提取的内容有图片的数字编号，图片的路径地址，所以创建这两种数据类型的数组
  			 */
  			var imgname=["drink","knockout","scratch"];
  			var imgcount=[81,81,56];
  			var timer=null;
  			var _this;
  			for (var i = 0; i < array_btn.length; i++) {
  				//绑定的点击事件为点击这个按钮会触发对应的动画，显然我们需要一个定时器
  				/**
  				 * 我们如何让这三个按钮去绑定上上面数组的内容呢？此时我们发现一个规律上面三个按钮的id默认值分别是从0-2，正好对应了上面的数组下表索引
  				 * 所以我们不妨在每次点击的时候，让上面我们定义的俩数据源下标绑定到按钮的id上，这样就可以实现点击第一个按钮的时候访问数据源数组的第一个数
  				 * 点击第二个按钮访问数据源数组的第二个数。
  				 * 但是有一点需要注意的是，我们绑定的时候必然是要用this关键字的但是到了计时器里面再使用this关键字指代的就不是按钮这个对象了而是window对象，所以
  				 * 我们要在还是按钮对象的时候保存一下当前的this对象以便后面使用
  				 */
  				array_btn[i].onclick=function(){
  					//在这个定时器中我们要播放动画，并且让他播放完毕后停止且正在播放时不停止，显然需要引入定时器的变量以及动画的播放数来来进行判断
  					//目前没有动画播放的时候允许这个点击事件的触发
  					_this=this;
  					var count=0;
  					/*
  					我们在这加入timer=null的判断的目的是为了方式当前动画还么地结束就启动一个新的计时器从而出现视频鬼畜等现象
  					*/
  					if(timer==null){
  						timer=window.setInterval(function(){
  							video.src="img/"+imgname[parseInt(_this.id)]+"_"+count+".jpg";
  							count++;
  						if(count>=imgcount[_this.id]){
  							clearInterval(timer);
  							//当图片播放完毕后我们将计时器关闭并且置空，计数器清0
  							timer=null;
  						}
  						},10);
  					}
  				}
  			}
  		</script>
  	</body>
  ```
* 4.3 综合案例，使用js代码编写一个点名机，并且将点到的人名信息保存下来；显然点名机并不难通过我们之前学习的那些内容很容易就能够得到思路，首先是数据源思想将人名保存到数组中，通过随机生成下标来访问数组元素，而如何去产生随机的数组下标数呢？显然我们要用到math库中的Random方法了并且我们要对产生的随机数进行处理以得到我们需要的范围，我们可以得到1-100的随机数然后让他对人名数组长度取余从而得到我们想要的数据，而点名机必然少不了人名在屏幕上滚动，所以我们需要让网页中的内容动态的改变所以这点我们需要使用计时器，一直更新网页上的信息，当点击停止按钮的时候终止并且记录点到的人。具体代码如下注意事项见代码注释。

  ```javascript
  <style type="text/css">
  			.main {
  				width: 180px;
  				height: 220px;
  				margin: 0 auto;
  				background: mediumaquamarine;
  				border: brown solid 1px;
  				text-align: center;
  			}
  		</style>
  	</head>
  	<body>
  		<div class="main">
  			<p id="peoplename"
  				style="height: 40px; font-size: 18px; background-color: cornflowerblue; margin: 20px 20px 80px 20px;">
  				null</p>
  			<button id="startbtn">抽签</button><br>
  			<button id="clearbtn">清除记录</button>
  		</div>
  		<div id="selected" style="background: goldenrod; width: 80px; height: auto; color: azure; margin: 0 auto; text-align: center;">
  		中奖名单
  		</div>
  		<script type="text/javascript">
  			var people = ["张三","里斯","王五","赵六","张七","李老八"]
  			var selectedPeople = [];
  			//转动的速度
  			var speed = 10;
  			//计时器对象
  			var timer = null;
  			//计时器2对象
  			var timer1;
  			//保存的数组下标
  			var nub;
  			//点击事件
  			startbtn.onclick = function() {
  				//第一次点击开启计时器1让人名开始转动，并且人名转动是随着随机数转动的
  				if (timer == null) {
  					timer = setInterval(function() {
  						nub = Math.floor((Math.random()*1000))%people.length;
  						peoplename.innerHTML = people[nub];
  						startbtn.innerHTML="暂停";
  					}, speed);
  				}else{
  					//第二次点击按钮的时候进行停止转动，会起另一个计时器去逐渐降低速度
  						timer1=setInterval(function(){
  							startbtn.disabled=true;
  							speed++;
  							//当speed大于50的时候就终止这两个计时器，并且将速度与恢复并且将保存数据到网页上
  							if(speed>50){
  								clearInterval(timer);
  								clearInterval(timer1);
  								speed=10;
  								timer=null;
  								startbtn.innerHTML="抽签";
  								selected.innerHTML=selected.innerHTML+"<br>"+people[nub];
  								startbtn.disabled=false;
  							}
  						},speed);
  				}
  			}
  			clearbtn.onclick=function(){
  				selected.innerHTML="中奖名单:";
  			}
  		</script>
  	</body>


  ```

## JavaScript第七天

1.DOM编程是BOM编程中一个比较重要的分支也就是document对象下面的方法使用他是用来操控浏览器正文的对象其实他的主要作用就是用来修改网页中的标签元素，以及查找标签等等操作，具体不在细说读者完全可以去查询api手册来进行了解，下面只粘一些查找标签的案例代码，请参考注释食用；

```javascript
	<body>
		<div id="maindiv">
			<p class = "p1">p1</p>
			<p class="p1">
				<span id="spanmain">
					<span>你好1</span>
					<span>你好2</span>
					<span>你好3</span>
				</span>
			</p>
			<p class="p1">p3</p>
		</div>
		<script>
			//按id获取标签元素
			var maindiv=document.getElementById("maindiv");
			var mainspan=document.getElementById("spanmain");
			//按class获取标签数组
			var p1array=document.getElementsByClassName("p1");
			//按标签的名字获取标签数组
			var spanarray=mainspan.getElementsByTagName("span");

			/**
			 * es6新特性：
			 * 使用querySelector("选择器")来查找元素
			 */
			//按id查找
			var es6_maindiv=document.querySelector("#maindiv");
			//按类查找,但是这种方法只能返回第一个标签元素
			var es6_p1 = document.querySelector(".p1");
			//按类查找所有的元素
			var es6_p1array = document.querySelectorAll(".p1");
			//按标签名查找元素与所有元素
			var es6_span = document.querySelector("span");
			var es6_spanarray = document.querySelectorAll("span");

			/**
			 * 按照家族关系来获取元素标签
			 */
			//获取第一个子标签
			var jz_span1=spanmain.firstChild;
			var jz_span2=spanmain.firstElementChild;
			//获取最后一个子标签
			var jz_span3=spanmain.lastElementChild;
			//获取所有的子标签返回array
			var jz_spanarray=spanmain.children;
			//获取父元素
			var jz_fater=spanmain.parentElement;
			var jz_fathersp=spanmain.parentNode;
			//获取兄弟元素标签
			var p1=document.querySelector(".p1");
			var jz_borther=p1.nextElementSibling;
			var jz_borthersp=p1.previousElementSibling;
		</script>
	</body>
```

2.案例 使用js代码编写一个能够发送评论的功能，并且要求能够删除要求使用模板模式； 这个案例显示要求了使用模板模式所以我们的思路为先创建一个评论的模板，里面的大部分内容都不需要更改，只要将评论内容与评论时间替换为xxxx。yyyy然后我们直接对模板里面的公告部分通过输入框输入的内容进行替换然后再填充到网页中就ok了，但是对于点击删除这一块有几个需要注意的点，比如如何给点击发送评论后动态生成的按钮绑定事件，以及如何实现点击删除按钮却删除所有的这条信息。思路大体如上注意事项见代码中注释；

```javascript
<style>
			.chatshow{
				border: 1px solid red;
				margin: 10px auto;
				padding: 5px;
				width: 320px;
			}
		</style>
	</head>
	<body>
		<input type="text" id="inputText"><button id="sender">发送</button>
		<div id="shows">

		</div>
		<script type="text/template" id="templates">
			<div class="chatshow">
				<img src="img/result.png" alt="" width="60px" height="60px">张三说:
				<span>xxx</span><br>
				<span>yyyy</span>
				<button>评论</button><button>点赞</button>
				<!-- 想要实现删除当前信息，首先我们需要对按钮进行事件绑定，因为我们这个标签是页面加载后才生成的，在js代码执行后才出现的所以我们
				 需要手动的绑定事件，也就是在按钮标签上绑定删除事件-->
				<button onclick="del(this)">删除</button>
			</div>
		</script>
		<script>
			//但是我们虽然绑定上了事件但是并不知道我们要删除哪一个标签，所以我们需要给方法传递一个参数this也就是当前的这个按钮标签，我们要删除的是
			//他的父元素 div所以我们使用node.parentNode.remove();能完成删除
			function del(node){
				node.parentNode.remove();
			}
			sender.onclick = function(){
				shows.innerHTML=shows.innerHTML+templates.innerHTML.replace("xxx",inputText.value).replace("yyyy",new Date());
			}

		</script>
	</body>
```

3.综合案例 使用js实现点餐模块，可以输入菜品与价格保存到右边表格中，有全选单选反选的功能，被选择的可以被删除，然后也可以进行开票操作生成账单。显然对于这个案例我们需要先搭建好表单与右边的表格头，然后表格内容tbody可以使用模板来进行追加填充，同样是创建模板可变的内容用xxxx，yyyy来替代然后使用字符串的replace(arg1，arg2)方法来进行替换然后填充到tbody中，而对于全选与反选，我们不妨为复选框添加一个class通过获取所有的复选框对象数组进行便利判断状态来进行修改，比如全选我们就便利复选框数组将他们的chacked状态全设为true全不选也是这样，反选则让当前状态取反即可。对于删除所选内容也是进行数组便利将所有chacked状态为true的执行remove方法，而对于单选我们就不在多说了，而结账模块，我们也是便利所有的元素数组然后根据第一个案例中的方法找到对应的信息模块来进行字符串拼接与运算然后填充到网页中。具体内容与注意实现见下代码。

```javascript
<title></title>
		<!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">
	</head>
    <body>

		<div class="row">
			<div class="col-md-2">
				<div class="form-group">
				    <label for="exampleInputEmail1">商品名称</label>
				    <input type="text" class="form-control" id="i1" placeholder="菜名">
				</div>
				<div class="form-group">
				    <label for="exampleInputEmail1">商品价格</label>
				    <input type="text" class="form-control" id="i2" placeholder="价格">
				  </div>
				  <button class="btn btn-success" id="addshop">添加</button>
				  <button class="btn btn-danger" id="removeSelect">删除</button>
				  <button class="btn btn-primary" id="reverseSelect">反选</button>
				  <button class="btn btn-primary" id="count">开票</button>
				  <div id="ticket" style="margin: 10px auto;border: 2px solid cadetblue;padding: 10px;text-align: center;">

				  </div>
			</div>
			<div class="col-md-10">
				<table class="table table-bordered table-hover table-striped ">
					<thead>
						<tr>
							<th><input type="checkbox" id="checkall"></th>
							<th>商品名称</th>
							<th>商品价格</th>
							<th>商品操作</th>
						</tr>
					</thead>
					<tbody id="tb">

					</tbody>
				</table>
			</div>
		</div>
		<script type="text/template" id="templ">
			<tr>
				<th><input type="checkbox" class="checkone"></th>
				<th>shopname</th>
				<th>shopprice</th>
				<th><button class="btn btn-danger" onclick="removeShop(this)">删除</button></th>
			</tr>
		</script>
		<script>
			/**
			 * 添加商品的方法,显然我们需要将我们在输入框中输入的内容填充到我们预定义的模板中，然后将模板以追加的形式添加到tbody中
			 */
			addshop.onclick = function(){
				tb.innerHTML=templ.innerHTML.replace("shopname",i1.value).replace("shopprice",i2.value)+tb.innerHTML;
			}
			/**
			 * 删除商品的方法，和之前我们做的删除一样，因为按钮是动态生成的所有只能在按钮内部进行事件绑定，所以onclick()方法写在按钮中，
			 * 然后我们需要将this作为参数穿到方法中
			 */
			function removeShop(removeBtn){
				removeBtn.parentNode.parentNode.remove();
			}
			/**
			 * 当我们上面的全选框发生改变的时候，我们就让下面所有的复选框的选择状态和全选的状态一致
			 */
			checkall.onchange = function(){
				var chackOneArray=document.getElementsByClassName("checkone");
				for(var i=0;i<chackOneArray.length;i++){
					chackOneArray[i].checked=checkall.checked;
				}
			}
			/**
			 * 反选
			 */
			reverseSelect.onclick = function(){
				var chackOneArray=document.getElementsByClassName("checkone");
				for(var i=0;i<chackOneArray.length;i++){
					chackOneArray[i].checked=!chackOneArray[i].checked;
				}
			}
			/**
			 * 删除所选
			 */
			removeSelect.onclick = function(){
				var chackOneArray=document.getElementsByClassName("checkone");
				for(var i=0;i<chackOneArray.length;i++){
					if(chackOneArray[i].checked){
						chackOneArray[i].parentNode.parentNode.remove();
					}
				}

			}
			/**
			 * 我们要完成开票这个动作，需要我们遍历右边菜单中的内容，读取里面的商品名称与商品价格，而且每读取一个商品名称我们就需要将他追加到
			 * div中，并且统计商品的总价格。但是我们获取到的只是按钮的数组，在我们便利数组的时候想要读取商品名与商品价格则需要获取到按钮父标签的
			 * 父标签也就是tr标签然后在获取tr标签中的th标签数组，然后读取第一个与第二个数组下标拿到商品的的名字与价格，然后再进一步的处理
			 */
			count.onclick=function(){
				ticket.innerHTML="<h4>票据</h4>"
				var chackOneArray=document.getElementsByClassName("checkone");
				var pay=0;
				for(var i=0;i<chackOneArray.length;i++){
					var goodarray=chackOneArray[i].parentNode.parentNode.querySelectorAll("th");
					pay=pay+Number(goodarray[2].innerHTML);
					ticket.innerHTML=ticket.innerHTML+(i+1)+"."+goodarray[1].innerHTML+":"+goodarray[2].innerHTML+"<br>";
					}
					ticket.innerHTML=ticket.innerHTML+"<br>"+"总计:"+pay+"元";
				}

		</script>
	</body>
```

## JavaScript第八天

1.在js中事件也是比较重要的一环，所谓事件就是鼠标事件与键盘事件。而鼠标事件无外乎鼠标左键单击，鼠标右键单击，鼠标中间单击。鼠标移入鼠标移出。而键盘事件无外乎哪个键按下，哪个键抬起等等，而这些事件都有一个个的事件与之对应，具体可以参照下面的表格

**事**件对象与属性**

**常量**


| **静态变量**        | **描述**                                 | **DOM** |
| --------------------- | ------------------------------------------ | --------- |
| **CAPTURING-PHASE** | **当前事件阶段为捕获阶段(1)**            | **1**   |
| **AT-TARGET**       | **当前事件是目标阶段,在评估目标事件(1)** | **2**   |
| **BUBBLING-PHASE**  | **当前的事件为冒泡阶段 (3)**             | **3**   |

**属性**


| **属性**                                                               | **描述**                                           | **DOM** |
| ------------------------------------------------------------------------ | ---------------------------------------------------- | --------- |
| [bubbles](https://www.runoob.com/jsref/event-bubbles.html)             | **返回布尔值，指示事件是否是起泡事件类型。**       | **2**   |
| [cancelable](https://www.runoob.com/jsref/event-cancelable.html)       | **返回布尔值，指示事件是否可拥可取消的默认动作。** | **2**   |
| [currentTarget](https://www.runoob.com/jsref/event-currenttarget.html) | **返回其事件监听器触发该事件的元素。**             | **2**   |
| **eventPhase**                                                         | **返回事件传播的当前阶段。**                       | **2**   |
| [target](https://www.runoob.com/jsref/event-target.html)               | **返回触发此事件的元素（事件的目标节点）。**       | **2**   |
| [timeStamp](https://www.runoob.com/jsref/event-timestamp.html)         | **返回事件生成的日期和时间。**                     | **2**   |
| [type](https://www.runoob.com/jsref/event-type.html)                   | **返回当前 Event 对象表示的事件的名称。**          | **2**   |

**方法**


| **方法**              | **描述**                                     | **DOM** |
| ----------------------- | ---------------------------------------------- | --------- |
| **initEvent()**       | **初始化新创建的 Event 对象的属性。**        | **2**   |
| **preventDefault()**  | **通知浏览器不要执行与事件关联的默认动作。** | **2**   |
| **stopPropagation()** | **不再派发事件。**                           | **2**   |

**目标事件对象**

**方法**


| **方法**                  | **描述**                                                        | **DOM** |
| --------------------------- | ----------------------------------------------------------------- | --------- |
| **addEventListener()**    | **允许在目标事件中注册监听事件(IE8** **= attachEvent())**       | **2**   |
| **dispatchEvent()**       | **允许发送事件到监听器上 (IE8 =** **fireEvent())**              | **2**   |
| **removeEventListener()** | **运行一次注册在事件目标上的监听事件(IE8 =** **detachEvent())** | **2**   |

**事件监听对象**

**方法**


| **方法**          | **描述**                         | **DOM** |
| ------------------- | ---------------------------------- | --------- |
| **handleEvent()** | **把任意对象注册为事件处理程序** | **2**   |

**文档事件对象**

**方法**


| **方法**          | **描述** | **DOM** |
| ------------------- | ---------- | --------- |
| **createEvent()** |          | **2**   |

**鼠标/键盘事件对象**

**属性**


| **属性**                                                               | **描述**                                                                                 | **DOM** |
| ------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------ | --------- |
| [altKey](https://www.runoob.com/jsref/event-altkey.html)               | **返回当事件被触发时，"ALT" 是否被按下。**                                               | **2**   |
| [button](https://www.runoob.com/jsref/event-button.html)               | **返回当事件被触发时，哪个鼠标按钮被点击。**                                             | **2**   |
| [clientX](https://www.runoob.com/jsref/event-clientx.html)             | **返回当事件被触发时，鼠标指针的水平坐标。**                                             | **2**   |
| [clientY](https://www.runoob.com/jsref/event-clienty.html)             | **返回当事件被触发时，鼠标指针的垂直坐标。**                                             | **2**   |
| [ctrlKey](https://www.runoob.com/jsref/event-ctrlkey.html)             | **返回当事件被触发时，"CTRL" 键是否被按下。**                                            | **2**   |
| [Location](https://www.runoob.com/jsref/event-key-location.html)       | **返回按键在设备上的位置**                                                               | **3**   |
| [charCode](https://www.runoob.com/jsref/event-key-charcode.html)       | **返回onkeypress事件触发键值的字母代码。**                                               | **2**   |
| [key](https://www.runoob.com/jsref/event-key-key.html)                 | **在按下按键时返回按键的标识符。**                                                       | **3**   |
| [keyCode](https://www.runoob.com/jsref/event-key-keycode.html)         | **返回onkeypress事件触发的键的值的字符代码，或者 onkeydown 或 onkeyup 事件的键的代码。** | **2**   |
| [which](https://www.runoob.com/jsref/event-key-which.html)             | **返回onkeypress事件触发的键的值的字符代码，或者 onkeydown 或 onkeyup 事件的键的代码。** | **2**   |
| [metaKey](https://www.runoob.com/jsref/event-metakey.html)             | **返回当事件被触发时，"meta" 键是否被按下。**                                            | **2**   |
| [relatedTarget](https://www.runoob.com/jsref/event-relatedtarget.html) | **返回与事件的目标节点相关的节点。**                                                     | **2**   |
| [screenX](https://www.runoob.com/jsref/event-screenx.html)             | **返回当某个事件被触发时，鼠标指针的水平坐标。**                                         | **2**   |
| [screenY](https://www.runoob.com/jsref/event-screeny.html)             | **返回当某个事件被触发时，鼠标指针的垂直坐标。**                                         | **2**   |
| [shiftKey](https://www.runoob.com/jsref/event-shiftkey.html)           | **返回当事件被触发时，"SHIFT" 键是否被按下。**                                           | **2**   |

*鼠标事件与键盘事件*


| **属性**                                                               | **描述**                                   | **DOM** |
| ------------------------------------------------------------------------ | -------------------------------------------- | --------- |
| [onclick](https://www.runoob.com/jsref/event-onclick.html)             | **当用户点击某个对象时调用的事件句柄。**   | **2**   |
| [oncontextmenu](https://www.runoob.com/jsref/event-oncontextmenu.html) | **在用户点击鼠标右键打开上下文菜单时触发** |         |
| [ondblclick](https://www.runoob.com/jsref/event-ondblclick.html)       | **当用户双击某个对象时调用的事件句柄。**   | **2**   |
| [onmousedown](https://www.runoob.com/jsref/event-onmousedown.html)     | **鼠标按钮被按下。**                       | **2**   |
| [onmouseenter](https://www.runoob.com/jsref/event-onmouseenter.html)   | **当鼠标指针移动到元素上时触发。**         | **2**   |
| [onmouseleave](https://www.runoob.com/jsref/event-onmouseleave.html)   | **当鼠标指针移出元素时触发**               | **2**   |
| [onmousemove](https://www.runoob.com/jsref/event-onmousemove.html)     | **鼠标被移动。**                           | **2**   |
| [onmouseover](https://www.runoob.com/jsref/event-onmouseover.html)     | **鼠标移到某元素之上。**                   | **2**   |
| [onmouseout](https://www.runoob.com/jsref/event-onmouseout.html)       | **鼠标从某元素移开。**                     | **2**   |
| [onmouseup](https://www.runoob.com/jsref/event-onmouseup.html)         | **鼠标按键被松开。**                       |         |
| **2**                                                                  |                                            |         |


| **属性**                                                         | **描述**                       | **DOM** |
| ------------------------------------------------------------------ | -------------------------------- | --------- |
| [onkeydown](https://www.runoob.com/jsref/event-onkeydown.html)   | **某个键盘按键被按下。**       | **2**   |
| [onkeypress](https://www.runoob.com/jsref/event-onkeypress.html) | **某个键盘按键被按下并松开。** | **2**   |
| [onkeyup](https://www.runoob.com/jsref/event-onkeyup.html)       | **某个键盘按键被松开。**       | **2**   |

2.上面我们已经了解了鼠标与键盘的事件方法以及他们的一些属性，所以我们接下来就根据上面表格中的一些内容来实现一些案例。

* 2.1 案例1 简单测试鼠标的所有事件。

  鼠标事件就比较简单有单击 长按 释放 双击 进入 离开这几个状。他们分别代表的事件为onclick，ondblclick，onmousedown，onmouseup，onmouseenter，onmouseleave。具体演示代码如下

  ```javascript
  <body>
  		<button id="zan">点赞</button>
  		<span id="boom">手雷</span>
  	</body>
  <script type="text/javascript">
  		/**
  		 * 鼠标事件就比较简单有单击 长按 释放 双击 进入 离开这几个状态，
  		 * 他们分别代表的事件为
  		 * onclick，ondblclick，onmousedown，onmouseup，onmouseenter，onmouseleave
  		 * 具体演示代码如下
  		 */
  		zan.onclick = function(){
  			zan.innerHTML="已赞";
  		}
  		zan.ondblclick = function(){
  			zan.innerHTML="666";
  		}
  		boom.onmousedown=function(){
  			boom.innerHTML="拉环";
  		}
  		boom.onmouseup=function(){
  			boom.innerHTML="扔";
  		}
  		boom.onmouseenter=function(){
  			boom.style.background="green";
  		}
  		boom.onmouseleave=function(){
  			boom.style.background="blue";
  		}

  	</script>
  ```
* 2.2 案例2 实现鼠标点击哪里按钮平滑的移动到点击的位置，并且实现右键点击出现自定义的菜单。

  首先这个案例我们需要监听鼠标点击的事件，而这个事件就是onmousedown，鼠标按下事件，并且可以通过event对象来获取到我们点击的是那个鼠标按键。我们通过为body绑定鼠标点击事件来完成监听。然后通过事件方法中传过来的e对象获取到当前点击的x y坐标通过定位来修改按钮的位置。

  而对于右键自定义的菜单我们先要吧浏览器自带的右键菜单给阻断掉然后为鼠标右键绑定自定义菜单。浏览器自带右键菜单的事件为oncontextmenu，我们为这个事件绑定个方法并且让他直接返回false就可以了。自定义右键菜单我们就可以先创建一个div让这个div先display none并且设置定位，而当我们右键单击的时候获取右键单击的位置然后通过定位的方式将菜单定位到我们点击的地方然后display block。

  ```javascript
  <style type="text/css">
  			html,body{
  				height: 100%;
  			}
  			button{
  				position: absolute;
  				transition: all 2s;
  			}
  			#mune{
  				background: cadetblue;
  				border: 1px solid red;
  				height: 120px;
  				width: 100px;
  				display: none;
  				position: absolute;
  			}
  		</style>
  	</head>
  	<body>
  		<button id="clickbtn">
  			点击
  		</button>
  		<div id="mune">
  			<ul>
  				<li><a href="#">任务1</a></li>
  				<li><a href="#">任务2</a></li>
  				<li><a href="#">任务3</a></li>
  			</ul>
  		</div>
  <script>
  			//首先我们要阻断浏览器自带的右键菜单
  			document.body.oncontextmenu=function(){
  				return false;
  			}
  			//然后我们要实现在浏览器上点击右键弹出一个自定义的菜单首先需要判断点击的是左键还是右键
  			document.body.onmousedown=function(e){
  				//若为右键我们就让我们自定义的菜单在我们点击的位置显示
  				if(e.button==2){
  					mune.style.left=e.clientX+"px";
  					mune.style.top=e.clientY+"px";
  					mune.style.display="block";
  					//若点的是左键就让他移动过去
  				}else if(e.button==0){
  					mune.style.display="none";
  					clickbtn.style.left=e.clientX+"px";
  					clickbtn.style.top=e.clientY+"px";
  				}
  			}
  		</script>


  	</body>
  ```
* 2.3 案例3 实现网页画板，可以调整画笔颜色与画笔粗细。

  显然我们这个需求需要一个画板和两个input来控制画笔的颜色与粗细，这些都是一些html的控件查阅手册就可以实现，而js代码中我们需要监听几个事件 1.监听画笔在画板点击的地方，当点击下去将画笔移动到点击的地方。2.当画笔点击了之后监听鼠标移动的事件，当鼠标移动的时候随着鼠标的轨迹去绘制线。3.当鼠标松开左键的时候终止事件。具体可见下代码

  ```javascript
  <body>
  		<canvas id="printbg" width="800px" height="400px" style="background: lightslategrey;"></canvas>
  		<input type="color" id="colorsel"/><input type="range" max="500" min="1" id="colorbord"/>

  		<script>
  			//获取画笔
  			var ctx=printbg.getContext("2d");
  			//点击画板的事件
  			printbg.onmousedown= function(e){
  				//在画板上生成画笔
  				ctx.beginPath();
  				//将画笔移动到我们鼠标点击的位置
  				ctx.moveTo(e.clientX,e.clientY);
  				//将画笔的颜色样式修改我们我们通过input输入的颜色
  				ctx.strokeStyle = colorsel.value;
  				//将画笔的粗细设置为我们input设置的粗细
  				ctx.lineWidth=colorbord.value;
  				//当我们鼠标移动的时候触发，绘制一根线从画笔之前的位置移动到鼠标移动的位置
  				printbg.onmousemove=function(e){
  					ctx.lineTo(e.clientX,e.clientY);
  					//渲染刚才绘制的图片
  					ctx.stroke();
  				}
  				//当抬起画笔的时候就将画笔置空
  				printbg.onmouseup=function(){
  					printbg.onmousemove=null;
  				}
  			}
  		</script>
  	</body>
  ```
* 2.4 案例4 实现监听键盘wasd做到网页上的控件移动。这个案例就比较明确了就是监听wasd这四个键的按压事件，分别按下wasd的时候实现控件在屏幕上的上下左右移动，但是我们只需要一个监听事件就可以完成，一个监听事件来判断是哪一个按键的code然后进行不同的操作。但是在里面有一个需要注意的是当我们移动控件的时候不能直接在原来的定位便宜上进行修改，需要引入一个变量来控制定位的left top偏移量。具体见代码

  ```javascript
  <head>
  		<meta charset="utf-8">
  		<title></title>
  		<style>
  			html,body{
  				height: 100%;
  			}
  			#plan{
  				position: absolute;
  				transition: all 2s;
  			}
  		</style>
  	</head>
  	<body>
  		<!-- 实现键盘左右上下键实现小飞机的移动 -->
  		<button id="plan">飞机</button>
  		<script>
  			//首先我们要创建两个对象来保存飞机的实时坐标，初始值就是top与left的默认值
  			var t=plan.style.top;
  			var l=plan.style.left;
  			document.body.onkeydown=function(e){
  				//当点击一次上下左右的时候就将按钮的定位往上下左右分别偏移50，这里必须要使用变量进行然后在与 "px" 进行拼接否则无法实现移动
  				console.log(e.keyCode);
  				if(e.keyCode==87){
  					t=t-50;
  					plan.style.top=t+"px";
  				}else if(e.keyCode==65){
  					l=l-50;
  					plan.style.left=l+"px";
  				}else if(e.keyCode==83){
  					t=t+50;
  					plan.style.top=t+"px";
  				}else if(e.keyCode==68){
  					l=l+50;
  					plan.style.left=l+"px";
  				}


  			}
  		</script>
  	</body>
  ```
* 2.5 案例5 实现上传图片上传完毕之后将上传的的图片展示在图片预览框中。`<br>`对于这个需求显然我们需要监听文件上传框，当文件上传框发生改变的时候触发监听创建一个文件读取者，当文件读取者读取完毕的时候将图片预览框修改为我们刚才上传的图片即可。具体见下代码

  ```javascript
  <body>
  		<img src="" alt="" id="imgtx">
  		<input type="file" id="imgfile" multiple>

  		<script>
  			/**
  			 * 实现上传头像我们要使用一个新的类。以及一些新事件方法
  			 * FileReader()文件读取者，并且通过这个对象的readAsDataURL(file)方法来读取到我们要传上去的图片,并且可以通过.result来返回
  			 * 文件的url。
  			 * .onchaneg当输入框中的内容发生改变的时候
  			 * .onload当文件完成加载的时候
  			 * 所以我们想要实现传入图片在框中实现预览，就首先需要一个文件上传框，然后需要一个图片框来显示我们要预览的图片
  			 * 首先我需要一个监听事件，监听当文件输入框改变的时候触发事件，然后创建文件读取者读取我们文件输入框中输入的图片内容
  			 * 然后当文件读取者读取完毕的时候再调用一个方法来让预览框显示我们之前传入的图片
  			 */
  			imgfile.onchange=function(){
  				var frd=new FileReader();
  				frd.readAsDataURL(imgfile.files[0]);
  				frd.onload=function(){
  				imgtx.src=frd.result;
  				}
  			}
  		</script>
  	</body>

  ```

## JavaScript第九天

1.在js中事件冒泡也是比较重要的一环但是对于我们后端程序员来说并不是很重要，在此我们只对事件冒泡进行了解与演示，事件冒泡用概念的形式来说的话就是一个事件在某个控件上触发了，可能这个控件并没有处理这个事件的能力所以js就要把这个事件委托给外面的控件进行处理或者外面的控件传递给内部控件进行处理。通俗点说就是我们为最里层的标签设置了一个事件但是在这个标签的外面还有其他比较大的控件比如说span外面的div控件，div控件外面的body控件等等，当外面点击span控件时他会将这个点击事件向外传递通知每一个能够处理这个事件的方法来进行处理。具体见下面案例

* 1.1 案例1 利用冒泡阻断来实现点击父标签只弹出父标签的框点击子标签只弹出子标签的框。这个案例就用到了js中的冒泡阻断，因为子标签的点击事件因为冒泡原理会传递到父标签上，你如果不添加阻断就会出现点击子标签弹出父标签和子标签的情况。

  ```javascript
  <!DOCTYPE html>
  <html>
  	<head>
  		<meta charset="utf-8">
  		<title></title>
  		<style>
  			#d1{
  				width: 100px;
  				height: 100px;
  				background: lightsalmon;
  			}
  			#d2{
  				width: 50px;
  				height: 50px;
  				background: aqua;
  			}
  		</style>
  	</head>
  	<body>
  		<div id="d1">
  			<div id="d2">
  			</div>
  		</div>
  		<script>
  			d1.onclick=function(){
  				alert("父标签被点击了");
  			} 
  			d2.onclick=function(e){
  				alert("子标签被点击了")
  				//阻断事件的冒泡性，让点击子标签只提示子标签，点击父标签只提示父标签
  				e.cancelBubble=true;
  			}
  		</script>
  	</body>
  </html>
  ```
* 1.2 案例2 实现模拟菜单，浏览器上显示两个菜单当点击某一个的时候展开具体信息再次点击的时候收回具体信息。

  显然这个需求我们只需要监听菜单头的事件当菜单头被点击的时候将菜单体设置成none或者block。注意事项见下代码

  ```javascript
  	<body>
  		<ul>
  			<li>川菜
  				<ul>
  					<li>1</li>
  					<li>2</li>
  					<li>3</li>
  				</ul>
  			</li>

  			<li>鲁菜
  				<ul>
  					<li>1</li>
  					<li>2</li>
  					<li>3</li>
  				</ul>
  			</li>
  		</ul>
  		<script>
  			/**
  			 * 获取所有的li数组然后循环绑定事件,在事件中外面要做到点击最外层的li也就是卤菜然后吧里面的ul给他隐藏掉
  			 * 所以我们在事件内部要判断li里面的ul的display状态，若为none则将他设置成block若为block则将他设置成none,
  			 * 因为js中的事件冒泡机制，尽管他内部的li没有子标签但是他还会委托给他的外层li让他进行处理，所以我们要将事件冒泡阻断
  			 * 但是这样会产生一个报错，若内部li无法向外委托就会无法实现我们this中的内容就会报错，所以我们加入trycatch进行处理
  			 */
  			var liarray=document.body.getElementsByTagName("li");
  			for(var i=0;i<liarray.length;i++){
  				liarray[i].onclick=function(e){
  					try{
  						this.firstElementChild.style.display=this.firstElementChild.style.display=="none"?"block":"none";
  					}catch{
  						e.cancelBubble=true;
  					}
  				}
  			}
  		</script>
  	</body>

  ```

2.正则表达式永远是一门语言中的高阶内容，它晦涩难懂但是却十分高效我们如果能够很好的利用正则表达式进行一些内容验证就能节省我们很多的时间，所以我们在这里仅仅是对正则表达式进行一点点的了解能够运用正则表达式就可以了。

* 正则常用符号
* 1 在没有 ^和$的时候 代表只要包含则匹配
  2 . 代表任意字符
  3 \ 代表转义符
  4 * 匹配前面的子表达式任意次。例如，zo*能匹配“z”，也能匹配“zo”以及“zoo”。*等价于{0,}。
  5 + 匹配前面的子表达式一次或多次(大于等于1次）。例如，“zo+”能匹配“zo”以及“zoo”，但不能匹配“z”。+等价于{1,}。
  6 ? 匹配前面的子表达式零次或一次。例如，“do(es)?”可以匹配“do”或“does”。?等价于{0,1}。
  7 {n} {n,} {n,m}      匹配次数
  8 []                  匹配范围
  9 ^匹配输入字行首。如果设置了RegExp对象的Multiline属性，^也匹配“\n”或“\r”之后的位置。
  $匹配输入行尾。如果设置了RegExp对象的Multiline属性，$也匹配“\n”或“\r”之前的位置。

2.1 综合案例1 利用正则表达式完成表单格式验证。

在我们进行前端后端开发的时候表单常常是我们接触最多的东西，比如登陆注册等等。而如果我们每次的验证都交给服务器来处理那么必然会导致大量的服务器资源占用，所以我们往往把表单输入格式的验证交给js来处理。而如何利用js来进行表单验证呢？根据尝试我们可以知道表单的输入框常常有两种状态。其一是当我们点入一个输入框也就是输入框获得焦点的状态反之就是输入框失去焦点的时候。那么我们只需要对这两种状态做文章就可以了。当获取到输入框焦点的时候我们需要让表单给出相应的输入格式提示，这一点可以利用span与display none来实现。而表单格式验证我们就可以通过输入框失去焦点的事件来实现，当输入框失去焦点的时候将输入框输入的内容通过正则来进行验证。并且在最后提交的时候我们可以判断上面的几个输入框内容是否合法来决定是否要提交。具体实现代码如下

```javascript
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title></title>
		<!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">
	    <style>
			fieldset { width: 500px;margin: 100px auto;}
			.form-control {margin-bottom: 30px;}
			.form-group   {position: relative;}
			.form-group span {position: absolute;bottom: -25px;display: none;}
		</style>
	</head>
    <body>

		 <fieldset id="">
		 	<legend>用户注册</legend>
		 
		 	<form action="https://www.baidu.com" method="POST" id="registfm">
		 	  <div class="form-group">
		 	    <label for="exampleInputEmail1">账号</label>
		 	    <input type="text" class="form-control" id="zh" placeholder="请输入账号">
				<span class="text-muted">请输入账号 6-18位 不能用中文 开头必须是字母</span>
				<span class="text-success">账号可用</span>
				<span class="text-danger" >账号输入有问题 请正确输入</span>
		 	  </div>
		 	  <div class="form-group">
		 	    <label for="exampleInputPassword1">密码</label>
		 	    <input type="password" class="form-control" id="mm" placeholder="请输入密码">
				<span class="text-muted">请输入密码 6-18位 不能用中文 开头必须是字母</span>
				<span class="text-success">密码可用</span>
				<span class="text-danger" >密码输入有问题 请正确输入</span>
		 	  </div>
		 	 <div class="form-group">
		 	   <label for="exampleInputPassword1">确认密码</label>
		 	   <input type="password" class="form-control" id="qrmm" placeholder="请确认密码">
			   <span class="text-muted">请重复输入密码</span>
			   <span class="text-success">重复密码可用</span>
			   <span class="text-danger" >两次密码不一致</span>
		 	 </div>
		 	  <div class="form-group">
		 	    <label for="exampleInputPassword1">邮箱</label>
		 	    <input type="email" class="form-control" id="" placeholder="请输入邮箱">
				<span class="text-muted">请正确输入您的邮箱</span>
				<span class="text-success">邮箱可用</span>
				<span class="text-danger" >邮箱输入有问题 请正确输入</span>
		 	  </div>
		 	  <button type="submit" class="btn btn-danger btn-block">注册</button>
		 	</form>
		 </fieldset>
		<script>
			//正则表达式的数组用来判断四个输入框中的值是否合法
			var rengArray=[
			/^[a-zA-Z]\w{5,17}$/,
			/^[a-zA-Z]\w{5,17}$/,
			0,
			/^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/
			];
			//获得所有的输入框
			var inputarray=document.getElementsByClassName("form-control");
			//遍历输入框来为他们绑定上获得焦点的事件，与失去焦点与正则表达式校验的事件
			for (var i = 0; i < inputarray.length; i++) {
				var input = inputarray[i];
				input.tempnub=i;
				input.onfocus=function(){
					var childs=this.parentNode.children;
					childs[3].style.display="none";
					childs[4].style.display="none";
					childs[2].style.display="inline";
				}
				input.onblur=function(){
					var childs=this.parentNode.children;
					if(this.tempnub==2){
						rengArray.splice(2,1,new RegExp("^"+this.value+"$"));
					}
					childs[2].style.display="none";
					if(this.value.length>0){
						if(rengArray[this.tempnub].test(this.value)){
							childs[3].style.display="inline";
						}else{
							childs[4].style.display="inline";
						}
					}
				}
			}
			//当点下提交按钮的时候，判断上面几个输入框是否都验证通过若有一个不通过的就阻断事件
			var divarray=document.getElementsByClassName("form-group");
			registfm.onsubmit=function(){
				for (var i = 0; i < divarray.length; i++) {
					if(divarray[i].children[3].style.display != "inline"){
						return false;
					}

				}
			}
		</script>
	</body>
</html>
```

## JavaScript第十天

1.今天我们来学习一个js的框架jquery，jQuery这个框架可以说是家喻户晓他的强大是众所周知的，我们使用jQuery框架之后好多特效我们只需要调用jq中的方法就可以完成了，而无需去编写原生的js代码。

2.如何去使用jq框架呢，我们最常用的就是使用cdn网址进行导入，通过使用百度的cdn来导入jq框架

```txt
src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js">
api手册 https://jquery.cuishifeng.cn/
```

3.jq中的核心内容与使用方法

* 3.1 jQuery中的核心内容，网页标签的选择。在原生js中我们可以通过一些检索的方法来根据标签名，标签id，标签类来检索某些标签。而在jq中我们只需要使用 $("表达式") 就可以完成对应标签的检索。其中表达式可以为 标签class，标签id，标签名。其中标签class和标签名可能会返回多个标签信息。示例如下。

  ```javascript
  var div = document.querySelector(".hehe");                          $(".hehe")
  var div = document.querySelector("#haha");                          $("#haha")
  var div = document.querySelector("div");                            $("div")
  ```
* 3.2 jQuery中的css，在原生js中我们只能通过 检索到的标签.style.xxxxx来设置标签的样式，而在jQuery中我们可以更加便捷的修改标签的样式，比如$("标签选择器").css({"样式1key":"样式1value","样式2key":"样式2value"})来实现css样式的修改。示例如下

  ```javascript
  <body>
  		<div id="divid" class="divclass">
  			你好世界
  		</div>
  		<script type="text/javascript">

  			$("#divid")
  			.width("800px")
  			.height("400px")
  			.css({"color":"#30b7ff","background":"#aabbcc","font-size":"99px"});

  		</script>
  	</body>
  ```
* 3.3 jQuery中的选择器，在jQuery中有很多的选择器具，通过这些选择器可以很方便的选到标签数组中我们需要的那些标签，但是有些内容并没有原生的js方便所以还是要具体情况具体分析，接下来我们见对几个选择器进行简单的演示，如果想要深入了解则可以去参考文档查看。

  ```javascript

  1.层级选择器,层级选择器的话大概和我们在写css的时候相似都是那几个
  子类选择器，只选择自己的儿子，而非直系不选择
  <body>
  		<div>
  			<p>1</p>
  			<p>1
  				<input>
  			</p>
  			<span style="display: block;">
  				<p>1</p>
  			</span>
  		</div>
  		<script>
  			$("div>p").css({
  				"background": "green"
  			})
  		</script>
  	</body>
  兄弟选择器，只选择自同辈的标签，就是选自和自己平级的标签
  	<body>
  		<div>
  			<p>1</p>
  			<p>1
  				<input>
  			</p>
  			<span style="display: block;">
  				<p>1</p>
  			</span>
  		</div>
  		<p>1</p>
  		<script>
  			$("div~p").css({
  				"background": "green"
  			})
  		</script>
  	</body>

  后代选择器，选择div标签所有的p后代无论是否直系
  <body>
  		<div>
  			<p>1</p>
  			<p>1
  				<input>
  			</p>
  		</div>
  		<script>
  			$("div p").css({
  				"background": "green"
  			})
  		</script>
  	</body>
  临近选择器，就是选择和自己紧挨着的
  	<body>
  		<div>
  			<p>1</p>
  			<span style="display: block;">
  				<p>1</p>
  			</span>
  			<p>1
  				<input>
  			</p>
  		</div>
  		<p>1</p>
  		<script>
  			$("span+p").css({
  				"background": "green"
  			})
  		</script>
  	</body>
  ```
* 3.4 jQuery中的选择器，我们上面是介绍了jq中的一些选择器其中大部分都和原生的css类似，而jq也有自己的一些选择器能够很方便的找到标签数组中我们需要的部分。

  ```html

  1.eq筛选器,eq(index)用于找到标签数组中第index个元素
  <body>
  		<ul>
  			<li>1</li>
  			<li>2</li>
  			<li>3</li>
  			<li>4</li>
  			<li>5</li>
  			<li>6</li>
  			<li>7</li>
  			<li>8</li>
  			<li>9</li>
  			<li>10</li>
  		</ul>
  		<script type="text/javascript">
  			$("li:eq(2)").css({"color":"red"})
  		</script>
  	</body>
  2.gt筛选器,gt(index)用于找到第标签数组中第index后面的元素标签
  	<body>
  		<ul>
  			<li>1</li>
  			<li>2</li>
  			<li>3</li>
  			<li>4</li>
  			<li>5</li>
  			<li>6</li>
  			<li>7</li>
  			<li>8</li>
  			<li>9</li>
  			<li>10</li>
  		</ul>
  		<script type="text/javascript">
  			$("li:gt(3)").css({"color":"red"})
  		</script>
  	</body>
  3.还有一些其他的比如 first last等等读者大可用到的时候再去查手册。。。。。。。
  ```
* 3.5 jq中的筛选器方法，在jq中有着不少的筛选器方法，他也是用来找到我们需要的标签的但是与选择器不同的是，筛选器是一些方法使用方式.fun()

  ```html
  1.first()筛选器
  	<body>
  		<ul>
  			<li>1</li>
  			<li>2</li>
  			<li>3</li>
  			<li>4</li>
  			<li>5</li>
  			<li>6</li>
  			<li>7</li>
  			<li>8</li>
  			<li>9</li>
  			<li>10</li>
  		</ul>
  		<script type="text/javascript">
  			$("li").first().css({"background":"green"})
  		</script>
  	</body>
  2.last()筛选器，与first筛选器对应只不过这个是找到最后一个的
  3.eq(index)筛选器，根据index找到对应的标签元素。
  <body>
  		<ul>
  			<li>1</li>
  			<li>2</li>
  			<li>3</li>
  			<li>4</li>
  			<li>5</li>
  			<li>6</li>
  			<li>7</li>
  			<li>8</li>
  			<li>9</li>
  			<li>10</li>
  		</ul>
  		<script type="text/javascript">
  			$("li").eq(2).css({"background":"green"})
  		</script>
  	</body>
  ```
* 3.6 jq中的事件，在jq中也对js中的事件进行了进一步的封装比如常见的鼠标事件，onclick封装成了click()方法，onchange封装成了change()方法，下面我们只演示一个点击选项让点击的选项设置样式并且清除其他的样式。显然我们要将我们点击的东西绑定上事件日汉化我们在触发点击的时候设置 this 的样式并且清除他的兄弟们 .siblings() 的样式。

  ```html
  <script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
  		<style>
  			.listyle{
  				color: aqua;
  				background-color: chocolate;
  			}
  		</style>
  	</head>
  	<body>
  		<ul>
  			<li>1</li>
  			<li>2</li>
  			<li>3</li>
  			<li class="listyle">4</li>
  			<li>5</li>
  			<li>6</li>
  			<li>7</li>
  			<li>8</li>
  			<li>9</li>
  			<li>10</li>
  			<li>11</li>
  			<li>12</li>
  			<li>13</li>
  			<li>14</li>
  			<li>15</li>
  		</ul>
  		<script>
  			$("li").click(function(){
  				$(this).addClass("listyle").siblings().removeClass("listyle");
  			});
  		</script>
  	</body>
  ```

4.综合案例，结合上面我们对jq中的内容进行了简单的介绍，但是这仅仅是jq的冰山一角想要学会jq还需要多多查看手册。我们在这通过两个综合的案例来进一步的加深对jq的理解

* 4.1 实现左右两栏的切换移动，有四个按钮这四个按钮分别可以实现左右两边选中移动，左右两边全部移动。具体见下代码

  ```html
  解读：由于我们没有写注释，再次对下面代码进行解读一波，我们要创建连个复选下拉框，默认内容都在左边，然后当我们选中并且点击移动的时候左边被选中的内容会移动到右边。这显然我们要为下面的四个按钮绑定点击事件，然后点击触发的时候会获取select下面的所有option标签并且通过筛选器 ：selected来进行判断当选中的时候就将左边的removeTo("#right")移动到右边，这样我们就实现类选中转移。而对应全部移动则只要去除：selected这个选择器就可以了。
  <!DOCTYPE html>
  <html>
  	<head>
  		<meta charset="utf-8">
  		<title></title>
  		<script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
  		<style type="text/css">
  			select{
  				width: 300px;
  				height: 300px;

  			}
  		</style>
  	</head>
  	<body>
  		<select multiple name="" id="left" >
  			<option value="">ss1</option>
  			<option value="">ss2</option>
  			<option value="">ss3</option>
  			<option value="">ss4</option>
  			<option value="">ss5</option>
  			<option value="">ss6</option>
  		</select>
  		<select multiple name="" id="right" >
  			<option value="">rr1</option>
  		</select>
  		<button>-></button>
  		<button>->></button>
  		<button><-</button>
  		<button><<-</button>
  		<script type="text/javascript">
  			$("button").eq(0).click(function(){
  				$("#left option:selected").appendTo("#right");
  			})
  			$("button").eq(1).click(function(){
  				$("#left option").appendTo("#right");
  			})
  			$("button").eq(2).click(function(){
  				$("#right option:selected").appendTo("#left");
  			})
  			$("button").eq(3).click(function(){
  				$("#right option").appendTo("#left");
  			})
  		</script>
  	</body>
  </html>
  ```
* 4.2 通过jq来改进之前写的购物车功能，需要改进的内容有 全选，全不选，反选，删除，添加这几个功能。
