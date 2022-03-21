public class Main {
    // make model for data
    public static String[] model = new String[10];

    public static void main(String[] args) {
        testAddTodoList();
    }


    //show TodoList
    public static void showTodoList(){
        for (int i = 0; i < model.length ; i++) {
                var todo = model[i];
                var no = i + 1;
                if(todo != null){
                    System.out.println(no + ". " + todo);
                }
        }
    }

//    public static void testShowTodoList(){
//        model[0] = "learn basic java";
//        model[1] = "learn OOP";
//        showTodoList();
//    }

    // addTodoList
    public static void addTodoList(String todo){
        // check full or not model data
        var isFull = true;
        // if not full
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

            for (int i = 0; i < temp.length ; i++) {
                model[i] = temp[i];
            }
        }

        // add new data
        for (int i = 0; i < model.length ; i++) {
            if(model[i] == null){
                model[i] = todo;
                break;
            }
        }
    }

    public static void testAddTodoList(){
        for (int i = 0; i < 25 ; i++) {
            addTodoList("add todo list " + i);
        }
        showTodoList();
    }

    // removeTodoList
    public static void removeTodoList(){}


}
