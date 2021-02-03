package ee.bcs.valiit.tasks.tasks.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDataServiceImpl implements UserDetailsService {

    @Autowired
    private BankRepository bankRepository;


    @Override
    public UserDetails loadUserByUsername(String idCardNr) throws UsernameNotFoundException {
        String password = bankRepository.findPasswordByIdCardNumber(idCardNr);
        return User.withUsername(idCardNr)
                .password(password)
                .roles("USER").build();
    }
}
