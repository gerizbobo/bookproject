package repository;

import entities.Review;
import lombok.AllArgsConstructor;
import org.hibernate.Session;

import java.util.List;
@AllArgsConstructor
public class ReviewRepository implements Repository<Review, Integer>{
    private final Session session;


    @Override
    public Review create(Review review) {
        return null;
    }

    @Override
    public List<Review> readAll() {
        return null;
    }

    @Override
    public Review read(Integer integer) {
        return null;
    }

    @Override
    public Review update(Review review) {
        return null;
    }

    @Override
    public void delete(Review review) {

    }
}
