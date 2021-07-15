package test.redisCache;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.exceptions.JedisException;

import java.util.*;

@Slf4j
@Component
public class RedisCacheImpl {

	@Autowired
	private JedisPool jedisPool;

	public Jedis getResource() {
		return jedisPool.getResource();
	}

	@Autowired
	private RedisTemplate redisTemplate;


	public void set(byte[] key, byte[] value) {
		Jedis jedis = this.getResource();
		try {
			jedis.set(key, value);
		} catch (Exception e) {
			throw new JedisException(e);
		} finally {
			jedis.close();
		}
	}

	
	public byte[] get(byte[] key) {
		Jedis jedis = this.getResource();
		try {
			return jedis.get(key);
		} catch (Exception e) {
			throw new JedisException(e);
		} finally {
			jedis.close();
		}
	}

	
	public Long getIncr(String key) {
		Jedis jedis = this.getResource();
		try {
			return jedis.incr(key);
		} catch (Exception e) {
			throw new JedisException(e);
		} finally {
			jedis.close();
		}
	}

	
	public Long getIncrby(String key, Long value) {
		Jedis jedis = this.getResource();
		try {
			return jedis.incrBy(key, value);
		} catch (Exception e) {
			throw new JedisException(e);
		} finally {
			jedis.close();
		}
	}

	
	public void delete(String key) {
		key = wrapperKey(key);
		this.delete(key.getBytes());
	}

	public boolean contain(String key) {
		key = wrapperKey(key);
		return this.contain(key.getBytes());
	}

	public boolean contain(byte[] key) {
		Jedis jedis = this.getResource();
		try {
			return jedis.exists(key);
		} catch (Exception e) {
			throw new JedisException(e);
		} finally {
			jedis.close();
		}

	}

	
	public void delete(byte[] key) {
		Jedis jedis = this.getResource();
		try {
			jedis.del(key);
		} catch (Exception e) {
			throw new JedisException(e);
		} finally {
			jedis.close();
		}

	}

	
	public void setnx(byte[] key, byte[] value) {
		Jedis jedis = this.getResource();
		try {
			jedis.setnx(key, value);
		} catch (Exception e) {
			throw new JedisException(e);
		} finally {
			jedis.close();
		}
	}

	
	public Long zcount(String key, double start, double end) {
		key = wrapperKey(key);
		Jedis jedis = this.getResource();
		try {
			Long num = jedis.zcount(key.getBytes(), start, end);
			return num;
		} catch (Exception e) {
			throw new JedisException(e);
		} finally {
			jedis.close();
		}
	}

	public void hset(String key, String field, String value) {
		key = wrapperKey(key);
		Jedis jedis = this.getResource();
		try {
			if (value != null)
				jedis.hset(key, field, value);
		} catch (Exception e) {
			throw new JedisException(e);
		} finally {
			jedis.close();
		}
	}

	public void hmset(String key, Map map) {
		key = wrapperKey(key);
		Jedis jedis = this.getResource();
		try {
			if (map != null)
				jedis.hmset(key, map);
		} catch (Exception e) {
			throw new JedisException(e);
		} finally {
			jedis.close();
		}
	}

	public String hget(String key, String field) {
		key = wrapperKey(key);
		Jedis jedis = this.getResource();
		try {
			return jedis.hget(key, field);
		} catch (Exception e) {
			throw new JedisException(e);
		} finally {
			jedis.close();
		}
	}

	
	public void hdel(String key, String field) {
		key = wrapperKey(key);
		Jedis jedis = this.getResource();
		try {
			jedis.hdel(key, field);
		} catch (Exception e) {
			throw new JedisException(e);
		} finally {
			jedis.close();
		}
	}

	
	public Map hgetAll(String key) {
		key = wrapperKey(key);
		Jedis jedis = this.getResource();
		try {
			return jedis.hgetAll(key);
		} catch (Exception e) {
			throw new JedisException(e);
		} finally {
			jedis.close();
		}
	}

	
	public Set keys(String key) {
		key = wrapperKey(key);
		Jedis jedis = this.getResource();
		try {
			return jedis.keys(key);
		} catch (Exception e) {
			throw new JedisException(e);
		} finally {
			jedis.close();
		}

	}

	
	public void sadd(String key, String... member) {
		key = wrapperKey(key);
		Jedis jedis = this.getResource();
		try {
			jedis.sadd(key, member);
		} catch (Exception e) {
			throw new JedisException(e);
		} finally {
			jedis.close();
		}
	}

	
	public Set smembers(String key) {
		key = wrapperKey(key);
		Jedis jedis = this.getResource();
		Set s = null;
		try {
			s = jedis.smembers(key);
		} catch (Exception e) {
			throw new JedisException(e);
		} finally {
			jedis.close();
		}
		return s;
	}

	
	public void srem(String key, String... member) {
		key = wrapperKey(key);
		Jedis jedis = this.getResource();
		try {
			jedis.srem(key, member);
		} catch (Exception e) {
			throw new JedisException(e);
		} finally {
			jedis.close();
		}
	}

	
	public long scount(String key) {
		key = wrapperKey(key);
		Jedis jedis = this.getResource();
		try {
			return jedis.scard(key);
		} catch (Exception e) {
			throw new JedisException(e);
		} finally {
			jedis.close();
		}
	}

	
	public boolean sismember(String key, String member) {
		key = wrapperKey(key);
		Jedis jedis = this.getResource();
		try {
			return jedis.sismember(key, member);
		} catch (Exception e) {
			throw new JedisException(e);
		} finally {
			jedis.close();
		}
	}

	public void delete(String... keys) {
		keys = wrapperKey(keys);
		Jedis jedis = this.getResource();
		try {
			jedis.del(keys);
		} catch (Exception e) {
			throw new JedisException(e);
		} finally {
			jedis.close();
		}
	}

	
	public String typeKey(String key) {
		key = wrapperKey(key);
		Jedis jedis = this.getResource();
		try {
			String keyType = jedis.type(key);
			return keyType;
		} catch (Exception e) {
			throw new JedisException(e);
		} finally {
			jedis.close();
		}
	}

	private String wrapperKey(String key) {
		return key;
	}

	private String[] wrapperKey(String... key) {
		return key;
	}

	
	public String get(String key) {
		Jedis jedis = this.getResource();
		try {
			return jedis.get(key);
		} catch (Exception e) {
			throw new JedisException(e);
		} finally {
			jedis.close();
		}
	}

    
    public void newSet(String key, String value) {
        Jedis jedis = this.getResource();
        try {
        	jedis.set(key,value);
        } catch (Exception e) {
            throw new JedisException(e);
        } finally {
            jedis.close();
        }
    }

	/**
	 * 设置缓存
	 *
	 * @param key          键
	 * @param cacheSeconds 超时时间，0为不超时
	 */
	
	public Long setExpire(String key, int cacheSeconds) {
		Jedis jedis = null;
		try {
			jedis = getResource();
			if (cacheSeconds != 0) {
				return jedis.expire(key, cacheSeconds);
			}
			return null;
		} catch (Exception e) {
			throw new JedisException(e);
		} finally {
			jedis.close();
		}
	}
}
