package flink;

import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
//从文件获取数据创建数据源
public class Src_from_file {
    public static void main(String[] args) throws Exception {

            // 1. 创建执行环境
            StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        //相对路径是从系统属性user.dir获取路径: idea下是project的根目录, standalone模式下是集群节点根目录
        //也可以从hdfs目录下读取, 使用路径:hdfs://...., 由于Flink没有提供hadoop相关依赖, 需要pom中添加相关依赖
            env.readTextFile("src/main/resources/words.txt")
               .print();

            env.execute();
        }
    }

