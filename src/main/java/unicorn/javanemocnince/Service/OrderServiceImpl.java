package unicorn.javanemocnince.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unicorn.javanemocnince.Errors.OrderNotFoundException;
import unicorn.javanemocnince.Models.Doctor;
import unicorn.javanemocnince.Models.NewOrder;
import unicorn.javanemocnince.Models.OperatingRoom;
import unicorn.javanemocnince.Models.Order;
import unicorn.javanemocnince.Repo.OrderRepository;
import unicorn.javanemocnince.Repo.SpecRepo;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    OrderRepository orderRepository;
    @Autowired
    OperatingRoomService operatingRoomService;
    @Autowired
    DoctorService doctorService;
    @Autowired
    PatientService patientService;
    @Autowired
    SpecRepo specRepo;

    @Override
    public Iterable<Order> listOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order addOrder(NewOrder newOrder) {
        Order order = new Order();
        Iterable<Order> orders = listOrders();
        List<Doctor> doctors = doctorService.getDoctorsBySpecialization(specRepo.findById(newOrder.getSpecializationId()).get());
        List<OperatingRoom> operatingRooms = operatingRoomService.findBySpecialization(specRepo.findById(newOrder.getSpecializationId()).get());
        LocalDate today = LocalDate.now();

        /*while (true) {
            today.plusDays(1);
                operatingRooms.forEach(room ->  {
                    ArrayList<Order> daysOrders = new ArrayList<>();
                    orders.forEach(item -> {
                        if (item.getIdOperatingRoom().equals(room) && item.getWorkingtime().split("|")[0].equals(String.valueOf(today.getMonthValue())) && item.getWorkingtime().split("|")[1].equals(String.valueOf(today.getDayOfMonth()))) {
                            daysOrders.add(order);
                        }
                    });
                                daysOrders.forEach(item -> {
                                    for (int i = 8; i < 19; i++) {
                                        if (i parseDate(item.getWorkingtime()))
                                    }
                                });
                }
                );
        }
        //return orderRepository.save(order);*/
        return null;
    }

    private String[][] parseDate(String str){
        String[][] date = new String[str.split("!").length][2];
        for (int i = 0; i < str.split("!").length; i++) {
            String[] parts = str.split("!")[i].split("\\|");
            date[i][0] = LocalDateTime.of(LocalDateTime.now().getYear(), Integer.parseInt(parts[0]), Integer.parseInt(parts[1]), Integer.parseInt(parts[2]), 0, 0).toString();
            date[i][1] = LocalDateTime.of(LocalDateTime.now().getYear(), Integer.parseInt(parts[0]), Integer.parseInt(parts[1]), Integer.parseInt(parts[3]), 0, 0).toString();
        }
        return date;
    }

    private String deparseDate(String[][] date){
        StringBuilder strBuilder = new StringBuilder();
        for (int i = 0; i < date.length; i++) {
            if (i > 0) {
                strBuilder.append("!");
            }
            strBuilder.append(LocalDateTime.parse(date[i][0]).format(DateTimeFormatter.ofPattern("M|d|H"))).append("|").append(LocalDateTime.parse(date[i][1]).format(DateTimeFormatter.ofPattern("H")));
        }
        return strBuilder.toString();
    }

    @Override
    public Order updateOrder(Long id, Order updatedOrder) {
        Optional<Order> existingOrderOptional = orderRepository.findById(id);

        if (existingOrderOptional.isPresent()) {
            Order existingOrder = existingOrderOptional.get();
            existingOrder.setIdDoctor(updatedOrder.getIdDoctor());
            existingOrder.setIdPatient(updatedOrder.getIdPatient());
            existingOrder.setIdOperatingRoom(updatedOrder.getIdOperatingRoom());
            // Update other fields as needed

            return orderRepository.save(existingOrder);
        } else {
            throw new OrderNotFoundException("Objednávka s ID " + id + " nebyl nalezen.");
        }
    }

    @Override
    public void deleteOrder(Long id) {
        Optional<Order> existingOrderOptional = orderRepository.findById(id);

        if (existingOrderOptional.isPresent()) {
            orderRepository.deleteById(id);
        } else {
            throw new OrderNotFoundException("Objednávka s ID " + id + " nebyl nalezen.");
        }
    }

    @Override
    public Order getOrder(Long id) {
        Optional<Order> existingOrderOptional = orderRepository.findById(id);

        if (existingOrderOptional.isPresent()) {
            return existingOrderOptional.get();
        } else {
            throw new OrderNotFoundException("Objednávka s ID " + id + " nebyl nalezen.");
        }
    }
}
