import org.junit.Test;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


/**
 * @author 贺威
 * @create 2018-10-30 14:19
 */
public class test {


    /**
     * 逆向生成表
     */
        @Test
        public void Generate() throws Exception{
            List<String> warnings = new ArrayList<String>();
            boolean overwrite = true;
            File configFile = new File("src/main/resource/generatorConfig.xml");
            ConfigurationParser cp = new ConfigurationParser(warnings);
            Configuration config = cp.parseConfiguration(configFile);
            DefaultShellCallback callback = new DefaultShellCallback(overwrite);
            MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
            myBatisGenerator.generate(null);
        }

        public void sd(){

        }


    }

