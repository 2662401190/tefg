package com.tefg.common;


import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

/**
 * @author 贺威
 * @create 2018-11-01 18:55
 */
public class TokenCache {

    public static final String TOKEN_PREFIX="token_";
    //日志
    private static Logger logger = LoggerFactory.getLogger(TokenCache.class);

    //本地缓存 LRU算法                                                                        初始化容量                最大容量                           有效期 12个小时
    private static LoadingCache<String,String> LocalCache= CacheBuilder.newBuilder().initialCapacity(1000).maximumSize(10000).expireAfterAccess(12, TimeUnit.HOURS )
            .build(new CacheLoader<String, String>() {
                //默认的数据加载实现，当调用get取值的时候，如果key没有对应的值，就调用这个方法加载
                @Override
                public String load(String s) throws Exception {
                    return "null";
                }
            });

        public  static  void setKey(String key ,String value){
            LocalCache.put(key, value);
        }

        public static String  getKey(String key){
             String value=null;
             try {
                    value=LocalCache.get(key);
                    if ("null".equals(value)){
                        return null;
                    }
                    return value;
             }catch (Exception e){
                logger.error("LocalCache get  error",e );
             }
             return null;
        }



}
