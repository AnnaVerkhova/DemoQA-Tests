package test.database;

import io.qameta.allure.Step;
import org.aeonbits.owner.ConfigFactory;
import test.TestConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final TestConfig config =
            ConfigFactory.create(TestConfig.class);

    @Step("Connecting to a database")
    public static Connection getConnection() throws SQLException {

        return DriverManager.getConnection(
                config.urlDB(),
                config.userDB(),
                config.passwordDB()
        );
    }
}
