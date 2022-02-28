package sqlserver.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import sqlserver.crud.model.Tutorial;

import java.util.List;
import java.util.Optional;

public interface TutorialRepository extends JpaRepository<Tutorial, Long> {
    List<Tutorial> findByPublished(boolean published);

    List<Tutorial> findByTitleContaining(String title);

    List<Tutorial> findByDescriptionContaining(String description);

    List<Tutorial> findByIdGreaterThanEqual(long id);

    List<Tutorial> findByDescriptionLikeAndTitleEqualsAndPublishedFalse(String description, String title);

    @Query(value = "select t from Tutorial t where t.id=?1")
    Optional<Tutorial> fetchTutorialsByID(int id);

}
