package com.example.demo.repository;

import com.example.demo.model.Greeting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface GreetingRepository extends JpaRepository<Greeting,Long>{
//    private final Map<Long, Greeting> greetingMap = new HashMap<>();
//    private long currentId = 1;
//
//    public Greeting save(Greeting greeting) {
//        if (greeting.getId() == 0) {
//            greeting.setId(currentId++);
//        }
//        greetingMap.put(greeting.getId(), greeting);
//        return greeting;
//    }
//
//    public Optional<Greeting> findById(long id) {
//        return Optional.ofNullable(greetingMap.get(id));
//    }
//
//    public List<Greeting> findAll() {
//        return new ArrayList<>(greetingMap.values());
//    }
//
//    public void deleteById(long id) {
//        greetingMap.remove(id);
//    }
//
//    public Greeting update(long id, Greeting greeting) {
//        greetingMap.put(id, greeting);
//        return greeting;
//    }
}
