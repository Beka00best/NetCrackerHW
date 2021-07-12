package week1;

import java.util.Date;
import java.util.HashMap;

public class HumanController {
    public static void main(String[] args) {
        Address[] addresses = new Address[5];
        addresses[0] = new Address("проспект Победы", 12, 254);
        addresses[1] = new Address("проспект Независимости", 1, 79);
        addresses[2] = new Address("улица Гагарина", 26, 408);
        addresses[3] = new Address("проспект Победы", 20, 28);
        addresses[4] = new Address("Брежневская улица", 4, 21);

        Human[] humans = new Human[5];
        humans[0] = new Human("Иванов", "Иван", 36, addresses[0], new Date(1985, 5, 12));
        humans[1] = new Human("Аркадиевна", "Маргарита", 20, addresses[1], new Date(2000, 11, 3));
        humans[2] = new Human("Павлов", "Павел", 28, addresses[2], new Date(1993, 2, 14));
        humans[3] = new Human("Павлов", "Сергей", 19, addresses[3], new Date(2002, 6, 8));
        humans[4] = new Human("Брежнева", "Екатерина", 42, addresses[4], new Date(1979, 1, 20));
        
        System.out.println("1. Поиск по фамилии");
        Human h1 = findSurname(humans, "Павлов");
        System.out.println(h1);
        h1 = findSurname(humans, "Петров");
        System.out.println(h1);
        System.out.println();

        System.out.println("2. Поиск по улице");
        Human h2 = findStreet(humans, "Майданская улица");
        System.out.println(h2);
        h2 = findStreet(humans, "переулок");
        System.out.println(h2);
        System.out.println();

        System.out.println("3. Поиск по номеру дома");
        Human h3 = findHouse(humans, 4);
        System.out.println(h3);
        h3 = findHouse(humans, 120);
        System.out.println(h3);
        System.out.println();

        System.out.println("4. Поиск по номеру квартиры");
        Human h4 = findFlat(humans, 254);
        System.out.println(h4);
        h4 = findFlat(humans, 120);
        System.out.println(h4);
        System.out.println();

        System.out.println("5. Вывод людей между датами");
        Date d1 = new Date(1984, 1, 1);
        Date d2 = new Date(2000, 11, 25);
        System.out.println("d1 = " + d1.getDay() + "." + d1.getMonth() + "." + d1.getYear());
        System.out.println("d2 = " + d2.getDay() + "." + d2.getMonth() + "." + d2.getYear());
        betweenDates(humans, d1, d2);
        System.out.println();

        System.out.println("6. Поиск самого молодого(старого)");
        Human old = findAge(humans, true);
        System.out.println("Старый: " + old);
        Human youn = findAge(humans, false);
        System.out.println("Молодой: " + youn);
        System.out.println();

        System.out.println("7. Поиск людей, проживающих на одной улице:");
        Human[] hum = findSameStree(humans);
        for (Human h : hum)
            System.out.println(h);
    }

    // поиск человека по фамилии
    public static Human findSurname(Human[] humans, String surname){
        for(Human h : humans){
            if(h.getSurname().equals(surname))
                return h;
        }
        return null;
    }

    // поиск человека по улице
    public static Human findStreet(Human[] humans, String street){
        for(Human h : humans){
            if(h.getAddress().getStreet().equals(street))
                return h;
        }
        return null;
    }

    // поиск человека по номеру дома
    public static Human findHouse(Human[] humans, int house){
        for(Human h : humans){
            if(h.getAddress().getHouse() == house)
                return h;
        }
        return null;
    }


    // поиск человека по номеру квартиры
    public static Human findFlat(Human[] humans, int flat){
        for(Human h : humans){
            if(h.getAddress().getFlat() == flat)
                return h;
        }
        return null;
    }

    // вывод людей, родившихся между заданными датами
    public static void betweenDates(Human[] humans, Date d1, Date d2){
        for(Human h : humans){
            if(h.getBirth().getTime() > Math.min(d1.getTime(), d2.getTime()) && h.getBirth().getTime() < Math.max(d1.getTime(), d2.getTime()))
                System.out.println(h);
        }
    }

    // поиск самого старого(молодого)
    public static Human findAge(Human[] humans, boolean old){
        if(humans.length == 0)
            return null;
        if(old){
            Human older = humans[0];
            int max = humans[0].getAge();
            for(Human h : humans) {
               if(h.getAge() > max){
                   older = h;
                   max = h.getAge();
               }
            }
            return older;
        }else{
            Human younger = humans[0];
            int min = humans[0].getAge();
            for(Human h : humans) {
                if(h.getAge() < min){
                    younger = h;
                    min = h.getAge();
                }
            }
            return younger;
        }
    }

    // поиск людей, проживающих на одной улице
    public static Human[] findSameStree(Human[] humans){
        if(humans.length == 0)
            return null;
        HashMap<String, Integer> stats = new HashMap<>();

        int maxHumansCount = 1;
        String maxStr = humans[0].getAddress().getStreet();
        for(Human h : humans){
            String street = h.getAddress().getStreet();
            if(!stats.containsKey(street)){
                stats.put(street, 1);
            }else {
                int count = stats.get(street);
                count++;
                stats.replace(street, count);
                if(count > maxHumansCount){
                    maxHumansCount = count;
                    maxStr = street;
                }
            }
        }

        Human[] res = new Human[maxHumansCount];
        int i = 0;
        for(Human h : humans){
            if(i >= maxHumansCount)
                break;
            if(h.getAddress().getStreet().equals(maxStr)) {
                res[i] = h;
                i++;
            }
        }
        return res;
    }
}
