package ECUtils;
public class ECConst {
	public static String DB_NAME ="Gym_Diary";
	public static String DB_HOST="localhost";
	public static String DB_USER="root";
	public static String DB_PASS ="";
	public static String SQLS[] = 
	{   
            "create table staff (id INT NOT NULL AUTO_INCREMENT, user_name varchar(45), pass varchar(45),  PRIMARY KEY (id))",	
		"insert into staff(user_name, pass) values ('admin', 'admin@123')",	
                "create table client (id INT NOT NULL AUTO_INCREMENT, client_name varchar(45), pass varchar(45), pt_name varchar(45),email varchar(20),  time varchar(20), duration varchar(30), focus varchar(40),date varchar(20),  PRIMARY KEY (id))",
                "insert into client(client_name,pass)values('user','user')",
"create table per_tra (id INT NOT NULL AUTO_INCREMENT, pt_name varchar(45),email varchar(20), pass varchar(45),  expertise varchar(100), Avail_time varchar(30) , PRIMARY KEY (id));"

        };
}
















