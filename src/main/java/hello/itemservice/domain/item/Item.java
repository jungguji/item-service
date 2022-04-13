package hello.itemservice.domain.item;

import lombok.*;

@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class Item {

    private Long id;
    private String itemName;
    private Integer price;
    private Integer quantity;

    @Builder
    public Item(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
