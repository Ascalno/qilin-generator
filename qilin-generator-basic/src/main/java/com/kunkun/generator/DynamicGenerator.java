package com.kunkun.generator;

import com.kunkun.model.MainTemplateConfig;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * @Author: xd
 * @Description: TODO 动态文件生成器
 * @DateTime: 2024/1/13 14:11
 **/
public class DynamicGenerator {
    public static void main(String[] args) throws TemplateException, IOException {
        String projectPath = System.getProperty("user.dir") + File.separator + "qilin-generator-basic";
        String inputPath = projectPath + File.separator + "src/main/resources/templates/MainTemplate.java.ftl";
        String outputPath = projectPath + File.separator + "MainTemplate.java";
        MainTemplateConfig mainTemplateConfig = new MainTemplateConfig();
        mainTemplateConfig.setAuthor("麒麟");
        mainTemplateConfig.setOutputText("求和结果: ");
        mainTemplateConfig.setLoop(false);


        doGenerator(inputPath,outputPath, mainTemplateConfig);

    }

    public static void doGenerator(String inputPath, String outputPath, Object model) throws IOException, TemplateException {
        // new 出 Configuration 对象， 参数为 Freemarker 版本号
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_32);

        File templateDir = new File(inputPath).getParentFile();
        // 指定模板文件所在的路径
        configuration.setDirectoryForTemplateLoading(templateDir);

        //设置模板文件使用的字符集
        configuration.setDefaultEncoding("utf-8");
        //创建模板对象，加载指定模板
        String templateName = new File(inputPath).getName();
        Template template = configuration.getTemplate(templateName);

        Writer out = new FileWriter(outputPath);

        template.process(model, out);

        //释放资源
        out.close();
    }
}
