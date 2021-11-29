import objects.ObjectN;
import objects.SubjectM;
import priorities.Priorities;

import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        Map<Integer, ObjectN> objectsN = new TreeMap<>(){{
            put(1, new ObjectN());
            put(2, new ObjectN());
            put(3, new ObjectN());
            put(4, new ObjectN());
            put(5, new ObjectN());
            put(6, new ObjectN());
        }};

        SubjectM subjectM1 = new SubjectM();
        SubjectM subjectM2 = new SubjectM();
        SubjectM lowPrio = new SubjectM(Priorities.LOWPRIO);

        subjectM1.getObjectsNToOwn(objectsN, 1, 2, 3);
        System.out.println(subjectM1);

        subjectM1.clearSubject(objectsN);
        System.out.println(subjectM1);

        subjectM2.getObjectsNToOwn(objectsN, 3, 4, 5);
        System.out.println(subjectM2);

        lowPrio.getObjectsNToOwn(objectsN,4, 5, 6);
        System.out.println(lowPrio);
    }
}
