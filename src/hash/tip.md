### 处理大数据量问题 
遇到在一定内存中处理很大数据的时候，可以使用hash将原数据转换（初筛分离数据），再模一个数使之范围缩小，再在每个范围将原数据进行处理，获得范围内
所需要的值，再将所有范围获得所需要的值进行比较，得到最终需要的值。

### 布隆过滤器
解决黑名单系统，爬虫去重问题等。
构建布隆过滤器定义一场长m的位图，将URL使用k个hash函数进行hash（相当于采集指纹），在模上m，得到一个格子，将这个格子涂上，最终得到k个黑色格子。
将黑色格子填到bitMap中。
查询：将URL使用将URL使用k个hash函数进行hash，在模上m，最终如果查询全部都是黑色格子，则证明是黑名单URL。
m大小与样本量和失误率有关，有公式。
k大小与m和样本量有关，向上取整。

### 一致性hash
