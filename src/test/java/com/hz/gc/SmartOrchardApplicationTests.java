package com.hz.gc;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SpringBootTest
class SmartOrchardApplicationTests {

    @Test
    void contextLoads() {

        List<String> list = new ArrayList<>();
        list.add("gc_admin");
        list.add("gc_attendance");
        list.add("gc_comment");
        list.add("gc_daily_progress");
        list.add("gc_item_project");
        list.add("gc_material");
        list.add("gc_notice");
        list.add("gc_permissinos");
        list.add("gc_position");
        list.add("gc_progress");
        list.add("gc_project_user");
        list.add("gc_role");
        list.add("gc_role_permissinos");
        list.add("gc_sub_project");
        list.add("gc_system");
        list.add("gc_total_project");
        list.add("gc_user");
        list.add("gc_change");


        FastAutoGenerator.create("jdbc:mysql://127.0.0.1:3306/gc?characterEncoding=utf8&connectTimeout=1000&socketTimeout=3000&autoReconnect=true&useUnicode=true&useSSL=false&serverTimezone=GMT%2B8","root", "root")
                .globalConfig(builder -> {
                    builder.author("第三组") // 设置作者
                            .enableSwagger() // 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件
                            .outputDir(System.getProperty("user.dir")+"\\src\\main\\java") // 指定输出目录
                            .commentDate("yyyy-MM-dd");

                })
                .packageConfig(builder -> {
                    builder.parent("com.hz") // 设置父包名
                            .moduleName("gc") // 设置父包模块名
                            .entity("pojo")
                            .service("service")
                            .serviceImpl("impl")
                            .controller("controller")
                            .mapper("dao")
                            .xml("dao")
                            .pathInfo(Collections.singletonMap(OutputFile.xml,
                                    System.getProperty("user.dir")+"\\src\\main\\resources\\mappers"));
                })
                .strategyConfig(builder -> {
                    builder.addInclude(list) // 设置需要生成的表名
                            // 设置过滤表前缀
                            .addTablePrefix("gc_")
                            .serviceBuilder()
                            .formatServiceFileName("%sService")
                            .formatServiceImplFileName("%sServiceImpl")
                            .entityBuilder()
                            .enableLombok()
                            .logicDeleteColumnName("isDelete")
                            .enableTableFieldAnnotation()
                            .controllerBuilder()
                            .formatFileName("%sController")
                            .enableRestStyle()
                            .mapperBuilder()
                            .superClass(BaseMapper.class)
                            .formatMapperFileName("%sDao")
                            .formatXmlFileName("%sMapper");

                })
                .execute();
    }

}
