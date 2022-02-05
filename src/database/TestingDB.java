/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import static java.lang.System.exit;
import java.util.Scanner;

/**
 *
 * @author ksaum
 */
public class TestingDB {
    public static void main(String[] args) {
        Scanner o=new Scanner(System.in);
        DbCon obj=new DbCon();
        obj.dbConnect("Saumya");
        
        
        while(true)
        {
            System.out.println("Enter 1.insert 2.display 3.update 4.delete 5.exit");
            int choice=o.nextInt();
            switch(choice)
            {
                case 1:
                        System.out.println("Enter Eid,Ename and City");
                        int Eid=o.nextInt();
                        String Ename=o.next();
                        String City=o.next();
                        obj.insert(Eid,Ename,City);
                        break;
                case 2:
                        obj.display();
                        break;
                case 3:
                        System.out.println("Enter Eid of employee whose Ename and City you want to change");
                        int id=o.nextInt();
                        System.out.println("Enter choice to update 1.Ename 2.City 3.both");
                        int ch=o.nextInt();
                        if(ch==1){
                            System.out.println("Enter updated Ename");
                            String name=o.next();
                            obj.update(id,name,null);
                        }
                        else if(ch==2){
                            System.out.println("Enter updated City");
                            String city=o.next();
                            obj.update(id,null,city);
                        }
                        else{
                            System.out.println("Enter updated Ename and city");
                            String name=o.next();
                            String city=o.next();
                            obj.update(id,name,city);
                        }
                        break;
                case 4: 
                        System.out.println("Enter Eid of employee whose data we want to delete");
                        int eid=o.nextInt();
                        obj.delete(eid);
                        break;
                case 5:
                        exit(0);
                        break;
            }
        }
    }
}
/*run:
connected successfully
Enter 1.insert 2.display 3.update 4.delete 5.exit
1
Enter Eid,Ename and City
4 shiva delhi
inserted successfully
Enter 1.insert 2.display 3.update 4.delete 5.exit
2
===================================================
Eid	Ename	City	
===================================================
123	punny	chhapra
124	sunny	chhapra
125	shivani	Bikaner
127	pihu	patna
128	saumya	buxar
2	manisha	patna
3	jaya	mumbai
4	shiva	delhi
Enter 1.insert 2.display 3.update 4.delete 5.exit
3
Enter Eid of employee whose Ename and City you want to change
3
Enter choice to update 1.Ename 2.City 3.both
3
Enter updated Ename and city
rekha delhi
updated successfully
Enter 1.insert 2.display 3.update 4.delete 5.exit
2
===================================================
Eid	Ename	City	
===================================================
123	punny	chhapra
124	sunny	chhapra
125	shivani	Bikaner
127	pihu	patna
128	saumya	buxar
2	manisha	patna
3	rekha	delhi
4	shiva	delhi
Enter 1.insert 2.display 3.update 4.delete 5.exit
3
Enter Eid of employee whose Ename and City you want to change
3
Enter choice to update 1.Ename 2.City 3.both
1
Enter updated Ename
jaya
updated successfully
Enter 1.insert 2.display 3.update 4.delete 5.exit
2
===================================================
Eid	Ename	City	
===================================================
123	punny	chhapra
124	sunny	chhapra
125	shivani	Bikaner
127	pihu	patna
128	saumya	buxar
2	manisha	patna
3	jaya	delhi
4	shiva	delhi
Enter 1.insert 2.display 3.update 4.delete 5.exit
3
Enter Eid of employee whose Ename and City you want to change
3
Enter choice to update 1.Ename 2.City 3.both
2
Enter updated City
mumbai
updated successfully
Enter 1.insert 2.display 3.update 4.delete 5.exit
2
===================================================
Eid	Ename	City	
===================================================
123	punny	chhapra
124	sunny	chhapra
125	shivani	Bikaner
127	pihu	patna
128	saumya	buxar
2	manisha	patna
3	jaya	mumbai
4	shiva	delhi
Enter 1.insert 2.display 3.update 4.delete 5.exit
4
Enter Eid of employee whose data we want to delete
4
deleted successfully
Enter 1.insert 2.display 3.update 4.delete 5.exit
2
===================================================
Eid	Ename	City	
===================================================
123	punny	chhapra
124	sunny	chhapra
125	shivani	Bikaner
127	pihu	patna
128	saumya	buxar
2	manisha	patna
3	jaya	mumbai
Enter 1.insert 2.display 3.update 4.delete 5.exit
5
BUILD SUCCESSFUL (total time: 2 minutes 19 seconds)
*/