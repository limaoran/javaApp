# MongoDB使用

## 一：MongoDB特点

* 社区活跃，文档丰富，有10gen商业支持，持续性有保障
* 所用语言：C++
* 特点：保留了SQL一些友好的特性（查询，索引）。
* 协议： Custom, binary（ BSON）
* Master/slave复制（支持自动错误恢复，使用 sets 复制）
* 内建分片机制
* 支持 javascript表达式查询
* 可在服务器端执行任意的 javascript函数
* 在数据存储时采用内存到文件映射
* 对性能的关注超过对功能的要求
* 在32位操作系统上，数据库大小限制在约2.5Gb。64位系统
*  数据库大小无限制
* 空数据库大约占 192Mb
* 采用 GridFS存储大数据或元数据



## 二：MongoDB安装配置

### MongoDB安装
官网http://www.mongodb.org/下载安装包


### MongoDB启动、关闭

* ./mongod -f  ../etc/mongo.conf(带配置文件启动) 或./mongod，服务器默认端口27017
* ./mongod --shutdown或./mongod -f ../etc/mongo.conf --shutdown
* 默认数据库目录在/data/db
* 自定义启动参数

本地mongoDB启动：
mongodb_start.bat
```sh
mongod.exe --dbpath G:\db\mongodb-data
```

### web控制台使用

配置文件rest=true，打开web控制台
默认端口28017
访问url: http://ip:28017

### 作业

* 学习mongodb安装配置
* 学习mongodb启动关闭、自定义参数
* 学习mongodb的web控制台使用

## 三：MongoDB shell详解

### shell使用及常用命令

* ./mongo --port 27017
* show dbs ----已有数据库列表
* show collections ---- 已有集合列表
* show users ----已有用户列表
* use dbname ---- 切换数据库，系统会自动延迟创建该数据库
* db.account.save({'name':'test','addr':'china'}) -- 创建集合
* db.account.find() -- 查看集合数据
* db.dropDatabase() -- 删除数据库

### MongoDB数据工具

* 数据库组件：mongod、mongos、mongo
* 数据库工具：
    * mongodump -h dbhost -d dbname -o dbdirectory -- 数据库备份
    * mongorestore -h dbhost -d dbname --directoryperdb dbdirectory -- 数据库恢复
    * ./bsondump dump/bbs/account.bson -- 查看bson对象
    * ./mongoexport -d bbs -c account -q {} -f name,addr --csv > account.csv   -- 数据导出工具，导出为csv格式
    * ./mongoexport -d bbs -c account -q {} -f name,addr  > account.json 导出为json格式
    * ./mongoexport -d bbs -c account -q '{"name":"test2"}' -f name,addr --csv > account.csv 带查询条件导出
    * ./mongoimport -d bbs -c account --type csv --headerline  --drop < account.csv  -- 数据导入工具,导入csv文件
    * ./mongoimport -d bbs -c account --type json  --drop < account.json	--导入json文件


### 作业

* 学习mongodb shell使用及常用命令
* 学习mongodb备份恢复命令
* 学习mongodb数据导入导出命令


## 四：MongoDB文档、集合、数据库的概念

* 文档是MongoDB中数据的基本单元，是MongoDB 的核心概念，很类似关系数据库中的行
* 集合可以被看作没有模式的表
* MongoDB每个实例都可容纳多个独立数据库，每个数据库都有自己的集合和权限


### 文档
* 多个键及其关联的值有序地放置在一起就是文档
* 单键值文档：{"userName" : "bbs11"}
* 多键值文档：{ "_id" : "76b606a9f9b770517ca4d98b", "userName" : "bbs59", "passwd" : "ddddddd", "acctAttr" : null }
* 文档中键/值对是有序的
* 文档中的值不仅可以是字符串，也可以是其它数据类型（或者嵌入其它文档），
* 键是字符串，键可以使用任意UTF-8字符。
* 键不能含有\0(空字符)，空字符表示键的结尾

* .和$做为保留字符，通常不应出现在键中
* 以下划线"_"开头的键通常情况下是保留的
* MongoDB不但区分数据类型，也区分大小写：
{"user" : "11"}与{"user" : 11}不同，{"User" : "11"}与{"user" : 11}
* 文档中不允许有重复的键。{"userName" : "bbs11"，"userName" : "david"}非法

### 集合

* 集合就是一组文档，与关系数据库的表可类比。
* 集合是无模式的。MongoDB对模式不做强制要求，由开发者灵活把握。

命令规则：

1. 集合名不能是空串"";
2. 不能含有空字符\0;
3. 不能以"system."开头，这是系统集合保留的前缀
4. 集合名不能含保留字符$
5. 组织集合的一种惯例是以.分开，近命名空间划分子集合，例如system.users,system.indexes

### 数据库

* 多个集合组成数据库
* 一个MongoDB实例可承载多个数据库，互相之间彼此独立
* 开发中通常将一个应用的所有数据存放到同一个数据库中
* 磁盘上，MongoDB将不同数据库存放在不同文件中

命令规则：

1. 数据库名是UTF-8字符串，最长64个字符
2. 不能是空字符串“”
3. 不能含''、.、$、/、\和\0
4. 应全部小写

系统保留数据库

1. admin: 这是root数据库，添加用户到该数据库中，该用户会自动继承所有数据库权限
2. local:这个数据库中的数据永远不会被复制，可以用于存储限于本地数据单台服务器的任意集合
3. config:分片时，config数据库在内部使用，保存分片信息

把数据库名放集合名前，得到的就是集合的完全限定名称，叫命令空间。命令空间长度不能超过121字节，实际使用时应小于100字节。

## 五：MongoDB的数据类型

### 基础数据类型

| 数据类型 | 描述 | 举例 |
| --- | --- | --- |
| null | 表示空值或者未定义的对象 | {“x”:null} |
| 布尔值 | 真或者假：true或者false | {“x”:true} |
| 32位整数 | 32位整数。shell是不支持该类型的，shell中默认会转换成64位浮点数 |
| 64位整数 | 64位整数。shell是不支持该类型的，shell中默认会转换成64位浮点数 |
| 64位浮点数 | 64位浮点数。shell中的数字就是这一种类型 | {“x”：3.14，“y”：3} |
| 字符串 | UTF-8字符串 | {“foo”:“bar”} |
| 符号 | shell不支持，shell会将数据库中的符号类型的数据自动转换成字符串 |
| 对象id | 文档的12字节的唯一id | {“id”: ObjectId()} |
| 日期 | 从标准纪元开始的毫秒数 | {“date”:new Date()} |
| 正则表达式 | 文档中可以包含正则表达式，遵循JavaScript的语法 | {“foo”:/foobar/i} |
| 代码	文档中可以包含JavaScript代码 | {“x”：function() {}} |
| 二进制数据 | 任意字节的二进制串组成，shell不支持 |
| 最大值 | BSON包括一个特殊类型，表示可能的最大值，shell不支持 |
| 最小值 | BSON包括一个特殊类型，表示可能的最小值，shell不支持 |
| 未定义 | undefined | {“x”：undefined} |
| 数组 | 值的集合或者列表 | {“arr”: [“a”,“b”]} |
| 内嵌文档 | 文档可以作为文档中某个key的value | {“x”:{“foo”:“bar”}} |

### ObjectID

![ObjectID](file:/E:/OneDrive/image/mongodb-ObjectID.png)
* 对象id类型是一个12字节的唯一id。每个字节2位16进制数，因此整个id类型是一个24位的字符串
* 前面四个字节代表从标准纪元开始的时间戳，以秒为单位
* 接下来三个字节表示机器号，一般是机器名的hash值。这可以保证不同机器产生的id不会冲突
* 接下来两个字节表示进程id号，保证统一机器不同建成产生的id不冲突
* 最后三个是计数器的计数值，对于任意一秒钟，可以产生2^24个数

## 六：MongoDB增、删、改文档

### 文档插入

* 单个文档插入:
```sh
db.account.insert({"userName" : "bbs10000001", "passwd" : "ddddddd", "acctAttr" : null })
```
* 批量插入，受MongoDB消息大小影响，最大消息16M
* 插入原理，驱动将文档转为bson,检查是否有_id键，传入数据库，数据库解析bson,不做有效性校验，原样存入数据库中。
* 文档大小不能超过4M

### 文档删除

* 删除文档中所有数据：db.account.remove(),不删除索引
* 条件删除：db.account.remove({"userName":"bbs1100"})
* 删除整个集合：db.account.drop()。数据、索引一起删除，性能好

### 文档更新

* 更新命令：
```sh
db.account.update({"userName":"bbs10"},{ "_id" : "3e1fd26f4b0f8351760fcc54", "userName" : "bbs10", "passwd" : "fff", "acctAttr" : null })
```
* $set用法，使用修改器进行局部更改：
```sh
db.account.update({"_id" : "3e1fd26f4b0f8351760fcc54"},{ "$set":{"passwd":"d"}})
```
* 去掉一个键：
```sh
db.account.update({"userName":"bbs10"},{ "$unset":{"passwd":1}})
```
* $inc用法：
```sh
db.account.update({"userName":"bbs10"},{ "$inc":{"age":30}})
```

* 加1：
```sh
db.account.update({"userName":"bbs10"},{ "$inc":{"age":1}})
```
* 减1：
```sh
db.account.update({"userName":"bbs10"},{ "$inc":{"age":-1}})
```
* $inc的键值必须为数值。
* 数组修改器$push。
```sh
db.account.update({"userName":"bbs10"},{$push:{"email":"1@163.com"}})
```
* $addToSet避免重复加入：
```sh
db.account.update({"userName":"bbs10"}},{$addToSet:{"email":"4@163.com"}})
```
* pop修改器，从数组尾删除一个元素：
```sh
db.account.update({"userName":"bbs10"},{$pop:{"email":1}})
```
* 从数组头删除一个元素：
```sh
db.account.update({"userName":"bbs10"},{$pop:{"email":-1}})
```
* 指定位置删除删除元素：
```sh
db.account.update({"userName":"bbs10"},{$pull:{"email":"2@163.com"}})
```
* 多文档更新：
```sh
db.account.update({"userName":"bbs10"},{$set:{"passwd":"a"}},false,true)
```
* 看执行结果，有多少文档被更新：
```sh
db.runCommand({getLastError:1})
```
* 执行getLastError时，驱动程序会等待数据库返回结果

## MongoDB问题解决

出现列String不能转换为Date
```mongodb
db.getCollection('Monitor_Website').find({"ICPTime":{$type:2}}).forEach(
    function(x){
    x.ICPTime=new Date();
    db.getCollection('Monitor_Website').save(x);
    }
);
````

## MongoDB用户管理

创建用户
```sh
db.createUser(
  {
    user: "root",
    pwd: "123456",
    roles: [
       { role: "read", db: "ytdb" },
       { role: "readWrite", db: "ytdb" }
    ]
  }
)
```


## 数据库优化

* 对于排序的字段，请加入索引
现在根据y字段倒序显示：db.user.find().sort({y: -1});，为了提高性能那么需要在字段y上加入索引
db.user.ensureIndex({y:1});这样一来，就可以根据索引排序，而不是直接查绚集合中的所有文档。
* 限制最大记录数：db.user.find().limit(10);
* 只查询所需要的键，而不是所有全查出来：db.user.find({}, {y: 1});
* 统计记录条数利用count()方法：db.user.find().count();
* 强制使用指定索引：db.user.find().hint({y: 1});



## 高级查询

### 利用索引提高查询速度
首先我们在x字段上建立索引：db.user.ensuerIndex({x : 1});

然后再查询：db.user.find({x:8}, {_id: 0, x: 1}).explain(); 会有如下输出：
```json
    {
            "cursor" : "BtreeCursor x_1",
            "nscanned" : 19,
            "nscannedObjects" : 19,
            "n" : 19,
            "millis" : 0,
            "nYields" : 0,
            "nChunkSkips" : 0,
            "isMultiKey" : false,
            "indexOnly" : true
          //  ……………………….
    }
```
其中"indexOnly" : true代表着此次查询启用了索引。
一般的查询不会利用索引，除非满足以下条件，

1. 必须列出要返回的字段名，这样才能决定是否需要启用索引
2. 必须显示的指出不显示_id字段{ _id : 0}

### 利用“.”（点号）进行对象间的导航
```sh
db.user.find({}, {“x.y” : 1});
```

### 查询指定范围的值
```sh
db.user.find({y: {$gt : 4, $lt : 10}}); // 4 < y < 10
```

### 匹配所有$all
```sh
db.things.find( { a: { $all: [ 2, 3 ] } } );
```

### 存在性判断$exists：
```sh
db.things.find( { a : { $exists : true } } ); // 如果存在则返回
db.things.find( { a : { $exists : false } } ); // 如果不存在则返回
```

### 求余$mod
```sh
db.things.find( "this.a % 10 == 1")
```
也可写成如下形式：
```sh
db.things.find( { a : { $mod : [ 10 , 1 ] } } )
```

### 不等于$ne
```sh
db.things.find( { x : { $ne : 3 } } );
```

### IN子句$in
```sh
db.things.find({j:{$in: [2,4,6]}});
```

### Not In子句$nin
```sh
db.things.find({j:{$nin: [2,4,6]}});
```

### OR条件$or
```sh
db.foo.find( { $or : [ { a : 1 } , { b : 2 } ] } )
```

### 利用正则表达式进行复杂匹配

```sh
db.customers.find( { name : /acme.*corp/i } );
db.customers.find( { name : { $regex : "acme.*corp", $options: "i" } } );
db.customers.find( { name : { $regex : /acme.*corp/i, $nin : ["acmeblahcorp"] } } );
```
i表示大小写不敏感

### 取反操作$not
```sh
db.customers.find( { name : { $not : /acme.*corp/i } } );
```

### 统计文档数：
```sh
nstudents = db.students.find({"address.state" : "CA"}).count();
```
不要这样做，这样会导致客户端排序，增加网络传输
```sh
nstudents = db.students.find({"address.state" : "CA"}).toArray().length; // VERY BAD
```


### 分页查询
```sh
db.students.find().skip(20).limit(10).count(true);
```

### 排序sort()
```sh
db.myCollection.find().sort( { ts : -1 } ); // 按TS降序排列
```

