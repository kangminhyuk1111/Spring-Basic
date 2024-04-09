package hello.core.order;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Order {
    private Long memberId;
    private String itemName;
    private int itemPrice;
    private int discountPrice;
}
