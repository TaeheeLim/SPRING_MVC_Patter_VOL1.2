package hello.itemservice.domain.item;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DeliveryCode {
    /**
     * FAST : 빠른배송
     * NORMAL : 일반배송
     * SLOW : 느린배송
     */
    private String code;
    private String displayName;
}
