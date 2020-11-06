package repository;

import com.example.quizclasssimple.models.Take;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TakeRepository extends JpaRepository<Take, Integer> {
}
