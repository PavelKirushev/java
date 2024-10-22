import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


public class Main {


    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        Map<String, Date> map = new HashMap<>();
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        for(int i = 0; i < 10; i ++){
            String name = scanner.nextLine();
            String date = scanner.nextLine();
            map.put(name, format.parse(date));
        }
        Iterator<Map.Entry<String, Date>> iterator = map.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<String, Date> pair = iterator.next();
            Calendar cal = Calendar.getInstance();
            cal.setTime(pair.getValue());
            int m = cal.get(Calendar.MONTH);
            if (m >= 5 && m <= 7){
                iterator.remove();
            }
        }
        for(Map.Entry<String, Date> pair: map.entrySet()){
            System.out.println(pair.getKey() + " " + pair.getValue());
        }
    }
}

/*
Олег Цыганков
27.09.2005
Владик
10.01.2005
Керил
05.05.2006
Артем не помню
01.01.2001
Паштет
19.03.2005
Мама
13.03.1985
Настька
22.12.2005
Челик
13.06.2005
Челик2
13.07.2005
Челик3
13.08.2005
 */