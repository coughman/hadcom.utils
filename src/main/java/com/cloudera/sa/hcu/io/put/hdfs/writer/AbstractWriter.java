package com.cloudera.sa.hcu.io.put.hdfs.writer;

import java.io.IOException;
import java.util.Properties;

import com.cloudera.sa.hcu.utils.PropertyUtils;

public abstract class AbstractWriter
{	
	protected static final String COMPRESSION_CODEC = "writer.compression.codec";
	public static final String CONF_OUTPUT_PATH = "writer.output.path";
	
	public AbstractWriter(Properties prop) throws IOException
	{
		String outputPath = PropertyUtils.getStringProperty(prop, CONF_OUTPUT_PATH);
		init(outputPath, prop);
	}
	
	abstract protected void init(String outputPath, Properties prop) throws IOException;
	
	abstract public void writeRow(String rowType, String[] columns) throws IOException;
	
	abstract public void close() throws IOException;
	
	
}
