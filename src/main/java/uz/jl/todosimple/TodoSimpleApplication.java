package uz.jl.todosimple;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;
import uz.jl.todosimple.entity.auth.AuthUser;
import uz.jl.todosimple.repository.auth.AuthUserRepository;

import java.util.Arrays;

@SpringBootApplication
public class TodoSimpleApplication implements CommandLineRunner {
    private final AuthUserRepository authUserRepository;
    private final PasswordEncoder passwordEncoder;

    public TodoSimpleApplication(AuthUserRepository authUserRepository, PasswordEncoder passwordEncoder) {
        this.authUserRepository = authUserRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public static void main(String[] args) {
        SpringApplication.run(TodoSimpleApplication.class, args);
    }
    @Override
    public void run(String... args) throws Exception {
//        AuthUser user1=new AuthUser();
//        user1.setUsername("user3");
//        user1.setPassword(passwordEncoder.encode("123"));
//        AuthUser user2=new AuthUser();
//        user2.setUsername("user4");
//        user2.setPassword(passwordEncoder.encode("123"));
//        authUserRepository.saveAll(Arrays.asList(user1,user2));
    }
}