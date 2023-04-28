package com.atguigu.ct.analysis;

import com.atguigu.ct.analysis.tool.AnalysisTextTool;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.util.ToolRunner;

/**
 * @Auther:我家二狗子
 * @Date:2022/12/22 13:38)
 * Description
 */
//分析数据
public class AnalysisData {
    public static void main(String[] args) throws Exception {
        int result = ToolRunner.run( new AnalysisTextTool(), args );
    }
}
