package com.first.board.buser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class BuserService {
    private final BuserRepository buserRepository;

    @Autowired
    public BuserService(BuserRepository buserRepository) {
        this.buserRepository = buserRepository;
    }

    // R E A D
    public List<Buser> getBusers() {
        return buserRepository.findAll();
    }

    public Buser getBuser(Integer id) {
        return buserRepository.findBuserById(id)
                .orElseThrow(() -> new IllegalStateException("User with id " + id + " not found."));
    }

    // C R E A T E
    public void addBuser(Buser buser) {
        Optional<Buser> optional_id = buserRepository.findBuserById(buser.getId());
        Optional<Buser> optional_email = buserRepository.findBuserByEmail(buser.getEmail());
        optional_id.ifPresent(u -> {
            throw new IllegalArgumentException("User with id " + buser.getId() + " already exists.");
        });
        optional_email.ifPresent(u -> {
            throw new IllegalArgumentException("User with email " + buser.getEmail() + " already exists.");
        });
        buserRepository.save(buser);
    }

    // D E L E T E
    public void deleteBuser(Integer id) {
        boolean exists = buserRepository.existsById(id);
        if (!exists) {
            throw new IllegalArgumentException("User with id " + id + " does not exist.");
        }
        buserRepository.deleteById(id);
    }

    // U P D A T E
    @Transactional // 메서드 내의 데이터베이스 작업이 안전하게 처리되며, 예외 발생 시 자동 롤백
    public void updateBuser(Integer id, String name, String email) {
        Buser buser = buserRepository.findBuserById(id)
                .orElseThrow(() -> new IllegalStateException("Not found buser: " + id));
        if (name != null && name.length() > 0 && !Objects.equals(buser.getName(), name)) {
            buser.setName(name);
        }
        if (email != null && email.length() > 0 && !Objects.equals(buser.getEmail(), email)) {
            if (buserRepository.findBuserByEmail(email).isPresent())
                throw new IllegalArgumentException("User with email " + email + " already exists.");
            buser.setEmail(email);
        }
        buserRepository.save(buser);
    }

}
