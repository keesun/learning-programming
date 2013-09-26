package whiteship;

import org.springframework.stereotype.Service;

/**
 * @author Keesun Baik
 */
@Service
public class BookService {

    public String book(int id) {
        return "book" + id;
    }
}
