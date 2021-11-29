# Задача коллективного владения

## Смысл задачи:

Имеется N объектов и M субъектов, M может быть как больше, равно, так и меньше N. Каждый субъект может быть способным
владеть некоторым подмножеством из N (например N1, N2, N3) - SN. Каждый субъект в некоторый момент времени может владеть
некоторыми объектами из своего подмножества SN. В каждый момент времени одним объектом может владеть только один
субъект.

## Ключевые моменты:

* Субъекты могут добавляться и удаляться из системы по одному за одно решение задачи распределения (то есть
  гарантируется что в процессе решения задачи агенты не будут удаляться и добавляться)
* Субъект может быть владельцем только тех объектов, которые находятся в подмножестве его допустимых объектов
* Распределение должно быть справедливым и стремиться к равномерному распределению среди субъектов
* Распределение должно быть устойчивым, то есть при добавлении или удалении субъекта не должен происходить сброс
  состояния и полный перерасчет, а должно производиться снятие владения и назначение владения в соответствии с новой
  диспозицией.
* Должна быть возможность для некоторого субъекта (при инициализации) задать параметр, который будет позволять ему
  становиться владельцем только в том случае, если нет других кандидатов (то есть субъект должен избегать становиться
  владельцем).
* Объект может находиться без владения кем-то только в том случае, если нет субъекта, в чьем подмножестве допустимого
  владения присутствует данный объект.
* Если субъект имеет приоритет LOWPRIO, то он становится владельцем, только в том случае, если нет владельца нормального
  приоритета и передает владение при появлении владельца нормального приоритета.

## Реализация:

Созданы 2 класса объект ObjectN и субъект SubjectM:

### Класс ObjectN

* Флаг boolean ableToOwn, обозначающий есть ли у объекта владелец

### Класс SubjectM

* TreeMap для хранения объектов по ключу(id) и автоматической сортировки
* Флаг boolean canOwn обозначающий может ли субъект владеть объектами
* Приоритет (enum Priorities)
* 2 конструктора для создания дефолтного экземпляра и экземпляра с пониженным приоритетом 