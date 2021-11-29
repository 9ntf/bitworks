import objects.ObjectN;
import objects.SubjectM;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import priorities.Priorities;

import java.util.Map;
import java.util.TreeMap;

public class SubjectMTest {
    private SubjectM subjectMTest = new SubjectM();
    private Map<Integer, ObjectN> objectsN = new TreeMap<>();

    //Коллекция для тестов
    @BeforeEach
    public void init() {
        for (int i = 0; i < 6; i++) {
            objectsN.put(i, new ObjectN());
        }
    }

    //Тест очистки субъекта, который не владеет объектами
    @Test
    public void testClearSubjectWithEmptyCollection_success() {
        Assertions.assertFalse(subjectMTest.clearSubject(objectsN));
    }

    //Тест очистки субъекта, который владеет объектами
    @Test
    public void testClearSubjectWithNotEmptyCollection_success() {
        subjectMTest.getObjectsNToOwn(objectsN, 1, 2, 3);
        Assertions.assertTrue(subjectMTest.clearSubject(objectsN));
    }
}
