<?xml version="1.0" encoding="UTF-8" ?>

<hadoopjob version="0.18.3">
  <bootstrap input="/media/S3A4095D502/Programming/hadoop/input/detik-1.txt" filesystem="00000000-0000-0000-377a-99710000002f"/>
  <configuration>
    <entry key="MAPREDUCE_JOB_OUTPUT_VALUE_CLASS" type="com.karmasphere.studio.common.lang.ClassDescriptor" value="org.apache.hadoop.io.LongWritable"/>
    <entry key="KARMASPHERE_MAPREDUCE_MAP_DETECT_TYPES" type="java.lang.Boolean" value="True"/>
    <entry key="MAPREDUCE_MAP_OUTPUT_KEY_CLASS" type="com.karmasphere.studio.common.lang.ClassDescriptor" value="org.apache.hadoop.io.Text"/>
    <entry key="KARMASPHERE_MAPREDUCE_REDUCE_DETECT_TYPES" type="java.lang.Boolean" value="True"/>
    <entry key="MAPREDUCE_JOB_REDUCES" type="java.lang.Integer" value="1"/>
    <entry key="MAPREDUCE_MAP_OUTPUT_VALUE_CLASS" type="com.karmasphere.studio.common.lang.ClassDescriptor" value="org.apache.hadoop.io.Text"/>
  </configuration>
  <operation type="input">
    <operator qualifiedName="org.apache.hadoop.mapred.TextInputFormat" binaryName="org.apache.hadoop.mapred.TextInputFormat"/>
  </operation>
  <operation type="mapper">
    <operator qualifiedName="mapred.IndexMapper" binaryName="mapred.IndexMapper"/>
  </operation>
  <operation type="partitioner">
    <operator qualifiedName="org.apache.hadoop.mapred.lib.HashPartitioner" binaryName="org.apache.hadoop.mapred.lib.HashPartitioner"/>
  </operation>
  <operation type="comparator">
    <operator qualifiedName="org.apache.hadoop.io.Text.Comparator" binaryName="org.apache.hadoop.io.Text$Comparator"/>
  </operation>
  <operation type="combiner">
  </operation>
  <operation type="reducer">
    <operator qualifiedName="mapred.IndexReducer" binaryName="mapred.IndexReducer"/>
  </operation>
  <operation type="outputformat">
    <operator qualifiedName="org.apache.hadoop.mapred.TextOutputFormat" binaryName="org.apache.hadoop.mapred.TextOutputFormat"/>
  </operation>
  <defaultArgs>
  </defaultArgs>
  <uploadedFiles>
  </uploadedFiles>
</hadoopjob>
