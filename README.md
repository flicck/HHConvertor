# HHConvertor  
java jdk>=1.8  
HHConvertor is a universal jar package for conversion between Hive ORC table and  HBase table.  
HHConvertor instructions for use can be viewed or downloaded online at http://www.techvision.top/HHConvertor.html  
  
HHConvertor是在HadoopLink基础上设计的具有一键互转Hive的ORC文件格式表格和HBase表格功能的通用jar包。  
HHConvertor的使用说明文档请在http://www.techvision.top/HHConvertor.html 在线查看或下载  
  
HHConvertor有以下优势：  
1  从表直接到表：执行完毕可直接到Hive或HBase的shell下找到指定的表格，查询数据。  
2  丰富的自定义功能：您可以设置预分region的设置是hash、
uniform还是customize（自定义）；您可以指定表中的一个字段或多个字段作为HBase表格的rowkey；您可以选择是否在rowkey后增加全局不重复的随机序列；您可以决定是否删除您作为rowkey的字段以节省硬盘空间，避免数据冗余。
