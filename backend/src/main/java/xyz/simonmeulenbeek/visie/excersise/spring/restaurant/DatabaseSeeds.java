package xyz.simonmeulenbeek.visie.excersise.spring.restaurant;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.init.ScriptUtils;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.SQLException;

@Component
@Profile("!prod")
public class DatabaseSeeds {

    @Autowired
    private Environment env;
    @Autowired
    private DataSource dataSource;


    @PostConstruct
    public void loadData() throws SQLException {
        System.out.println("Checking available database seeds.");
        ClassLoader cl = this.getClass().getClassLoader();
        for (String activeProfile: env.getActiveProfiles()) {
            ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver(cl);
            try {
                for (Resource resource: resolver.getResources("classpath*:db/seeds/" + activeProfile + "/*.sql")) {
                    System.out.println("Seeding table: " + resource.getFilename());
                    ScriptUtils.executeSqlScript(dataSource.getConnection(), resource);
                }
            } catch (Exception e) {

            }

        }
    }
}
