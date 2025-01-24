package com.pitagoras.springboot.demo.rent.seeds;
import com.pitagoras.springboot.demo.rent.entity.Authority;
import com.pitagoras.springboot.demo.rent.entity.Seed;
import com.pitagoras.springboot.demo.rent.entity.User;
import com.pitagoras.springboot.demo.rent.repository.AuthorityRepository;
import com.pitagoras.springboot.demo.rent.repository.SeedRepository;
import com.pitagoras.springboot.demo.rent.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.List;
import java.util.Optional;


@Configuration
@EnableTransactionManagement
public class SetUserRoles implements ApplicationRunner {

    private final AuthorityRepository authorityRepository;
    private final SeedRepository seedRepository;
    private final UserRepository userRepository;


    @Autowired
    public SetUserRoles(AuthorityRepository authorityRepository, SeedRepository seedRepository, UserRepository userRepositoryl, UserRepository userRepository) {
        this.authorityRepository = authorityRepository;
        this.seedRepository = seedRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        String seedName = "SetUserRoles";
        Optional<Seed> seed = this.seedRepository.findByName(seedName);
        if (seed.isPresent()) {
            return;
        }
        Seed seedToBeExecuted = new Seed();
        seedToBeExecuted.setName(seedName);
        seedToBeExecuted.setSuccess(false);

        Seed savedSeed = this.seedRepository.save(seedToBeExecuted);

        Authority admin = new Authority();
        admin.setUserId(1);
        admin.setAuthority("ROLE_ADMIN");
        this.authorityRepository.save(admin);

        Authority employee = new Authority();
        employee.setUserId(2);
        employee.setAuthority("ROLE_EMPLOYEE");
        this.authorityRepository.save(employee);


        Authority manager = new Authority();
        manager.setUserId(3);
        manager.setAuthority("ROLE_MANAGER");
        this.authorityRepository.save(manager);

        seedToBeExecuted.setSuccess(true);
        this.seedRepository.save(seedToBeExecuted);
        }
    }

