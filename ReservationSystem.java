import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Customer {
    private String id;
    private String name;

    public Customer(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Customer{id='" + id + "', name='" + name + "'}";
    }
}

class Room {
    private String number;
    private String type;

    public Room(String number, String type) {
        this.number = number;
        this.type = type;
    }

    public String getNumber() {
        return number;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Room{number='" + number + "', type='" + type + "'}";
    }
}

class Reservation {
    private String reservationId;
    private String customerId;
    private String roomNumber;
    private String checkInDate;
    private String checkOutDate;

    public Reservation(String reservationId, String customerId, String roomNumber, String checkInDate, String checkOutDate) {
        this.reservationId = reservationId;
        this.customerId = customerId;
        this.roomNumber = roomNumber;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }

    @Override
    public String toString() {
        return "Reservation{id='" + reservationId + "', customerId='" + customerId + "', roomNumber='" + roomNumber + "', checkInDate='" + checkInDate + "', checkOutDate='" + checkOutDate + "'}";
    }
}

class ReservationSystem {
    private List<Customer> customers;
    private List<Room> rooms;
    private List<Reservation> reservations;

    public ReservationSystem() {
        customers = new ArrayList<>();
        rooms = new ArrayList<>();
        reservations = new ArrayList<>();
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public void makeReservation(Reservation reservation) {
        reservations.add(reservation);
    }

    public List<Customer> listCustomers() {
        return customers;
    }

    public List<Room> listRooms() {
        return rooms;
    }

    public List<Reservation> listReservations() {
        return reservations;
    }
}

public class Main {
    private static ReservationSystem reservationSystem = new ReservationSystem();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("1. Add Customer");
            System.out.println("2. Add Room");
            System.out.println("3. Make Reservation");
            System.out.println("4. List Customers");
            System.out.println("5. List Rooms");
            System.out.println("6. List Reservations");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (option) {
                case 1:
                    addCustomer();
                    break;
                case 2:
                    addRoom();
                    break;
                case 3:
                    makeReservation();
                    break;
                case 4:
                    listCustomers();
                    break;
                case 5:
                    listRooms();
                    break;
                case 6:
                    listReservations();
                    break;
                case 7:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }

    private static void addCustomer() {
        System.out.print("Enter customer ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter customer name: ");
        String name = scanner.nextLine();
        reservationSystem.addCustomer(new Customer(id, name));
        System.out.println("Customer added.");
    }

    private static void addRoom() {
        System.out.print("Enter room number: ");
        String number = scanner.nextLine();
        System.out.print("Enter room type: ");
        String type = scanner.nextLine();
        reservationSystem.addRoom(new Room(number, type));
        System.out.println("Room added.");
    }

    private static void makeReservation() {
        System.out.print("Enter reservation ID: ");
        String reservationId = scanner.nextLine();
        System.out.print("Enter customer ID: ");
        String customerId = scanner.nextLine();
        System.out.print("Enter room number: ");
        String roomNumber = scanner.nextLine();
        System.out.print("Enter check-in date (YYYY-MM-DD): ");
        String checkInDate = scanner.nextLine();
        System.out.print("Enter check-out date (YYYY-MM-DD): ");
        String checkOutDate = scanner.nextLine();
        reservationSystem.makeReservation(new Reservation(reservationId, customerId, roomNumber, checkInDate, checkOutDate));
        System.out.println("Reservation made.");
    }

    private static void listCustomers() {
        System.out.println("Customers:");
        for (Customer customer : reservationSystem.listCustomers()) {
            System.out.println(customer);
        }
    }

    private static void listRooms() {
        System.out.println("Rooms:");
        for (Room room : reservationSystem.listRooms()) {
            System.out.println(room);
        }
    }

    private static void listReservations() {
        System.out.println("Reservations:");
        for (Reservation reservation : reservationSystem.listReservations()) {
            System.out.println(reservation);
        }
    }
}
