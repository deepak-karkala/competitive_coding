"""
An animal shelter, which holds only dogs and cats, operates on a strictly
"first in, first out"basis. People must adopt either the"oldest"(based on arrival
time) of all animals at the shelter, or they can select whether they would prefer
a dog or a cat (and will receive the oldest animal of that type). They cannot
select which specific animal they would like. Create the data structures to
maintain this system and implement operations such as enqueue, dequeueAny,
dequeueDog, and dequeueCat.
"""


class Animal:
    def __init__(self, name):
        self.name = name
        self.order = -1

    def set_order(self, order):
        self.order = order

    def get_order(self):
        return self.order

    def is_older_than(self, animal):
        return self.order >= animal.get_order()


class Cat(Animal):
    pass


class Dog(Animal):
    pass


class AnimalQueue:
    def enqueue(self, animal):
        pass

    def dequeue_any(self):
        pass

    def dequeue_cat(self):
        pass

    def dequeue_dog(self):
        pass


if __name__ == "__main__":
    animal_shelter = AnimalQueue()
    animal_shelter.enqueue(Dog("dog1"))
    animal_shelter.enqueue(Dog("dog2"))
    animal_shelter.enqueue(Dog("cat1"))
    animal_shelter.enqueue(Dog("dog3"))
    animal_shelter.enqueue(Dog("cat2"))
    print(animal_shelter.dequeue_any())
    print(animal_shelter.dequeue_cat())
    print(animal_shelter.dequeue_dog())
