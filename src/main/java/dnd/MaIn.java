package dnd;

import dnd.model.Data;
import dnd.model.Person;
import dnd.model.Rumor;
import dnd.service.Loader;

import java.io.IOException;

public class MaIn {
    public static void main(String... main) throws IOException {
        Data data = new Loader().load();

        StringBuffer buff = new StringBuffer(1000);
        for (Person person : data.people) {
            int index = (int)(Math.random() * person.rumorList.size());
            Rumor rumor = person.rumorList.get(index);

            buff.append("A rumor I know about ").append(person.name)
                    .append(", ").append(rumor.text)
                    .append(" #").append(rumor.type.ordinal()).append(index).append("\n");
        }

        System.out.println(buff.toString());

    }
}
