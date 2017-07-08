package ua.lviv.cinema.dto;

import ua.lviv.cinema.entity.Coordinate;
import ua.lviv.cinema.entity.Order;
import ua.lviv.cinema.entity.Seance;
import ua.lviv.cinema.entity.User;

import javax.persistence.Embedded;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

/**
 * Created by n.dorosh on 06.07.2017.
 */
public class SeatDTOFull {

    private int id;


    private boolean freeSeat = true;


    private boolean reservedSeat = false;

    private int price;

     private int  orderId;

      private int userId;


    private int seanceId;



    private int coordinateRow;
    private int coordinateColumn;


    public SeatDTOFull() {
    }

    public SeatDTOFull(int id, boolean freeSeat, int price, int seanceId, int coordinateRow, int coordinateColumn) {
        this.id = id;
        this.freeSeat = freeSeat;
        this.price = price;
        this.seanceId = seanceId;
        this.coordinateRow = coordinateRow;
        this.coordinateColumn = coordinateColumn;
    }

    public boolean isReservedSeat() {
        return reservedSeat;
    }

    public void setReservedSeat(boolean reservedSeat) {
        this.reservedSeat = reservedSeat;
    }

    public boolean isFreeSeat() {
        return freeSeat;
    }

    public void setFreeSeat(boolean freeSeat) {
        this.freeSeat = freeSeat;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getCoordinateRow() {
        return coordinateRow;
    }

    public void setCoordinateRow(int coordinateRow) {
        this.coordinateRow = coordinateRow;
    }

    public int getCoordinateColumn() {
        return coordinateColumn;
    }

    public void setCoordinateColumn(int coordinateColumn) {
        this.coordinateColumn = coordinateColumn;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSeanceId() {
        return seanceId;
    }

    public void setSeanceId(int seanceId) {
        this.seanceId = seanceId;
    }

    @Override
    public String toString() {
        return "SeatDTOFull{" +
                "id=" + id +
                ", freeSeat=" + freeSeat +
                ", reservedSeat=" + reservedSeat +
                ", price=" + price +
                ", orderId=" + orderId +
                ", userId=" + userId +
                ", seanceId=" + seanceId +
                ", coordinateRow=" + coordinateRow +
                ", coordinateColumn=" + coordinateColumn +
                '}';
    }
}
