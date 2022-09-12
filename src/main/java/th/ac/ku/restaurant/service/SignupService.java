package th.ac.ku.restaurant.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import th.ac.ku.restaurant.dto.SignupDto;
import th.ac.ku.restaurant.model.User;
import th.ac.ku.restaurant.repository.UserRepository;

@Service
public class SignupService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ModelMapper modelMapper;

    public boolean isUsernameAvailable(String username) {
        return repository.findByUsername(username) == null;
    }

    //อันเก่าจะรับเป็น User
//    public void createUser(User user) {
//        //ไม่ได้ save ลง database โดยตรงใช้สร้าง User ใหม่แล้วcopyที่รับเข้ามาใส่ในUserที่สร้างใหม่
//        //ปลอดภัยแต่ว่า manual
//        User record = new User();
//        record.setFirstName(user.getFirstName());//copy ใส่ใน user ที่สร้างใหม่
//        record.setLastName(user.getLastName());
//        record.setRole(user.getRole());
//        record.setUsername(user.getUsername());
//
//        String hashedPassword = passwordEncoder.encode(user.getPassword());
//        record.setPassword(hashedPassword);
//
//        repository.save(record);
//    }

    //ใช้DTO
    //อันที่มีการใช้ DTO ไม่ต้องมีการcopyใส่ Userแล้ว เพราะมีการใช้ ModelMapper
    public void createUser(SignupDto user) {
        User record = modelMapper.map(user, User.class);//แปลง SignupDto เป็นclassที่ระบุใน parameter ที่สอง(User.class)

        String hashedPassword = passwordEncoder.encode(user.getPassword());
        record.setPassword(hashedPassword);

        repository.save(record);
    }

    public User getUser(String username) {
        return repository.findByUsername(username);
    }



}
