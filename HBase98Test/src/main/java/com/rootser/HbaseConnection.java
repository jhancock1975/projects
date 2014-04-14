package com.rootser;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.HBaseAdmin;

public class HbaseConnection {
	public static void main(String[] args) throws IOException {
		Configuration conf = new Configuration();
		
		Configuration hc = HBaseConfiguration.create(conf);

		HTableDescriptor ht = new HTableDescriptor( TableName.valueOf("User"));

		ht.addFamily(new HColumnDescriptor("Id"));

		ht.addFamily(new HColumnDescriptor("Name"));

		System.out.println("connecting");

		HBaseAdmin hba = new HBaseAdmin(hc);

		System.out.println("Creating Table");

		hba.createTable(ht);

		/*System.out.println("dropping table......");
		
		hba.disableTable(ht.getName());
		
		hba.deleteTable(ht.getName());*/
		
		hba.close();
		
		System.out.println("done");
	}
}