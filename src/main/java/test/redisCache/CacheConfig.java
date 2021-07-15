package test.redisCache;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachingConfigurerSupport;

@org.springframework.cache.annotation.CacheConfig
public class CacheConfig extends CachingConfigurerSupport {

    @Autowired
    RedisCacheImpl redisCacheImpl;



}
