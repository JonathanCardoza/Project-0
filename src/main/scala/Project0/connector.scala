package Project0

import java.sql.Connection
import java.sql.DriverManager

class connector {

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


}
