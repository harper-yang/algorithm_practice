package harper.github.io.queueAndStack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 猫狗队列
 *
 * @Project Test4(harper.github.io.queueAndStack)
 * @Author  yangzhao
 * @Date    2020/9/29 下午5:44
 * @Version 3.0
 */
public class Test4 {

    public static void main(String[] args) {

    }

    public class DogCatQueue {
        private Queue<PetEnterQueue> dogQ;
        private Queue<PetEnterQueue> catQ;
        private Long count;

        public DogCatQueue() {
            this.dogQ = new LinkedList<>();
            this.catQ = new LinkedList<>();
            this.count = 0L;
        }

        public void add(Pet pet) {
            if (pet.getType().equals("dog")) {
                this.dogQ.add(new PetEnterQueue(pet, this.count++));
            } else if (pet.getType().equals("cat")) {
                this.catQ.add(new PetEnterQueue(pet, this.count++));
            } else {
                throw new RuntimeException("error type");
            }
        }

        public Pet pollAll() {
            if (!this.dogQ.isEmpty() && !this.catQ.isEmpty()) {
                if (this.dogQ.peek().getCount() < this.catQ.peek().getCount()) {
                    return this.dogQ.poll().getPet();
                } else {
                    return this.catQ.poll().getPet();
                }
            } else if (!this.dogQ.isEmpty()) {
                return this.dogQ.poll().getPet();
            } else if (!this.catQ.isEmpty()) {
                return this.catQ.poll().getPet();
            } else {
                throw new RuntimeException("queue is empty");
            }
        }

    }

    public static class PetEnterQueue {
        private Pet pet;
        private Long count;

        public PetEnterQueue(Pet pet, Long count) {
            this.pet = pet;
            this.count = count;
        }

        public Pet getPet() {
            return this.pet;
        }

        public Long getCount() {
            return this.count;
        }

        public String getPetType() {
            return this.pet.getType();
        }
    }

    public static class Pet {

        private String type ;

        public Pet(String type) {
            this.type = type;
        }

        public String getType() {
            return type;
        }
    }

    public static class Dog extends Pet{

        public Dog() {
            super("dog");
        }
    }
    public static class Cat extends Pet{

        public Cat() {
            super("cat");
        }
    }
}
