package com.kunkun.generator;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.ArrayUtil;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

/**
 * @Author: xd
 * @Description: TODO 静态文件生成器
 * @DateTime: 2024/1/12 18:21
 **/
public class StaticGenerator {

    public static void main(String[] args) {
        String projectPath = System.getProperty("user.dir");
        //输入路径
        String inputPath = projectPath + File.separator + "qilin-generator-demo-projects" + File.separator + "acm-template";

        //输出路径
        String outputPath = projectPath;

//        copyFilesByRecursive(inputPath, outputPath);
        copyFilesByHutool(inputPath, outputPath);

    }

    /**
     * 拷贝文件 (Hutool 实现， 会将输入目录完整拷贝到输出目录下)
     *
     * @param inputPath  输入路径
     * @param outputPath 输出路径
     */
    public static void copyFilesByHutool(String inputPath, String outputPath) {
        FileUtil.copy(inputPath, outputPath, false);
    }


    public static void copyFilesByRecursive(String inputPath, String outputPath) {
        File inputFile = new File(inputPath);
        File outputFile = new File(outputPath);

        try {
            copyFileByRecursive(inputFile, outputFile);
        } catch (Exception e) {
            System.err.println("文件复制失败");
            e.printStackTrace();
        }

    }

    private static void copyFileByRecursive(File inputFile, File outputFile) {

        //判断是文件还是目录
        if (inputFile.isDirectory()) {
            File destOutputFile = new File(outputFile, inputFile.getName());

            //是目录则，先创建目录
            if (!destOutputFile.exists()) {
                destOutputFile.mkdirs();
            }
            //获取目录下的所有文件和子目录
            File[] files = inputFile.listFiles();
            if (ArrayUtil.isEmpty(files)) {
                //如果没有子文件或目录则结束
                return;
            }
            for (File file : files) {
                copyFileByRecursive(file, destOutputFile);
            }
        } else {
            //如果是文件则直接复制到目标目录下
            Path destPath = outputFile.toPath().resolve(inputFile.getName());
            FileUtil.copy(inputFile.toPath(), destPath, StandardCopyOption.REPLACE_EXISTING);
        }
    }


}
