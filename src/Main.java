public class Main {
    // making model for data
    public static java.util.Scanner scanner = new java.util.Scanner(System.in);
    public static String[]model = new String[10];

    public static void main(String[] args) {
       viewShowTodoList();
    }

    // making business logic

    // making showTodoList
    public static void showTodoList(){
        System.out.println("TODOLIST");
        for (int i = 0; i <model.length ; i++) {
            var todo = model[i];
            var no = i + 1;
            if(todo != null){
                System.out.println(no + ". " + todo);
            }
        }
    }

    // testing testShowTodoList
    public static void testShowTodoList(){
        model[0] = "learn java basic";
        model[1] = "learn java OOP";
        showTodoList();
    }

    // make addTodoList
    public static void addTodoList(String todo){
        // check is data or model full?
        var isFull = true;
        for (int i = 0; i < model.length ; i++) {
            if(model[i] == null){
                isFull = false;
                break;
            }
        }


        // if full
        if(isFull){
            var temp = model;
            model = new String[model.length*2];

            for (int i = 0; i <temp.length ; i++) {
                model[i] = temp[i];
            }
        }

        // if not full add in here
        for (int i = 0; i < model.length ; i++) {
            if(model[i] == null){
                model[i] = todo;
                break;
            }
        }
    }

    // making test addTodoList
    public static void testAddTodoList(){
        for (int i = 0; i < 25 ; i++) {
            addTodoList("todo to- " + i);
        }
        showTodoList();
    }

    // making removeTodoList
    public static boolean removeTodoList(Integer number){
        if(number-1 > model.length){
            return false;
        }else if(model[number -1 ] == null){
            return false;
        }else{
            for (int i = number-1; i < model.length ; i++) {
                if(i == (model.length-1)){
                    model[i] = null;
                }else{
                    model[i] = model[i + 1];
                }
            }
            return true;
        }
    }

    // testing removeTodoList
    public static void testRemoveTodoList(){
        addTodoList("one");
        addTodoList("two");
        addTodoList("three");

        showTodoList();

        var remove = removeTodoList(4);
        System.out.println(remove);

        remove = removeTodoList(7);
        System.out.println(remove);

        remove = removeTodoList(2);
        System.out.println(remove);

        showTodoList();
    }

    // making input
    public static String input(String  info){
        System.out.print("enter " + info);
        var data = scanner.nextLine();
        return data;
    }

    // making view App

    // making viewShowTodoList
    public static void viewShowTodoList(){

        while(true){
            showTodoList();
            System.out.println("MENU");
            System.out.println("1. ADDITION");
            System.out.println("2. REMOVE");

            var input = input("enter menu(x if cancel)");
            if(input.equals("x")){
                break;
            }else if(input.equals("1")){
                viewAddTodoList();
            }else if(input.equals("2")){
                viewRemoveTodoList();
            }else{
                System.out.println("not found whats your add");
            }
        }
    }

    // testing testViewShowTodoList
    public static void testViewShowTodoList(){
        addTodoList("ONE");
        addTodoList("TWO");
        addTodoList("THREE");

        viewShowTodoList();
    }

    // making viewAddTodoList
    public static void viewAddTodoList(){
        showTodoList();
        System.out.println("ADD TODOLIST");
        var input = input("enter data(x if cancel)");
        if(input.equals("x")){
            // cancel
        }else{
            addTodoList(input);
        }
    }

    public static void testViewAddTodoList(){
        addTodoList("ONE");
        addTodoList("TWO");
        addTodoList("THREE");
        viewAddTodoList();
        showTodoList();
    }

    // making viewRemoveTodoList
    public static void viewRemoveTodoList(){
        showTodoList();
        System.out.println("REMOVE TODOLIST");
        var input = input("enter data(x if cancel)");
        if(input.equals("x")){
            // cancel
        }else{
            boolean success = removeTodoList(Integer.valueOf(input));
            if(!success){
                System.out.println("data " + input + " fail to remove");
            }
        }
    }

    public static void testViewRemoveTodoList(){
        addTodoList("ONE");
        addTodoList("TWO");
        addTodoList("THREE");
        viewRemoveTodoList();
        showTodoList();
    }

}
