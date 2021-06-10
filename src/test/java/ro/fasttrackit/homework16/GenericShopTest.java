package ro.fasttrackit.homework16;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static ro.fasttrackit.homework16.Category.*;

class GenericShopTest {
    ShopService genericShop;

    @Test
    @DisplayName("WHEN an item is added THEN the item is in the list")
    void addItem() {
        ShopService<Clothes> service = new ShopService();

        service.addItem(new Clothes("tricou", 50, ON_SALE));
        assertThat(service.getItems()).hasSize(1);
        assertThat(service.getItems()).containsExactly(new Clothes("tricou", 50, ON_SALE));
    }

    @Test
    @DisplayName("return item with lower price works")
    void findWithLowerPrice() {
        ShopService<Electronics> service = new ShopService<>(List.of(
                new Electronics("tv", 3000, ON_SALE),
                new Electronics("telefon", 1500, ON_SALE),
                new Electronics("casti", 250, REFURBISHED),
                new Electronics("laptop", 5000, ON_SALE)
        ));

        List<Electronics> result = service.findWithLowerPrice(2000);
        assertThat(result).hasSize(2);
        assertThat(result).extracting("name")
                .containsExactly("telefon", "casti");
    }
}
