package com.cloudera.sa.hcu.io.put.hdfs.writer;

import java.lang.reflect.Constructor;
import java.util.Properties;

import com.cloudera.sa.hcu.io.put.local.reader.AbstractLocalFileColumnReader;

public class WriterFactory
{
	public static final String CONF_WRITER_CLASS = "put.writer";
	

	public static AbstractWriter initWriter(Properties p)
	{
		String readerClass = p.getProperty(CONF_WRITER_CLASS);
		
		try
		{
			Constructor constructor = Class.forName(readerClass).getConstructor(Properties.class);
		
			return (AbstractWriter)constructor.newInstance(p);
		}catch(Exception e)
		{
			throw new RuntimeException(CONF_WRITER_CLASS + " value of '" + readerClass + "' was unable to construct into a " + AbstractWriter.class.getName(), e);
		}
	}



}
