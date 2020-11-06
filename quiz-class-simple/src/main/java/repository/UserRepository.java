package repository;

import com.example.quizclasssimple.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByEmail(String email);

    List<User> findByOrderByFullnameAsc();

    List<User> findAllByOrderByIdDesc();


    @Query("from User where name=?1 order by id")
    List<User> findByFullnameSorted(String name);
}
