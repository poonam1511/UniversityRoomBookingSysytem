package ECUtils;
public class ECConst {
	public static String DB_NAME ="UniversityRoomBookingSysytem";
	public static String DB_HOST="localhost";
	public static String DB_USER="root";
	public static String DB_PASS ="";
	public static String SQLS[] = 
	{   
            "create table staff (id INT NOT NULL AUTO_INCREMENT, user_name varchar(45), pass varchar(45),  PRIMARY KEY (id))",	
		"insert into staff(user_name, pass) values ('admin', 'admin@123')",	
                "create table booking_detail (id INT NOT NULL AUTO_INCREMENT, lec_name varchar(45),email varchar(20),  time varchar(20), duration varchar(30),date varchar(30),type_of_room varchar(20),room_no varchar(20),attendee_no varchar(20),reason_for_booking varchar(20),status varchar(20),booking_id varchar(20),room_cap varchar(20),  PRIMARY KEY (id))",
"create table room_detail (id INT NOT NULL AUTO_INCREMENT, room_no varchar(45), type_of_room varchar(45), room_cap varchar(45), PRIMARY KEY (id));"

        };
}
















