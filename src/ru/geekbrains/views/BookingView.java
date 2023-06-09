package ru.geekbrains.views;

import ru.geekbrains.models.Table;
import ru.geekbrains.models.TableModel;
import ru.geekbrains.presenters.Model;
import ru.geekbrains.presenters.View;
import ru.geekbrains.presenters.ViewObserver;

import java.util.Collection;
import java.util.Date;

public class BookingView implements View {
    private ViewObserver observer; // наблюдатель

    /**
     * Установить наблюдателя, отслеживающего действия пользователя
     * @param observer наблюдатель
     */

    public void setObserver(ViewObserver observer) {
        this.observer = observer;
    }

    /**
     * Отобразить список всех столиков
     * @ param tables столики
     */
    public void showTables(Collection<Table> tables) {
        for (Table table: tables) {
            System.out.println(table);
        }
    }

    /**
     * Действие клиента (пользователь нажал на кнопку бронирования), бронирование столика
     * @param dateReservation дата бронирования
     * @param tableNo номер столика
     * @param name имя клиента
     */
    public void reservationTable(Date dateReservation,int tableNo, String name) {
        observer.onReservationTable(dateReservation, tableNo, name);
    }


    /**
     * TODO: Доработать метод в рамках домашней работы
     * Действие клиента (пользователь нажал на кнопку изменения бронирования),
     * изменение бронирования столика
     * @param oldReservation старый номер бронирования
     * @param reservationDate новая дата бронирования
     * @param tableNo номер столика
     * @param name имя клиента
     */
    public void changeReservationTable(int oldReservation, Date reservationDate, int tableNo, String name){
        cancelReservationTableStatus(oldReservation);
        observer.onReservationTable(reservationDate, tableNo, name);
    }

    /**
     * Отобразить результат резервирования столика
     * @param reservationId номер брони
     */
    public void showReservationTableStatus(int reservationId){
        if(reservationId > 0){
            System.out.printf("Столик успешно забранирован.\nНомер брони: #%d\n", reservationId);
        } else {
            System.out.println("Ошибка бронирования столика.\nПовторите попытку позже");
        }
    }
    /**
     * Отобразить результат отмены резервирования столика
     * @param oldReservation номер брони для отмены
     */
    @Override
    public void cancelReservationTableStatus(int oldReservation) {
        if(oldReservation > 0){
            System.out.printf("Бронирвоание #%d отменено.\n", oldReservation);
        } else {
            System.out.println("Ошибка отмены бронирования столика.\nПовторите попытку позже");
        }
    }
}
