package SchoolAdministration.util;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


 public class SqlServerUtils  {

    String connectionUrl = null;

    // Declare the JDBC objects.
    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;


    public SqlServerUtils()
    {

    }

    public SqlServerUtils(String connectionStringUrl) throws Exception
    {
        this.connect(connectionStringUrl);
    }


    /***
     * This api connects to sql server , It uses connection string from config.properties file
     * @return Connection object
     * @throws Exception
     */
    public Connection connect() throws Exception {

        if( (con !=null) && (!con.isClosed()))
        {
            closeConnection();
        }

        if(connectionUrl==null) {
        	
        	connectionUrl = "jdbc:sqlserver://database-1.crotnk9kagij.us-east-1.rds.amazonaws.com;databaseName=medikart;user=awsrdsadmin;password=success12!#";
            //connectionUrl = TestProperties.getValue("WOISqlServerConnectionString");
        }
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        return DriverManager.getConnection(connectionUrl);
    }


    /***
     * This api connects to sql server ,
     * @param connectionString - Connection String
     * @return Connection object
     * @throws Exception
     */
    public Connection connect(String connectionString) throws Exception {

        if(con!=null)
        {
            if(!con.isClosed())
            {
                closeConnection();
            }
        }

        connectionUrl = connectionString;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        return DriverManager.getConnection(connectionUrl);
    }

    /***
     * This api close existing open connection
     * @throws Exception
     */
    public void closeConnection() throws Exception {
        con.close();
        con = null;
    }

    /***
     * This api executes sql server query and returns the resultset
     * @param query - Sql server query
     * @return result set
     */
    public ResultSet SelectData(String query)
    {
        try
        {
            con = connect();
            stmt = con.createStatement();
            stmt.setFetchSize(Integer.parseInt(/*TestProperties.getValue("dbCassendraMaxResultSetSize")*/"100"));
            rs = stmt.executeQuery(query);

        }
        catch (Exception ex)
        {
            ex.printStackTrace();

        }

        return rs;

    }

    /***
     * This api executes query and returns true/false if query executed successfully.
     * @param query - Query to execute
     * @return boolean value
     */
    public  boolean Execute(String query)
    {
        boolean retVal = false;

        try
        {
            con = connect();
            stmt = con.createStatement();
            stmt.execute(query);
            retVal = true;


        }
        catch (Exception ex)
        {
            ex.printStackTrace();

        }

        return retVal;
    }

    /***
     * This api accepts table name and calculate no of rows in a table.
     * @param tableName - Table name
     * @return no of rows
     */
    public  long count(String tableName)
    {
        return count(tableName,"");
    }

    /***
     * This api accepts table name with condition and execute query to calculate no of rows in a table.
     * @param tableName - Table name
     * @param condition - sql condition
     * @return no of rows with meets table name and condition.
     */
    public  long count(String tableName,String condition)
    {
        long count = -1;

        try {

            String query = null;
            con = connect();
            stmt = con.createStatement();

            if (condition.equalsIgnoreCase(""))
            {
                query = "SELECT count(*) FROM " + tableName + ";";
            }
            else
            {
                query = "SELECT count(*) FROM " + tableName + " where " + condition + ";";
            }

            rs = stmt.executeQuery (query);
            if (rs == null) return 0;

            rs.next();
            count = rs.getInt(1);



        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return count;

    }

}
