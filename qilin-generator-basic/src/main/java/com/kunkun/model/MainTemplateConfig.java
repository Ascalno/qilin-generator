package com.kunkun.model;

import lombok.Data;

/**
 * 静态模板配置
 **/
@Data
public class MainTemplateConfig {

    /**
     * 作者 （字符串 填充信息）
     */
    private String author = "麒麟";

    /**
     * 输出信息
     */
    private String outputText = "输出结果";

    /**
     * 是否循环
     */
    private boolean loop = false;
}
