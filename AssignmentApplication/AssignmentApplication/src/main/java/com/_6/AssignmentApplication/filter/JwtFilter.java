package com._6.AssignmentApplication.filter;

import com._6.AssignmentApplication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JwtFilter {

    @Autowired
    private UserRepository userRepo;
<<<<<<< Updated upstream
=======

    @Autowired
    private JwtUtil jwtUtil;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        final String header = request.getHeader(HttpHeaders.AUTHORIZATION);

        // Check if the header is null or doesn't start with "Bearer "
        if (!StringUtils.hasText(header) ||(StringUtils.hasText(header)) && !header.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }

        // Extract the token after "Bearer "
        final String token;
        try {
            token = header.split(" ")[1].trim();
        } catch (ArrayIndexOutOfBoundsException e) {
            filterChain.doFilter(request, response);
            return;
        }

        // Get user identity and set it on the Spring Security context
        UserDetails userDetails = userRepo
                .findByUserName(jwtUtil.getUsernameFromToken(token))
                .orElse(null);

        // Validate the JWT token
        if (userDetails == null || !jwtUtil.validateToken(token, userDetails)) {
            filterChain.doFilter(request, response);
            return;
        }

        // Create authentication token
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                userDetails, null,
                userDetails.getAuthorities()
        );

        authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

        // Set the authentication in the security context
        SecurityContextHolder.getContext().setAuthentication(authentication);

        filterChain.doFilter(request, response);
    }

>>>>>>> Stashed changes
}
