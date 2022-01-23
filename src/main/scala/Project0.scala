import java.awt.print.Printable
import java.sql.{Connection, DriverManager}
import scala.io.StdIn.readLine

object Project0 {

  def main(args: Array[String]): Unit = {
    val loggedIn = 0
    println("Hello! Welcome to the transaction App!")
    val username = readLine("Please enter your username: ")
    val password = readLine("Please enter your password ")
    val accessLevel = username
    if((!username.equals("Admin") || !password.equals("root")) &&
      (!username.equals("user") || !password.equals("user"))){
      println("Incorrect login credentials!")
      return
    }
    if(accessLevel.equals("Admin")){
      println("Welcome " + username + ", what would you like to do? ")
      println("Press:\n 1. View list of Clients' ID\n 2. View list of Clients' name\n 3. View list of clients' account type\n 4. View when last paid.")
      val adminRes = readLine()
      if(adminRes.equals("1")) {
        println("Here is the list of Clients' ID:")
        getClientsID()
      } else if(adminRes.equals("2")){
        println("Here is the list of clients:")
        getClientsName()
      } else if(adminRes.equals("3")){
        println("Here is the list of Clients' account type:")
        getClientsAcctType()
      }
    } else if(accessLevel.equals("user")){
      println("Welcome " + username + ", what would you like to do?" )

    }

  }

  def dbConnection (): Connection = {
    val connection ="jdbc:mysql://127.0.0.1:3306/UserInfo"
    val userName = "root"
    val password ="Special7791@"
    val driver = "com.mysql.cj.jdbc.Driver"
    val con = DriverManager.getConnection(connection, userName, password)

    try {
      Class.forName(driver)
      val con = DriverManager.getConnection(connection, userName, password)
      if(con != null)
        System.out.println("Database connection is successful!")
    } catch {
      case e: Exception =>
        e.printStackTrace()
    }
    return con

  }

  def getClientsID() : Connection = {
    val connection ="jdbc:mysql://127.0.0.1:3306/UserInfo"
    val userName = "root"
    val password ="Special7791@"
    val driver = "com.mysql.cj.jdbc.Driver"
    val con = DriverManager.getConnection(connection, userName, password)

    try {
      Class.forName(driver)
      val con = DriverManager.getConnection(connection, userName, password)
      val query = "SELECT ID FROM ClientInfo"
      val statement = con.createStatement()
      val resultSet = statement.executeQuery(query)
      while(resultSet.next()) {
        val ID = resultSet.getInt("ID")
        println(ID)
      }
      if(con != null)
        System.out.println("Database connection is successful!")
    } catch {
      case e: Exception =>
        e.printStackTrace()
    }
    return con
  }

  def getClientsName() : Connection = {
    val connection ="jdbc:mysql://127.0.0.1:3306/UserInfo"
    val userName = "root"
    val password ="Special7791@"
    val driver = "com.mysql.cj.jdbc.Driver"
    val con = DriverManager.getConnection(connection, userName, password)

    try {
      Class.forName(driver)
      val con = DriverManager.getConnection(connection, userName, password)
      val query = "SELECT Name FROM ClientInfo"
      val statement = con.createStatement()
      val resultSet = statement.executeQuery(query)
      while(resultSet.next()) {
        val clientsName = resultSet.getString("Name")
        println(clientsName)
      }
      if(con != null)
        System.out.println("Database connection is successful!")
    } catch {
      case e: Exception =>
        e.printStackTrace()
    }
    return con
  }

  def getClientsAcctType() : Connection = {
    val connection ="jdbc:mysql://127.0.0.1:3306/UserInfo"
    val userName = "root"
    val password ="Special7791@"
    val driver = "com.mysql.cj.jdbc.Driver"
    val con = DriverManager.getConnection(connection, userName, password)

    try {
      Class.forName(driver)
      val con = DriverManager.getConnection(connection, userName, password)
      val query = "SELECT AcctType FROM ClientInfo"
      val statement = con.createStatement()
      val resultSet = statement.executeQuery(query)
      while(resultSet.next()) {
        val acctType = resultSet.getString("AcctType")
        println(acctType)
      }
      if(con != null)
        System.out.println("Database connection is successful!")
    } catch {
      case e: Exception =>
        e.printStackTrace()
    }
    return con
  }

}
