package com.scala.app

import org.apache.spark.SparkContext
import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession

/**
 * @author ${user.name}
 */
object App2 {
  
  def foo(x : Array[String]) = x.foldLeft("")((a,b) => a + b)
  
  def main(args : Array[String]) {
    println( "Hello World!" )
    println("concat arguments = " + foo(args))

    val warehouseLocation = "F:\\software\\spark-2.0.0-bin-hadoop2.7\\metastore_db"
    val spark = SparkSession
   .builder()
   .appName("SparkSessionZipsExample")
   .config("spark.sql.warehouse.dir", warehouseLocation)
   .enableHiveSupport()
   .getOrCreate()

    val people = spark.table("people");
    people.foreach(x=>println(x))

  }

  

}


