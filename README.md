# wechat_test
######1.使用@RequestBody注解
application/x-www-form-urlencoded， 可选（即非必须，因为这种情况的数据@RequestParam, @ModelAttribute也可以处理，当然@RequestBody也能处理）； 
multipart/form-data, 不能处理（即使用@RequestBody不能处理这种格式的数据）；  其他格式， 必须（其他格式包括application/json, application/xml等。这些格式的数据，必须使用@RequestBody来处理）；

######2.使用@Data注解
Lombok是一个通过注解以达到减少代码的Java库,如通过注解的方式减少get,set方法,构造方法等。

