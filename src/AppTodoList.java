public class AppTodoList {
    public static String[] model = new String[10];
    public static java.util.Scanner scanner  = new java.util.Scanner(System.in);
    public static void main(String[] args) {
        viewShowTodoList();
    }
    // business logic

    /**
     * show TodoList
     */
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

    public static void testShowTodoList(){
        model[0] = "learn basic java";
        model[1] = "learn OOP Java";
        showTodoList();
    }

    /**
     * add TodoList
     */
    public static void addTodoList(String todo){
        // check model is empty?
        var isFull = true;
        for (int i = 0; i <model.length ; i++) {
            if(model[i] == null){
                isFull = false;
                break;
            }
        }

        // if full we resize the size to be 2X
        if(isFull){
            var temp = model;
            model = new String[model.length * 2];

            for (int i = 0; i < temp.length ; i++) {
                model[i] = temp[i];
            }
        }

        // add in position data Array null
        for (int i = 0; i < model.length ; i++) {
            if(model[i] == null){
                model[i] = todo;
                break;
            }
        }

    }

    public static void testAddTodoList(){
        for (int i = 0; i < 25 ; i++) {
            addTodoList("Example to do to- " + i);
        }
        showTodoList();
    }

    /**
     * remove TodoList
     */
    public static boolean removeTodoList(Integer number){
        // check if number bigger than total
        if((number-1) >= model.length){
            return false;
        }else if(model[number-1] == null){
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

    public static void testRemoveTodoList(){
        addTodoList("one");
        addTodoList("two");
        addTodoList("three");
        addTodoList("four");
        addTodoList("five");

        var result = removeTodoList(20);
        System.out.println(result);

        result = removeTodoList(7);
        System.out.println(result);

        result = removeTodoList(2);
        System.out.println(result);

        showTodoList();
    }

    public static String input(String info){
        System.out.print(info + ":");
        String data = scanner.nextLine();
        return data;
    }

    public static void testInput(){
        var data = input("name");
        System.out.println("hi " + data);
        var data2 = input("task");
        System.out.println("task " + data2);
    }

    //show View TodoList
    public static void viewShowTodoList(){
        while (true) {
            showTodoList();
            System.out.println("MENU");
            System.out.println("1. Addition");
            System.out.println("2. Remove");
            System.out.println("x. Exit");
            var input = input("select");
            if(input.equals("1")){
                viewAddTodoList();
            }else if (input.equals("2")) {
                viewRemoveTodoList();
            }else if(input.equals("x")){
                break;
            }else{
                System.out.println("option not understand");
            }
        }

    }

    public static void testViewShowTodoList(){
        addTodoList("ONE");
        addTodoList("TWO");
        addTodoList("THREE");
        addTodoList("FOUR");
        viewShowTodoList();
    }

    //show view Add TodoList
    public static void viewAddTodoList(){
        System.out.println("ADD TODOLIST");
        var input = input("please input(x if cancel)");
        if(input.equals("x")){
            // cancel
        }else{
            addTodoList(input);
        }
    }

    public static void testViewAddTodoList(){
        addTodoList("one");
        addTodoList("two");

        viewAddTodoList();

        showTodoList();
    }

    //show view Remove TodoList
    public static void viewRemoveTodoList(){
        System.out.println("REMOVE TODOLIST");
        var input = input("please add number for remove(x if cancel)");

        if(input.equals("x")){
            // x cancel
        }else{
          boolean success = removeTodoList(Integer.valueOf(input));
          if(!success){
              System.out.println("fail to remove " + input);
          }
        }

    }

    public static void testViewRemoveTodoList(){
        addTodoList("one");
        addTodoList("two");
        addTodoList("three");
        addTodoList("four");
        showTodoList();
        viewRemoveTodoList();
        showTodoList();
    }
}
