package com.corssover;

import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.util.StringUtils;

import com.google.code.ssm.Cache;
import com.google.code.ssm.CacheFactory;
import com.google.code.ssm.config.DefaultAddressProvider;
import com.google.code.ssm.providers.xmemcached.MemcacheClientFactoryImpl;
import com.google.code.ssm.providers.xmemcached.XMemcachedConfiguration;
import com.google.code.ssm.spring.SSMCache;
import com.google.code.ssm.spring.SSMCacheManager;

import net.rubyeye.xmemcached.auth.AuthInfo;

@Configuration
@EnableAutoConfiguration
@EntityScan(basePackages = { "com.corssover.domain" })
@EnableJpaRepositories(basePackages = { "com.corssover.repositories" })

@ComponentScan(basePackages = { "com.corssover" })
@EnableTransactionManagement

@PropertySource(value = { "classpath:/application.properties" })

@EnableConfigurationProperties
public class BeanConfiguration extends CachingConfigurerSupport {

	private static final String USERNAME = "";// System.getenv("MEMCACHIER_USERNAME");
	private static final String PASSWORD = ""; // System.getenv("MEMCACHIER_PASSWORD");
	
	@Value("${memcached.host}")
	private String SERVER ;//= "127.0.0.1:11211"; System.getenv("MEMCACHIER_SERVERS");

	@Autowired
	private Environment environment;

//	@Bean
//	@Override
//	public CacheManager cacheManager() {
//		Set<SSMCache> ssmCacheSet = new HashSet<>();
//		SSMCache ssmCache = new SSMCache((com.google.code.ssm.Cache) defaultCache(), 300, false);
//
//		ssmCacheSet.add(ssmCache);
//
//		SSMCacheManager ssmCacheManager = new SSMCacheManager();
//		ssmCacheManager.setCaches(ssmCacheSet);
//		return ssmCacheManager;
//	}
//
//	@Bean
//	public CacheFactory cacheFactory() {
//		CacheFactory cacheFactory = new CacheFactory();
//		cacheFactory.setCacheName("defaultCache");
//		cacheFactory.setCacheClientFactory(new MemcacheClientFactoryImpl());
//
//		String server = SERVER;
//		if (StringUtils.isEmpty(server)) {
//			server = environment.getProperty("cache.server");
//		}
//
//		XMemcachedConfiguration cacheConfiguration = createCacheConfiguration(server);
//		cacheFactory.setAddressProvider(new DefaultAddressProvider(server));
//		cacheFactory.setConfiguration(cacheConfiguration);
//
//		return cacheFactory;
//	}
//
//	// @Bean
//	public Cache defaultCache() {
//		try {
//			return cacheFactory().getCache();
//		} catch (Exception e) {
//			throw new RuntimeException(e);
//		}
//	}
//
//	private XMemcachedConfiguration createCacheConfiguration(final String server) {
//		XMemcachedConfiguration cacheConfiguration = new XMemcachedConfiguration();
//		cacheConfiguration.setConsistentHashing(true);
//		cacheConfiguration.setUseBinaryProtocol(true);
//
//		// Authentication only applicable on Heroku cloud platform
//		if (!StringUtils.isEmpty(USERNAME) && !StringUtils.isEmpty(PASSWORD)) {
//			Map<InetSocketAddress, AuthInfo> authInfoMap = new HashMap<InetSocketAddress, AuthInfo>();
//			authInfoMap.put(getInetSocketAddress(server), AuthInfo.plain(USERNAME, PASSWORD));
//			cacheConfiguration.setAuthInfoMap(authInfoMap);
//		}
//
//		return cacheConfiguration;
//	}
//
//	private InetSocketAddress getInetSocketAddress(final String server) {
//		String[] split = server.split("\\.");
//		String hostName = split[0];
//		int port = Integer.parseInt(split[1]);
//		InetSocketAddress inetSocketAddress = new InetSocketAddress(hostName, port);
//		return inetSocketAddress;
//	}

}
