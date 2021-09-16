package dnd;

import dnd.model.Data;
import dnd.model.Person;
import dnd.model.Rumor;
import dnd.service.Loader;

import java.io.IOException;

public class MaIn {
    final static String TUES = "rumors.json";
    final static String THURS = "rumors2.json";
    public static final boolean NEWGAME = false;

    public static void main(String... main) throws IOException {
        Data data = new Loader().load(THURS);

        generateMyRumors(data, null);
        if(NEWGAME) {
            for (Person person : data.people) {
                generateMyRumors(data, person);
            }
        }

    }

    private static void generateMyRumors(Data data, Person whom) {
        StringBuffer buff = new StringBuffer(1000);
        if (whom == null) {
            buff.append("\nDM, These are commonly held rumors.\n\n");
        } else {
            buff.append("\nDM, Send this to : " + whom.name+"\n\n");
        }
        for (Person person : data.people) {
            if (person /*same as*/ == whom) continue;
            int index = (int) (Math.random() * person.rumorList.size());
            Rumor rumor = person.rumorList.get(index);

            buff.append("A rumor I know about ").append(person.name)
                    .append(", ").append(rumor.text)
                    .append(" #").append(rumor.type.ordinal()).append(index).append("\n");
        }

        System.out.println(buff.toString());
    }
}
