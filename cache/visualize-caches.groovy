ehCacheBeanManagerName = "outizEhCacheManager";

cacheManager = spring.getBean(ehCacheBeanManagerName)

cacheManager.getCacheNames().each  {cacheName ->
 // i don't want to display the native caches
 if( cacheName != "entityCacheRegion" && cacheName != "queryCacheRegion" ) {
   println cacheName
   cache = cacheManager.getCache(cacheName).getNativeCache()
   cache.getKeys().each {key ->
     println cache.get(key)
   }
 }
}
