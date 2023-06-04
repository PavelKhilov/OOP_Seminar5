package ru.geekbrains.models;

import ru.geekbrains.presenters.Model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class TableModel implements Model {

    private Collection<Table> tables;


    /**
     * Получение списка всех столиков
     * @ return столики
     */
    public Collection<Table> loadTables() {
        if (tables == null) {
            tables = new ArrayList<>();

            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
        }
        return tables;
    }

    /**
     * Бронирвоание столика
     * @param reservationDate дата бронирвоания
     * @param tableNo номер столика
     * @param name имя клиента
     * @return номер брони
     */
    public int reservationTable(Date reservationDate, int tableNo, String name) {
        for (Table table : tables) {
            if(table.getNo() == tableNo) {
                Reservation reservation = new Reservation(reservationDate, name);
                table.getReservation().add(reservation);
                return reservation.getId();
            }
        }
        return -1;
        //throw new RuntimeException("Невозможно забронировать столик.");
    }

    // TODO: Разработать самостоятельно в рамках домащней работы
    public int changeReservation(int oldReservation, Date reservationDate, int tableNo, String name){
        return -1;
    }

}
