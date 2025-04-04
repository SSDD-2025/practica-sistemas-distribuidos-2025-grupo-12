package es.grupo12.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {


	@Autowired
	RepositoryUserDetailsService userDetailsService;

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
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails user = User.builder()
                    .username("user")
                    .password(passwordEncoder().encode("pass"))
                    .roles("USER")
                    .build();
		UserDetails admin = User.builder()
					.username("admin")
					.password(passwordEncoder().encode("adminpass"))
					.roles("USER","ADMIN")
					.build();
        return new InMemoryUserDetailsManager(user, admin);
    }

	@Bean
	@Order(1)
	public SecurityFilterChain webFilterChain(HttpSecurity http) throws Exception {

		http.authenticationProvider(authenticationProvider());

		http.csrf(csrf -> csrf.disable());

        http
			.authorizeHttpRequests(authorize -> authorize
							// PUBLIC PAGES
							.requestMatchers("/").permitAll()
							.requestMatchers("/products").permitAll()
							.requestMatchers("/products/**").permitAll()
							.requestMatchers("/error").permitAll()
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
							// API PAGES
							.requestMatchers("/api/products/").permitAll()
							.requestMatchers("/api/products/**").permitAll()
							.requestMatchers("/api/users/").permitAll()
							.requestMatchers("/api/users/**").permitAll()
							.requestMatchers("/api/reviews/").permitAll()
							.requestMatchers("/api/reviews/**").permitAll()
							.requestMatchers("/api/messages/").permitAll()
							.requestMatchers("/api/messages/**").permitAll()
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
