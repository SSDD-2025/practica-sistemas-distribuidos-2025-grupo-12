package es.grupo12.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import es.grupo12.security.jwt.JwtRequestFilter;
import es.grupo12.security.jwt.UnauthorizedHandlerJwt;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Autowired
	private JwtRequestFilter jwtRequestFilter;
	
	@Autowired
	RepositoryUserDetailsService userDetailsService;

	@Autowired
	private UnauthorizedHandlerJwt unauthorizedHandlerJwt;

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
		return authConfig.getAuthenticationManager();
	}

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();

		authProvider.setUserDetailsService(userDetailsService);
		authProvider.setPasswordEncoder(passwordEncoder());

		return authProvider;
	}

    

	@Bean
	@Order(1)
	public SecurityFilterChain apiFilterChain(HttpSecurity http) throws Exception {
		
		http.authenticationProvider(authenticationProvider());

		http
			.securityMatcher("/api/**")
			.exceptionHandling(handling -> handling.authenticationEntryPoint(unauthorizedHandlerJwt));
		
		http
			.authorizeHttpRequests(authorize -> authorize
                    // PRIVATE ENDPOINTS
					.requestMatchers(HttpMethod.GET, "/api/products/**").permitAll()
					.requestMatchers(HttpMethod.POST, "/api/products/**").hasRole("USER")
					.requestMatchers(HttpMethod.DELETE, "/api/products/**").hasRole("USER")
					.requestMatchers(HttpMethod.PUT, "/api/products/**").hasRole("USER")
					.requestMatchers(HttpMethod.GET, "/api/users/**").hasRole("USER")
					.requestMatchers(HttpMethod.POST, "/api/users/**").permitAll()
					.requestMatchers(HttpMethod.DELETE, "/api/users/**").hasRole("ADMIN")
					.requestMatchers(HttpMethod.GET, "/api/reviews/**").permitAll()
					.requestMatchers(HttpMethod.POST, "/api/reviews/**").hasRole("USER")
					.requestMatchers(HttpMethod.DELETE, "/api/reviews/**").hasRole("ADMIN")
					.requestMatchers(HttpMethod.GET, "/api/messages/**").hasRole("USER")
					.requestMatchers(HttpMethod.POST, "/api/messages/**").hasRole("USER")
					.requestMatchers(HttpMethod.DELETE, "/api/messages/**").hasRole("ADMIN")
				
					// PUBLIC ENDPOINTS
					.anyRequest().permitAll()
			);
		
        // Disable Form login Authentication
        http.formLogin(formLogin -> formLogin.disable());

        // Disable CSRF protection (it is difficult to implement in REST APIs)
        http.csrf(csrf -> csrf.disable());

        // Disable Basic Authentication
        http.httpBasic(httpBasic -> httpBasic.disable());

        // Stateless session
        http.sessionManagement(management -> management.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

		// Add JWT Token filter
		http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);

		return http.build();
	}

	@Bean
	@Order(2)
	public SecurityFilterChain webFilterChain(HttpSecurity http) throws Exception {

		http.authenticationProvider(authenticationProvider());

        http
			.authorizeHttpRequests(authorize -> authorize
							// PUBLIC PAGES
							.requestMatchers("/").permitAll()
							.requestMatchers("/products/**").permitAll()
							.requestMatchers("/error").permitAll()
							.requestMatchers("/user_reviews").permitAll()
							.requestMatchers("/search").permitAll()
							.requestMatchers("/register").permitAll()
							.requestMatchers("/logged_user").permitAll()
							.requestMatchers("/style1.css").permitAll()
							.requestMatchers("/uploadStyle.css").permitAll()
							//ADMIN PAGES
							.requestMatchers("/administration").hasAnyRole("ADMIN")
							.requestMatchers("/allProducts").hasAnyRole("ADMIN")
							.requestMatchers("/allReviews").hasAnyRole("ADMIN")
							.requestMatchers("/users").hasAnyRole("ADMIN")
							.requestMatchers("/delete_productFromList/**").hasAnyRole("ADMIN")
							.requestMatchers("/messages").hasAnyRole("ADMIN")
							// DOCUMENTATION
							.requestMatchers("/v3/api-docs*/**").permitAll()
							.requestMatchers("/swagger-ui.html").permitAll()
							.requestMatchers("/swagger-ui/**").permitAll()
							//PRIVATE PAGES
							.anyRequest().hasAnyRole("USER")
							
			)
			.formLogin(formLogin -> formLogin
							.loginPage("/login")
							.failureUrl("/loginerror")
							.defaultSuccessUrl("/")
							.permitAll()
			)
			.logout(logout -> logout
							.logoutUrl("/logout")
							.logoutSuccessUrl("/")
							.permitAll()
			);

		return http.build();
	}
}
