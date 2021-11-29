package objects;

import priorities.Priorities;

import java.util.Map;
import java.util.TreeMap;

public class SubjectM {
    //Подмножество Субъектов
    private Map<Integer, ObjectN> subjectsM = new TreeMap<>();
    //Может владеть объектами
    private boolean canOwn = true;
    //Приоритет
    private Priorities priority;

    //По умолчанию при создании экземпляра он может владеть объектами и у него нормальный приоритет
    public SubjectM() {
        this.priority = Priorities.NORMPRIO;
    }

    //Задаем приоритет при создании экземпляра
    public SubjectM(Priorities priority) {
        this.priority = priority;
    }

    public Map<Integer, ObjectN> getSubjectsM() {
        return subjectsM;
    }

    public Map<Integer, ObjectN> getObjectsNToOwn(Map<Integer, ObjectN> objectsN, Integer... id) throws IndexOutOfBoundsException{
        //Если Субъект может владеть объектами
        if (this.canOwn) {
            for (int i = 0; i < id.length; i++) {
                for (Map.Entry<Integer, ObjectN> entry : objectsN.entrySet()) {
                    //Если мы находим нужный объект
                    if (entry.getKey().equals(id[i])) {
                        //Если нельзя владеть объектом или задан приоритет LOW, то продолжается цикл
                        if (entry.getValue().isAbleToOwn()) {
                            this.subjectsM.put(entry.getKey(), entry.getValue());
                            entry.getValue().setAbleToOwn(false);
                        }
                    }
                }
            }
            this.canOwn = false;
        }
        return subjectsM;
    }

    //Метод для очищения коллекции объектов
    public boolean clearSubject(Map<Integer, ObjectN> objectsN) {
        if (subjectsM.isEmpty()) {
            return false;
        } else {
            for (Map.Entry<Integer, ObjectN> entryObj : objectsN.entrySet()) {
                for (Map.Entry<Integer, ObjectN> entrySubj : subjectsM.entrySet()) {
                    if (entrySubj.equals(entryObj)) {
                        entryObj.getValue().setAbleToOwn(true);
                    }
                }
            }
            subjectsM.clear();
            canOwn = true;
            return true;
        }
    }

    @Override
    public String toString() {
        return subjectsM.entrySet().toString();
    }
}
