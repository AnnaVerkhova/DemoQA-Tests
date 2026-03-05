package test.api.integrationTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import test.database.DatabaseConnection;

import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseConnectionTest {

    @Test(description = "Check that the connection is established and open")
    public void testDatabaseConnection() {
        try (Connection connection = DatabaseConnection.getConnection()) {
            Assert.assertNotNull(connection, "Failed to establish connection to the database");
            Assert.assertFalse(connection.isClosed(), "The database connection was closed.");
        } catch (SQLException e) {
            Assert.fail("Error connecting to database: " + e.getMessage());
        }
    }
}
