
public class Main {
    public static void main(String[] args) {
        MyQueue<Integer> myQueue = new MyQueue<>();

        for (int i = 1; i < 100; i++) {
            if(i % 5 == 0)myQueue.push(i);
        }

//        myQueue.pop();
//        myQueue.pop();
//        myQueue.pop();

        System.out.println(myQueue);

//        while(!myQueue.isEmpty()){
//            myQueue.pop();
//        }

        int front = myQueue.front();
        int back = myQueue.back();

        System.out.println("Back value: "+ back);
        System.out.println("Front value: "+ front);

//        System.out.println(myQueue);

    }
}
