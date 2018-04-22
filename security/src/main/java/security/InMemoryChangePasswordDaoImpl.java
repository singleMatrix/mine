package security;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.memory.InMemoryDaoImpl;
import org.springframework.stereotype.Service;

/**
 * Illustrates an extension to InMemoryDaoImpl which allows password changes.
 * 
 * @author Mularien
 */
@Service
public class InMemoryChangePasswordDaoImpl extends InMemoryDaoImpl implements IChangePassword {
	/* (non-Javadoc)
	 * @see com.packtpub.springsecurity.security.IChangePassword#changePassword(java.lang.String, java.lang.String)
	 */
	public void changePassword(String username, String password) {
		// get the UserDetails
		User userDetails = (User) getUserMap().getUser(username);
		// create a new UserDetails with the new password
		User newUserDetails = new User(userDetails.getUsername(),password,
				userDetails.isEnabled(),userDetails.isAccountNonExpired(),
				userDetails.isCredentialsNonExpired(),
				userDetails.isAccountNonLocked(),userDetails.getAuthorities());
		// add to the map
		getUserMap().addUser(newUserDetails);
	}
}
