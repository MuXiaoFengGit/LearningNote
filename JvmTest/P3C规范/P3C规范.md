# 问题记录

### 1、版本控制工具中的标签是什么？
[TOC]


# OOP规约

- 通过类名来访问静态变量或方法

- 所有覆写方法，必须加@Override注解

- 推荐使用Objects.equal();

- 非基本数据类型对象比较，必须使用equal()

- POJO类属性使用包装类，方法返回值和参数使用包装类，局部变量使用基本类型 

- POJO属性不设定默认值，必须有toString()

- 构造方法禁止加入业务逻辑，需使用init方法

- String.split 方法需检查分隔符后是否有内容，不然容易越界

  # 集合相关

  

- 重写equal必须重写hashCode

- List转数组，必须使用集合的toArray(T[] array),传入类型大小完全一样的数组，数组转List，数组.asList后不能使用add remove  clear 方法，

- subList产生的list是原list的引用，修改会引起原list内容改动

- 关于<? extends T>,适用于频繁往外读取（get），不使用add

  <? super T>,适用于频繁写入（set），不使用get

  ``

  //泛型是主观的，返回值不可控

  List<Integer> ll = get();

  public List get(){

   return new ArrayList<String>();

  }

​       ``

- foreach 中使用Iterator.remove ，不能使用List.remove
-  集合、HashMap初始化时需定义初始大小，负载因子，防止扩容、r重建hash表等。
- Map类的遍历使用entrySet同时获取key-value，keySet其实是遍历了两次，效率更低。



# 异常

- 运行时异常（RuntimeException 如：NPE）不应被catch，应主动处理。
- 异常不应用来做流程控制、条件控制，比条件判断效率低很多。也就是不能说把catch当if用。
- catch到的异常应尽可能区分异常类型，作对应的异常处理，不能不做处理。
- 除了return this的方法，不建议使用级联调用。
- 内部调用方法，应采用抛异常方式提示错误，给外部调用方法应使用Result方式
- 抽取代码公共部分作为单独方法。

