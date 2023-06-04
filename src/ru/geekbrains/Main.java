package ru.geekbrains;

import ru.geekbrains.models.TableModel;
import ru.geekbrains.presenters.BookingPresenter;
import ru.geekbrains.views.BookingView;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        /**
         * TODO: Метод changeReservationTable должен ЗАРАБОТАТЬ
         *
         * @param args аргументы комадной строки
         */

        TableModel model = new TableModel();
        BookingView view = new BookingView();
        BookingPresenter bookingPresenter = new BookingPresenter(model, view);

        bookingPresenter.loadTables();
        bookingPresenter.updateView();

        view.reservationTable(new Date(), 2, "Станислав");
        view.reservationTable(new Date(), 4, "Виктор");

        view.changeReservationTable(1001, new Date(), 3, "Станислав");
    }
}