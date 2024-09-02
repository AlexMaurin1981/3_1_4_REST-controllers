package REST_controller.boot_security.demo.reposotorie;

import REST_controller.boot_security.demo.entetie.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

}
