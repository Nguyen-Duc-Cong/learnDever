package repository;

import com.example.quizclasssimple.models.QuizQuestion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizQuestionRepository extends JpaRepository<QuizQuestion,Integer> {
}
