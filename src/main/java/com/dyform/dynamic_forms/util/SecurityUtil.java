package com.dyform.dynamic_forms.util;

import com.dyform.dynamic_forms.entity.FormResponse;
import com.dyform.dynamic_forms.entity.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class SecurityUtil {

    public User getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return (User) authentication.getPrincipal();  // Assuming User is the principal
    }


    public UserDetails getCurrentUserDetails() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return (UserDetails) authentication.getPrincipal();
    }


    public void assertAdmin() {
        UserDetails currentUser = getCurrentUserDetails();
        boolean isAdmin = currentUser.getAuthorities().stream()
                .anyMatch(authority -> authority.getAuthority().equals("ROLE_ADMIN"));
        if (!isAdmin) {
            throw new RuntimeException("Access denied. Admins only.");
        }
    }


    public void assertCanAccess(FormResponse response) {
        UserDetails currentUser = getCurrentUserDetails();
        boolean isAdmin = currentUser.getAuthorities().stream()
                .anyMatch(authority -> authority.getAuthority().equals("ROLE_ADMIN"));

        if (!isAdmin && !response.getAssignedTo().getUsername().equals(currentUser.getUsername())) {
            throw new RuntimeException("Access denied. You are not assigned to this response.");
        }
    }
}
