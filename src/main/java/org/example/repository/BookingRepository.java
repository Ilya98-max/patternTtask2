package org.example.repository;
import org.example.context.BookingContext;
import java.util.List;

public interface BookingRepository {

    void addBooking(BookingContext booking);

    void removeBooking(int roomNumber);

    BookingContext findByRoom(int roomNumber);

    List<BookingContext> findAll();
}


