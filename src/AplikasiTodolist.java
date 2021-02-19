public class AplikasiTodolist {

    public static String[] model = new String[10];

    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void main(String[] args) {
        viewShowTodoList();
    }

    /**
     * Show Todolist
     */

    public static void showTodoList(){
        System.out.println("TODOLIST");
        for (var i = 0; i < model.length; i++){
            var todo = model[i];
            var no = i + 1;

            if (todo != null){
                System.out.println(no + ". " + todo);
            }
        }
    }

    public static void testShowTodoList(){
        model[0] = "Learn Basic Java";
        model[1] = "Learn build todo apps in java";
        showTodoList();
    }

    /**
     * Add TodoList
     */

    public static void addTodoList(String todo){
        //check it if it is full or not?
        var isFull = true;
        for (int i = 0; i < model.length; i++) {
            if (model[i] == null) {
                //model is still have an empty space
                isFull = false;
                break;
            }
        }

        //if array is full, rezise the size of array 2x

        if(isFull){
            var temp = model;
            model = new String[model.length * 2];

            for (int i = 0; i < temp.length; i++){
                model[i] = temp[i];
            }
        }

        //add to the position that array is null
        for (var i = 0; i < model.length; i++){
            if (model[i] == null){
                model[i] = todo;
                break;
            }
        }
    }

    public static void testAddTodoList(){
        for (var i = 0; i < 25; i++){
            addTodoList("looping " + i);
        }

        showTodoList();
    }

    /**
     * Remove TodoList
     */

    public static boolean removeTodoList(Integer number){
        if ((number - 1) >= model.length){
            return false;
        }else if (model[number - 1] == null) {
            return false;
        }else {
            model[number - 1] = null;

            for (int i = (number - 1); i < model.length ; i++) {
                if (i == (model.length - 1)) {
                    model[i] = null;
                }else {
                    model[i] = model [i + 1];
                }
            }
            return true;
        }
    }

    public static void testRemoveTodoList(){
        addTodoList("satu");
        addTodoList("dua");
        addTodoList("tiga");
        addTodoList("empat");
        addTodoList("lima");

        var result = removeTodoList(20);
        System.out.println(result);

        result = removeTodoList(7);
        System.out.println(result);

        result = removeTodoList(2);
        System.out.println(result);

        showTodoList();
    }

    public static String input(String info) {
        System.out.print(info + " : ");
       String data = scanner.nextLine();
       return data;
    }

    public static void testInput(){
        var name = input("Name");
        System.out.println("Hi " + name);

        var channel = input("Channel");
        System.out.println(channel);
    }

    /**
     * View Show Todolist
     */
    public static void viewShowTodoList(){
        while (true) {
            showTodoList();
            System.out.println("MENU");
            System.out.println("1. Add");
            System.out.println("2. Delete");
            System.out.println("x. Exit");

            var input = input("Choose");
            if (input.equals("1")){
                viewAddTodoList();
            }else if (input.equals("2")){
                viewRemoveTodoList();
            }else if (input.equals("x")){
                break;
            }else {
                System.out.println("Incorrect choosen");
            }
        }
    }

    public static void testViewShowTodoList() {
        addTodoList("One");
        addTodoList("Two");
        addTodoList("Three");
        addTodoList("Four");
        addTodoList("Five");
        viewShowTodoList();
    }

    /**
     * View Add Todolist
     */
    public static void viewAddTodoList(){
        System.out.println("ADD TODOLIST");

        var todo = input("Todo (Press x to Cancel)");

        if (todo.equals("x")){

        }else {
            addTodoList(todo);
        }
    }

    public static void testViewAddTodoList(){

        addTodoList("one");
        addTodoList("two");
        viewAddTodoList();

        showTodoList();
    }

    /**
     * View Delete Todolist
     */
    public static void viewRemoveTodoList(){
        System.out.println("DELETE TODOLIST");

        var number = input("NUMBER THAT YOU WANT TO DELETE (Press x to Cancel)");

        if (number.equals("x")){
            //cancel
        }else {
           boolean success = removeTodoList(Integer.valueOf(number));
           if (!success){
               System.out.println("Failed to delete todolist " + number);
           }
        }

    }

    public static void testViewRemoveTodoList(){
        addTodoList("one");
        addTodoList("two");
        addTodoList("three");

        showTodoList();

        viewRemoveTodoList();

        showTodoList();
    }

}
