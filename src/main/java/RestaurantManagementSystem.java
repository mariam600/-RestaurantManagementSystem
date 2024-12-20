// Singleton for Order Manager
class OrderManager {
    private static OrderManager instance;

    private OrderManager() {
        // Private constructor to ensure only one instance
    }

    public static OrderManager getInstance() {
        if (instance == null) {
            instance = new OrderManager();
        }
        return instance;
    }

    public void processOrder(String orderDetails) {
        System.out.println("Order processed: " + orderDetails);
    }
}

// Singleton for Payment System
class PaymentSystem {
    private static PaymentSystem instance;

    private PaymentSystem() {
        // Private constructor to ensure only one instance
    }

    public static PaymentSystem getInstance() {
        if (instance == null) {
            instance = new PaymentSystem();
        }
        return instance;
    }

    public void processPayment(double amount) {
        System.out.println("Payment processed: $" + amount);
    }
}

// Abstract class for Menu Items
abstract class MenuItem {
    protected String name;
    protected double price;

    public MenuItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public abstract void prepare();
}

// Concrete Menu Item classes
class Appetizer extends MenuItem {
    public Appetizer(String name, double price) {
        super(name, price);
    }

    @Override
    public void prepare() {
        System.out.println("Preparing appetizer: " + name);
    }
}

class MainCourse extends MenuItem {
    public MainCourse(String name, double price) {
        super(name, price);
    }

    @Override
    public void prepare() {
        System.out.println("Preparing main course: " + name);
    }
}

class Dessert extends MenuItem {
    public Dessert(String name, double price) {
        super(name, price);
    }

    @Override
    public void prepare() {
        System.out.println("Preparing dessert: " + name);
    }
}

// Factory for Menu Items
class MenuItemFactory {
    public static MenuItem createMenuItem(String type, String name, double price) {
        switch (type.toLowerCase()) {
            case "appetizer":
                return new Appetizer(name, price);
            case "maincourse":
                return new MainCourse(name, price);
            case "dessert":
                return new Dessert(name, price);
            default:
                throw new IllegalArgumentException("Invalid menu item type: " + type);
        }
    }
}

// Abstract class for Tables
abstract class Table {
    protected int tableNumber;

    public Table(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    public abstract void reserve();
}

// Concrete Table classes
class RegularTable extends Table {
    public RegularTable(int tableNumber) {
        super(tableNumber);
    }

    @Override
    public void reserve() {
        System.out.println("Reserving Regular Table #" + tableNumber);
    }
}

class VIPTable extends Table {
    public VIPTable(int tableNumber) {
        super(tableNumber);
    }

    @Override
    public void reserve() {
        System.out.println("Reserving VIP Table #" + tableNumber);
    }
}

class OutdoorTable extends Table {
    public OutdoorTable(int tableNumber) {
        super(tableNumber);
    }

    @Override
    public void reserve() {
        System.out.println("Reserving Outdoor Table #" + tableNumber);
    }
}

// Factory for Tables
class TableFactory {
    public static Table createTable(String type, int tableNumber) {
        switch (type.toLowerCase()) {
            case "regular":
                return new RegularTable(tableNumber);
            case "vip":
                return new VIPTable(tableNumber);
            case "outdoor":
                return new OutdoorTable(tableNumber);
            default:
                throw new IllegalArgumentException("Invalid table type: " + type);
        }
    }
}

// Main class for the Restaurant Management System
public class RestaurantManagementSystem {
    public static void main(String[] args) {
        // Singleton usage
        OrderManager orderManager = OrderManager.getInstance();
        orderManager.processOrder("Burger and Fries");

        PaymentSystem paymentSystem = PaymentSystem.getInstance();
        paymentSystem.processPayment(19.99);

        // Factory usage for Menu Items
        MenuItem appetizer = MenuItemFactory.createMenuItem("appetizer", "Spring Rolls", 5.99);
        appetizer.prepare();

        MenuItem mainCourse = MenuItemFactory.createMenuItem("maincourse", "Grilled Chicken", 15.99);
        mainCourse.prepare();

        MenuItem dessert = MenuItemFactory.createMenuItem("dessert", "Cheesecake", 6.99);
        dessert.prepare();

        // Factory usage for Tables
        Table regularTable = TableFactory.createTable("regular", 1);
        regularTable.reserve();

        Table vipTable = TableFactory.createTable("vip", 2);
        vipTable.reserve();

        Table outdoorTable = TableFactory.createTable("outdoor", 3);
        outdoorTable.reserve();
    }
}

