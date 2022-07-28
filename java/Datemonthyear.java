
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.Period;
import static java.time.temporal.ChronoUnit.DAYS;
import java.util.Date;

public class Datemonthyear {
    public static void main(String[] args) throws ParseException {
        Scanner c = new Scanner(System.in);
          System.out.println("Enter your birth date in dd-mm-yyyy format");
           String s = c.nextLine();
           boolean a1;
           a1=validateJavaDate(s);
           try{
               if(a1==false){
                   throw new ArithmeticException("This date does'nt exist ");
               }
               else{
       char[] c1=s.toCharArray();
       
       int da=(c1[0]-48)*10+(c1[1]-48);
         
       int mo=(c1[3]-48)*10+(c1[4]-48);
           
       int y=(c1[6]-48)*1000+(c1[7]-48)*100+(c1[8]-48)*10+(c1[9]-48);
       try{
         if(y<0022){
             throw new ArithmeticException("U cannot live for more 2000 years");
         }else{
       LocalDate bday = LocalDate.of(y,mo,da); 
       LocalDate today = LocalDate.now();
       System.out.println("today's date : "+today);
       Period age = Period.between(bday, today); 
       int years = age.getYears();
       int tmonths=years*12;
       int months = age.getMonths();
       
       tmonths+=months;
       int date = age.getDays();
       
       LocalDate date1 = LocalDate.of(y, mo, da); 
       LocalDate date2 =LocalDate.now(); 
    
           
       long dayBetween = DAYS.between(date1, date2);
            try{
                 if(dayBetween<0 || years<0 || tmonths<0){
                     throw new ArithmeticException("Date is yet to come");
                       }
                 else{
                     System.out.println("u have lived "+ dayBetween+" days ");
                     System.out.println("u have lived " + tmonths+" months");
                     System.out.println("u have lived "+ years+" years "  );            
                }
           }     
            catch(ArithmeticException e){
                 System.out.println("Date is yet to come");
                    }
                 }
       }        
           catch(ArithmeticException e1){
                  System.out.println("U cannot live for more 2000 years");           
                 }
              }
       }
           catch(ArithmeticException e2){
               System.out.println("This date does'nt exist ");
           }      
      }
      
       public static boolean validateJavaDate(String strDate)
      {	
       if (strDate.trim().equals(""))
       {
           return true;
       }
       
       else
           {	     
           SimpleDateFormat sdfrmt = new SimpleDateFormat("dd-MM-yyyy");
           sdfrmt.setLenient(false);
           
           try
           {
               Date javaDate = sdfrmt.parse(strDate); 
           }
          
           catch (ParseException e)
           {
               return false;
           }
           
           return true;
       }
       }
}
