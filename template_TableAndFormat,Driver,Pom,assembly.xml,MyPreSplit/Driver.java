package com.myCustomizePath;


import org.apache.hadoop.util.ProgramDriver;

import cn.runner.Runner;


public class Driver {
	public static void main(String[] args) throws Throwable {
		int exitCode=-1;
		ProgramDriver driver=new ProgramDriver();
		//默认短命令为HadoopLink
		try {
			driver.addClass("HHConvertor", Runner.class, "HHConvertor");
			exitCode=driver.run(args);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.exit(exitCode);
	}
}
