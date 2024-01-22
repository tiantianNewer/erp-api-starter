package nxu.it.api.security;

import java.util.List;
import java.util.Optional;

public interface TokenService {
    default boolean isValid(String token) {
        return token != null;
    }

    default Optional<String> getUserName(String token) {
        return Optional.ofNullable(token)
                .map(t ->
                        isValid(token) ? "user" : null
                );

    }

    default List<String> getRoles(String token) {
        return isValid(token) ? List.of("common") : List.of();
    }

}
