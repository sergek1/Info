import java.util.List;
// import com.Info.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public interface UserService {
    List<User> getAllUsers();
    User getUserById(Long id);
    void saveUser(User user);
    void deleteUser(Long id);
    void addUser(String username);
}

// @Service
// @RequiredArgsConstructor
// public class UserService extends GenericService<User, Long> {
//     @Autowired
//     public UserService(UserRepository userRepository) {
//         super(userRepository);
//     }
// }
