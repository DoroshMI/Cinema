package ua.lviv.cinema.serviceImpl;

import java.io.IOException;
import java.security.Principal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.mail.MessagingException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import ua.lviv.cinema.component.TicketPDFComponent;
import ua.lviv.cinema.dao.OrderDao;
import ua.lviv.cinema.dao.TicketDao;
import ua.lviv.cinema.dao.UserDao;
import ua.lviv.cinema.entity.Order;
import ua.lviv.cinema.entity.Seance;
import ua.lviv.cinema.entity.Seat;
import ua.lviv.cinema.entity.StatusTicket;
import ua.lviv.cinema.entity.Ticket;
import ua.lviv.cinema.entity.User;
import ua.lviv.cinema.service.*;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderDao orderDao;

    @Autowired
    UserService userService;

    @Autowired
    SeatService seatService;

    @Autowired
    TicketService ticketService;


    @Autowired
    TicketDao ticketDao;

    @Autowired
    private MailSenderService mailSenderService;

    @Autowired
    private TicketPDFComponent ticketPDFComponent;

    @Override
    public void save(Order order) {
        orderDao.save(order);
    }

    @Override
    public void saveAndFlush(Order order) {
        orderDao.saveAndFlush(order);

    }



    @Override
    public List<Order> findAll() {
        return orderDao.findAll();
    }

    @Override
    public void delete(Order order) {
        orderDao.delete(order);

    }

    @Override
    public void update(Order order) {
        orderDao.save(order);

    }

    @Override
    public Order findById(Integer id) {
        return orderDao.findById(id);
    }

    @Override
    public Order findByIdWithSeats(Integer id) {
        return orderDao.findByIdWithSeats(id);
    }

    @Override
    @Transactional
    public void addTicketIntoBasket(Principal principal, int seatId) {
        User user = userService.findById(Integer.parseInt(principal.getName()));

        Seat seat = seatService.findById(seatId);

        seat.setUser(user);
        seatService.update(seat);


    }

    @Override
    public void deleteTicketFromBasket(int userId, int seatId) {
        User user = userService.findByIdWithSeats(userId);

        Seat seat = seatService.findById(seatId);
        seat.setUser(null);


        seatService.update(seat);

    }

    @Override
    public Order createOrderAndSave(int userId) {
        Order order = null;
        User user = userService.findByIdWithSeats(userId);
        if (user.getSeats().size() == 0) {
            order = userService.findByIdWithOrders(userId).getOrders()
                    .get(userService.findByIdWithOrders(userId).getOrders().size() - 1);
            return this.findByIdWithSeats(order.getId());
        }

        order = new Order(LocalDateTime.now(), user.getSeats().stream().findFirst().get().getSeance());

        orderDao.saveAndFlush(order);

        order.setUser(user);

        for (Seat seat : user.getSeats()) {

            order.getSeats().add(seat);

            seat.setOrder(order);
            seat.setUser(null);
            seat.setFreeSeat(false);
            seatService.update(seat);
        }
        order.setStatusTicket(StatusTicket.PROCESSED);
        orderDao.save(order);

        user.getSeats().clear();
        userService.update(user);

        return order;

    }

    @Override
    public void buyTikets(int userId) {

        Order order = lastOrderInUser(userId);
        order = this.findByIdWithSeats(order.getId());
        order.getSeats().stream().forEach(seat -> {
            seat.setOrder(null);
            seatService.update(seat);
        });
        order.setNameMovie(order.getSeance().getMovie().getTitle());
        order.setSeance(null);
        order.setStatusTicket(StatusTicket.FUTURE);
        this.update(order);
        //order.setCountTickets()

        String theme = "thank's for buy tikets";
        String mailBody =
                "your tickets are: " ;
        User user = userService.findById(userId);

        try {
            mailSenderService.sendMailWithTickets(theme, mailBody, user.getEmail(), "C:\\Users\\User\\Downloads\\tickets.pdf");
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("email has not been sent!!!");
        }

        ticketPDFComponent.main();
    }

    @Override
    @Async
    public void deleteOrder(int userId) {
        Order order = lastOrderInUser(userId);
//
        while (order.getStatusTicket().equals(StatusTicket.PROCESSED) &&
                LocalDateTime.now().isBefore(order.getLocalDateTime().plusMinutes(1))) {
        }

        order = lastOrderInUser(userId);
        if (order.getStatusTicket().equals(StatusTicket.PROCESSED)) {
            System.out.println("delete 2");
            order = this.findByIdWithSeats(order.getId());
            order.getSeats().stream().forEach(seat -> {
                seat.setOrder(null);
                seat.setFreeSeat(true);
                seatService.update(seat);
            });
            this.delete(order);
        }
    }

    @Override
    public Order lastOrderInUser(int userId) {
        Order order = null;
        User user = userService.findByIdWithOrders(userId);
        int countOrders = user.getOrders().size();
        if (countOrders == 0) {
            return null;
        }

        return user.getOrders().get(countOrders - 1);

    }

    @Override
    public Order lastOrderWithSeatInUser(int userId) {
        return orderDao.findByIdWithSeats(lastOrderInUser(userId).getId());
    }

    @Override
    public void deleteTicketFromLastOrder(int userId, int seatId) {
        Order order = lastOrderInUser(userId);

        Seat seat = seatService.findById(seatId);
        seat.setFreeSeat(true);
        seat.setUser(null);
        seat.setOrder(null);

        seatService.update(seat);

    }

    @Override
    public void deleteLastOrderAndRedirectBasket(int userId) {
        Order order = lastOrderInUser(userId);

        order = this.findByIdWithSeats(order.getId());
        User user = userService.findByIdWithSeats(userId);

        for (Seat seat : order.getSeats()) {
            seat.setUser(user);
            seat.setOrder(null);
            seat.setFreeSeat(true);
            seatService.update(seat);
        }

    }

}
