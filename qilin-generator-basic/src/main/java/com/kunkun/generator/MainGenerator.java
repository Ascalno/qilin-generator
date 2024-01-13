package com.kunkun.generator;

import com.kunkun.model.MainTemplateConfig;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;

/**
 * @Author: xd
 * @Description: TODO
 * @DateTime: 2024/1/13 14:39
 **/
public class MainGenerator {
    public static void main(String[] args) throws TemplateException, IOException {
        //1.静态文件生成
        String projectPath = System.getProperty("user.dir");
        //输入路径
        String inputPath = projectPath + File.separator + "qilin-generator-demo-projects" + File.separator + "acm-template";
        //输出路径
        String outputPath = projectPath;
        StaticGenerator.copyFilesByRecursive(inputPath, outputPath);

        //动态文件生成
        String dynamicInputPath = projectPath + File.separator + "qilin-generator-basic" +  File.separator + "src/main/resources/templates/MainTemplate.java.ftl";
        String dynamicOutputPath = projectPath + File.separator + "acm-template/src/com/kunkun/acm/MainTemplate.java";

        MainTemplateConfig mainTemplateConfig = new MainTemplateConfig();
        mainTemplateConfig.setAuthor("麒麟");
        mainTemplateConfig.setOutputText("求和结果: ");
        mainTemplateConfig.setLoop(false);
        DynamicGenerator.doGenerator(dynamicInputPath,dynamicOutputPath, mainTemplateConfig);
    }
}
