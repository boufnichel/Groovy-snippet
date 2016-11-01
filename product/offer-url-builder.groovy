resolver = spring.getBean("outizDefaultProductModelUrlResolver")
fss = spring.getBean("flexibleSearchService")
rst = fss.search("Select {pk} from {offer as o join catalogversion as cv on {o.catalogversion}={cv.pk}} where {cv.version}='Online'").getResult()
rst.each {
 
  url = resolver.resolve(it)
  println url
}

