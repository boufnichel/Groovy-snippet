ehCacheBeanManagerName = "outizEhCacheManager";

cacheManager = spring.getBean(ehCacheBeanManagerName)

cacheManager.getCacheNames().each  {cacheName ->
 
  println cacheName
  cache = cacheManager.getCache(cacheName).getNativeCache()
  cache.getKeys().each {key ->
    println cache.get(key)
  }
}