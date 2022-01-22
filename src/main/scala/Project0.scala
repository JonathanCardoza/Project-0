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
    if(!username.equals("Admin") || !password.equals("root")){
      println("Incorrect login credentials!")
      return
    }

    println("Welcome " + username + " what would you like to do? ")
    println("Press:\n 1. To view balance\n 2. Get account number or\n 3. View account type\n 4. View when last paid.")
    val adminRes = readLine()

    if(adminRes.equals("1")) {
      println("Your balance is:")
      getAcctBalance()
    } else if(adminRes.equals("2")){
      println("Your account number is:")
      getAcctNum()
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
      val query = "SELECT * FROM ClientInfo"
      val statement = con.createStatement()
      val resultSet = statement.executeQuery(query)

      while(resultSet.next()) {
        val id = resultSet.getInt("ID")
        println(id)
      }
      statement.close()
      if(con != null)
        System.out.println("Database connection is successful!")
    } catch {
      case e: Exception =>
        e.printStackTrace()
    }
    return con

  }

  def getAcctBalance() : Connection = {
    val connection ="jdbc:mysql://127.0.0.1:3306/UserInfo"
    val userName = "root"
    val password ="Special7791@"
    val driver = "com.mysql.cj.jdbc.Driver"
    val con = DriverManager.getConnection(connection, userName, password)

    try {
      Class.forName(driver)
      val con = DriverManager.getConnection(connection, userName, password)
      val query = "SELECT Balance FROM BankInfo"
      val statement = con.createStatement()
      val resultSet = statement.executeQuery(query)
      while(resultSet.next()) {
        val balance = resultSet.getInt("Balance")
        println(balance)
      }
      if(con != null)
        System.out.println("Database connection is successful!")
    } catch {
      case e: Exception =>
        e.printStackTrace()
    }
    return con
  }

  def getAcctNum() : Connection = {
    val connection ="jdbc:mysql://127.0.0.1:3306/UserInfo"
    val userName = "root"
    val password ="Special7791@"
    val driver = "com.mysql.cj.jdbc.Driver"
    val con = DriverManager.getConnection(connection, userName, password)

    try {
      Class.forName(driver)
      val con = DriverManager.getConnection(connection, userName, password)
      val query = "SELECT AcctNum FROM BankInfo"
      val statement = con.createStatement()
      val resultSet = statement.executeQuery(query)
      while(resultSet.next()) {
        val acctNum = resultSet.getInt("AcctNum")
        println(acctNum)
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
