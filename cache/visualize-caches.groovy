ehCacheBeanManagerName = "outizEhCacheManager";

cacheManager = spring.getBean(ehCacheBeanManagerName)

cacheManager.getCacheNames().each  {cacheName ->
 // i don't want to display the native caches
 if( cacheName != "entityCacheRegion" && cacheName != "queryCacheRegion" ) {
   println "--> cache = " + cacheName
   cache = cacheManager.getCache(cacheName)
   if(cache.getKeys() != null && cache.getKeys().size() > 0) {
     println "---> entries :"
     cache.getKeys().each {key ->
      println "---->" + cache.get(key)
     }
   } else {
     println "---> cache empty !"
   }
  
 }
}
