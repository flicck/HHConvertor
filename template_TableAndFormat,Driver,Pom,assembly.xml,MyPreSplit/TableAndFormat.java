package com.myCustomizePath;

public class TableAndFormat {
	/**  0、配置是hiveOrc转hbase还是hbase转hiveOrc 
	 *    mode=HiveHBase---》hiveOrc转hbase
	 *    mode=HBaseHive---》》hbase转hiveOrc
	 */
	public static String mode="HiveHBase";   													//mode设置
	
	/**  1、两个模式都要配置的通用配置===================================================================================
	 */
	
	/**（1）输入您的hbase表名-->如果mode为HiveHBase,则您的Hbase表已经存在时将被删除并重新创建。	
	 * 					   -->如果mode为HBaseHive,则您的表必须已经存在（一张有结构有数据的表）
	 *    				   -->如果您使用了命名空间，则命名空间必须已经存在
	 * 					   -->如果您未填写命名空间，则会在default下建表
	 */
	public static String hBaseTable="myns1:users";	 											//两个mode都需要设置、
	/**（2）输入您的hive表名,:前是数据库名称，:后是表名 
	 * 
	 */
	public static String hiveTable="wanghan15:t_userorc";										//两个mode都需要设置
	/**（3）beeline的hiveServer2的连接地址,用于jdbc连接hive
	 */
	public static String hiveLocation="192.168.134.20:10000";									//两个mode都需要设置		
	/**（4) zookeeper的连接地址，用于连接HMaster
	 */
	public static String zkLocation="nn1.hadoop:2181,nn2.hadoop:2181,s1.hadoop:2181";  			//两个mode都需要设置		
	/** (5) 指定列族名称，只支持所有的列都在一个列族
	 */
	public static String columnFamily="cf1";													//两个mode都需要设置
	/** (6) 指定taskId
	 */
	public static String taskId="wang";															//两个mode都需要设置
	 
	/**  2、HiveHBase的mode需要配置的==================================================================================
	 */
	/**（1） 指定hdfs上的临时目录，这个临时目录是hive输出orc文件的临时目录，在mode为HiveHBase时生效
	 */
	public static String outputPath="/user/wanghan15/output1/";									//HiveHBase需要设置
	/**（2）预分region的设置
	 * 选项有hash(哈希分配)和uniform(uniform分配)和customize(自定义),如果为自定义需要新建一个split jar包
	 */
	public static String devisionRegionMethod="hash";											//HiveHBase需要设置
		/**（2.1） 设置region的数量,在devisionRegionMethod为hash和uniform的时候生效
		 */
		public static int numOfRegions=12;														//HiveHBase需要设置
		/**（2.2） 设置预分region的rowkey，如果为default,那么会为您生成一个不会重复的随机rowkey
		 * 		    除了default，还可以设置某一个字段或者某几个字段拼接作为rowkey,不同的字段用_分隔
		 * 		  default: public static String rowkey="default";
		 * 		  customize:public static String rowkey="userid_ip_zipcode";	
		 * 		    如果ifRowkeyRandom为true的状态，程序会为您在您自定义的rowkey后方增加一个不会重复的随机数
		 * 		  ifRowkeyRandom在您的rowkey不为default的时候生效
		 */		
		public static String rowkey="default";	    											//HiveHBase需要设置
		public static boolean ifRowkeyRandom=true;           									//HiveHBase需要设置		
		/**（2.3）ifDeleteColumnsFromHBase设置为true，将会把您作为rowkey的字段从HBase的Hfile中删除，这样避免数据的亘余
		 * 		   如果为false则不会
		 */
		public static boolean ifDeleteColumnsFromHBase=true;									//HiveHBase需要设置
		
	/**  3、HBaseHive的mode需要配置的==================================================================================
	*/
		/** 
		 * ==》如果mode为HBaseHive，则您的Hive表无需存在(存在将被删除),程序会根据您传入的结构和路径自动创建orc格式的hive表
		 * ==》如果mode为HBaseHive，则您需要修改hiveTableStruct值的default为您指定的格式,请用json填写,
		 *     数据类型支持所有hive数据类型，填写数据类型的时候请一律小写
		 *     如果您传入的类型中有timestamp格式，请将其的类型设置为'timestamp_'后加上时间的格式
		 *     如'timestamp_yyyy-MM-dd HH:mm:ss'，hive只支持秒级别的时间戳，所以即使您指定了毫秒级别的时间类型，毫秒精度
		 *     也将被舍去。
		 * ==》如果mode为HBaseHive，则您需要填写hiveTableLocation，数据将放入您指定的hdfs目录
		 * ==》如果mode为HBaseHive，则您需要填写hiveTableType，设置创建的表是内部表Internal还是外部表external			 
		 */	
		public static String hiveTableStruct="{'occupation':'string','sex':'string','age':'int'}";	//HBaseHive需要设置
		public static String hiveTableLocation="hdfs://ns1/user/su/task/hde_su";					//HBaseHive需要设置
		public static String hiveTableType="external";												//HBaseHive需要设置
	
}
