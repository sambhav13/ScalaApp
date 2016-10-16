package com.scala.app

import org.apache.spark.SparkContext
import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession

/**
 * @author ${user.name}
 */
object App {
  
  def foo(x : Array[String]) = x.foldLeft("")((a,b) => a + b)
  
  def main(args : Array[String]) {
    println( "Hello World!" )
    println("concat arguments = " + foo(args))

    val master = "local[2]"
    val conf = new SparkConf().setAppName("scala").setMaster(master)
	
    val sc = new SparkContext(conf)
    val textFile = sc.textFile("./src/main/resources/README.md")
    textFile.foreach(x=>println(x))

    /*val spark = SparkSession
   .builder()
   .appName("SparkSessionZipsExample")
   .getOrCreate()*/

    val data = Array(1, 2, 3, 4, 5)
	 val distData = sc.parallelize(data)
	 distData.foreach(x=>println(x))

  }

  def mockRDD[T]: org.apache.spark.rdd.RDD[T] = null

}
