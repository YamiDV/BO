// package com.inclub.apibackofficeadmin.crosscutting;

// import java.time.LocalDateTime;

// import org.springframework.beans.factory.annotation.Autowired;

// import org.springframework.stereotype.Component;
// import org.springframework.web.server.ServerWebExchange;
// import org.springframework.web.server.WebFilter;
// import org.springframework.web.server.WebFilterChain;

// import com.inclub.apibackofficeadmin.domain.models.UserActivity;
// import com.inclub.apibackofficeadmin.infraestructure.repositories.UserActivityRepository;

// import reactor.core.publisher.Mono;

// @Component
// public class UserActivityWebFilter implements WebFilter {

//     @Autowired
//     private UserActivityRepository userActivityRepository;

//     @Override
// public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
//     return exchange.getPrincipal().flatMap(principal -> {
//         String username = principal.getName();

//         UserActivity userActivity = new UserActivity();
//         userActivity.setUsername(username);
//         userActivity.setAction("Request to " + exchange.getRequest().getURI());
//         userActivity.setTimestamp(LocalDateTime.now());

//         return userActivityRepository.save(userActivity)
//             .then(chain.filter(exchange));
//     });
// }
// }


/// ES SOLO AVANCE :v
// no lo  activen por que no deja ver los tokens