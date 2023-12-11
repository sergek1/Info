package com.Info.repository;// import org.springframework.data.repository.CrudRepository;
import com.Info.model.entity.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;


//@Repository
//@Component
public interface UserRepository extends CrudRepository<MyUser, Long> {
    
}
