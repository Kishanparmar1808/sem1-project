import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;
class student{
    Scanner sc = new Scanner(System.in);
    String name;
    int number;
    String Email;
    int age;
    String Mo;
    String Gender;
    void setData(){
        System.out.println("Enter Youer Name  ");
         name=sc.next();
         Email=name+"@gmail.com";
        System.out.println("Email :"+Email);
        System.out.println("Enter Youer Age");
         age=sc.nextInt();
         System.out.println("Enter Youer Mobile Number ");
         String Mo = sc.next();
     boolean isValid = false;
     while (!isValid) {
         System.out.println("Enter your 10-digit mobile number:");
          Mo = sc.next() ;

         if (Mo.length() == 10 && Mo.matches("\\d+")) {
             System.out.println("You have entered a valid 10-digit mobile number.");
             isValid = true;
         } else {
             System.out.println("Invalid mobile number. Please enter a 10-digit mobile number.");
         }
     }

     System.out.println("You can continue now.");
 
        System.out.println("Enter Youer Gender");
         Gender=sc.next();
         String Gender=sc.next();
            if(Gender.equalsIgnoreCase("male") || Gender.equalsIgnoreCase("female")){
                System.out.println(Gender);
            }
    }
}
class linkedList{
    class node {
        node next;
        student s;
        node(student s){
            this.s = s;
            next = null;
        }
    }
    node first = null;
    void insertAtLast(student s){
        if (first == null){
            first = new node(s);
        }
        else{
            node n = new node(s);
            node temp = first;
            while(temp.next!=null){
                temp = temp.next;
            }
            temp.next = n;
        }
    }
    void display(){
        node temp= first;
        while(temp!=null){
            System.out.println(temp.s.name);
            System.out.println(temp.s.Mo);
            System.out.println(temp.s.age);
            System.out.println(temp.s.Gender);
            temp=temp.next;
        }
    }
}

class railway {


   static void checkMO(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Youer Mobile Number ");
            String Mo = sc.next();
        boolean isValid = false;
        while (!isValid) {
            System.out.println("Enter your 10-digit mobile number:");
             Mo = sc.next() ;

            if (Mo.length() == 10 && Mo.matches("\\d+")) {
                System.out.println("You have entered a valid 10-digit mobile number.");
                isValid = true;
            } else {
                System.out.println("Invalid mobile number. Please enter a 10-digit mobile number.");
            }
        }

        System.out.println("You can continue now.");
    

    }

    static void viewticket(){
        student s= new student();
        s.setData();
        linkedList l1 = new linkedList();
        l1.insertAtLast(s);
        System.out.println("User Details");
        l1.display();
        }
    public static void main(String[] args)throws Exception{
        String  dburl="jdbc:mysql://localhost:3309/railway1";
        String dbuser="root";
        String dbpass="";
        String driver="com.mysql.cj.jdbc.Driver";
        Class.forName(driver);
        Connection  con=DriverManager.getConnection(dburl,dbuser,dbpass);
        if(con!=null){
            System.out.println("Connection successfull");
        }
        else{
            System.out.println("Faild");
        }
        int setavelblity1=20;
        int setavelblity2=150;
        int setavelblity3=300;
        int setavelblity4=80;
        int setavelblity5=150;
        int setavelblity6=200;
        int seatNo=1;
        int CseatNo=1;
        int seatNo3=1;
        int CseatNo3=1;
        boolean b=true;
        while(b){
        System.out.println("=========WElCOME TO RAILWAY BOOKING PORTAL============");
        System.out.println("1.  login .");
        System.out.println("2 . Ticket Booking.");
        System.out.println("3 . Cancal Ticket");
        System.out.println("4 . view Ticket");
        System.out.println("5 . Exit");
        System.out.println("Choice Youer option");
        Scanner sc=new Scanner(System.in);
        int ch=sc.nextInt();
        switch (ch) {
            case 1:
            System.out.println("Details for Login");
            System.out.println("Enter Youer Name  ");
            String name=sc.next();
            String Email=name+"@gmail.com";
            System.out.println("Email :"+Email);
            System.out.println("Enter Youer Age");
            int age=sc.nextInt();
            System.out.println("Enter Youer Mobile Number ");
            String Mo = sc.next();
        boolean isValid = false;
        while (!isValid) {
            System.out.println("Enter your 10-digit mobile number:");
             Mo = sc.next() ;

            if (Mo.length() == 10 && Mo.matches("\\d+")) {
                System.out.println("You have entered a valid 10-digit mobile number.");
                isValid = true;
            } else {
                System.out.println("Invalid mobile number. Please enter a 10-digit mobile number.");
            }
        }

        System.out.println("You can continue now.");
    

            
            System.out.println("Enter Passward must be in Digit and 4 Digit");
            String Pass=sc.next();
            if(Pass.length()==4){
                System.out.println("Valid Passward"); 
            }
            System.out.println("Enter Youer Gender");
            String Gender=sc.next();
            if(Gender.equalsIgnoreCase("male") || Gender.equalsIgnoreCase("female")){
                System.out.println(Gender);
            }
            System.out.println("Login Sucessufull");
            String p="insert into passengers(name,age,gender,contact_number,email) values(?,?,?,?,?)";
            PreparedStatement Pst=con.prepareStatement(p);
            Pst.setString(1,name);
            Pst.setInt(2, age);
            Pst.setString(3, Gender);
            Pst.setString(4, Mo);
            Pst.setString(5, Email);
            int R=Pst.executeUpdate();
            
            break;

            case 2 :
            System.out.println("1. Enter Origin Station To Go ");
            String FromStation=sc.next();
            System.out.println("Enetr Destination Station ");
            String ToStation=sc.next();
            System.out.println("Enter jourany  month");
            int month=sc.nextInt();
            if(month>=1 && month<=12){
                System.out.println("ok");
            }
            else{
                System.out.println("Invalid Month");
            }
            System.out.println("Enter jourany day of date");
            int day=sc.nextInt();
            if(day>=1 && day<=31){
                System.out.println("ok");
            }else{
                System.out.println("Invalid");
            }

            System.out.println("Enter Jouray Year");
            int year=sc.nextInt();

            String date=year+"/"+month+"/"+day;

            System.out.println("1 . First Class AC");
            System.out.println("2 . AC 2-Tier");
            System.out.println("3 . AC 3-Tier");
            System.out.println("4 . AC Chair car");
            System.out.println("5 . Second Sitting");
            System.out.println("6 . Sleeper");
            System.out.println("Choice Youer class");
            int Catacary=sc.nextInt();
            switch (Catacary) {
                case 1:
                
                String pname;
                int age1;
                System.out.println("How many Parson");
            int person=sc.nextInt(); 
            System.out.println("Enter Booking date(YYYY/MM/DD)");
            String bdate=sc.next();
            for(int i=0;i<person;i++){
             System.out.println("Enter name :"+(i+1));
             pname=sc.next();
             System.out.println("Enter Passerger Age :"+(i+1));
            age1=sc.nextInt();
            if (person<=setavelblity1) {
                setavelblity1--;
            }
            else{
                System.out.println("Seat is Not Aveliable");
            }
            }
            String sql="insert into trains(train_name,origin,destination,departure_time,arrival_time,date,availability) values(?,?,?,?,?,?,?)";
            PreparedStatement pst=con.prepareStatement(sql);
            
            pst.setString(1, "Rajathani Express");
            pst.setString(2,FromStation);
            pst.setString(3, ToStation);
            pst.setString(4,"12:00" );
            pst.setString(5, "5:00");
            pst.setString(6, date);
            pst.setInt(7, setavelblity1);
            int r=pst.executeUpdate();
            System.out.println("1. UPI Payment");
            System.out.println("2 .Cradit Card Payment");
            System.out.println("Enter youer choice payment Method");
            int payment=sc.nextInt();
            switch(payment){
                case 1 :
                int Frate=3000*person;
                double Totalfare=Frate*0.18+Frate;
                
                System.out.println("Enter youer name for Billing");
                String Bname=sc.next();
                System.out.println("Passenger Name :"+Bname);
                System.out.println("From Station :"+FromStation);
                System.out.println("To Station :"+ToStation);
                System.out.println(" jourany date  :"+date);
                System.out.println("Booking date :"+bdate);
                
                for(int k=0;k<=person;k++){
                System.out.println("Seat Number : "+seatNo);
                seatNo++;
                }
                System.out.println("Class Name:  1st-class");
                String s="insert into booking(booking_date,journey_date,class,seat_number,status) values(?,?,?,?,?)";
                PreparedStatement p1=con.prepareStatement(s);
                p1.setString(1, bdate);
                p1.setString(2, date);
                p1.setString(3, "1-st class");
                p1.setInt(4, seatNo);
                p1.setString(5,"Booked");
                int r0=p1.executeUpdate();

                boolean isValidUPI = false;
                String upiId;
        
                while (!isValidUPI) {
                    System.out.println("Enter your UPI ID:");
                    upiId = sc.next();
        
                    if (upiId.matches("\\d{10}@([a-zA-Z]+)")) {
                        isValidUPI = true;
                        System.out.println("UPI ID is valid. Proceeding to the next step...");
                        System.out.println("Enter Youer Ticket Amount"+Totalfare);
                        double amount=sc.nextDouble();
                        if(amount==Totalfare){
                            System.out.println("payment Successfull");
                            System.out.println("Youer Tickit IS Booked");
                            System.out.println("HAPPY JOURNAY");
                        }
                    } else {
                        System.out.println("Invalid UPI ID. Please enter a valid UPI ID.");
                    }
                }
                String a="insert into payments(payment_mode,payment_date,amount) values(?,?,?)";
                PreparedStatement S=con.prepareStatement(a);
                S.setString(1, "UPI");
                S.setString(2, bdate);
                S.setDouble(3, Totalfare);
                int r1=S.executeUpdate();
                break;

                case 2:
                int CFrate=3000*person;
                double CTotalfare=CFrate*0.18+CFrate;
                
                System.out.println("Enter youer name for Billing");
                String bname=sc.next();
                System.out.println("Passenger Name :"+bname);
                System.out.println("From Station :"+FromStation);
                System.out.println("To Station :"+ToStation);
                System.out.println(" jourany date  :"+date);
                System.out.println("Booking date :"+bdate);
                
                for(int k=0;k<=person;k++){
                System.out.println("Seat Number : "+CseatNo);
                CseatNo++;
               
                }
                System.out.println("Class Name:  1st-class");
                String S1="insert into booking(booking_date,journey_date,class,seat_number,status) values(?,?,?,?,?)";
                PreparedStatement P=con.prepareStatement(S1);
                P.setString(1, bdate);
                P.setString(2, date);
                P.setString(3, "1-st class");
                P.setInt(4, CseatNo);
                P.setString(5,"Booked");
                int r2=P.executeUpdate();
                System.out.println("Enter cradit Card NO");
                String Craditno=sc.next();
                double amount1;
                if(Craditno.length()==16){
                    for(int i=0;i<16;i++){
                    if(Craditno.charAt(i)>=0 && Craditno.charAt(i)<=9){
                        System.out.println("Enter youer Total Amount :"+CTotalfare);
                            amount1=sc.nextDouble();
                            if(CTotalfare==amount1){
                            System.out.println("payment Successfull");
                            System.out.println("Youer Tickit IS Booked");
                            System.out.println("HAPPY JOURNAY");
                    }
                }       
                }
            }
        String a1="insert into payments(payment_mode,payment_date,amount) values(?,?,?)";
        PreparedStatement s1=con.prepareStatement(a1);
        s1.setString(1, "Cradit Card");
        s1.setString(2, bdate);
        s1.setDouble(3, CTotalfare);
            }
                break;
            
                case 2:
                
                String pname2;
                int age2;
                System.out.println("How many Pasrson");
            int person2=sc.nextInt(); 
            System.out.println("Enter Booking date (YYYY/MM/DD)");
            String bdate2=sc.next();
            for(int i=1;i<=person2;i++){
             System.out.println("Enter name :"+(i+1));
             pname=sc.next();
             System.out.println("Enter Passerger Age :"+(i+1));
            age=sc.nextInt();
            if (person2<=setavelblity2) {
                setavelblity2--;
            }
            else{
                System.out.println("Seat is Not Aveliable");
            }
            }
            String sql2="insert into trains(train_name,origin,destination,departure_time,arrival_time,date,availability)  values(?,?,?,?,?,?,?)";
            PreparedStatement pst2=con.prepareStatement(sql2);
            pst2.setString(1, "Tejas Express");
            pst2.setString(2,FromStation);
            pst2.setString(3, ToStation);
            pst2.setString(4,"1:00" );
            pst2.setString(5, "8:00");
            pst2.setString(6, date);
            pst2.setInt(7, setavelblity2);
            int r2=pst2.executeUpdate();
            System.out.println("1. UPI Payment");
            System.out.println("2 .Cradit Card Payment");
            System.out.println("Enter youer choice payment Method");
            int payment2=sc.nextInt();
            switch(payment2){
                case 1 :
                int Frate=2200*person2;
                double Totalfare=Frate*0.18+Frate;
                
                System.out.println("Enter youer name for Billing");
                String Bname=sc.next();
                System.out.println("Passenger Name :"+Bname);
                System.out.println("From Station :"+FromStation);
                System.out.println("To Station :"+ToStation);
                System.out.println(" jourany date  :"+date);
                System.out.println("Booking date :"+bdate2);
                
                for(int k=0;k<=person2;k++){
                System.out.println("Seat Number : "+seatNo);
                seatNo++;
                
                }
                System.out.println("Class Name:  AC 2-tier");
                String s="insert into booking(booking_date,journey_date,class,seat_number,status) values(?,?,?,?,?)";
                PreparedStatement st=con.prepareStatement(s);
                st.setString(1, bdate2);
                st.setString(2, date);
                st.setString(3, "Ac 2-tier");
                st.setInt(4, seatNo);
                st.setString(5,"Booked");
                int r3=st.executeUpdate();
                boolean isValidUPI = false;
                String upiId;
        
                while (!isValidUPI) {
                    System.out.println("Enter your UPI ID:");
                    upiId = sc.next();
        
                    if (upiId.matches("\\d{10}@([a-zA-Z]+)")) {
                        isValidUPI = true;
                        System.out.println("UPI ID is valid. Proceeding to the next step...");
                        System.out.println("Enter Youer Ticket Amount"+Totalfare);
                        double amount=sc.nextDouble();
                        if(amount==Totalfare){
                            System.out.println("payment Successfull");
                            System.out.println("Youer Tickit IS Booked");
                            System.out.println("HAPPY JOURNAY");
                        }
                    } else {
                        System.out.println("Invalid UPI ID. Please enter a valid UPI ID.");
                    }
                }
                
                    String a="insert into payments(payment_mode,payment_date,amount) values(?,?,?)";
                    PreparedStatement S=con.prepareStatement(a);
                    S.setString(1, "UPI");
                    S.setString(2, bdate2);
                    S.setDouble(3, Totalfare);
                          
                break;

                case 2:
                int CFrate=2200*person2;
                double CTotalfare=CFrate*0.18+CFrate;
                
                System.out.println("Enter youer name for Billing");
                String bname=sc.next();
                System.out.println("Passenger Name :"+bname);
                System.out.println("From Station :"+FromStation);
                System.out.println("To Station :"+ToStation);
                System.out.println(" jourany date  :"+date);
                System.out.println("Booking date :"+bdate2);
                
                for(int k=0;k<=person2;k++){
                System.out.println("Seat Number : "+CseatNo);
                CseatNo++;
                
                }
                System.out.println("Class Name:  AC 2-tier");
                String s2="insert into booking(booking_date,journey_date,class,seat_number,status) values(?,?,?,?,?)";
                PreparedStatement p2=con.prepareStatement(s2);
                p2.setString(1, bdate2);
                p2.setString(2, date);
                p2.setString(3, "Ac 2-tier");
                p2.setInt(4, CseatNo);
                p2.setString(5,"Booked");
                int r4=p2.executeUpdate();
                System.out.println("Enter cradit Card NO");
                String Craditno=sc.next();
                if(Craditno.length()==16){
                    for(int i=0;i<16;i++){
                    if(Craditno.charAt(i)>=0 && Craditno.charAt(i)<=9){
                        System.out.println("Enter youer Total Amount :"+CTotalfare);
                            double amount=sc.nextDouble();
                            if(CTotalfare==amount){
                            System.out.println("payment Successfull");
                            System.out.println("Youer Tickit IS Booked");
                            System.out.println("HAPPY JOURNAY");
                    }
                    }           
                }
            }
            String a1="insert into payments(payment_mode,payment_date,amount) values(?,?,?)";
        PreparedStatement s1=con.prepareStatement(a1);
        s1.setString(1, "Cradit Card");
        s1.setString(2, bdate2);
        s1.setDouble(3, CTotalfare);
        }
                break;

                case 3:
                
                String pname3;
                int age3;
                System.out.println("How many Pasrson");
            int person3=sc.nextInt(); 
            System.out.println("Enter Booking date (YYYY/MM/DD)");
            String bdate3=sc.next();
            for(int i=1;i<=person3;i++){
             System.out.println("Enter name :"+(i+1));
             pname=sc.next();
             System.out.println("Enter Passerger Age :"+(i+1));
            age=sc.nextInt();
            if (person3<=setavelblity3) {
                setavelblity3--;
            }
            else{
                System.out.println("Seat is Not Avelaiable");
            }
            }
            String sql3="insert into trains(train_name,origin,destination,departure_time,arrival_time,date,availability) values(?,?,?,?,?,?,?)";
            PreparedStatement pst3=con.prepareStatement(sql3);
            pst3.setString(1, "GaribRath Express");
            pst3.setString(2,FromStation);
            pst3.setString(3, ToStation);
            pst3.setString(4,"5:00" );
            pst3.setString(5, "10:00");
            pst3.setString(6, date);
            pst3.setInt(7, setavelblity3);
            int r3=pst3.executeUpdate();
            System.out.println("1. UPI Payment");
            System.out.println("2 .Cradit Card Payment");
            System.out.println("Enter youer choice payment Method");
            int payment3=sc.nextInt();
            switch(payment3){
                case 1 :
                int Frate3=1000*person3;
                double Totalfare3=Frate3*0.18+Frate3;
                
                System.out.println("Enter youer name for Billing");
                String Bname3=sc.next();
                System.out.println("Passenger Name :"+Bname3);
                System.out.println("From Station :"+FromStation);
                System.out.println("To Station :"+ToStation);
                System.out.println(" jourany date  :"+date);
                System.out.println("Booking date :"+bdate3);
                for(int k=0;k<person3;k++){
                System.out.println("Seat Number : "+seatNo3);
                seatNo3++;
                }
                System.out.println("Class Name:  AC 3-tier");
                String s3="insert into booking(booking_date,journey_date,class,seat_number,status) values(?,?,?,?,?)";
                PreparedStatement p3=con.prepareStatement(s3);
                p3.setString(1, bdate3);
                p3.setString(2, date);
                p3.setString(3, "Ac 3-tier");
                p3.setInt(4, seatNo3);
                p3.setString(5,"Booked");
                int r5=p3.executeUpdate();
                boolean isValidUPI = false;
                String upiId;
        
                while (!isValidUPI) {
                    System.out.println("Enter your UPI ID:");
                    upiId = sc.next();
        
                    if (upiId.matches("\\d{10}@([a-zA-Z]+)")) {
                        isValidUPI = true;
                        System.out.println("UPI ID is valid. Proceeding to the next step...");
                        System.out.println("Enter Youer Ticket Amount"+Totalfare3);
                        double amount=sc.nextDouble();
                        if(amount==Totalfare3){
                            System.out.println("payment Successfull");
                            System.out.println("Youer Tickit IS Booked");
                            System.out.println("HAPPY JOURNAY");
                        }
                    } else {
                        System.out.println("Invalid UPI ID. Please enter a valid UPI ID.");
                    }
                }
                
                    String a="insert into payments(payment_mode,payment_date,amount) values(?,?,?)";
                    PreparedStatement S=con.prepareStatement(a);
                    S.setString(1, "UPI");
                    S.setString(2, bdate3);
                    S.setDouble(3, Totalfare3);
                
                break;

                case 2:
                int CFrate3=1000*person3;
                double CTotalfare3=CFrate3*0.18+CFrate3;

                System.out.println("Enter youer name for Billing");
                String bname3=sc.next();
                System.out.println("Passenger Name :"+bname3);
                System.out.println("From Station :"+FromStation);
                System.out.println("To Station :"+ToStation);
                System.out.println(" jourany date  :"+date);
                System.out.println("Booking date :"+bdate3);
                
                for(int k=0;k<=person3;k++){
                System.out.println("Seat Number : "+CseatNo3);
                CseatNo3++;
                
                }
                System.out.println("Class Name:  AC 3-tier");
                String S3="insert into booking(booking_date,journey_date,class,seat_number,status) values(?,?,?,?,?)";
                PreparedStatement P3=con.prepareStatement(S3);
                P3.setString(1, bdate3);
                P3.setString(2, date);
                P3.setString(3, "Ac 3-tier");
                P3.setInt(4, CseatNo3);
                P3.setString(5,"Booked");
                int r6=P3.executeUpdate();
                System.out.println("Enter cradit Card NO");
                String Craditno3=sc.next();
                if(Craditno3.length()==16){
                    for(int i=0;i<16;i++){
                    if(Craditno3.charAt(i)>=0 && Craditno3.charAt(i)<=9){
                        System.out.println("Enter youer Total Amount :"+CTotalfare3);
                            double amount=sc.nextDouble();
                            if(CTotalfare3==amount){
                            System.out.println("payment Successfull");
                            System.out.println("Youer Tickit IS Booked");
                            System.out.println("HAPPY JOURNAY");
                    }
                }               
            }
        }
        String a1="insert into payments(payment_mode,payment_date,amount) values(?,?,?)";
        PreparedStatement s1=con.prepareStatement(a1);
        s1.setString(1, "Cradit Card");
        s1.setString(2, bdate3);
        s1.setDouble(3, CTotalfare3);
    }            
                break;  
    
                case 4:
              
                String pname4;
                int age4;
                System.out.println("How many Pasrson");
            int person4=sc.nextInt(); 
            System.out.println("Enter Booking date (YYYY/MM/DD)");
            String bdate4=sc.next();   
            for(int i=1;i<=person4;i++){
             System.out.println("Enter name :"+(i+1));
             pname=sc.next();
             System.out.println("Enter Passerger Age :"+(i+1));
            age=sc.nextInt();
            if (person4<=setavelblity4) {
                setavelblity4--;
            }
            else{
                System.out.println("Seat is Not Aveliable");
            }
        }
            String sql4="insert into trains(train_name,origin,destination,departure_time,arrival_time,date,availability) values(?,?,?,?,?,?,?)";
            PreparedStatement pst4=con.prepareStatement(sql4);
            pst4.setString(1, "VadeBhart Express");
            pst4.setString(2,FromStation);
            pst4.setString(3, ToStation);
            pst4.setString(4,"7:00" );
            pst4.setString(5, "11:00");
            pst4.setString(6, date);
            pst4.setInt(7, setavelblity4);
            int r4=pst4.executeUpdate();
            System.out.println("1. UPI Payment");
            System.out.println("2 .Cradit Card Payment");
            System.out.println("Enter youer choice payment Method");
            int payment4=sc.nextInt();
            switch(payment4){
                case 1 :
                int Frate=600*person4;
                double Totalfare=Frate*0.18+Frate;
                
                System.out.println("Enter youer name for Billing");
                String Bname=sc.next();
                System.out.println("Passenger Name :"+Bname);
                System.out.println("From Station :"+FromStation);
                System.out.println("To Station :"+ToStation);
                System.out.println(" jourany date  :"+date);
                System.out.println("Booking date :"+bdate4);
                
                for(int k=0;k<=person4;k++){
                System.out.println("Seat Number : "+seatNo);
                seatNo++;
                
                }
                System.out.println("Class Name:  AC chair Car");
                String s4="insert into booking(booking_date,journey_date,class,seat_number,status) values(?,?,?,?,?)";
                PreparedStatement p4=con.prepareStatement(s4);
                p4.setString(1, bdate4);
                p4.setString(2, date);
                p4.setString(3, "Ac Chair Car");
                p4.setInt(4, seatNo);
                p4.setString(5,"Booked");
                int r6=p4.executeUpdate();
                boolean isValidUPI = false;
                String upiId;
        
                while (!isValidUPI) {
                    System.out.println("Enter your UPI ID:");
                    upiId = sc.next();
        
                    if (upiId.matches("\\d{10}@([a-zA-Z]+)")) {
                        isValidUPI = true;
                        System.out.println("UPI ID is valid. Proceeding to the next step...");
                        System.out.println("Enter Youer Ticket Amount"+Totalfare);
                        double amount=sc.nextDouble();
                        if(amount==Totalfare){
                            System.out.println("payment Successfull");
                            System.out.println("Youer Tickit IS Booked");
                            System.out.println("HAPPY JOURNAY");
                        }
                    } else {
                        System.out.println("Invalid UPI ID. Please enter a valid UPI ID.");
                    }
                }
                
                    String a="insert into payments(payment_mode,payment_date,amount) values(?,?,?)";
                    PreparedStatement S=con.prepareStatement(a);
                    S.setString(1, "UPI");
                    S.setString(2, bdate4);
                    S.setDouble(3, Totalfare);
                
                break;

                case 2:
                int CFrate=600*person4;
                double CTotalfare=CFrate*0.18+CFrate;
            
                System.out.println("Enter youer name for Billing");
                String bname=sc.next();
                System.out.println("Passenger Name :"+bname);
                System.out.println("From Station :"+FromStation);
                System.out.println("To Station :"+ToStation);
                System.out.println(" jourany date  :"+date);
                System.out.println("Booking date :"+bdate4);
                
                for(int k=0;k<=person4;k++){
                System.out.println("Seat Number : "+CseatNo);
                CseatNo++;
                
                }
                System.out.println("Class Name:  Ac chair car");
                String S4="insert into booking(booking_date,journey_date,class,seat_number,status) values(?,?,?,?,?)";
                PreparedStatement P4=con.prepareStatement(S4);
                P4.setString(1, bdate4);
                P4.setString(2, date);
                P4.setString(3, "Ac Chair Car");
                P4.setInt(4, CseatNo);
                P4.setString(5,"Booked");
                int r7=P4.executeUpdate();
                System.out.println("Enter cradit Card NO");
                String Craditno=sc.next();
                if(Craditno.length()==16){
                    for(int i=0;i<16;i++){
                    if(Craditno.charAt(i)>=0 && Craditno.charAt(i)<=9){
                        System.out.println("Enter youer Total Amount :"+CTotalfare);
                            double amount=sc.nextDouble();
                            if(CTotalfare==amount){
                            System.out.println("payment Successfull");
                            System.out.println("Youer Tickit IS Booked");
                            System.out.println("HAPPY JOURNAY");
                    }
                }           
                }
            }
            String a1="insert into payments(payment_mode,payment_date,amount) values(?,?,?)";
        PreparedStatement s1=con.prepareStatement(a1);
        s1.setString(1, "Cradit Card");
        s1.setString(2, bdate4);
        s1.setDouble(3, CTotalfare);
        }
                break;
                case 5:
                
                String pname5;
                int age5;
                System.out.println("How many Pasrson");
            int person5=sc.nextInt(); 
            System.out.println("Enter Booking date (YYYY/MM/DD)");
            String bdate5=sc.next();
            for(int i=1;i<=person5;i++){
             System.out.println("Enter name :"+(i+1));
             pname=sc.next();
             System.out.println("Enter Passerger Age :"+(i+1));
            age=sc.nextInt();
            if (person5<=setavelblity5) {
                setavelblity5--;
            }
            else{
                System.out.println("Seat is Not Aveliable");
            }
            }
            String sql5="insert into trains(train_name,origin,destination,departure_time,arrival_time,date,availability) values(?,?,?,?,?,?,?)";
            PreparedStatement pst5=con.prepareStatement(sql5);
            pst5.setString(1, "AgastKranti Exress");
            pst5.setString(2,FromStation);
            pst5.setString(3, ToStation);
            pst5.setString(4,"4:00" );
            pst5.setString(5, "9:00");
            pst5.setString(6, date);
            pst5.setInt(7, setavelblity5);
            int r5=pst5.executeUpdate();
            System.out.println("1. UPI Payment");
            System.out.println("2 .Cradit Card Payment");
            System.out.println("Enter youer choice payment Method");
            int payment5=sc.nextInt();
            switch(payment5){
                case 1 :
                int Frate=400*person5;
                double Totalfare=Frate*0.18+Frate;
               
                System.out.println("Enter youer name for Billing");
                String Bname=sc.next();
                System.out.println("Passenger Name :"+Bname);
                System.out.println("From Station :"+FromStation);
                System.out.println("To Station :"+ToStation);
                System.out.println(" jourany date  :"+date);
                System.out.println("Booking date :"+bdate5);
                
                for(int k=0;k<=person5;k++){
                System.out.println("Seat Number : "+seatNo);
                seatNo++;
                
                }
                System.out.println("Class Name:  second Setting");
                String S5="insert into booking(booking_date,journey_date,class,seat_number,status) values(?,?,?,?,?)";
                PreparedStatement P5=con.prepareStatement(S5);
                P5.setString(1, bdate5);
                P5.setString(2, date);
                P5.setString(3, "Second Setting");
                P5.setInt(4, seatNo);
                P5.setString(5,"Booked");
                int r7=P5.executeUpdate();
                boolean isValidUPI = false;
                String upiId;
        
                while (!isValidUPI) {
                    System.out.println("Enter your UPI ID:");
                    upiId = sc.next();
        
                    if (upiId.matches("\\d{10}@([a-zA-Z]+)")) {
                        isValidUPI = true;
                        System.out.println("UPI ID is valid. Proceeding to the next step...");
                        System.out.println("Enter Youer Ticket Amount"+Totalfare);
                        double amount=sc.nextDouble();
                        if(amount==Totalfare){
                            System.out.println("payment Successfull");
                            System.out.println("Youer Tickit IS Booked");
                            System.out.println("HAPPY JOURNAY");
                        }
                    } else {
                        System.out.println("Invalid UPI ID. Please enter a valid UPI ID.");
                    }
                }
                
                    String a="insert into payments(payment_mode,payment_date,amount) values(?,?,?)";
                    PreparedStatement S=con.prepareStatement(a);
                    S.setString(1, "UPI");
                    S.setString(2, bdate5);
                    S.setDouble(3, Totalfare);
                
                break;

                case 2:
                int CFrate=400*person5;
                double CTotalfare=CFrate*0.18+CFrate;
               
                System.out.println("Enter youer name for Billing");
                String bname=sc.next();
                System.out.println("Passenger Name :"+bname);
                System.out.println("From Station :"+FromStation);
                System.out.println("To Station :"+ToStation);
                System.out.println(" jourany date  :"+date);
                System.out.println("Booking date :"+bdate5);
                
                for(int k=0;k<=person5;k++){
                System.out.println("Seat Number : "+CseatNo);
                CseatNo++;
                
                }
                System.out.println("Class Name:  Second Setting");
                String s5="insert into booking(booking_date,journey_date,class,seat_number,status) values(?,?,?,?,?)";
                PreparedStatement p5=con.prepareStatement(s5);
                p5.setString(1, bdate5);
                p5.setString(2, date);
                p5.setString(3, "Second Setting");
                p5.setInt(4, CseatNo);
                p5.setString(5,"Booked");
                int r8=p5.executeUpdate();
                System.out.println("Enter cradit Card NO");
                String Craditno=sc.next();
                if(Craditno.length()==16){
                    for(int i=0;i<16;i++){
                    if(Craditno.charAt(i)>=0 && Craditno.charAt(i)<=9){
                        System.out.println("Enter youer Total Amount :"+CTotalfare);
                            double amount=sc.nextDouble();
                            if(CTotalfare==amount){
                            System.out.println("payment Successfull");
                            System.out.println("Youer Tickit IS Booked");
                            System.out.println("HAPPY JOURNAY");
                    }
                }           
                }
            }
            String a1="insert into payments(payment_mode,payment_date,amount)  values(?,?,?)";
        PreparedStatement s1=con.prepareStatement(a1);
        s1.setString(1, "Cradit Card");
        s1.setString(2, bdate5);
        s1.setDouble(3, CTotalfare);
        }
                break;

                case 6:

                String pname6;
                int age6;
                System.out.println("How many Pasrson");
            int person6=sc.nextInt(); 
            System.out.println("Enter Booking date (YYYY/MM/DD)");
            String bdate6=sc.next();
            for(int i=1;i<=person6;i++){
             System.out.println("Enter name :"+(i+1));
             pname=sc.next();
             System.out.println("Enter Passerger Age :"+(i+1));
            age=sc.nextInt();
            if (person6<=setavelblity6){
                setavelblity6--;
            }
            else{
                System.out.println("Seat is Not Aveliable");
            }
            }
            String sql6="insert into trains(train_name,origin,destination,departure_time,arrival_time,date,availability) values(?,?,?,?,?,?,?)";
            PreparedStatement pst6=con.prepareStatement(sql6);
            pst6.setString(1, "Tejas Express");
            pst6.setString(2,FromStation);
            pst6.setString(3, ToStation);
            pst6.setString(4,"1:00" );
            pst6.setString(5, "8:00");
            pst6.setString(6, date);
            pst6.setInt(7, setavelblity6);
            int r6=pst6.executeUpdate();
            System.out.println("1. UPI Payment");
            System.out.println("2 .Cradit Card Payment");
            System.out.println("Enter youer choice payment Method");
            int payment6=sc.nextInt();
            switch(payment6){
                case 1 :
                int Frate=200*person6;
                double Totalfare=Frate*0.18+Frate;
        
                System.out.println("Enter youer name for Billing");
                String Bname=sc.next();
                System.out.println("Passenger Name :"+Bname);
                System.out.println("From Station :"+FromStation);
                System.out.println("To Station :"+ToStation);
                System.out.println(" jourany date  :"+date);
                System.out.println("Booking date :"+bdate6);
               
                for(int k=0;k<=person6;k++){
                System.out.println("Seat Number : "+seatNo);
                seatNo++;
              
                }
                System.out.println("Class Name:  Sleeper");
                String s5="insert into booking(booking_date,journey_date,class,seat_number,status) values(?,?,?,?,?)";
                PreparedStatement p5=con.prepareStatement(s5);
                p5.setString(1, bdate6);
                p5.setString(2, date);
                p5.setString(3, "Sleeper");
                p5.setInt(4, seatNo);
                p5.setString(5,"Booked");
                int r9=p5.executeUpdate();
                System.out.println("Enter UPI NO");
                String Number=sc.next();
                if(Number.length()==10){
                    for(int i=0;i<10;i++){
                        if(Number.charAt(i)>=0 && Number.charAt(i)<=9){
                            System.out.println("Enter youer Total Amount :"+Totalfare);
                            double amount=sc.nextDouble();
                            if(Totalfare==amount){
                            System.out.println("payment Successfull");
                            System.out.println("Youer Tickit IS Booked");
                            System.out.println("HAPPY JOURNAY");
                            }
                        }
                    }
                    String a="insert into payments(payment_mode,payment_date,amount) values(?,?,?)";
                    PreparedStatement S=con.prepareStatement(a);
                    S.setString(1, "UPI");
                    S.setString(2, bdate6);
                    S.setDouble(3, Totalfare);
                }
                break;

                case 2:
                int CFrate=200*person6;
                double CTotalfare=CFrate*0.18+CFrate;
            
                System.out.println("Enter youer name for Billing");
                String bname=sc.next();
                System.out.println("Passenger Name :"+bname);
                System.out.println("From Station :"+FromStation);
                System.out.println("To Station :"+ToStation);
                System.out.println(" jourany date  :"+date);
                System.out.println("Booking date :"+bdate6);
                
                for(int k=0;k<=person6;k++){
                System.out.println("Seat Number : "+CseatNo);
                CseatNo++;
                }
                System.out.println("Class Name:  Sleeper");
                String s6="insert into booking(booking_date,journey_date,class,seat_number,status) values(?,?,?,?,?)";
                PreparedStatement p6=con.prepareStatement(s6);
                p6.setString(1, bdate6);
                p6.setString(2, date);
                p6.setString(3, "Sleeper");
                p6.setInt(4, CseatNo);
                p6.setString(5,"Booked");
                int r10=p6.executeUpdate();
                System.out.println("Enter cradit Card NO");
                String Craditno=sc.next();
                if(Craditno.length()==16){
                    for(int i=0;i<16;i++){
                    if(Craditno.charAt(i)>=0 && Craditno.charAt(i)<=9){
                        System.out.println("Enter youer Total Amount :"+CTotalfare);
                            double amount=sc.nextDouble();
                            if(CTotalfare==amount){
                            System.out.println("payment Successfull");
                            System.out.println("Youer Tickit IS Booked");
                            System.out.println("HAPPY JOURNAY");
                    }
                }           
                }
            }
            String a1="insert into payments(payment_mode,payment_date,amount) values(?,?,?)";
        PreparedStatement s1=con.prepareStatement(a1);
        s1.setString(1, "Cradit Card");
        s1.setString(2, bdate6);
        s1.setDouble(3, CTotalfare);
        }
                break;            
        }
        break;  
            case  3:
            System.out.println("Enter Booking ID for cancall Ticket :");
            int Bid=sc.nextInt();
            String sqlc="Delete from booking where booking_id=? ";
            PreparedStatement pst1=con.prepareStatement(sqlc);
            pst1.setInt(1, Bid);
            int r1=pst1.executeUpdate();
            String sqlc1="Delete from payment where booking_id=? ";
            PreparedStatement Pst1=con.prepareStatement(sqlc1);
            Pst1.setInt(1, Bid);
            int R1=Pst1.executeUpdate();
            
            System.out.println("Youer ticket Delete Succssfull");
            System.out.println();
            break;

            case 4 :
            System.out.println("Enter Booking ID for view Ticket :");
            int Bidv=sc.nextInt();
            String sqlv="select * from booking where booking_id=?";
            PreparedStatement pstv=con.prepareStatement(sqlv);
            pstv.setInt(1,Bidv);
            //viewticket();
            ResultSet rs=pstv.executeQuery();
            while (rs.next()) {
                System.out.println("booking_id       :"+rs.getInt(1));
                System.out.println("booking_date     :"+rs.getString(2));
                System.out.println("journey_date     :"+rs.getString(3));
                System.out.println("class            :"+rs.getString(4));
                System.out.println("seat_number      :"+rs.getInt(5));
                System.out.println("status           :"+rs.getString(6));
            }

            System.out.println("Enter booking id for Payment Details of Coustmer");
            int pid=sc.nextInt();

            String sqlv1="select * from payments where booking_id=?";
            PreparedStatement pstv1=con.prepareStatement(sqlv1);
            pstv1.setInt(1,pid);
            ResultSet Rs=pstv1.executeQuery();
            while (Rs.next()){
                System.out.println("payment_mode     :"+Rs.getString(2));
                System.out.println("payment_mode     :"+Rs.getString(3));
                System.out.println("Amount           :"+Rs.getDouble(4));
            }

            System.out.println("Enter train no for view Coustmer tarin details");
            int tno=sc.nextInt();

            String sqlv2="select * from trains where train_no=?";
            PreparedStatement pstv2=con.prepareStatement(sqlv2);
            pstv2.setInt(1,tno);
            ResultSet Rs1=pstv2.executeQuery();
            while (Rs1.next()){
                System.out.println("train_name      :"+Rs1.getString(2));
                System.out.println("origin          :"+Rs1.getString(3));
                System.out.println("destination     :"+Rs1.getString(4));
                System.out.println("departure_time  :"+Rs1.getString(5));
                System.out.println("arrival_time    :"+Rs1.getString(6));
                System.out.println("date            :"+Rs1.getString(7));
                System.out.println("availability    :"+Rs1.getInt(8));

            }
            
            break;  
    

    case 5:
    b=false;
    break;
}
        }
}
}
