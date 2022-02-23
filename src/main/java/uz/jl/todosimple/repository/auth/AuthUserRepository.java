package uz.jl.todosimple.repository.auth;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.jl.todosimple.entity.auth.AuthUser;

public interface AuthUserRepository extends JpaRepository<AuthUser, Long> {

    AuthUser findAuthUserByUsername(String username);
}
