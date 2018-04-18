package cn.com.dom4j.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Demo1 {

    public static void main(String[] args) {

//        f1();
//        f2();

//        f3();
        f4();

    }

    private static void f4() {

        Jedis jedis = new Jedis("118.89.50.50", 6379);

        // 存储 hash (String key & String value 的 map 容器)

        // 赋值: hset hmset
        // 取值: hget hmget hgetall
        // 删除: hdel   [del 会将整个 hash删除掉]
        // 增加/减少: hincrby
        // 判断存在: hexists
        // 获取属性数目: hlen
        // 获取所有的 key: hekys


        String myHash = "myHash";

        // 1. 赋值
        jedis.hset(myHash, "name", "jack");
        jedis.hset(myHash, "age", "16");

        Map<String, String> map = new HashMap<String, String>();
        map.put("password", "123456");
        jedis.hmset(myHash, map);


        // 2. 取值
        String value = jedis.hget(myHash, "name");
        System.out.println(value);

        List<String> values = jedis.hmget(myHash, "name", "age", "password");
        System.out.println(values);

        map = jedis.hgetAll(myHash);
        System.out.println(map);

        // 3. 删除
        jedis.hdel(myHash, "name", "password");
        System.out.println(jedis.hgetAll(myHash));

        // 4. 增加 / 减少
        jedis.hincrBy(myHash, "age", 15);
        System.out.println(jedis.hgetAll(myHash));

        jedis.hincrBy(myHash, "age", -3);
        System.out.println(jedis.hgetAll(myHash));

        // 5. 判断存在
        Boolean exists = jedis.hexists(myHash, "name");
        System.out.println(exists);

        // 6. 判断属性个数
        Long hlen = jedis.hlen(myHash);
        System.out.println(hlen);

        // 7. 拿到 hash的所有 key
        Set<String> hkeys = jedis.hkeys(myHash);
        System.out.println(hkeys);


        jedis.close();


    }

    private static void f3() {

        Jedis jedis = new Jedis("118.89.50.50", 6379);

        // Redis数据结构有以下几种
        // 1. 字符串 (string)
        // 2. 字符串列表 (list)
        // 3. 有序字符串集合 (sorted set)
        // 4. 哈希 (hash)
        // 5. 字符串集合 (set)


        // 存储字符串,  最多存储 512M长度的字符串
        jedis.set("company", "imooc");
        String value = jedis.get("company");
        System.out.println(value);

        value = jedis.getSet("company", "baidu");
        System.out.println(value);

        // 删除某个键值对
        jedis.del("company");

        // 将某个 key对应的 value自增
        jedis.incr("num");

        // 将某个 key对应的 value自减
        jedis.decr("num");

        // 将某个 key对应的 value增加 n
        jedis.incrBy("num", 10);

        jedis.decrBy("num", 3);


        jedis.append("num", " hello");



        jedis.close();




    }

    private static void f2() {

        // 获得连接池配置对象
        JedisPoolConfig config = new JedisPoolConfig();

        // 设置最大连接数
        config.setMaxTotal(30);
        // 设置最大空闲连接数
        config.setMaxIdle(10);

        // 获得连接池
        JedisPool jedisPool = new JedisPool(config, "118.89.50.50", 6379);

        // 获得核心对象
        Jedis jedis = null;
        try {
            // 通过连接池获得连接
            jedis = jedisPool.getResource();

            jedis.set("name", "张三");
            String value = jedis.get("name");
            System.out.println(value);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }



    }

    private static void f1() {

        Jedis jedis = new Jedis("118.89.50.50", 6379);

        jedis.set("name", "imooc");

        String value = jedis.get("name");
        System.out.println(value);

        jedis.close();
    }


}
