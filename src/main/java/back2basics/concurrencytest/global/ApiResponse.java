package back2basics.concurrencytest.global;

import back2basics.concurrencytest.api.CoffeeOrderResponse;
import lombok.Getter;

@Getter
public class ApiResponse {
    private final boolean success;
    private final CoffeeOrderResponse data;
    private final String error;

    private ApiResponse(boolean success, CoffeeOrderResponse data, String error) {
        this.success = success;
        this.data = data;
        this.error = error;
    }

    public static ApiResponse success(CoffeeOrderResponse data) {
        return new ApiResponse(true, data, null);
    }

    public static ApiResponse fail(String errorMessage) {
        return new ApiResponse(false, null, errorMessage);
    }
}