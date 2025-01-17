package com.tc.hutoolTest.utilTest;

import cn.hutool.core.lang.Dict;
import cn.hutool.extra.template.Template;
import cn.hutool.extra.template.TemplateConfig;
import cn.hutool.extra.template.TemplateEngine;
import cn.hutool.extra.template.TemplateUtil;

/**
 * 填充模板
 * 类似日志门面slf4j
 * 不用关心底层使用哪种模板引擎
 * 要想实现复杂的页面，自己还得hi模板语法
 */
public class TemplateUtilTest {
    public static void main(String[] args) {
//        // 获取模板引擎，默认的模板路径是文本
//        TemplateEngine engine = TemplateUtil.createEngine(new TemplateConfig());
//        // 获取模板
//        Template template = engine.getTemplate("Hello {name}");
//        // 模板填充内容
//        String render = template.render(Dict.create().set("name", "Hutool"));
//        System.out.println(render); // Hello {name}


        // 模板路径是classpath
        TemplateEngine engine = TemplateUtil.createEngine(new TemplateConfig("templates", TemplateConfig.ResourceMode.CLASSPATH));
        Template template = engine.getTemplate("velocity_test.vtl");
        String result = template.render(Dict.create().set("name", "Hutool"));

    }
}
