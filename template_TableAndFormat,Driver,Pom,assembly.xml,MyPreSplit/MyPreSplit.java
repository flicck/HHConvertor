package cn.preSplit;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.apache.hadoop.hbase.util.RegionSplitter.SplitAlgorithm;


public class MyPreSplit implements SplitAlgorithm {

	public Set<String> readSplit(){
		Set<String> sets = new TreeSet<String>();

		//读数据
		InputStream in = this.getClass().getClassLoader().getResourceAsStream("split");
		
		System.out.println(in);
		String line=null;
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new InputStreamReader(in,"utf-8"));
			while((line=reader.readLine())!=null){
				line=line.trim();
				sets.add(line);
			}
		} catch (Exception e) {			
			e.printStackTrace();
		}
		System.out.println(sets);
		return sets;
		
	}
	@Override
	public byte[] firstRow() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public byte[] lastRow() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String rowToStr(byte[] arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String separator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setFirstRow(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setFirstRow(byte[] arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setLastRow(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setLastRow(byte[] arg0) {
		// TODO Auto-generated method stub
		
	}
	//根据您的regions的数量进行region分配（分析split文件,将数据装成list集合）
	@Override
	public byte[][] split(int arg0) {
		//编写一个list集合，转换您的预分region数据
		List<byte[]> list = new ArrayList<byte[]>();
		//遍历我们的region start key end key
		try{
			for(String s:readSplit()){
				list.add(s.getBytes());
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		//将list集合转为二维数组
		return list.toArray(new byte[0][]);
	}

	@Override
	public byte[] split(byte[] arg0, byte[] arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public byte[] strToRow(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
