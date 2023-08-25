package commands;

import commandsLogic.CollectionManager;
import manager.MessageToSer;
import response.ResponseFormer;

import java.util.Objects;

public class HelpCommand implements Command {
    public static final String NAME = "help";
    private final CollectionManager manager;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HelpCommand that = (HelpCommand) o;
        return Objects.equals(manager, that.manager);
    }

    @Override
    public int hashCode() {
        return Objects.hash(manager);
    }


    public HelpCommand(CollectionManager manager) {
        this.manager = manager;
    }

    @Override
    public CommandStatus execute(MessageToSer message) {
        ResponseFormer.appendLine("""
                help : вывести справку по доступным командам
                info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)
                show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении
                add {element} : добавить новый элемент в коллекцию
                update_id{element} : обновить значение элемента коллекции, id которого равен заданному
                remove_by_id id : удалить элемент из коллекции по его id
                clear : очистить коллекцию
                save : сохранить коллекцию в файл
                execute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.
                exit : завершить программу (без сохранения в файл)
                отсортировать коллекцию в порядке, обратном нынешнему
                sort : отсортировать коллекцию в естественном порядке
                history : вывести последние 7 команд (без их аргументов)
                sum_of_age : вывести сумму значений поля age для всех элементов коллекции
                max_by_coordinates : вывести любой объект из коллекции, значение поля coordinates которого является максимальным
                filter_contains_name name : вывести элементы, значение поля name которых содержит заданную подстроку""");
        return new CommandStatus("help command",true);
    }

    @Override
    public String getName() {
        return NAME;
    }

}
