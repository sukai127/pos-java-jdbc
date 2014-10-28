import com.thoughtworks.iamcoach.pos.*;
import com.thoughtworks.iamcoach.pos.service.PromotionService;

import java.util.List;

public class App {
    public static void main(String[] args) {
        try {
            List list = FileHelper.get("cart.txt");
            Scanner scanner = new BarcodeScanner();
            PromotionService promotionService = new PromotionService();
            Pos pos = new Pos(scanner, promotionService);
            pos.printInventory(list);

        } catch (Exception e) {
            System.out.println("对不起本机暂停服务。。。。。。。。。。");
        }
    }
}
