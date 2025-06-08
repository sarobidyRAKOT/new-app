package itu.mg.new_app.utilitaires;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;

public class Ref_Type {
    
    public static <T> ParameterizedTypeReference<Json_Result<T>> single(Class<T> clazz) {
        return new ParameterizedTypeReference<Json_Result<T>>() {};
    }

    public static <T> ParameterizedTypeReference<Json_Result<List<T>>> list(Class<T> clazz) {
        return new ParameterizedTypeReference<Json_Result<List<T>>>() {};
    }
}
