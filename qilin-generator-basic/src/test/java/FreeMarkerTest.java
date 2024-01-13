import cn.hutool.core.lang.hash.Hash;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.*;

/**
 * @Author: xd
 * @Description: TODO
 * @DateTime: 2024/1/13 0:40
 **/
public class FreeMarkerTest {

    @Test
    public void test() throws IOException, TemplateException {
        // new 出 Configuration 对象， 参数为 Freemarker 版本号
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_32);
        try {
            // 指定模板文件所在的路径
            configuration.setDirectoryForTemplateLoading(new File("src/main/resources/templates"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //设置模板文件使用的字符集
        configuration.setDefaultEncoding("utf-8");

        //创建模板对象，加载指定模板
        Template template = configuration.getTemplate("myweb.html.ftl");

        //数据模型
        HashMap<String, Object> dataModel = new HashMap<>();
        dataModel.put("currentYear",2024);
        List<Map<String, Object>> menuItems = new ArrayList<>();
        Map<String,Object> menuItem1 = new HashMap<>();
        menuItem1.put("url","https://www.bilibili.com");
        menuItem1.put("label","B站");
        menuItems.add(menuItem1);
        Map<String,Object> menuItem2 = new HashMap<>();
        menuItem2.put("url","https://www.baidu.com");
        menuItem2.put("label","百度");
        menuItems.add(menuItem2);
        dataModel.put("menuItems",menuItems);

        Writer out = new FileWriter("myweb.html");

        template.process(dataModel,out);

        //释放资源
        out.close();

    }
}
