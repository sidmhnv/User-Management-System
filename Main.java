
import java.util.*;

public class Main{
    public static void main(String[] args) {
        //step1: fetch data
//        User u1=new User("Siddhesh", true, new HashSet<String>(Arrays.asList("Admin","User")));
//        List<User> users=new ArrayList<>();
//        users.add(u1);
        //list of all users
        List<User> users=new ArrayList<>();
        users.add(new User("Siddhesh", true, new HashSet<String>(Arrays.asList("CEO","Responsible"))));
        users.add(new User("Manasvi", true, new HashSet<String>(Arrays.asList("CTO","Responsible"))));
        users.add(new User("Jayesh", false, new HashSet<String>(Arrays.asList("BugIdentifier","Irresponsible","Lazy"))));


        //step2: remove inactive users
        Iterator<User> iterator = users.iterator();
        while(iterator.hasNext()){
            User u=iterator.next();
            if(!u.isActive()) {
                System.out.println(u.getName()+" is lazy");
                iterator.remove();
            }
        }
        System.out.println("Active users are as followed: ");
        for(User u1:users){
            if(u1.isActive()) System.out.println(u1.getName());
        }

        //step3: count user per role using map
        Map<String, Integer> roleCount= new HashMap<>();
        for(User u2 : users){
            for(String role:u2.getRoles()){
                roleCount.put(role,roleCount.getOrDefault(role,0)+1);
            }
        }
        for(Map.Entry<String,Integer> entry:roleCount.entrySet()){
            System.out.println(entry.getKey()+": "+entry.getValue());
        }

    }
}